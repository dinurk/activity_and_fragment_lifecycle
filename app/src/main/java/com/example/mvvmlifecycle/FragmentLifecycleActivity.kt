package com.example.mvvmlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.snackbar.Snackbar

class FragmentLifecycleActivity : AppCompatActivity() {

    private val backStackManager = FragmentBackStackManager(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_lifecycle)

        Log.i("activity_with_fragments", "onCreate")

        val fragmentSwitcher = FragmentSwitcher(supportFragmentManager, R.id.fragment_container)
        fragmentSwitcher.registerFragment("first", SimpleFragment())
        fragmentSwitcher.registerFragment("second", SimpleFragment2())

        if(savedInstanceState == null) {
            fragmentSwitcher.switchTo("first", true)
        }

        val switchFragmentsButton = findViewById<Button>(R.id.switch_fragments_button)
        switchFragmentsButton.setOnClickListener {

            if(backStackManager.getSize() > 10) {
                Snackbar.make(this, switchFragmentsButton, "BackStack contains 10 entries!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var fragmentName = "first"
            val lastEntry = backStackManager.getLastEntry()
            lastEntry?.let {
                fragmentName = if (lastEntry.name == "first") "second" else "first"
            }
            fragmentSwitcher.switchTo(fragmentName, true)
        }

        val returnToMainButton = findViewById<Button>(R.id.return_to_main_activity_button)
        returnToMainButton.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (backStackManager.getSize() == 0) {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("activity_with_fragments", "onStart")
    }
    
    override fun onResume() {
        super.onResume()
        Log.i("activity_with_fragments", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity_with_fragments", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activity_with_fragments", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity_with_fragments", "onDestroy")
    }
}
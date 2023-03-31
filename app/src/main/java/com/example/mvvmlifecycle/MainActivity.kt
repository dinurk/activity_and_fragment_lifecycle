package com.example.mvvmlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("activity_main", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("activity_main", "onStart")

        val button = findViewById<Button>(R.id.go_to_fragment_lifecycle_button)
        button.setOnClickListener {
            intent = Intent(this, FragmentLifecycleActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("activity_main", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity_main", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activity_main", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity_main", "onDestroy")
    }
}
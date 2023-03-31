package com.example.mvvmlifecycle

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class FragmentSwitcher(private val fragmentManager: FragmentManager,  @IdRes private val containerViewId: Int) {

    private val fragmentStates: MutableMap<String, Fragment> = HashMap()

    fun switchTo(fragmentName: String, useBackStack: Boolean): Boolean {
        if(!fragmentStates.containsKey(fragmentName)) {
            return false
        }

        fragmentManager.commit {
            replace(containerViewId, fragmentStates[fragmentName]!!)
            setReorderingAllowed(true)
            if(useBackStack) {
                addToBackStack(fragmentName)
            }
        }

        return true
    }

    fun registerFragment(name: String, fragment: Fragment){
        fragmentStates[name] = fragment
    }
}
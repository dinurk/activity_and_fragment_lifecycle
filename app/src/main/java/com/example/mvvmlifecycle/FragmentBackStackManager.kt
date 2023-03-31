package com.example.mvvmlifecycle

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.BackStackEntry

class FragmentBackStackManager(private val fragmentManager: FragmentManager) {

    fun getSize(): Int {
        return fragmentManager.backStackEntryCount
    }

    fun getLastEntry(): BackStackEntry? {
        val backStackSize = getSize()
        if(backStackSize == 0) {
            return null
        }
        return fragmentManager.getBackStackEntryAt(backStackSize - 1)
    }
}
package com.example.mvvmlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SimpleFragment2 : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("fragment_2", "fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragment_2", "fragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("fragment_2", "fragment: onCreateView")
        return inflater.inflate(R.layout.fragment_simple2, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragment_2", "fragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragment_2", "fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("fragment_2", "fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("fragment_2", "fragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragment_2", "fragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragment_2", "fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("fragment_2", "fragment: onDetach")
    }
}
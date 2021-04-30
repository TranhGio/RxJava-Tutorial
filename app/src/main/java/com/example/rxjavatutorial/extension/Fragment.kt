package com.example.rxjavatutorial.extension

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * @author at-vinhnguyen on 4/26/21.
 */

fun Fragment.addChildFragment(@IdRes containerId: Int, childFragment: Fragment) {
    childFragmentManager.beginTransaction().add(containerId, childFragment)
        .commitAllowingStateLoss()
}

fun Fragment.getCurrentFragment(@IdRes containerId: Int): Fragment? {
    return fragmentManager?.findFragmentById(containerId)
}

fun Fragment.log(logContent: String) {
    Log.i("xxx", logContent)
}
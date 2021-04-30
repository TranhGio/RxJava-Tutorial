package com.example.rxjavatutorial.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author at-vinhnguyen on 4/23/21.
 */

public const val START_ACTIVITY_REQUEST_CODE = 1511

fun AppCompatActivity.replaceFragment(
    containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false
) {
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment, if (addToBackStack) fragment.tag else null).commit()
}

fun AppCompatActivity.addFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
    supportFragmentManager.beginTransaction()
        .add(containerId, fragment, if (addToBackStack) fragment.tag else null).commit()
}

inline fun <reified T : Any> Activity.startActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivityForResult(intent, START_ACTIVITY_REQUEST_CODE, options)
}

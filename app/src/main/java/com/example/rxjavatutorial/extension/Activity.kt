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
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment)
    if (addToBackStack) transaction.addToBackStack(fragment::javaClass.name)
    transaction.commit()
}

fun AppCompatActivity.addFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(containerId, fragment)
    if (addToBackStack) transaction.addToBackStack(fragment::javaClass.name)
    transaction.commit()
}

inline fun <reified T : Any> Activity.startActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivityForResult(intent, START_ACTIVITY_REQUEST_CODE, options)
}

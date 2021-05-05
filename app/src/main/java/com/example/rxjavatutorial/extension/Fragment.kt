package com.example.rxjavatutorial.extension

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * @author at-vinhnguyen on 4/26/21.
 */

fun Fragment.addChildFragment(
    @IdRes containerId: Int,
    childFragment: Fragment,
    isBackStack: Boolean
) {
    val transaction = childFragmentManager.beginTransaction()
    transaction.add(containerId, childFragment)
    if (isBackStack) transaction.addToBackStack(childFragment::javaClass.name)
    transaction.commit()
}

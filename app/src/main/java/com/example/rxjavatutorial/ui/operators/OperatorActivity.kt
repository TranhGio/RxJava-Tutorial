package com.example.rxjavatutorial.ui.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavatutorial.R
import com.example.rxjavatutorial.extension.addFragment
import com.example.rxjavatutorial.extension.replaceFragment
import com.example.rxjavatutorial.ui.operators.simple.SimpleFragment

/**
 * @author at-vinhnguyen on 4/26/21.
 */
class OperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)
        openOperatorsFragment()
    }

    private fun openOperatorsFragment() {
        addFragment(R.id.frmContainer, OperatorFragment.newInstance(), true)
    }

    public fun openSimpleFragment() {
        replaceFragment(R.id.frmContainer, SimpleFragment.newInstance(), true)
    }
}

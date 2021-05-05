package com.example.rxjavatutorial.ui.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavatutorial.R
import com.example.rxjavatutorial.extension.replaceFragment
import com.example.rxjavatutorial.ui.operators.disposable.DisposableFragment
import com.example.rxjavatutorial.ui.operators.simple.SimpleFragment

/**
 * @author at-vinhnguyen on 4/26/21.
 */
class OperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)
        supportActionBar?.title = OperatorActivity::class.java.simpleName
        openOperatorsFragment()
    }

    private fun openOperatorsFragment() {
        replaceFragment(R.id.frmContainer, OperatorFragment.newInstance())
    }

    fun openSimpleFragment() {
        replaceFragment(R.id.frmContainer, SimpleFragment.newInstance(), true)
    }

    fun openDisposableFragment() {
        replaceFragment(R.id.frmContainer, DisposableFragment.newInstance(), true)
    }
}

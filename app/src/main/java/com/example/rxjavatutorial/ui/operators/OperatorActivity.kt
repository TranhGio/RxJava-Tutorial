package com.example.rxjavatutorial.ui.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavatutorial.R
import com.example.rxjavatutorial.extension.replaceFragment
import com.example.rxjavatutorial.ui.operators.createobservable.CreateObservableFragment
import com.example.rxjavatutorial.ui.operators.createobservable.RangeFragment
import com.example.rxjavatutorial.ui.operators.createobservable.RepeatFragment
import com.example.rxjavatutorial.ui.operators.disposable.DisposableFragment
import com.example.rxjavatutorial.ui.operators.filter.FilterFragment
import com.example.rxjavatutorial.ui.operators.interval.IntervalFragment
import com.example.rxjavatutorial.ui.operators.timer.TimerFragment
import com.example.rxjavatutorial.ui.operators.map.MapFragment
import com.example.rxjavatutorial.ui.operators.operator.OperatorFragment
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

    fun openFilterFragment() {
        replaceFragment(R.id.frmContainer, FilterFragment.newInstance(), true)
    }

    fun openMapFragment() {
        replaceFragment(R.id.frmContainer, MapFragment.newInstance(), true)
    }

    fun openCreateObservableFragment() {
        replaceFragment(R.id.frmContainer, CreateObservableFragment.newInstance(), true)
    }

    fun openRangeFragment() {
        replaceFragment(R.id.frmContainer, RangeFragment.newInstance(), true)
    }

    fun openRepeatFragment() {
        replaceFragment(R.id.frmContainer, RepeatFragment.newInstance(), true)
    }

    fun openIntervalFragment() {
        replaceFragment(R.id.frmContainer, IntervalFragment.newInstance(), true)
    }

    fun openTimerFragment() {
        replaceFragment(R.id.frmContainer, TimerFragment.newInstance(), true)
    }
}

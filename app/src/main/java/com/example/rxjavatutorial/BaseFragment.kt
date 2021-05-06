package com.example.rxjavatutorial

import androidx.fragment.app.Fragment
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * @author at-vinhnguyen on 5/5/21.
 */
abstract class BaseFragment : Fragment() {

    abstract fun <T> getObserver(): Observer<T>

    abstract fun getObservable(): Observable<String>
}

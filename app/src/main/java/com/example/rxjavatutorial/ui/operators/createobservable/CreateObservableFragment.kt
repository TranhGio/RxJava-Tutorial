package com.example.rxjavatutorial.ui.operators.createobservable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavatutorial.BaseFragment
import com.example.rxjavatutorial.R
import com.example.rxjavatutorial.databinding.FragmentSampleBinding
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author at-vinhnguyen on 4/26/21.
 */
class CreateObservableFragment : BaseFragment() {

    companion object {
        fun newInstance() = RepeatFragment()
    }

    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSampleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDoSomeWork.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        getObservableList()
            // Run on Background Thread
            .subscribeOn(Schedulers.io())
            // Be notified on the main thread
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getObserver())
    }

    override fun <T> getObserver(): Observer<T> {
        return object : Observer<T> {
            override fun onSubscribe(d: Disposable) {
                binding.tvResult.text =
                    getString(
                        R.string.placeHolder,
                        binding.tvResult.text.toString() + "\n onSubscribe: " + d.isDisposed
                    )
            }

            override fun onNext(t: T) {
                binding.tvResult.text =
                    getString(
                        R.string.placeHolder,
                        binding.tvResult.text.toString() + "\n onNext: " + t
                    )
            }

            override fun onError(e: Throwable) {
                binding.tvResult.text =
                    getString(
                        R.string.placeHolder,
                        binding.tvResult.text.toString() + "\n onError: " + e.message
                    )
            }

            override fun onComplete() {
                binding.tvResult.text =
                    getString(
                        R.string.placeHolder,
                        binding.tvResult.text.toString() + "\n onComplete"
                    )
            }
        }
    }

    override fun getObservable(): Observable<String> =
        Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                if (!emitter.isDisposed) {
                    emitter.onNext("Dang Vinh")
                    emitter.onComplete()
                    Log.i("xxx", "subscribe: ${emitter.isDisposed}")
                }
            }
        })

    private fun getObservableList(): Observable<String> {
        val listStrRes = mutableListOf("Steven", "Frank", "Paul", "David", "Michel")
        return Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                if (!emitter.isDisposed) {
                    for (str in listStrRes) {
                        emitter.onNext("$str 4")
                    }
                }
                emitter.onComplete()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

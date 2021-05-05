package com.example.rxjavatutorial.ui.operators.disposable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavatutorial.BaseFragment
import com.example.rxjavatutorial.R
import com.example.rxjavatutorial.databinding.FragmentSampleBinding
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author at-vinhnguyen on 5/5/21.
 */
class DisposableFragment : BaseFragment() {

    companion object {
        fun newInstance() = DisposableFragment()
    }

    private val compositeDisposable = CompositeDisposable()
    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(getObserver())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        compositeDisposable.clear()
    }

    override fun <String> getObserver() = object : Observer<String> {
        override fun onSubscribe(d: Disposable) {
            binding.tvResult.text =
                getString(
                    R.string.placeHolder,
                    "${binding.tvResult.text}\nonSubscribe: ${d.isDisposed}"
                )
            compositeDisposable.add(d)
        }

        override fun onNext(t: String) {
            binding.tvResult.text =
                getString(R.string.placeHolder, "${binding.tvResult.text}\nonNext: $t")
        }

        override fun onError(e: Throwable) {
            binding.tvResult.text =
                getString(R.string.placeHolder, "${binding.tvResult.text}\nonError: ${e.message}")
        }

        override fun onComplete() {
            binding.tvResult.text =
                getString(R.string.placeHolder, "${binding.tvResult.text}\nonComplete")
        }
    }

    override fun getObservable(): Observable<String> =
        Observable.just("Steven", "Frank", "Paul", "David", "Michel")
}

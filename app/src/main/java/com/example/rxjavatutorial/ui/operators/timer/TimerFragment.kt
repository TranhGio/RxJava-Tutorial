package com.example.rxjavatutorial.ui.operators.timer

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
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * @author mvn-vinhnguyen on 5/6/21.
 */
class TimerFragment : BaseFragment() {

    companion object {
        fun newInstance() = TimerFragment()
    }

    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding!!
    private var nowTime: Long = 0

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
        initListeners()
    }

    private fun initListeners() {
        binding.btnDoSomeWork.setOnClickListener {
            doSomeWorks()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun <T> getObserver() = object : Observer<T> {
        override fun onSubscribe(d: Disposable) {
            nowTime = System.currentTimeMillis()
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
                    binding.tvResult.text.toString() + "\n onNext: ${(System.currentTimeMillis() - nowTime) / 1000} second elapsed"
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

    override fun getObservable(): Observable<String> {
        return Observable.timer(5, TimeUnit.SECONDS, Schedulers.io()).map { it.toString() }
    }

    private fun doSomeWorks() {
        getObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .takeWhile { t -> t != "10" }
            .subscribe(getObserver<String>())
    }
}

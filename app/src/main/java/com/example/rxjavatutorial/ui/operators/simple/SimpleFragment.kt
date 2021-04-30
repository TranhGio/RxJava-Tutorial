package com.example.rxjavatutorial.ui.operators.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjavatutorial.databinding.FragmentSampleBinding
import com.example.rxjavatutorial.extension.log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author at-vinhnguyen on 4/26/21.
 */
class SimpleFragment : Fragment() {

    companion object {
        fun newInstance() = SimpleFragment()
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
        getObservable()
            .observeOn(Schedulers.io())
            // Run on Background Thread
            .subscribeOn(Schedulers.io())
            // Be notified on the main thread
            .subscribe(getObserver())
    }

    private fun getObservable() = Observable.just("Exciter", "Winner", "SH", "Vespa")

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                log("onSubscribe: ${d.isDisposed}")
                log(Thread.currentThread().name)
            }

            override fun onNext(t: String) {
                Thread.sleep(3000)
                log("onNext: $t")
                log(Thread.currentThread().name)
                binding.tvResult.text = t
            }

            override fun onError(e: Throwable) {
                log("onError: $e")
                log(Thread.currentThread().name)
            }

            override fun onComplete() {
                log("onComplete")
                log(Thread.currentThread().name)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

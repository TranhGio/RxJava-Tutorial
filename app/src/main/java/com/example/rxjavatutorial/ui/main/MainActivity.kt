package com.example.rxjavatutorial.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavatutorial.databinding.ActivityMainBinding
import com.example.rxjavatutorial.extension.startActivity
import com.example.rxjavatutorial.model.RxButton
import com.example.rxjavatutorial.ui.operators.OperatorActivity

class MainActivity : AppCompatActivity() {

    private val adapter: RxSelectionAdapter by lazy {
        RxSelectionAdapter(mutableListOf(RxButton.OPERATORS, RxButton.NETWORKING)).apply {
            onButtonClicked = { position ->
                when (position) {
                    RxButton.OPERATORS.ordinal -> {
                        startActivity<OperatorActivity>()
                    }
                    RxButton.NETWORKING.ordinal -> {
                        Log.i("xxx", "NETWORKING")
                    }
                    else -> {
                        Log.i("xxx", "else")
                    }
                }
            }
        }
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        binding.rvRxJavaRxAndroid.setHasFixedSize(true)
        binding.rvRxJavaRxAndroid.adapter = adapter
    }
}

package com.example.rxjavatutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavatutorial.model.RxButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = RxSelectionAdapter(mutableListOf(RxButton.OPERATORS, RxButton.NETWORKING))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvRxJavaRxAndroid.setHasFixedSize(false)
        rvRxJavaRxAndroid.adapter = adapter
        adapter.onButtonClicked = { position -> Log.i("xxx", "Edited: $position") }
    }
}

package com.example.rxjavatutorial.ui.operators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjavatutorial.databinding.FragmentOperatorBinding
import com.example.rxjavatutorial.model.RxOperatorsButton

/**
 * @author at-vinhnguyen on 4/23/21.
 */
class OperatorFragment : Fragment() {

    companion object {
        fun newInstance() = OperatorFragment()
    }

    private var _binding: FragmentOperatorBinding? = null
    private val binding get() = _binding!!

    private val adapter: OperatorAdapter by lazy {
        OperatorAdapter(
            mutableListOf(
                RxOperatorsButton.SIMPLE,
                RxOperatorsButton.DISPOSABLE
            )
        ).apply {
            operatorButtonClicked = { position ->
                when (position) {

                    RxOperatorsButton.SIMPLE.ordinal -> {
                        (activity as? OperatorActivity)?.openSimpleFragment()
                    }
                    RxOperatorsButton.DISPOSABLE.ordinal -> {
                        (activity as? OperatorActivity)?.openDisposableFragment()
                    }
                    //Todo add button handle later
                    else -> {
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOperatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        binding.rvOperator.setHasFixedSize(true)
        binding.rvOperator.adapter = adapter
    }
}

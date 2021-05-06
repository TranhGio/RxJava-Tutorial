package com.example.rxjavatutorial.ui.operators.operator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjavatutorial.databinding.FragmentOperatorBinding
import com.example.rxjavatutorial.model.RxOperatorsButton
import com.example.rxjavatutorial.ui.operators.OperatorActivity

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
                RxOperatorsButton.DISPOSABLE,
                RxOperatorsButton.FILTER,
                RxOperatorsButton.MAP,
                RxOperatorsButton.FLAT_MAP
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
                    RxOperatorsButton.FILTER.ordinal -> {
                        (activity as? OperatorActivity)?.openFilterFragment()
                    }
                    RxOperatorsButton.MAP.ordinal -> {
                        (activity as? OperatorActivity)?.openMapFragment()
                    }
                    RxOperatorsButton.FLAT_MAP.ordinal -> {

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

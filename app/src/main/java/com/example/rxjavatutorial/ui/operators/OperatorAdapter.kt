package com.example.rxjavatutorial.ui.operators

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatutorial.databinding.ItemButtonBinding
import com.example.rxjavatutorial.model.RxOperatorsButton

/**
 * @author at-vinhnguyen on 4/23/21.
 */

class OperatorAdapter(private val rxOperatorsButtons: MutableList<RxOperatorsButton>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var operatorButtonClicked: (position: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperatorViewHolder {
        val view = ItemButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OperatorViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? OperatorViewHolder)?.bindView(position)
    }

    override fun getItemCount() = rxOperatorsButtons.size

    inner class OperatorViewHolder(private val itemButtonBinding: ItemButtonBinding) :
        RecyclerView.ViewHolder(itemButtonBinding.root) {
        init {
            itemButtonBinding.btnRx.setOnClickListener {
                operatorButtonClicked.invoke(adapterPosition)
            }
        }

        fun bindView(position: Int) {
            itemButtonBinding.btnRx.text = rxOperatorsButtons[position].name
        }
    }
}

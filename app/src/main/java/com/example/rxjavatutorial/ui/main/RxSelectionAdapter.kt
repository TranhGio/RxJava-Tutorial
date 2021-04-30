package com.example.rxjavatutorial.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatutorial.databinding.ItemButtonBinding
import com.example.rxjavatutorial.model.RxButton

/**
 * @author at-vinhnguyen on 4/22/21.
 */
class RxSelectionAdapter(private val buttons: MutableList<RxButton>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var onButtonClicked: (position: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemButtonBinding = ItemButtonBinding.inflate(LayoutInflater.from(parent.context))
        return RxSelectionViewHolder(
            itemButtonBinding
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RxSelectionViewHolder) {
            holder.bindView(position)
        }
    }

    override fun getItemCount() = buttons.size

    inner class RxSelectionViewHolder(private val itemButtonBinding: ItemButtonBinding) :
        RecyclerView.ViewHolder(itemButtonBinding.root) {
        init {
            itemButtonBinding.btnRx.setOnClickListener {
                onButtonClicked.invoke(adapterPosition)
            }
        }

        fun bindView(position: Int) {
            itemButtonBinding.btnRx.text = buttons[position].name
        }
    }
}

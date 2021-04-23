package com.example.rxjavatutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatutorial.model.RxButton
import kotlinx.android.synthetic.main.item_button.view.*

/**
 * @author at-vinhnguyen on 4/22/21.
 */
class RxSelectionAdapter(private val buttons: MutableList<RxButton>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    public var onButtonClicked: (position : Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RxSelectionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RxSelectionViewHolder) {
            holder.bindView(position)
        }
    }

    override fun getItemCount() = buttons.size

    inner class RxSelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.btnRx.setOnClickListener {
                onButtonClicked.invoke(adapterPosition)
            }
        }

        fun bindView(position: Int) {
            itemView.btnRx.text = buttons[position].name
        }
    }
}

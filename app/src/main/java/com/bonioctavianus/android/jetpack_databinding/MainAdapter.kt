package com.bonioctavianus.android.jetpack_databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bonioctavianus.android.jetpack_databinding.databinding.RowItemBinding

class MainAdapter(
    private val mItems: List<Item>,
    private val mClickListener: ((item: Item) -> Unit)
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<RowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_item,
            parent,
            false
        )
        return ItemViewHolder(binding, mClickListener)
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mItems[position])
    }
}

class ItemViewHolder(
    private val binding: RowItemBinding,
    private val mClickListener: (item: Item) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.item = item
        binding.root.setOnClickListener { mClickListener.invoke(item) }
    }
}
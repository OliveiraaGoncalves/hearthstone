package com.hearthstone.feature_home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hearthstone.feature.home.databinding.AdapterBackItemBinding
import com.hearthstone.feature_home.domain.model.Cardback

class CardBackAdapter(private val items: List<Cardback>, private val onItemClick: (item: Cardback) -> Unit) :
    RecyclerView.Adapter<CardBackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterBackItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: AdapterBackItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cardback) {
            binding.itemTextView.text = item.name
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}

package com.example.trashsortapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trashsortapp.databinding.CardCellBinding

class CardAdapter (
    private val sortRules: List<SortRule>,
    private val clickListener: SortRuleClickListener
)
    : RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int = sortRules.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindSortRule(sortRules[position])
    }
}
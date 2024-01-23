package com.example.trashsortapp

import androidx.recyclerview.widget.RecyclerView
import com.example.trashsortapp.databinding.CardCellBinding

class CardViewHolder(
    private val  cardCellBinding: CardCellBinding,
    private val clickListener: SortRuleClickListener
): RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindSortRule(sortRule: SortRule){
         cardCellBinding.cover.setImageResource(sortRule.container)
        cardCellBinding.title.text = sortRule.type

        cardCellBinding.cardView.setOnClickListener{
            clickListener.OnClick(sortRule)
        }
    }
}
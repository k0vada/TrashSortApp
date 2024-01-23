package com.example.trashsortapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trashsortapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sortRuleID = intent.getIntExtra(SORT_RULE_ID_EXTRA, -1)
        val sortRule = sortRuleFromID(sortRuleID)
        if(sortRule != null){
            binding.container.setImageResource(sortRule.container)
            binding.typeContainer.text = sortRule.type
            binding.description.text = sortRule.description
            binding.newThings.text = sortRule.newThings

        }
    }

    private fun sortRuleFromID(sortRuleID: Int): SortRule? {
        for(sortRule in sortRuleList) {
            if(sortRule.id == sortRuleID){
                return sortRule
            }
        }
        return null

    }
}
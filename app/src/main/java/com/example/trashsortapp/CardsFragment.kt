package com.example.trashsortapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trashsortapp.databinding.FragmentCardsBinding

class CardsFragment : Fragment(), SortRuleClickListener {

    private lateinit var binding: FragmentCardsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
            //return inflater.inflate(binding.root, container, false)

        populateSortRules()

        val cardsFragment = this
        binding.recycleView.apply {
            layoutManager = GridLayoutManager(requireContext(),1 )
            adapter = CardAdapter(sortRuleList, cardsFragment)
        }
        return binding.root
    }
    override fun OnClick(sortRule: SortRule) {
        val intent = Intent(requireContext(), DetailActivity::class.java )
        intent.putExtra(SORT_RULE_ID_EXTRA, sortRule.id)
        startActivity(intent)
    }

    private fun populateSortRules() {
        val sortRuleGlass1 = SortRule(
            R.drawable.container_glass,
            "Стекло",//Сдавай как стекло",
            "Стоит сполоснуть. Этикетки не срывай, а крышечки собирай вместе с металлом или пластиком.",
            "Новые вещи после вторичной переработки: стекловолокно, жидкое стекло, плитку, черепицу, строительные лаки, краски, мастики, фильтры для воды и многое другое"
        )
        sortRuleList.add(sortRuleGlass1)

        val sortRuleMetall1 = SortRule(
            R.drawable.container_metall,
            "Металл",//Сдавай как металл",
            "Собирай только чистую фольгу, без остатков жира и пищи. Спрессуй для компактности. Перерабаывается только фольга без слоя бумаги или пластика.",
            "Новые вещи после вторичной переработки: бижутерия, упаковочные и строительные, контейнеры, конденсаторы, провода и многое другое"
        )
        sortRuleList.add(sortRuleMetall1)


        val sortRulePlastic1 = SortRule(
            R.drawable.container_plastic,
            "Пластик",//Сдавай как пластик",
            "Ценным вторсырьем являются прозрачные, голубые, зеленые и коричневые буьылки из-под напитков, их примет любой пункт. Промой от содержимого, высуши и сожми. Этикетку сорви, если она закрывает больше половины бутылки или крышечки.",
            "Новые вещи после вторичной переработки: текстильные и строительные материалы, пленка, пакеты, контейнеры, мебель, трубы и многое другое"
        )
        sortRuleList.add(sortRulePlastic1)


        val sortRuleRed1 = SortRule(
            R.drawable.container_red,
            "Другое",//Утилизируй ответственно!",
            "Вторичной переработкой таких материалов обеспечивают специальные компании.",
            "Такие материалы содержат различные вещества и материалы, и процессы их переработки могут различаться. При переработке обычно проводится извлечение этих материалов с целью их повторного использования"
        )
        sortRuleList.add(sortRuleRed1)

        val sortRulePaper1 = SortRule(
            R.drawable.container_paper,
            "Макулатура",
            "Только чистая, сухая, не загрязненная жиром и остатками еды. Освободи от скотча, металлических и пластиковых элементов.",
            "Новые вещи после вторичной переработки: коробки, пакеты, тетради,  блокноты, туалетная бумага, бумажные полотенца, новая бумага"
        )
        sortRuleList.add(sortRulePaper1)

        val sortRuleNoRecycled = SortRule(
            R.drawable.container_paper,
            "Не перерабатывается",
            "Переработка этого вида отхдов сложна или нерентабельна, поэтому в России его преимущественно не принимают",
            "Постарайся уменьшить потребление или отказаться."
        )
        sortRuleList.add(sortRuleNoRecycled)




    }




}
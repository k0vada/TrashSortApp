package com.example.trashsortapp

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {

    private lateinit var imageViewItem: ImageView
    private lateinit var cardRecycle: CardView
    private lateinit var cardNonRecycle: CardView
    private lateinit var textCorrectAnswers: TextView
    private lateinit var textIncorrectAnswers: TextView

    data class Item(
        val resId: Int,
        val recycle: Boolean
    )

    private val items: List<Item> by lazy {
        val itemList = mutableListOf<Item>()
        for (i in 1..9) {
            val recycleResourceId = resources.getIdentifier("re_pic$i", "drawable", requireActivity().packageName) //"food${String.format("%02d", i)}"
            val nonRecycleResourceId = resources.getIdentifier("no_pic$i", "drawable", requireActivity().packageName)

            itemList.add(Item(recycleResourceId, true))
            itemList.add(Item(nonRecycleResourceId, false))
        }
        itemList
    }

    private var taskNumber = 0
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_game, container, false)

        imageViewItem = view.findViewById(R.id.imageViewItem)
        cardRecycle = view.findViewById(R.id.cardRecycle)
        cardNonRecycle = view.findViewById(R.id.cardNonRecycle)
        textCorrectAnswers = view.findViewById(R.id.textCorrectAnswer)
        textIncorrectAnswers = view.findViewById(R.id.textIncorrectAnswer)

        nextImage()

        cardRecycle.setOnClickListener { onButtonClick(true) }
        cardNonRecycle.setOnClickListener { onButtonClick(false) }

        return view
    }
    private fun nextImage() {
        if (items.isNotEmpty()) {
            var newTaskNumber = (0 until items.size).random()

            // Пока новый номер задачи равен предыдущему, выбираем новый номер
            while (newTaskNumber == taskNumber) {
                newTaskNumber = (0 until items.size).random()
            }

            taskNumber = newTaskNumber

            val resourceId = items[taskNumber].resId

            try {
                val drawable = ContextCompat.getDrawable(requireActivity(), resourceId)

                if (drawable != null) {
                    imageViewItem.setImageDrawable(drawable)
                } else {
                    Log.e("GameActivity", "Drawable is null for resource ID: $resourceId")
                    // Если drawable == null, попробуйте выбрать следующее изображение
                    nextImage()
                }
            } catch (e: Resources.NotFoundException) {
                Log.e("GameActivity", "Resource not found for ID: $resourceId")
                // Если ресурс не найден, попробуйте выбрать следующее изображение
                nextImage()
            }
        } else {
            Log.e("GameActivity", "Список items пуст. Невозможно показать следующий элемент.")
        }
    }

    private fun onButtonClick(isRecycle: Boolean) {
        if (items.isNotEmpty()) {
            val correctAnswer = items[taskNumber].recycle

            if (isRecycle == correctAnswer) {
                correctAnswers++
            } else {
                incorrectAnswers++
            }
            updateScoreText()
            nextImage()
        } else {
            Log.e("GameActivity", "Список items пуст. Невозможно обработать ответ.")
    }
}

    private fun updateScoreText() {
        textCorrectAnswers.text = "Правильных ответов: $correctAnswers"
        textIncorrectAnswers.text = "Неправильных ответов: $incorrectAnswers"
    }
}
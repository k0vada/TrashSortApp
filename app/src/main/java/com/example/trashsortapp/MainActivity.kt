package com.example.trashsortapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null

            when (menuItem.itemId) {
                R.id.navigation_trash -> {
                    selectedFragment = CardsFragment()
                }

                R.id.navigation_search -> {
                    selectedFragment = SearchFragment()
                }

                R.id.navigation_map -> {
                    selectedFragment = MapFragment()
                }

                R.id.navigation_game -> {
                    selectedFragment = GameFragment()
                }
            }

            if (selectedFragment != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, selectedFragment)
                transaction.commit()
            }

            true
        }
        // Карточки для выборп типа мусора - первый фрагмент по умолчанию
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, CardsFragment())
        transaction.commit()
    }
}
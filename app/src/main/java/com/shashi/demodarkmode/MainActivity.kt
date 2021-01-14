package com.shashi.demodarkmode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {

    lateinit var materialButtonToggleGroup: MaterialButtonToggleGroup
    lateinit var darkMode: DarkMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        materialButtonToggleGroup = findViewById(R.id.btg_theme)
        setSupportActionBar(toolbar)

        darkMode = DarkMode(this)
        loadTheme()
        checkDefaultButton()

        materialButtonToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if (isChecked) {
                when (checkedId) {
                    R.id.btn_default -> saveTheme("default")
                    R.id.btn_dark -> saveTheme("dark")
                    else -> saveTheme("light")
                }

                loadTheme()
            }

        }
    }

    private fun checkDefaultButton() {
        val id = when (darkMode.getDarkModeState()) {
            -1 -> R.id.btn_default
            2 -> R.id.btn_dark
            else -> R.id.btn_light
        }
        materialButtonToggleGroup.check(id)
    }

    private fun saveTheme(theme: String) {
        darkMode.setDarkModeState(theme)
    }

    private fun loadTheme() {
        val savedTheme = darkMode.getDarkModeState()
        AppCompatDelegate.setDefaultNightMode(savedTheme)
    }

}
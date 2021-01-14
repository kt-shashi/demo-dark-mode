package com.shashi.demodarkmode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {

    lateinit var materialButtonToggleGroup: MaterialButtonToggleGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        materialButtonToggleGroup = findViewById(R.id.btg_theme)
        materialButtonToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if (isChecked) {
                val theme = when (checkedId) {
                    R.id.btn_default -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    R.id.btn_dark -> AppCompatDelegate.MODE_NIGHT_YES
                    else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                AppCompatDelegate.setDefaultNightMode(theme)
            }

        }

    }
}
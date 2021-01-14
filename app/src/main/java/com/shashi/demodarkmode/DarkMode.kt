package com.shashi.demodarkmode

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

class DarkMode(context: Context) {

    var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("darkmode", Context.MODE_PRIVATE)

    fun setDarkModeState(state: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("darkmodestate", state)
        editor.apply()
    }

    fun getDarkModeState(): Int {
        val state = sharedPreferences.getString("darkmodestate", "")
        val mode = when (state) {
            "default" -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            "dark" -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_NO
        }
        return mode
    }

}
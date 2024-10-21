package com.example.awesome_shop_jetpack_compose.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveLoginData(fullName: String, username: String, password: String) {
        preferences.edit().apply {
            putString("full_name", fullName)
            putString("username", username)
            putString("password", password)
            apply()
        }
    }

    fun getLoginData(): Triple<String?, String?, String?> {
        val fullName = preferences.getString("full_name", null)
        val username = preferences.getString("username", null)
        val password = preferences.getString("password", null)
        return Triple(fullName, username, password)
    }

    fun clearLoginData() {
        preferences.edit().clear().apply()
    }
}

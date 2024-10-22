package com.example.awesome_shop_jetpack_compose.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveCredentials(token: String, fullName: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.putString("fullName", fullName)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("token", token).apply()
    }

    fun getFullName(): String? {
        return sharedPreferences.getString("fullName", null)
    }

    fun saveFullName(fullName: String) {
        sharedPreferences.edit().putString("fullName", fullName).apply()
    }

    fun clearCredentials() {
        sharedPreferences.edit().clear().apply()
    }
}

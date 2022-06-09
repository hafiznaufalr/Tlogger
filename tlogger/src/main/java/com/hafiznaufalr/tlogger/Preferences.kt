package com.hafiznaufalr.tlogger

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object Preferences {
    private const val API_KEY = "api_key"
    private const val CHAT_ID = "chat_id"

    private fun getSharedPreference(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun putApiKey(context: Context, apiKey: String) {
        val editor = getSharedPreference(context).edit()
        editor.putString(API_KEY, apiKey)
        editor.apply()
    }

    fun getApiKey(context: Context): String? {
        return getSharedPreference(context).getString(API_KEY, null)
    }

    fun putChatId(context: Context, chatId: String) {
        val editor = getSharedPreference(context).edit()
        editor.putString(CHAT_ID, chatId)
        editor.apply()
    }

    fun getChatId(context: Context): String? {
        return getSharedPreference(context).getString(CHAT_ID, null)
    }

}
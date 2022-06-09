package com.hafiznaufalr.tlogger

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

object Tlogger {
    fun setupLogger(context: Context, apiKey: String, chatId: String) {
        Preferences.putApiKey(context, apiKey)
        Preferences.putChatId(context, chatId)
    }

    fun sendLogger(context: Context, message: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val apiKey = Preferences.getApiKey(context)
            val chatId = Preferences.getChatId(context)
            val url = "https://api.telegram.org/bot${apiKey}/sendMessage?chat_id=${chatId}&text=${message}"
            URL(url).readText()
        }
    }
}
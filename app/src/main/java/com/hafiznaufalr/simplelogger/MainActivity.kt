package com.hafiznaufalr.simplelogger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.hafiznaufalr.tlogger.Tlogger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = MessageFormat()
        message.environment = "DEV"
        message.endpoint = "https://api.dev.sample/get-token"
        message.message = "EXCEPTION"


        Tlogger.setupLogger(this,"update your key", "update your chatId")
        Tlogger.sendLogger(this, Gson().toJson(message))
    }
}
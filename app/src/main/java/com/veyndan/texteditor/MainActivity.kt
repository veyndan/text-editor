package com.veyndan.texteditor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import okio.Okio

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.data != null) {
            val textView = findViewById<TextView>(R.id.text)

            val source = Okio.buffer(Okio.source(contentResolver.openInputStream(intent.data)))

            textView.text = source.readUtf8()
        }
    }
}

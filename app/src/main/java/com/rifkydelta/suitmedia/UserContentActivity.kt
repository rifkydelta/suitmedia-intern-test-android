package com.rifkydelta.suitmedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserContentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_content)

        val btnSelectUser: Button = findViewById(R.id.btnSelectUser)
        val btnBack: ImageButton = findViewById(R.id.btnBack)

        val name =
            intent.getStringExtra(EXTRA_NAME).takeIf { !it.isNullOrBlank() } ?: "no name inputted"

        val textView: TextView = findViewById(R.id.userName)
        textView.text = name

        // Update UI, misalnya dengan TextView
        val pageText: TextView = findViewById(R.id.pageNumber)
        pageText.text = "Second Screen"

        btnSelectUser.setOnClickListener {
            val move = Intent(this, ListUser::class.java)
            startActivity(move)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

}

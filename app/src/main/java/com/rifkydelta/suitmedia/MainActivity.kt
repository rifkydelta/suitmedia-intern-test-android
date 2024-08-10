package com.rifkydelta.suitmedia.main

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.rifkydelta.suitmedia.MainViewModel
import com.rifkydelta.suitmedia.R
import com.rifkydelta.suitmedia.UserContentActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        val inpName: TextInputEditText = findViewById(R.id.inpName)
        val inpPalindrome: TextInputEditText = findViewById(R.id.inpPalindrome)
        val buttonCheck: Button = findViewById(R.id.buttonCheck)
        val buttonNext: Button = findViewById(R.id.buttonNext)

        viewModel.name.observe(this, Observer { name ->
            inpName.setText(name ?: "")
        })

        viewModel.palindrome.observe(this, Observer { palindrome ->
            inpPalindrome.setText(palindrome ?: "")
        })

        buttonCheck.setOnClickListener {
            val palindromeInput = inpPalindrome.text.toString()

            viewModel.setPalindrome(palindromeInput)

            if (palindromeInput.isNullOrEmpty()) {
                Toast.makeText(this, "Input cannot be empty or null!", Toast.LENGTH_SHORT).show()
            } else if (palindromeInput == palindromeInput.reversed()) {
                Toast.makeText(this, "It's a palindrome!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not a palindrome!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonNext.setOnClickListener {
            val nameInput = inpName.text.toString()

            viewModel.setName(nameInput)

            val move = Intent(this, UserContentActivity::class.java)
            move.putExtra(
                UserContentActivity.EXTRA_NAME,
                if (nameInput.isNotEmpty()) nameInput else "Anonymous User 😎"
            )
            startActivity(move)
        }
    }
}

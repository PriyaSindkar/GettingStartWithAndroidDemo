package com.priyasindkar.gettingstartwithandroiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<MaterialButton>(R.id.submit_button)
        val editTextUserName = findViewById<EditText>(R.id.edittext_username)
        val editTextPassword = findViewById<EditText>(R.id.edittext_password)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radiogroup_gender)
        val textviewError = findViewById<TextView>(R.id.textview_error)

        submitButton.setOnClickListener {

            if (editTextUserName.text.isEmpty()) {
                editTextUserName.error = "Username required"
                editTextUserName.requestFocus()
                return@setOnClickListener
            }

            if (editTextPassword.text.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (radioGroupGender.checkedRadioButtonId == -1) {
                textviewError.visibility = View.VISIBLE
                return@setOnClickListener
            }
            Toast.makeText(this, "Submit registration form", Toast.LENGTH_SHORT).show()
        }
    }
}
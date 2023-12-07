package com.bignerdranch.android.criminalintent

import android.annotation.SuppressLint
import android.content.Intent

import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {

    private lateinit var dateText: TextView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        dateText = findViewById(R.id.crime_date2)
        val currentDateTime = DateFormat.getDateTimeInstance().format(Date())
        dateText.text = currentDateTime

        floatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val checkBoxState = intent.getBooleanExtra("checkBoxState", false)

        val message = if (checkBoxState) {
            "CheckBox был включен"
        } else {
            "CheckBox был выключен"
        }

        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        snackbar.setAction("Ok") {
            navigateBackToPreviousScreen()
        }
        snackbar.show()
    }

    private fun navigateBackToPreviousScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
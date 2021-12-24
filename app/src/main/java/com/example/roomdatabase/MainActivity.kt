package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var name:EditText
    private lateinit var age:EditText
    private lateinit var add:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
            add.setOnClickListener {
                if (validate())
                {
                    saveNote()
                }
            }}
        private fun saveNote() {
            val database = UserDatabase.getInstance(this)
            val userDAO=database?.userdao()
            val user=User(0, name.text.toString(), age.text.toString())
            GlobalScope.launch {
                userDAO?.insert(user)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Saved record", Toast.LENGTH_SHORT).show()
                    finish()
                }    }}

            private fun validate(): Boolean {
            if (name.text.isEmpty() or age.text.isEmpty()) {
                Toast.makeText(this, "please enter the NAME and AGE", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
    fun setUI() {
        name = findViewById(R.id.EtNAME)
        age = findViewById(R.id.EtAGE)
        add = findViewById(R.id.BtnADD)
    }
    }










        











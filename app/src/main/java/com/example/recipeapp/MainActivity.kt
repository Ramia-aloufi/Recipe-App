package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var title:EditText
    lateinit var author:EditText
    lateinit var ingredients:EditText
    lateinit var instructions:EditText

    lateinit var save:Button
    lateinit var view:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){
        title = findViewById(R.id.title)
        author = findViewById(R.id.author)
        ingredients = findViewById(R.id.ingredients)
        instructions = findViewById(R.id.instructions)

        view = findViewById(R.id.View)
        save = findViewById(R.id.Save)
    }
}
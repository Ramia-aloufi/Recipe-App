package com.example.recipeapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var title: EditText
    lateinit var author: EditText
    lateinit var ingredients: EditText
    lateinit var instructions: EditText
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    lateinit var save: Button
    lateinit var view: Button
    lateinit var data:Receipes.datalist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        save.setOnClickListener {
            gettext()
            addtoapi()

        }
        view.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun init() {
        title = findViewById(R.id.title)
        author = findViewById(R.id.author)
        ingredients = findViewById(R.id.ingredients)
        instructions = findViewById(R.id.instructions)
        view = findViewById(R.id.View)
        save = findViewById(R.id.Save)
    }

    fun gettext(){
        val aa = title.text.toString()
        val bb = author.text.toString()
        val cc = ingredients.text.toString()
        val dd = instructions.text.toString()
         data = Receipes.datalist(aa,bb,cc,dd)


    }
    fun addtoapi(){

        apiInterface!!.added(data).enqueue(object : Callback<Receipes.datalist> {
            override fun onResponse(call: Call<Receipes.datalist>, response: Response<Receipes.datalist>) {
                Log.d("TAG", response.code().toString() + "")
                Toast.makeText(this@MainActivity,"added", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Receipes.datalist>, t: Throwable?) {
                Toast.makeText(this@MainActivity,"failure", Toast.LENGTH_SHORT).show()
                call.cancel()
            }


        })


    }
}


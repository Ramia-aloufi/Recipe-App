package com.example.recipeapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var al:ArrayList<Receipes.datalist>
    lateinit var rv:RecyclerView
    lateinit var btn:Button
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
        getUser()
        adapt()

        btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun init(){
        al = arrayListOf()
        rv = findViewById(R.id.rv)
        btn = findViewById(R.id.vi)

    }
    fun getUser() {

        val progressDialog = ProgressDialog(this@MainActivity2)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        apiInterface!!.getit().enqueue(object : Callback<List<Receipes.datalist>> {
            override fun onResponse(call: Call<List<Receipes.datalist>>, response: Response<List<Receipes.datalist>>) {
                progressDialog.dismiss()
                val resource = response.body()
                for(user in resource!!){
                    var users = Receipes.datalist(user.title,user.author,user.ingredients,user.instructions)

                    al.add(users)

                }
                rv.adapter?.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Receipes.datalist>>, t: Throwable) {
                progressDialog.dismiss()
                call.cancel()
            }
        })
    }

    fun adapt(){
        rv.adapter = MyAdapter(al)
        rv.layoutManager = LinearLayoutManager(this)
    }
}

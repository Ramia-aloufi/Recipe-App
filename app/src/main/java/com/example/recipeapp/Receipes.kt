package com.example.recipeapp

import android.icu.text.CaseMap

class Receipes{
    lateinit var data:List<Receipes.datalist>

    class datalist(val title: String,val author:String,val ingredients:String,val instructions:String)
}
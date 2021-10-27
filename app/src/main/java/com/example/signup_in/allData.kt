package com.example.signup_in

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class allData : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var textView:TextView
    lateinit var textView2:TextView
    lateinit var bt_out:Button
    lateinit var add:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        sharedPreferences=getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        textView=findViewById(R.id.textView)
        textView2=findViewById(R.id.textView2)
        bt_out=findViewById(R.id.bt_out)
        textView2.text=sharedPreferences.getString("name","phone").toString()
       textView.text=sharedPreferences.getString("phone","phone").toString()
        bt_out.setOnClickListener {

          intent=  Intent(this,sign_in::class.java)
            startActivity(intent)



        }

        }


    }

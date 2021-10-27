package com.example.signup_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var bt_Sup:Button
    lateinit var bt_Sin:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        bt_Sin=findViewById(R.id.bt_Sin)
        bt_Sup=findViewById(R.id.bt_Sup)



        bt_Sin.setOnClickListener {
            val intent=Intent(this,sign_in::class.java)
            startActivity(intent)
        }

       bt_Sup.setOnClickListener {

           val intent2=Intent(this,sign_up::class.java)
           startActivity(intent2)
       }


    }
}
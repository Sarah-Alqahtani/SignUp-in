package com.example.signup_in

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class sign_in : AppCompatActivity() {
    lateinit var db:database
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editInName:EditText
    lateinit var editInPassword:EditText
    lateinit var bt_sin2:Button
    lateinit var add:SharedPreferences.Editor
    var status=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        sharedPreferences=getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        add=sharedPreferences.edit()
        editInName=findViewById(R.id.editInName)
        editInPassword=findViewById(R.id.editInPassword)
        bt_sin2=findViewById(R.id.bt_sin2)
        db= database(applicationContext)

        bt_sin2.setOnClickListener{
            var s1=editInName.text.toString()
            var s2=editInPassword.text.toString()
            status=db.checkpassword(s2)
            if (status.equals(s2)){
                add.putString("name",s1).commit()

                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();

               intent= Intent(this, MainActivity::class.java).apply {
                    startActivity(intent)
                }

            } else{
                Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT).show();
            }



        }



    }
}
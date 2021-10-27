package com.example.signup_in

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class sign_up : AppCompatActivity() {
    lateinit var db:database
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editUpName: EditText
    lateinit var editupPhone: EditText
    lateinit var editupPass: EditText
    lateinit var edituploc: EditText
    lateinit var bt_sub: Button

    var status=""//to use saveadata function
    lateinit var s1:String
    var s2=""
    var s3=""
    var s4=""
    lateinit var add:SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        db= database(applicationContext)
        sharedPreferences=getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        add=sharedPreferences.edit()
        editUpName=findViewById(R.id.editUpName)
        editupPhone=findViewById(R.id.editupPhone)
        editupPass=findViewById(R.id.editupPass)
        edituploc=findViewById(R.id.edituploc)
        bt_sub=findViewById(R.id.bt_submit)

  bt_sub.setOnClickListener {

        s1= editUpName.text.toString()
        s2= editupPhone.text.toString()
        s3=editupPass.text.toString()
        s4=edituploc.text.toString()
       db.savedata(s1,s2,s3,s4)
      //  status= db.savedata(s1,s2,s3,s4)
      Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
          .show();
        add.putString("name",s1).commit()
        add.putString("phone",s2).commit()
        add.apply()

 intent=Intent(this,allData::class.java)
    startActivity(intent)




        }













}}
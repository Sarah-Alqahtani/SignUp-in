package com.example.signup_in

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class database(context: Context): SQLiteOpenHelper(context,"details.db", null, 1) {
    var sqLiteDatabase: SQLiteDatabase =writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db!=null){ db.execSQL("create table  DataUser (S1 text,S2 text,S3 text,S4 text )") }

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}


    fun savedata(s1:String,s2:String,s3:String,s4:String): Long {

val sv=ContentValues()
sv.put("S1",s1)
sv.put("S2",s2)
sv.put("S3",s3)
sv.put("S4 ",s4)
      var save=sqLiteDatabase.insert("DataUser",null,sv)

return save

    }

    @SuppressLint("Range")
    fun getdata(s1: String, s2: String, s3: String, s4: String):String{
  var c : Cursor =sqLiteDatabase.query("DataUser" , null,null, null, null, null,null)
 c.moveToFirst()
var gdata = c.getString(c.getColumnIndex("S1"))+"\n"+ c.getString(c.getColumnIndex("S2"))

return gdata

    }
    @SuppressLint("Range")
    fun checkpassword(chpass: String): String {
        //  sqLiteDatabase=writableDatabase

        var c: Cursor = sqLiteDatabase.query(
            "students", null, "S2=?", arrayOf(chpass), null, null, null
        )
        if (c.count < 1) {
            return "name not exists"
        }
        c.moveToFirst()
        var loc = c.getString(c.getColumnIndex("S4"))
        return loc
    }


}



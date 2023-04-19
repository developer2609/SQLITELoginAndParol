package com.developer.registerproject.db2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.developer.registerproject.db.MyObject
import com.developer.registerproject.db2.MyObject2.DB_NAMES
import com.developer.registerproject.model.Login
import com.developer.registerproject.model.Users

class MyDbHelper2(context: Context):SQLiteOpenHelper(context,DB_NAMES,null,1) ,MyDbInterface2{
    override fun onCreate(db: SQLiteDatabase?) {
        var query="create table ${MyObject2.TABLE_NAMES} (${MyObject2.IDS} integer not null primary key autoincrement unique,${MyObject2.LOGIN} text not null,${MyObject2.PAROL} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addlogin(login: Login) {
        val database=writableDatabase
        val contentValues= ContentValues()
        contentValues.put(MyObject2.LOGIN,login.login)
        contentValues.put(MyObject2.PAROL,login.parol)
        database.insert(MyObject2.TABLE_NAMES,null,contentValues)
        database.close()

    }

    override fun getLogins(): List<Login> {
        val list=ArrayList<Login>()
        val database=readableDatabase
        val query="select*from ${MyObject2.TABLE_NAMES}"
        val cursor=database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val login= Login(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                )
                list.add(login)

            }while (cursor.moveToNext())
        }
        return list
    }
}
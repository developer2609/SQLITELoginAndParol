package com.developer.registerproject.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.developer.registerproject.db.MyObject.DB_NAME
import com.developer.registerproject.db.MyObject.ID
import com.developer.registerproject.db.MyObject.NAME
import com.developer.registerproject.db.MyObject.NUMBER
import com.developer.registerproject.db.MyObject.PAROL
import com.developer.registerproject.db.MyObject.TABLE_NAME
import com.developer.registerproject.db.MyObject.USERNAME
import com.developer.registerproject.model.Users

class MyDbHelper(context: Context):SQLiteOpenHelper(context,DB_NAME,null,1),MyDbInterface {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query="create table $TABLE_NAME ($ID integer not null primary key autoincrement unique,$NAME text not null,$NUMBER text not null,$USERNAME text not null ,$PAROL text not null )"
        p0?.execSQL(query)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    @SuppressLint("SuspiciousIndentation")
    override fun addUser(users: Users) {
          val database=writableDatabase
        val contentValues=ContentValues()
            contentValues.put(NAME,users.name)
            contentValues.put(NUMBER,users.number)
           contentValues.put(USERNAME,users.username)
           contentValues.put(PAROL,users.parol)
            database.insert(TABLE_NAME,null,contentValues)
            database.close()

    }

    override fun getAllUsers(): List<Users> {
     val list=ArrayList<Users>()
        val database=readableDatabase
        val query="select*from $TABLE_NAME"
        val cursor=database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val users=Users(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(2),
                    )
                list.add(users)

            }while (cursor.moveToNext())
        }
        return list




    }

}
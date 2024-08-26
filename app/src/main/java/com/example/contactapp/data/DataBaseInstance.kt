package com.example.contactapp.data

import android.content.Context
import androidx.room.Room
import com.example.contactapp.data.dataSource.ContactDataBase

object DataBaseInstance {
     var db: ContactDataBase?=null
    fun getDB(context:Context): ContactDataBase {
        if(db==null)
        {
            db=Room.databaseBuilder(context,ContactDataBase::class.java,"contact_db").allowMainThreadQueries().build()
        }
        return db!!
    }
}

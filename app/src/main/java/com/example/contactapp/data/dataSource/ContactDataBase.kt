package com.example.contactapp.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.data.table.Contact


@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactDataBase:RoomDatabase() {

    abstract fun dao(): ContactDao


}
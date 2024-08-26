package com.example.contactapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.contactapp.data.table.Contact


@Dao
interface ContactDao {

    @Upsert
    fun saveUpdateContact(contact: Contact)

    @Delete
    fun deleteContact(contact:Contact)

    @Query("SELECT * FROM contact")
    fun getAllContacts():List<Contact>

    @Query("Select * from contact where name Like '%' || :name || '%'")
    fun isContactAlreadyExist(name:String):List<Contact>

}
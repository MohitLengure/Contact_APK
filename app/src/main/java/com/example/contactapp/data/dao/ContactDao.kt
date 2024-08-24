package com.example.contactapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.contactapp.data.table.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert
    fun saveUpdateContact(contact: Contact)

    @Delete
    fun deleteContact(contact:Contact)

    @Query("Select * from contact")
    fun getAllContacts(): Flow<List<Contact>>



}
package com.example.contactapp.data.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
                  @PrimaryKey(autoGenerate = true) var id:Int?=null,

                   var name:String,
                   var phone:String,
                   var email:String
                   //var DOB:Long,
                   //var profile:ByteArray
)
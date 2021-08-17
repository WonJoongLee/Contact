package com.wonjoong.android.contact.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id : Int, // pk, auto generate at room
    val name : String,
    val age : Int,
    val company : String,
    val single : String
)

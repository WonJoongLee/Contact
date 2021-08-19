package com.wonjoong.android.contact.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // pk, auto generate at room
    val name: String,
    val relationship: String,
    val age: Int,
    val company: String,
    val hobby: String,
    val personality: String,
    val marriage: String,
    val children: String,
    val like: String,
    val dont_like: String,
    val etc: String
)

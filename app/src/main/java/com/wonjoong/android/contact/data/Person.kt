package com.wonjoong.android.contact.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // pk, auto generate at room

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "relationship")
    val relationship: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "company")
    val company: String,

    @ColumnInfo(name = "hobby")
    val hobby: String,

    @ColumnInfo(name = "personality")
    val personality: String,

    @ColumnInfo(name = "marriage")
    val marriage: String,

    @ColumnInfo(name = "children")
    val children: String,

    @ColumnInfo(name = "like")
    val like: String,

    @ColumnInfo(name = "dont_like")
    val dont_like: String,

    @ColumnInfo(name = "etc")
    val etc: String
)

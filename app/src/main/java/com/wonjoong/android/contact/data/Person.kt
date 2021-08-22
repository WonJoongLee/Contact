package com.wonjoong.android.contact.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // pk, auto generate at room

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "relationship")
    var relationship: String,

    @ColumnInfo(name = "age")
    var age: Int,

    @ColumnInfo(name = "company")
    var company: String,

    @ColumnInfo(name = "hobby")
    var hobby: String,

    @ColumnInfo(name = "personality")
    var personality: String,

    @ColumnInfo(name = "marriage")
    var marriage: String,

    @ColumnInfo(name = "children")
    var children: String,

    @ColumnInfo(name = "like")
    var like: String,

    @ColumnInfo(name = "dont_like")
    var dont_like: String,

    @ColumnInfo(name = "etc")
    var etc: String
) : Serializable

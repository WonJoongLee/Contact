package com.wonjoong.android.contact.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO : Contains the methods used for accessing the database
@Dao
interface PersonDAO {

    // OnConflictStrategy : If there is same person, just ignore the person. Maybe it should be change later
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(person: Person)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Person>>

    @Query("SELECT * FROM person_table WHERE id = :id")
    fun getUserById(id: Int): LiveData<Person>
}
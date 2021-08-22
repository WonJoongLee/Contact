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

    //@Query("SELECT * FROM person_table ORDER BY name ASC")
    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Person>>

    // This isn't using, because sending data from MainActivity to DetailsScreen will be
    // faster than searching data at DetailsScreen.
    @Query("SELECT * FROM person_table WHERE id = :id")
    fun getUserById(id: Int): LiveData<Person>

    @Query("UPDATE person_table SET name = :name, relationship = :relationship, age = :age, company = :company, hobby = :hobby, personality = :personality, marriage = :marriage, children = :children, like = :like, dont_like = :dontlike, etc = :etc WHERE id = :id")
    suspend fun updateUserById(
        id: Int,
        name : String,
        relationship : String,
        age : Int,
        company : String,
        hobby : String,
        personality : String,
        marriage : String,
        children : String,
        like : String,
        dontlike : String,
        etc: String
    )
}
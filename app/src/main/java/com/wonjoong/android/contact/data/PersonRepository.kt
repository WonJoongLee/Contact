package com.wonjoong.android.contact.data

import android.util.Log
import androidx.lifecycle.LiveData

// A repository class abstacts access to multiple data sources.
class PersonRepository(private val personDao: PersonDAO) {
    val readAllData: LiveData<List<Person>> = personDao.readAllData()
    suspend fun addPerson(person: Person) {
        personDao.addPerson(person)
    }

    val getUserById: (Int) -> LiveData<Person> = { id ->
        personDao.getUserById(id)
    }

    suspend fun updateUserById(
        id: Int,
        name: String,
        relationship: String,
        age: Int,
        company: String,
        hobby: String,
        personality: String,
        marriage: String,
        children: String,
        like: String,
        dontlike: String,
        etc: String
    ) {
        personDao.updateUserById(
            id,
            name,
            relationship,
            age,
            company,
            hobby,
            personality,
            marriage,
            children,
            like,
            dontlike,
            etc
        )
    }
}
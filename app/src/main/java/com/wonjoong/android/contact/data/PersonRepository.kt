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
        Log.e("1", personDao.getUserById(id).value.toString())
        personDao.getUserById(id)
    }
}
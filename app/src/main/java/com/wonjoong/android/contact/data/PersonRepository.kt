package com.wonjoong.android.contact.data

import androidx.lifecycle.LiveData

// A repository class abstacts access to multiple data sources.
class PersonRepository(private val personDao : PersonDAO) {
    val readAllData : LiveData<List<Person>> = personDao.readAllData()
    suspend fun addPerson(person : Person){
        personDao.addPerson(person)
    }
}
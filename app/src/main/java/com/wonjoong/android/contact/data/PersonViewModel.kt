package com.wonjoong.android.contact.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// viewmodel : The ViewModel's role is to provide data to the UI and survive configuration changes.
//             A ViewModel acts as a communication center between the Repository and the UI
class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Person>>
    private val repository: PersonRepository

    init {
        val personDao = PersonDatabase.getDatabase(application).personDao()
        repository = PersonRepository(personDao)
        readAllData = repository.readAllData
    }

    fun addPerson(person: Person) {
        // Use background thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPerson(person)
        }
    }
}
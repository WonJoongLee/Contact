package com.wonjoong.android.contact.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// viewmodel : The ViewModel's role is to provide data to the UI and survive configuration changes.
//             A ViewModel acts as a communication center between the Repository and the UI
class PersonViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Person>>
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

    fun getUserById(id: Int) = repository.getUserById(id)
    fun updateUserById(
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
        Log.e("CheckName", name)
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUserById(
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
}

class PersonViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            return PersonViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
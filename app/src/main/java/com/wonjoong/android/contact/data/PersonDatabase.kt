package com.wonjoong.android.contact.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Database : Contains the database holder and serves as the main access point for the underlying connection to your app's persisted, relational data
@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao() : PersonDAO

    // singleton, person database will have only one instance of its class
    companion object {
        // Volatile : visible to other thread
        @Volatile
        private var INSTANCE : PersonDatabase? = null

        fun getDatabase(context : Context) : PersonDatabase{
            val tempInstance = INSTANCE // Should use only one instance in room database, because having multiple instance in room database is expensive
            if(tempInstance != null){ // if instance exists, than return the instance
                return tempInstance
            }
            synchronized(this){ // otherwise, create new instance
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "person_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
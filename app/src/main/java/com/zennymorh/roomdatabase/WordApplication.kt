package com.zennymorh.roomdatabase

import android.app.Application

class WordApplication : Application(){
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    // We are doing this because we only want one instance of the
    // database and repository
    val database by lazy { WordRoomDatabase.getDatabase(this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}
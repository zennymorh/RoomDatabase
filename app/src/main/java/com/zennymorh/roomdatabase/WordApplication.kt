package com.zennymorh.roomdatabase

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordApplication : Application(){
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    // We are doing this because we only want one instance of the
    // database and repository

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}
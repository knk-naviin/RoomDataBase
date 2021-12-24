package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    companion object {
        @Volatile private var INSTANCE:UserDatabase?=null
        fun getInstance(context: Context):UserDatabase?
        {
            if (INSTANCE==null)
            {
                synchronized(UserDatabase::class.java){
                    INSTANCE=Room.databaseBuilder(
                        context,UserDatabase::class.java,"Userdatabase"
                    ).build()
                    return INSTANCE!!
                }
            }
            return INSTANCE
        }

    }
    abstract fun userdao():UserDAO
}


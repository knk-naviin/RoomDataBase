package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {
    @Insert
      fun insert(user: User)
     @Delete
      fun delete(user: User)
    @Query("SELECT * FROM user_Table")
     fun getuser():LiveData<List<User>>
}
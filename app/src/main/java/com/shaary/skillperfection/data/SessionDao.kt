package com.shaary.skillperfection.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface SessionDao {
    @Query("select * from session")
    fun getAll(): LiveData<List<Session>>

    @Query("select * from session where id = :id")
    fun getTimeById(id: Long): Session

    @Insert
    fun insert(timeData: Session)
}
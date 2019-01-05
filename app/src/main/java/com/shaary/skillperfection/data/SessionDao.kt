package com.shaary.skillperfection.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface SessionDao {
    @Query("select * from timedata")
    fun getAll(): List<Session>

    @Query("select * from timedata where id = :id")
    fun getTimeById(id: Long): Session

    @Insert
    fun insert(timeData: Session)
}
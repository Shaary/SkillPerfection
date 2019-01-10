package com.shaary.skillperfection.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface SkillDao {
    @Query("select * from skill")
    fun getAll(): LiveData<List<Skill>>

    @Query("select * from skill where id = :id")
    fun getSkillById(id: Long): Skill

    @Insert
    fun insert(skill: Skill)
}
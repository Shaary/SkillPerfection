package com.shaary.skillperfection.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface SkillDao {
    @Query("select * from skill")
    fun getAll(): LiveData<List<Skill>>

    @Query("select * from skill where id = :id")
    fun getSkillById(id: Long): Skill

    @Insert
    fun insert(skill: Skill)

    @Query("delete from skill where id = :id")
    fun delete(id: Long)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(skill: Skill)
}
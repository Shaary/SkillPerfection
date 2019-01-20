package com.shaary.skillperfection.ViewModel

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.shaary.skillperfection.data.Skill
import com.shaary.skillperfection.data.SkillDao

class SkillRepo(private val skillDao: SkillDao) {
    val allSkills: LiveData<List<Skill>> = skillDao.getAll()

    @WorkerThread
    suspend fun insert(skill: Skill) {
        skillDao.insert(skill)
    }

    @WorkerThread
    suspend fun delete(id: Long) {
        skillDao.delete(id)
    }

    @WorkerThread
    suspend fun update(skill: Skill){
        skillDao.update(skill)
    }
}
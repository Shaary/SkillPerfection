package com.shaary.skillperfection.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.shaary.skillperfection.data.Skill
import com.shaary.skillperfection.data.TrackingDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class SkillViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private val repository: SkillRepo
    val allSkills: LiveData<List<Skill>>

    init {
        val skillDao = TrackingDatabase.getDatabase(application).skillDao()
        repository = SkillRepo(skillDao)
        allSkills = repository.allSkills
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun insert(skill: Skill) = scope.launch(Dispatchers.IO) {
        repository.insert(skill)
    }
}
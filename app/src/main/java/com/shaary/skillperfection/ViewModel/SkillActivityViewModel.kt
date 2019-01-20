package com.shaary.skillperfection.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.shaary.skillperfection.data.Skill
import com.shaary.skillperfection.data.TrackingDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class SkillActivityViewModel(application: Application): AndroidViewModel(application) {
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private val repository: SkillRepo

    init {
        val skillDao = TrackingDatabase.getDatabase(application).skillDao()
        repository = SkillRepo(skillDao)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun delete(id: Long) = scope.launch(Dispatchers.IO) {
        repository.delete(id)
    }

    fun update(skill: Skill) = scope.launch(Dispatchers.IO) {
        repository.update(skill)
    }
}
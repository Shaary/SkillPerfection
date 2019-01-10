package com.shaary.skillperfection.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.shaary.skillperfection.data.Skill
import com.shaary.skillperfection.data.TrackingDatabase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

class SkillViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SkillRepo
    val allSkills: LiveData<List<Skill>>

    init {
        val skillDao = TrackingDatabase.getDatabase(application).skillDao()
        repository = SkillRepo(skillDao)
        allSkills = repository.allSkills
    }

    private var parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)
}
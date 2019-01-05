package com.shaary.skillperfection.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Skill(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        val name: String,
        val time: Long = 0)
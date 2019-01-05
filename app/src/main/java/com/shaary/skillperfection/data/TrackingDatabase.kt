package com.shaary.skillperfection.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Session::class], version = 1)
abstract class TrackingDatabase: RoomDatabase() {
    abstract fun sessionDao(): SessionDao
    abstract fun skillDao(): SkillDao
}

/* Make two tables Skill and Session. And make one to many relationship.
    For Skill table have columns: id, name, total time.
    For Sessions have: id, date, time, skill_id.
 */
package com.shaary.skillperfection.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Session::class, Skill::class], version = 1)
abstract class TrackingDatabase: RoomDatabase() {
    abstract fun sessionDao(): SessionDao
    abstract fun skillDao(): SkillDao

    companion object {
        @Volatile
        private var INSTANCE: TrackingDatabase? = null

        fun getDatabase(context: Context): TrackingDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TrackingDatabase::class.java,
                        "Word_database"
                ).allowMainThreadQueries() //TODO: change to calls on the different thread
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

/* Make two tables Skill and Session. And make one to many relationship.
    For Skill table have columns: id, name, total time.
    For Sessions have: id, date, time, skill_id.
 */
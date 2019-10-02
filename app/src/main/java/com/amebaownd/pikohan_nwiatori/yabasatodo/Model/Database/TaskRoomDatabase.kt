package com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task

@Database(entities = arrayOf(Task::class),version = 1)
abstract class TaskRoomDatabase:RoomDatabase(){
    abstract fun taskDao() : TaskDao

    companion object{
        @Volatile
        private var INSTANCE : TaskRoomDatabase?=null

        fun getDatabase(context: Context):TaskRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
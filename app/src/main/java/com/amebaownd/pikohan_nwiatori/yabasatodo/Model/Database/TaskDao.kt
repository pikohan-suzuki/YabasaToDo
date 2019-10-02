package com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task

@Dao
interface TaskDao{
    @Query("SELECT * FROM task_table ORDER BY task_id ASC")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
package com.amebaownd.pikohan_nwiatori.yabasatodo.Repository

import androidx.lifecycle.LiveData
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Database.TaskDao
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task

class TaskRepository (private val taskDao: TaskDao){

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task:Task){
        taskDao.insert(task)
    }
}
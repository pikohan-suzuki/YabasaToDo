package com.amebaownd.pikohan_nwiatori.yabasatodo.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Database.TaskRoomDatabase
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task
import com.amebaownd.pikohan_nwiatori.yabasatodo.Repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel (application: Application):AndroidViewModel(application){
    private val repository:TaskRepository
    val allTasks:LiveData<List<Task>>


    init{
        val taskDao = TaskRoomDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        allTasks = repository.allTasks
    }

    fun insert(task:Task) = viewModelScope.launch {
        repository.insert(task)
    }
}
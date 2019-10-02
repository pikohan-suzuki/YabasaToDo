package com.amebaownd.pikohan_nwiatori.yabasatodo

import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task

internal fun getActiveAndCompletedStats(tasks:List<Task>?):StatsResult{
    return if(tasks==null || tasks.isEmpty()){
        StatsResult(0f,0f)
    }else{
        val totalTasks = tasks.size
        val numberOfActiveTasks = tasks.count{it.isActive}
        StatsResult(
            activeStats = 100f * numberOfActiveTasks / totalTasks,
            completedStats = 100f * numberOfActiveTasks / totalTasks
        )
    }
}

data class StatsResult(val activeStats:Float,val completedStats:Float)
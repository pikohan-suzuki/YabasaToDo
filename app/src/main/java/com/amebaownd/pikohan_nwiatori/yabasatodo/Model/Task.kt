package com.amebaownd.pikohan_nwiatori.yabasatodo.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task_table")
data class Task(

    @PrimaryKey
    @ColumnInfo(name="task_id")
    var id:String = UUID.randomUUID().toString(),
    @ColumnInfo(name="title")
    val title:String,
    @ColumnInfo(name="deadline")
    val deadline:Long,
    @ColumnInfo(name="category")
    val category:Int,
    @ColumnInfo(name="isActive")
    var isActive:Boolean = true
)
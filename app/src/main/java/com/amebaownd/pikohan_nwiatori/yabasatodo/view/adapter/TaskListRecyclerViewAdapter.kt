package com.amebaownd.pikohan_nwiatori.yabasatodo.view.adapter

import android.content.Context
import android.graphics.Color
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.amebaownd.pikohan_nwiatori.yabasatodo.Category
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task
import com.amebaownd.pikohan_nwiatori.yabasatodo.R
import java.util.*

class TaskListRecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<TaskListRecyclerViewAdapter.TaskListViewHolder>() {

    private var taskList = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.task_card, parent, false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.title.text = taskList[position].title
        holder.category.text = when (taskList[position].category) {
            1 -> {
                holder.card.setBackgroundColor(Color.RED)
                "Event"
            }
            2 -> {
                holder.card.setBackgroundColor(Color.GREEN)
                "Task"
            }
            3 -> {
                holder.card.setBackgroundColor(Color.CYAN)
                "Other"
            }
            else -> ""
        }
        holder.remaind.text =
            if (Date().time - taskList[position].deadline > 0) "期限切れ"
            else (Date().time - taskList[position].deadline).toString()

        holder.completed.isChecked= !(taskList[position].isActive)
    }

    fun setTaskList(taskList:List<Task>){
        this.taskList = taskList
        notifyDataSetChanged()
    }

    class TaskListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card = view.findViewById<CardView>(R.id.task_cardView)
        val title = view.findViewById<TextView>(R.id.task_card_title)
        val remaind = view.findViewById<TextView>(R.id.task_card_remaind)
        val category = view.findViewById<TextView>(R.id.task_card_category)
        val completed =view.findViewById<CheckBox>(R.id.completed_checkBox)
    }
}
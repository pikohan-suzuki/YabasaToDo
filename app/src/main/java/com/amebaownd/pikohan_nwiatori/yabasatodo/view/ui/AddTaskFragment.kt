package com.amebaownd.pikohan_nwiatori.yabasatodo.view.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.amebaownd.pikohan_nwiatori.yabasatodo.Model.Task
import com.amebaownd.pikohan_nwiatori.yabasatodo.R
import com.amebaownd.pikohan_nwiatori.yabasatodo.ViewModel.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_addtask.*
import kotlinx.android.synthetic.main.fragment_tasklist.*

class AddTaskFragment():Fragment(){

    lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_addtask,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFab()

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.main, menu)
    }
    private fun setupFab(){
        view?.findViewById<FloatingActionButton>(R.id.submit_addtask_fab)?.let {
            it.setOnClickListener{
                taskViewModel.insert(Task(
                    title = add_task_title.text.toString(),
                    deadline = add_task_deadLine.text.toString().toLong(),
                    category = add_task_category.text.toString().toInt(),
                    isActive = true
                ))
                navigateToTaskListFragment()
            }
        }
    }

    private fun navigateToTaskListFragment(){
        val action =
            AddTaskFragmentDirections.actionAddTaskFragmentToTaskListFragment()
        findNavController().navigate(action)
    }


    private fun validation():Boolean{
        return add_task_title.text.toString().isNotBlank()
    }
}
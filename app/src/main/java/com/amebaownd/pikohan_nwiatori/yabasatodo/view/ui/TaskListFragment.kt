package com.amebaownd.pikohan_nwiatori.yabasatodo.view.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amebaownd.pikohan_nwiatori.yabasatodo.R
import com.amebaownd.pikohan_nwiatori.yabasatodo.ViewModel.TaskViewModel
import com.amebaownd.pikohan_nwiatori.yabasatodo.view.adapter.TaskListRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment() : Fragment() {

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_tasklist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFab()

        val recyclerView = view.findViewById<RecyclerView>(R.id.task_list_recyclerView)
        val adapter = TaskListRecyclerViewAdapter(view.context)
        recyclerView.adapter= adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        taskViewModel.allTasks.observe(this, Observer { tasks->
            tasks?.let{
                adapter.setTaskList(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu,inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.action_menu_filter -> {
                openFilterPopUpMenu()
                Toast.makeText(this.context,"Taped",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.sort_by_yabasa -> {
                true
            }
            R.id.sort_by_deadline -> {
                true
            }
            R.id.sort_by_weight_asc -> {
                true
            }
            R.id.sort_by_weight_desc -> {
                true
            }
            else -> false
        }


    private fun openFilterPopUpMenu(){

    }

    private fun setupFab() {
        view?.findViewById<FloatingActionButton>(R.id.add_task_fab)?.let {
            it.setOnClickListener { navigateToAddTaskFragment() }
        }
    }

    private fun navigateToAddTaskFragment() {
        val action =
            TaskListFragmentDirections.actionTaskListFragmentToAddTaskFragment()
        findNavController().navigate(action)
    }
}
package com.example.debtsapp.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.debtsapp.R
import com.example.debtsapp.databinding.FragmentActivitiesBinding
import com.example.debtsapp.models.User
import com.example.debtsapp.ui.activities.add_group.AddGroupFragment


class GroupsFragment : Fragment() {

    private lateinit var groupsViewModel: GroupsViewModel
    private var _binding: FragmentActivitiesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupsViewModel =
            ViewModelProvider(this).get(GroupsViewModel::class.java)

        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.addGroupButton.setOnClickListener {
            showAddActivityDialog()
            // val navController = Navigation.findNavController(root)
            // navController.navigate(R.id.action_navigation_groups_to_addGroupFragment2)
        }

        binding.activitiesListRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = GroupAdapter(createTestList()) {
                val navController = Navigation.findNavController(root)
                navController.navigate(R.id.action_navigation_groups_to_navigation_activity_info)
            }
        }

        return root
    }

    // TODO: replace
    private fun createTestList(): ArrayList<com.example.debtsapp.models.Activity> {
        return arrayListOf(
            com.example.debtsapp.models.Activity(0, "test", 0, User(0, "test user 0"), 789),
            com.example.debtsapp.models.Activity(1, "test", 1, User(0, "test user 1"), 4567),
            com.example.debtsapp.models.Activity(0, "test", 0, User(0, "test user 0"), 789),
            com.example.debtsapp.models.Activity(1, "test", 1, User(0, "test user 1"), 4567),
            com.example.debtsapp.models.Activity(0, "test", 0, User(0, "test user 0"), 789),
            com.example.debtsapp.models.Activity(1, "test", 1, User(0, "test user 1"), 4567),
            com.example.debtsapp.models.Activity(0, "test", 0, User(0, "test user 0"), 789),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showAddActivityDialog() {
        val fragmentManager = activity?.supportFragmentManager
        val newFragment = AddGroupFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction
            ?.add(android.R.id.content, newFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}
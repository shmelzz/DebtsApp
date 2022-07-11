package com.example.debtsapp.ui.activities.add_group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.debtsapp.databinding.DialogAddActivityBinding

class AddGroupFragment : DialogFragment() {

    private lateinit var groupsViewModel: AddGroupViewModel
    private var _binding: DialogAddActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupsViewModel =
            ViewModelProvider(this).get(AddGroupViewModel::class.java)

        _binding = DialogAddActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.topAppBar.setNavigationOnClickListener {
            dismiss()
        }

        binding.topAppBar.setOnMenuItemClickListener {
            // TODO: change later
            dismiss()
            true
        }

        binding.addActivityMembersBtn.setOnClickListener {
            val dialog = AddMembersDialog()
            activity?.supportFragmentManager?.let {
                dialog.show(it, "members")
            }
            binding.addActivityMembersTv.visibility = TextView.VISIBLE
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
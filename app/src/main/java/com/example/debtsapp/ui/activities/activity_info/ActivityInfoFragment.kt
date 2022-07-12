package com.example.debtsapp.ui.activities.activity_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.debtsapp.databinding.FragmentActivityInfoBinding

class ActivityInfoFragment : Fragment() {
    private lateinit var activityInfoViewModel: ActivityInfoViewModel
    private var _binding: FragmentActivityInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activityInfoViewModel =
            ViewModelProvider(this).get(ActivityInfoViewModel::class.java)
        _binding = FragmentActivityInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.topAppBar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.debtsapp.ui.activities.add_group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debtsapp.databinding.AddMemberCardBinding
import com.example.debtsapp.models.User

class AddMembersAdapter(private val dataSet: ArrayList<User>) :
    RecyclerView.Adapter<AddMembersAdapter.AddMembersViewHolder>() {

    class AddMembersViewHolder(private val cardBinding: AddMemberCardBinding) :
        RecyclerView.ViewHolder(cardBinding.root) {

        fun bindArticle(user: User) {
            cardBinding.friendNameTv.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddMembersViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AddMemberCardBinding.inflate(from, parent, false)
        return AddMembersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddMembersViewHolder, position: Int) {
        holder.bindArticle(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}
package com.example.debtsapp.ui.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debtsapp.databinding.ActivityCardBinding
import com.example.debtsapp.models.Activity

class GroupAdapter(
    private val dataSet: ArrayList<Activity>,
    private val onItemClicked: (position: Int) -> Unit
) :
    RecyclerView.Adapter<GroupAdapter.GroupHolder>() {

    class GroupHolder(
        private val cardBinding: ActivityCardBinding,
        onItemClicked: (Int) -> Unit
    ) : RecyclerView.ViewHolder(cardBinding.root) {

        init {
            itemView.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        fun bindArticle(activity: Activity) {
            cardBinding.activityCardTitleTv.text = activity.name
            cardBinding.activityCardSumTv.text = "Sum: " + activity.sum.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ActivityCardBinding.inflate(from, parent, false)
        return GroupHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        holder.bindArticle(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}
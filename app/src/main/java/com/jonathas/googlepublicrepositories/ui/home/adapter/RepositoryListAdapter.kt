package com.jonathas.googlepublicrepositories.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonathas.googlepublicrepositories.databinding.ListitemHomeRepoBinding
import com.jonathas.googlepublicrepositories.ui.home.HomeRepoModel

class RepositoryListAdapter : RecyclerView.Adapter<RepositoryListAdapter.RepositoryItem>() {

    var repositoryList: List<HomeRepoModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItem =
        RepositoryItem(
            ListitemHomeRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryItem, position: Int) {
        holder.bindData(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size


    inner class RepositoryItem(
        private val binding: ListitemHomeRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: HomeRepoModel) {
            binding.repo = item
        }
    }

}
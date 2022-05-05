package com.example.githubrepos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepos.databinding.ListItemReposBinding

class RepoAdapter() : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    var list : List<ItemsItem> = arrayListOf()

    inner class RepoHolder(val binding: ListItemReposBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemsItem) {
            binding.tvRepoName.text = item.name
            val url = item.owner?.avatarUrl
            Glide.with(itemView.context).load(url).placeholder(R.drawable.repos).into(binding.ivRepo)

            itemView.setOnClickListener {
                val intent = Intent(it.context,SingleRepoActivity::class.java)
                item.stargazersCount?.let { it1 -> intent.putExtra("StarCount", it1.toInt()) }
                intent.putExtra("Readme",item.description.toString())
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        return RepoHolder(ListItemReposBinding.bind(LayoutInflater.from(parent.context).
                inflate(R.layout.list_item_repos,parent,false)))
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun swapData(newData: List<ItemsItem>) {
        this.list = newData
        notifyDataSetChanged()
    }
}
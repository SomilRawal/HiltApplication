package com.rawaldevs.hiltapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rawaldevs.hiltapplication.databinding.PartialItemUserBinding
import com.rawaldevs.hiltapplication.model.User


/**
 * @auther Somil Rawal
 * Created on 18-11-2024 at 20:36.
 * somil.rawal@gmail.com
 */

class UserAdapter  : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val diffUtil = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
    val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            PartialItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(parent.context, binding)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder as UserViewHolder) {
            val user = asyncListDiffer.currentList[position]
            binding?.textviewName?.text = user?.name
            binding?.textviewEmail?.text = user?.email
        }
    }

    inner class UserViewHolder(context: Context, val binding: PartialItemUserBinding?) :
        RecyclerView.ViewHolder(binding?.root ?: View(context))


}
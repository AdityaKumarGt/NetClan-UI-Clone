package com.aditya.netclan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditya.netclan.R
import com.aditya.netclan.databinding.UserItemBinding
import com.aditya.netclan.model.User
import com.bumptech.glide.Glide
import java.util.Locale

class UsersAdapter(var context: Context, var userList: List<User>):
    RecyclerView.Adapter<UsersAdapter.MyUserViewHolder>() {

    var filteredList: List<User> = ArrayList(userList)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersAdapter.MyUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.MyUserViewHolder, position: Int) {
        val user = filteredList[position]

        holder.binding.name.text = user.name
        holder.binding.city.text = user.city
        holder.binding.position.text = user.position
        holder.binding.interests.text = "${user.purposes?.get(0)} | ${user.purposes?.get(1)} | ${user.purposes?.get(2)}"
        holder.binding.status.text = user.status
        holder.binding.about.text = user.about
        holder.binding.distanceRange.text = "Within ${user.distanceRange}"

        if (user.image != null){
            holder.binding.profileImage.visibility = View.VISIBLE
            holder.binding.acronymName.visibility = View.GONE
            Glide.with(context)
                .load(user.image) // URL or resource ID
                .into(holder.binding.profileImage)
        }else{
            holder.binding.profileImage.visibility = View.GONE
            holder.binding.acronymName.visibility = View.VISIBLE
            holder.binding.acronymName.text = user.acronymName
        }


    }

    override fun getItemCount(): Int {
        return filteredList.size

    }


   inner class MyUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: UserItemBinding = UserItemBinding.bind(view)

    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            ArrayList(userList)
        } else {
            val lowercaseQuery = query.toLowerCase(Locale.ROOT)
            userList.filterTo(ArrayList()) {
                it.name?.toLowerCase(Locale.ROOT)?.contains(lowercaseQuery) == true ||
                        it.city?.toLowerCase(Locale.ROOT)?.contains(lowercaseQuery) == true ||
                        it.position?.toLowerCase(Locale.ROOT)?.contains(lowercaseQuery) == true ||
                        it.purposes?.any { purpose -> purpose.toLowerCase(Locale.ROOT).contains(lowercaseQuery) } == true ||
                        it.status?.toLowerCase(Locale.ROOT)?.contains(lowercaseQuery) == true ||
                        it.about?.toLowerCase(Locale.ROOT)?.contains(lowercaseQuery) == true

            }
        }
        notifyDataSetChanged()
    }



    fun submitList(newList: List<User>) {
        userList = ArrayList(newList)
        notifyDataSetChanged()
    }


}
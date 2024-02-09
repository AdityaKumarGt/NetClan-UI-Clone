package com.aditya.netclan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditya.netclan.R
import com.aditya.netclan.databinding.BusinessUserItemBinding
import com.aditya.netclan.databinding.UserItemBinding
import com.aditya.netclan.model.BusinessUser
import com.aditya.netclan.model.User
import com.bumptech.glide.Glide
import java.util.Locale

class BusinessUsersAdapter(var context: Context, var userList: List<BusinessUser>):
    RecyclerView.Adapter<BusinessUsersAdapter.MyBusinessUserViewHolder>() {

    var filteredList: List<BusinessUser> = ArrayList(userList)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessUsersAdapter.MyBusinessUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.business_user_item, parent, false)
        return MyBusinessUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: BusinessUsersAdapter.MyBusinessUserViewHolder, position: Int) {
        val user = filteredList[position]

        holder.binding.name.text = user.name
        holder.binding.cityAndRange.text = "${user.city}, within ${user.distanceRange}"
        holder.binding.position.text = "${user.position?.get(0)} | ${user.position?.get(1)}"
        holder.binding.status.text = user.status

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


    inner class MyBusinessUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: BusinessUserItemBinding = BusinessUserItemBinding.bind(view)

    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            ArrayList(userList)
        } else {
            val lowercaseQuery = query.toLowerCase(Locale.ROOT)
            userList.filterTo(ArrayList()) {
                it.name!!.toLowerCase(Locale.ROOT).contains(lowercaseQuery) ||
                        it.city!!.toLowerCase(Locale.ROOT).contains(lowercaseQuery) ||
                        it.position!!.any { purpose -> purpose.toLowerCase(Locale.ROOT).contains(lowercaseQuery) } ||
                        it.status!!.toLowerCase(Locale.ROOT).contains(lowercaseQuery)
            }
        }
        notifyDataSetChanged()
    }



    fun submitList(newList: List<BusinessUser>) {
        userList = ArrayList(newList)
        notifyDataSetChanged()
    }


}
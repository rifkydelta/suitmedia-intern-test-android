package com.rifkydelta.suitmedia

import User
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.tvItemName.text = user.fullName
        holder.tvItemDescription.text = user.email

        // Menggunakan Glide untuk memuat gambar dari URL ke ImageView
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .circleCrop() // untuk menjadikan gambar bulat
            .into(holder.imgItemPhoto)

        // Set OnClickListener untuk pindah ke UserContentActivity
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, UserContentActivity::class.java)
            intent.putExtra(UserContentActivity.EXTRA_NAME, user.fullName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val imgItemPhoto: ShapeableImageView = itemView.findViewById(R.id.img_item_photo)
    }
}

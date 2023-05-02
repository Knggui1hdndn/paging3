package com.example.phntrangtrongrcy.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3.R
import com.example.phntrangtrongrcy.model.entity.User
import retrofit2.Response.error

class MainAdapter( ) :
    PagingDataAdapter<User, MainAdapter.MainAdapterViewHolder>(COMPARATOR) {

    class MainAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.avatar)
        val txt = itemView.findViewById<TextView>(R.id.txt)
        fun bind(data: User) {
//            Glide.with(itemView.context)
//                .load(data.avatar)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .centerCrop()
//                .into(img)
            txt.text = data.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {
        return MainAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        val dataList = snapshot()// và trả về một danh sách hiện tại của dữ liệu
        if (dataList.isNotEmpty()) {
            val data = dataList[position]
            if (data != null) {
                holder.bind(data)
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }
}
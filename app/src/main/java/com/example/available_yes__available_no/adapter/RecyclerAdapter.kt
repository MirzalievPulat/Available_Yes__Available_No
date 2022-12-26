package com.example.available_yes__available_no.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.available_yes__available_no.R
import com.example.available_yes__available_no.model.Member

class RecyclerAdapter(val contex:Context,var members:ArrayList<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        if (members[position].available) {
            return 0
        }else
            return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_member_layout,parent,false)
            return MemberViewHolder(view)
        }else {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_member_layout_no, parent, false)
            return MemberViewNoHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var member = members[position]

        if (holder is MemberViewHolder){
            holder.picture.setImageResource(member.picture)
            holder.surname.text = member.surname
            holder.name.text = member.name
        }
        if (holder is MemberViewNoHolder){
            holder.surname.text = "This surname is not available"
            holder.name.text = "This name is not available"
        }
    }

    }

    class MemberViewHolder(var view:View):RecyclerView.ViewHolder(view){
        var picture = view.findViewById<ImageView>(R.id.picture)
        var surname = view.findViewById<TextView>(R.id.tv_surname)
        var name = view.findViewById<TextView>(R.id.tv_name)
    }

    class MemberViewNoHolder(var view:View):RecyclerView.ViewHolder(view){
        var surname = view.findViewById<TextView>(R.id.tv_surname)
        var name = view.findViewById<TextView>(R.id.tv_name)
    }
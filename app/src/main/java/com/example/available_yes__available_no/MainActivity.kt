package com.example.available_yes__available_no

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.available_yes__available_no.adapter.RecyclerAdapter
import com.example.available_yes__available_no.model.Member

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }
    fun initviews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshAdapter(prepareMembers())
    }

    fun refreshAdapter(members:ArrayList<Member>){
        recyclerView.adapter = RecyclerAdapter(this, members)
    }

    fun prepareMembers(): ArrayList<Member>{
        var members = ArrayList<Member>()

        for (i in 1..30){
            if (i == 1 || i ==8 || i == 15 || i == 25){
                members.add(Member(R.drawable.sample, "Mirzaliyev", "Po'lat", false))
            }else
                members.add(Member(R.drawable.sample, "Mirzaliyev", "Po'lat", true))
        }
        return members
    }
}
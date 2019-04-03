package com.yirong.androidanimation


import android.annotation.SuppressLint
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_normal.view.*
import android.app.Activity
import android.content.Intent



@SuppressLint("RestrictedApi")
class MainActivity : Activity() {
    lateinit var ITEMS:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ITEMS =ArrayList<String>()
        ITEMS.add(0,"补间动画")
        ITEMS.add(1,"属性动画")
        ITEMS.add(2,"帧动画")
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //初始化适配器
        recyclerView.adapter = MyRecyclerViewAdapter(ITEMS)

    }

    inner class MyRecyclerViewAdapter(private val list: List<String>) :
        RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>(),View.OnClickListener {
        override fun onClick(v: View?) {
            if(v!=null){
                Log.i("item_click",v.tag.toString())
                var intent = Intent(applicationContext,SecondActivity::class.java)

                var pos = v.tag as Int
                intent!!.putExtra("tag",pos)
                intent!!.putExtra("title",ITEMS[pos])

                startActivity(intent)

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_normal, parent, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyRecyclerViewAdapter.ViewHolder, position: Int) {
            holder.mText.text = list[position]
            holder.mText.tag = position
            holder.mText.setOnClickListener(this)
        }

        override fun getItemCount(): Int {
            Log.i("size",""+list.size)
            return list.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var mText: TextView = itemView.item_tx

        }
    }

}

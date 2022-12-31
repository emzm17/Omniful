package com.example.github.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.github.DetailsActivity
import com.example.github.R
import com.example.github.data.Item
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterRepo(private val context:Context,private val list:ArrayList<Item>):RecyclerView.Adapter<AdapterRepo.AdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
       return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
         holder.bind(list[position])
         holder.itemView.setOnClickListener {
             Toast.makeText(context, list[position].name,Toast.LENGTH_LONG).show()
             val intent=Intent(context, DetailsActivity::class.java)
             intent.putExtra("REPO",list[position])
             startActivity(context,intent,null)
         }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class AdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

          fun bind(item: Item)=with(itemView){
                 title_tv.text=item.name
                 stars_tv.text=item.stargazers_count.toString()
                 desc_tv.text=item.description
          }

    }
}
package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github.data.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm:GithubViewModel
    private lateinit var adapter:AdapterRepo
    private lateinit var list:ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm=ViewModelProvider(this)[GithubViewModel::class.java]
        vm.Everything()
        list=ArrayList()
        adapter= AdapterRepo(this,list)
        rcview.layoutManager=LinearLayoutManager(this)
        rcview.adapter=adapter
        vm.list.observe(this) {
            if (it.isSuccessful) {
                it.body()!!.items.forEach { itr->
                     list.add(itr)
                }

            }

        }


    }
}
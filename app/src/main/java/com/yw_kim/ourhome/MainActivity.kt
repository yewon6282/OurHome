package com.yw_kim.ourhome

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val recycler_item = mutableListOf<RecyclerViewModel>()

        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))
        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))
        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))

        val recyclerview_main = findViewById<ListView>(R.id.recyclerview_main)

        val recyclerviewAdapter = RecyclerViewAdapter(recycler_item)

        recyclerview_main.adapter = recyclerviewAdapter

        recyclerview_main.setOnItemClickListener { parent, view, position, id ->

        }*/

        val items = mutableListOf<RecyclerViewModel>()

        items.add(RecyclerViewModel("안녕하세요.", "원룸에 새로 이사한 ..."))
        items.add(RecyclerViewModel("정보 알려주세요.", "편안한 의자를 사고 싶은데 ..."))

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview_main)
        val recyclerViewAdapter = RecyclerViewAdapter(items)

        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerViewAdapter.itemClick = object : RecyclerViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position].title, Toast.LENGTH_LONG).show()
            }
        }
    }
}
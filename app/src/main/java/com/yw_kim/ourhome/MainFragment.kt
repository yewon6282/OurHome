package com.yw_kim.ourhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageButton
import androidx.navigation.findNavController

class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* val recycler_item = mutableListOf<RecyclerViewModel>()

        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))
        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))
        recycler_item.add(RecyclerViewModel("안녕하세요.", "새로 이사한 ..."))

        val recyclerview_main = findViewById<ListView>(R.id.recyclerview_main)

        val recyclerviewAdapter = RecyclerViewAdapter(recycler_item)

        recyclerview_main.adapter = recyclerviewAdapter

        recyclerview_main.setOnItemClickListener { parent, view, position, id ->

        }*/

        /*val items = mutableListOf<RecyclerViewModel>()

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
        }*/
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.findViewById<ImageButton>(R.id.main_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_self)
        }

        view.findViewById<ImageButton>(R.id.un_button).setOnClickListener {

        }

        view.findViewById<ImageButton>(R.id.mypage_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_mypageFragment)
        }

        return view
    }
}
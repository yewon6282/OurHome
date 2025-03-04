package com.yw_kim.ourhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
class RecyclerViewAdapter (val List : MutableList<RecyclerViewModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        if(convertView == null) {
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_item, parent, false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listview_title)
        title.text = List[position].title

        val content = convertView.findViewById<TextView>(R.id.listview_content)
        content.text = List[position].content

        return convertView!!
    }
}*/

class RecyclerViewAdapter (val items : MutableList<RecyclerViewModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        if(itemClick != null)
        {
            holder.itemView.setOnClickListener {v ->
                itemClick?.onClick(v, position)
            }
        }

        holder.bindItems(items[position])
    }

    // 전체 리사이클러뷰의 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : RecyclerViewModel) {
            val recycler_title = itemView.findViewById<TextView>(R.id.recyclerview_title)
            val recycler_content = itemView.findViewById<TextView>(R.id.recyclerview_content)

            recycler_title.text = item.title
            recycler_content.text = item.content
        }
    }
}
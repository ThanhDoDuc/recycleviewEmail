package com.example.myapplication
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

data class ItemModel(val avatar: String, val nickname: String, val title: String, val content: String, val time: String)
class RVItemAdapter(val items: ArrayList<ItemModel>, val listener: ItemClickListener?): RecyclerView.Adapter<RVItemAdapter.RVItemViewHolder>() {
class RVItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
    val avatar = itemView.findViewById<TextView>(R.id.avatar)
    val nickname = itemView.findViewById<TextView>(R.id.nickname)
    val title = itemView.findViewById<TextView>(R.id.title)
    val content = itemView.findViewById<TextView>(R.id.content)
    val time = itemView.findViewById<TextView>(R.id.time)
    init {
        itemView.setOnClickListener {
            listener?.ItemClick(adapterPosition)
        }
    }
    }
    interface ItemClickListener {
        fun ItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_item, parent, false)
        return RVItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.avatar.text = items[position].avatar
        holder.title.text = items[position].title
        holder.time.text = items[position].time
        holder.content.text = items[position].content
        holder.nickname.text = items[position].nickname
        Log.i("tung", "onBindViewHolder: ")
    }
}
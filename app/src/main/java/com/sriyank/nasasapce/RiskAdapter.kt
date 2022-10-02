package com.sriyank.nasasapce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.nasasapce.model.RiskData

class RiskAdapter(private var RiskList: ArrayList<RiskData>):
    RecyclerView.Adapter<RiskAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener){

        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.riskitem,
            parent,false)

        return ViewHolder(v,mListener)
    }


    override fun getItemCount(): Int {
        return RiskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = RiskList[position]

        holder.img.setImageResource(currentItem.img)
        holder.title.text = currentItem.Stress
        holder.discription.text = currentItem.About

    }

    class ViewHolder(itemView: View, listener: onItemClickListener):
        RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.RiskImage)
        val title: TextView = itemView.findViewById(R.id.TitleRisk)
        val discription: TextView = itemView.findViewById(R.id.DiscRisk)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }

}
package com.example.kalkulator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class kalkuAdapter(private val dataSet : MutableList<DataKalkul>):
        RecyclerView.Adapter<kalkuAdapter.DataKalkulHolder>(){

    class DataKalkulHolder(view: View):RecyclerView.ViewHolder(view) {
        val hasil = view.findViewById<TextView>(R.id.hasil)
        val bil1 =view.findViewById<TextView>(R.id.Bil1)
        val bil2 = view.findViewById<TextView>(R.id.bil2)
        val hapus = view.findViewById<ImageView>(R.id.icDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
       DataKalkulHolder{
           val view = LayoutInflater.from(parent.context).inflate(
               R.layout.activity_kalku_adapter,parent,false
           )
        return DataKalkulHolder(view)
       }


    override fun onBindViewHolder(holder: DataKalkulHolder, position: Int) {
        val data = dataSet[position]
        holder.hasil.text = dataSet[position].Hasil
        holder.bil1.text = dataSet[position].Bil1
        holder.bil2.text = dataSet[position].Bil2
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
       return dataSet.size
    }

}
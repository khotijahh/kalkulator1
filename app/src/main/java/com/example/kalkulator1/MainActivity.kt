package com.example.kalkulator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bil1 : EditText
    private lateinit var bil2 : EditText
    private lateinit var tambah: Button
    private lateinit var kurang : Button
    private lateinit var kali : Button
    private lateinit var bagi : Button
    private lateinit var txtHasil : TextView
    private lateinit var Hasil : TextView
    private lateinit var btnSimpan : Button
    private lateinit var btnHapus : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bil1 = findViewById(R.id.editBil1)
        bil2 = findViewById(R.id.editBil2)
        tambah = findViewById(R.id.btnTambah)
        kurang = findViewById(R.id.btnMin)
        kali = findViewById(R.id.btnKali)
        bagi = findViewById(R.id.btnBagi)
        txtHasil = findViewById(R.id.txtHasil)
        Hasil = findViewById(R.id.tvHasil2)
        btnHapus = findViewById(R.id.btnDelete)
        btnSimpan = findViewById(R.id.btnSimpan)
        recyclerView = findViewById(R.id.listData)

    val data = mutableListOf<DataKalkul>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = kalkuAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager= viewManager

        btnSimpan.setOnClickListener {
            val bil1 = bil1.text.toString()
            val bil2 = bil2.text.toString()
            val hasil = Hasil.text.toString()

            val dataSiswa = DataKalkul(bil1,bil2,hasil)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
        tambah.setOnClickListener{ plus() }
        kurang.setOnClickListener{ min() }
        bagi.setOnClickListener{ bagi() }
        kali.setOnClickListener { kali() }
        btnHapus.setOnClickListener { reset() }
    }
    fun plus(){
        val hitung = bil1.text.toString().toDouble() + bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()
    }
    fun min(){
        val hitung = bil1.text.toString().toDouble() - bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()
    }
    fun kali(){
        val hitung = bil1.text.toString().toDouble() * bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()
    }
    fun bagi(){
        val hitung = bil1.text.toString().toDouble() / bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()
    }
    fun reset(){
        Hasil.text = "0"
        bil1.text.clear()
        bil2.text.clear()
    }
}
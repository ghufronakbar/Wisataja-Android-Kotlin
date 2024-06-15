package com.example.wisataja.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataja.DetailWisataActivity
import com.example.wisataja.R
import com.example.wisataja.model.Wisata

class KategoriAdapter(
    private val context: Context,
    private val wisataList: List<Wisata>
) : RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

    inner class KategoriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivWisata: ImageView = itemView.findViewById(R.id.ivKategori)
        private val tvNamaWisata: TextView = itemView.findViewById(R.id.tvNamaWisataCard)

        fun bind(wisata: Wisata) {
            ivWisata.setImageResource(wisata.gambar)
            tvNamaWisata.text = wisata.nama

            itemView.setOnClickListener {
                val intent = Intent(context, DetailWisataActivity::class.java).apply {
                    putExtra("nama", wisata.nama)
                    putExtra("rating", wisata.rating)
                    putExtra("lokasi", wisata.lokasi)
                    putExtra("gambar", wisata.gambar)
                    putExtra("jambuka", wisata.jambuka)
                    putExtra("harga", wisata.harga)
                    putExtra("detail1", wisata.detail1)
                    putExtra("detail2", wisata.detail2)
                    putExtra("detail3", wisata.detail3)
                    putExtra("detail4", wisata.detail4)
                    putExtra("maps", wisata.maps)
                    putExtra("deskripsi", wisata.deskripsi)

                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_wisata_kategori, parent, false)
        return KategoriViewHolder(view)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        holder.bind(wisataList[position])
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }
}

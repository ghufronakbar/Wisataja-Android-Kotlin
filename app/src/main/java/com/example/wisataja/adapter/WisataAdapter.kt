package com.example.wisataja.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataja.DetailWisataActivity
import com.example.wisataja.R
import com.example.wisataja.model.Wisata

class WisataAdapter(
    private val context: Context,
    private val wisataList: List<Wisata>
) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    inner class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cvWisata: CardView = itemView.findViewById(R.id.cvWisata)
        private val ivWisata: ImageView = itemView.findViewById(R.id.ivWisata)
        private val tvNamaWisata: TextView = itemView.findViewById(R.id.tvNamaWisata)
        private val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        private val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)

        fun bind(wisata: Wisata) {
            ivWisata.setImageResource(wisata.gambar)
            tvNamaWisata.text = wisata.nama
            tvRating.text = wisata.rating
            tvLocation.text = wisata.lokasi

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_wisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        holder.bind(wisataList[position])
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }
}

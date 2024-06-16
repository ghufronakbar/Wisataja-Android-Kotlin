package com.example.wisataja

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailWisataActivity : AppCompatActivity() {
    private lateinit var tvDeskripsi: TextView
    private lateinit var tvSeeAll: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val namaWisata = intent.getStringExtra("nama")
        val ratingWisata = intent.getStringExtra("rating")
        val lokasiWisata = intent.getStringExtra("lokasi")
        val gambarWisata = intent.getIntExtra("gambar", R.color.black)
        val jamBukaWisata = intent.getStringExtra("jambuka")
        val hargaWisata = intent.getStringExtra("harga")
        val detail1Wisata = intent.getIntExtra("detail1", R.color.black)
        val detail2Wisata = intent.getIntExtra("detail2", R.color.black)
        val detail3Wisata = intent.getIntExtra("detail3", R.color.black)
        val detail4Wisata = intent.getIntExtra("detail4", R.color.black)
        val mapsWisata = intent.getIntExtra("maps", R.color.black)
        val deskripsiWisata = intent.getStringExtra("deskripsi")


        val ivWisata: ImageView = findViewById(R.id.ivKategori)
        val tvNamaWisata: TextView = findViewById(R.id.tvNamaKategori)
        val tvNamaWisata2: TextView = findViewById(R.id.tvNamaWisata2)
        val tvJamBuka: TextView = findViewById(R.id.tvJamBuka)
        val tvRating: TextView = findViewById(R.id.tvRating)
        val tvHargaTiket: TextView = findViewById(R.id.tvHargaTiket)
        val ivDetail1: ImageView = findViewById(R.id.ivDetail1)
        val ivDetail2: ImageView = findViewById(R.id.ivDetail2)
        val ivDetail3: ImageView = findViewById(R.id.ivDetail3)
        val ivDetail4: ImageView = findViewById(R.id.ivDetail4)
        val ivMaps: ImageView = findViewById(R.id.ivMaps)
        val tvDeskripsi: TextView = findViewById(R.id.tvDeskripsi)



        ivWisata.setImageResource(gambarWisata)
        tvNamaWisata.text = namaWisata
        tvNamaWisata2.text = namaWisata
        tvRating.text = ratingWisata
        tvJamBuka.text = jamBukaWisata
        tvHargaTiket.text = hargaWisata
        ivDetail1.setImageResource(detail1Wisata)
        ivDetail2.setImageResource(detail2Wisata)
        ivDetail3.setImageResource(detail3Wisata)
        ivDetail4.setImageResource(detail4Wisata)
        ivMaps.setImageResource(mapsWisata)
        tvDeskripsi.text = deskripsiWisata


        title = namaWisata

        tvSeeAll = findViewById(R.id.tvSeeAll)

        // Show "See All" if the description is too long
        tvDeskripsi.post {
            if (tvDeskripsi.lineCount > 3) {
                tvSeeAll.visibility = View.VISIBLE
                tvDeskripsi.maxLines = 3
            }
        }

        // Handle "See All" click
        tvSeeAll.setOnClickListener {
            if (tvSeeAll.text == "Lihat Selengkapnya") {
                tvDeskripsi.maxLines = Int.MAX_VALUE
                tvSeeAll.text = "Lihat Lebih Sedikit"
            } else {
                tvDeskripsi.maxLines = 3
                tvSeeAll.text = "Lihat Selengkapnya"
            }
        }
    }
}

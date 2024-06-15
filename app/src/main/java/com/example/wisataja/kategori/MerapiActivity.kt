package com.example.wisataja.kategori

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataja.R
import com.example.wisataja.adapter.KategoriAdapter
import com.example.wisataja.model.Wisata

class MerapiActivity : AppCompatActivity() {

    private lateinit var kategoriAdapter: KategoriAdapter
    private lateinit var wisataList: MutableList<Wisata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merapi)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewKategori)

        wisataList = mutableListOf(
            Wisata(
                "Gunung Merapi",
                "4.8",
                "Kaliurang, Sleman, Yogyakarta",
                R.drawable.iv_merapi,
                "Senin-Minggu 24 Jam",
                "20.000",
                R.drawable.iv_merapi1,
                R.drawable.iv_merapi2,
                R.drawable.iv_merapi3,
                R.drawable.iv_merapi4,
                R.drawable.map,
                "Gunung Merapi adalah gunung berapi di bagian tengah Pulau Jawa dan merupakan salah satu gunung api teraktif di Indonesia. Merapi memiliki ketinggian puncak 2.930 meter dan telah meletus sebanyak 68 kali sejak 1548. Kawasan wisata Gunung Merapi menawarkan pemandangan alam yang indah dan aktivitas petualangan seperti pendakian gunung, tur jeep lava, dan kunjungan ke museum vulkanik."
            ),
            Wisata(
                "Bungker Kali Adem",
                "4.4",
                "Kaliadem, Sleman, Yogyakarta",
                R.drawable.iv_bungker,
                "Senin-Minggu 07:00 - 17:00",
                "10.000",
                R.drawable.iv_bungker1,
                R.drawable.iv_bungker2,
                R.drawable.iv_bungker3,
                R.drawable.iv_bungker4,
                R.drawable.map,
                "Bungker Kaliadem adalah sebuah bungker perlindungan yang terletak di lereng Gunung Merapi. Bungker ini dibangun sebagai tempat perlindungan dari letusan Gunung Merapi. Kini, Bungker Kaliadem menjadi salah satu destinasi wisata menarik di kawasan lereng Merapi yang menawarkan pemandangan alam yang indah serta sejarah letusan Merapi."
            ),
            Wisata(
                "Merapi Lava Tour",
                "4.6",
                "Kaliurang, Sleman, Yogyakarta",
                R.drawable.iv_lava_tour,
                "Senin-Minggu 07:00 - 17:00",
                "350.000 (per jeep)",
                R.drawable.iv_lava_tour1,
                R.drawable.iv_lava_tour2,
                R.drawable.iv_lava_tour3,
                R.drawable.iv_lava_tour4,
                R.drawable.map,
                "Merapi Lava Tour adalah wisata petualangan yang menggunakan jeep untuk mengelilingi area lereng Gunung Merapi yang terkena dampak letusan. Tur ini menawarkan pengalaman yang menantang dengan pemandangan alam yang menakjubkan dan sejarah letusan Merapi."
            ),
            Wisata(
                "Batu Alien",
                "3.6",
                "Kaliurang, Sleman, Yogyakarta",
                R.drawable.iv_batu_alien,
                "Senin-Minggu 07:00 - 17:00",
                "10.000",
                R.drawable.iv_batu_alien1,
                R.drawable.iv_batu_alien2,
                R.drawable.iv_batu_alien3,
                R.drawable.iv_batu_alien4,
                R.drawable.map,
                "Batu Alien berada di lereng Gunung Merapi, bongkahan batu Vulkanik yang muncul setelah bencana dahsyat erupsi Merapi 2010 silam. Yang pertama menemukan menyebut, itu wajah alien, makanya sekarang namanya wisata Batu Alien."
            ),

            )
        kategoriAdapter = KategoriAdapter(this, wisataList)
        recyclerView.adapter = kategoriAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}
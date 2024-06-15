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

class PantaiActivity : AppCompatActivity() {

    private lateinit var kategoriAdapter: KategoriAdapter
    private lateinit var wisataList: MutableList<Wisata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantai)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewKategori)

        wisataList = mutableListOf(
            Wisata(
                "Watu Kodok",
                "4.7",
                "Gunung Kidul, Yogyakarta",
                R.drawable.iv_pantai_watu_kodo,
                "Senin-Minggu 06.00-18.00",
                "10000",
                R.drawable.iv_pantai_watu_kodo1,
                R.drawable.iv_pantai_watu_kodo2,
                R.drawable.iv_pantai_watu_kodo3,
                R.drawable.iv_pantai_watu_kodo4,
                R.drawable.map,
                "Pantai Watu Kodok terletak di Gunung Kidul, Yogyakarta. Pantai ini terkenal dengan batu-batu karang yang besar dan ombaknya yang cukup kuat. Cocok untuk menikmati pemandangan alam dan bermain air."
            ),
            Wisata(
                "Pantai Timang",
                "4.8",
                "Gunung Kidul, Yogyakarta",
                R.drawable.iv_pantai_timang,
                "Senin-Minggu 08.00-17.00",
                "150000",
                R.drawable.iv_pantai_timang1,
                R.drawable.iv_pantai_timang2,
                R.drawable.iv_pantai_timang3,
                R.drawable.iv_pantai_timang4,
                R.drawable.map,
                "Pantai Timang terletak di Gunung Kidul, Yogyakarta. Pantai ini terkenal dengan jembatan gantung yang menghubungkan daratan dengan batu karang besar di tengah laut. Wisatawan bisa menikmati suasana pantai yang eksotis dan menantang."
            ),
            Wisata(
                "Pantai Watu Nenek",
                "4.6",
                "Gunung Kidul, Yogyakarta",
                R.drawable.iv_pantai_watu_nenek,
                "Senin-Minggu 07.00-17.00",
                "20000",
                R.drawable.iv_pantai_watu_nenek1,
                R.drawable.iv_pantai_watu_nenek2,
                R.drawable.iv_pantai_watu_nenek3,
                R.drawable.iv_pantai_watu_nenek4,
                R.drawable.map,
                "Pantai Watu Nenek terletak di Gunung Kidul, Yogyakarta. Pantai ini memiliki pasir putih yang luas dan ombak yang tidak terlalu besar. Cocok untuk bersantai dan menikmati keindahan alam."
            ),
            Wisata(
                "Pantai Parangtritis",
                "4.4",
                "Bantul, Yogyakarta",
                R.drawable.iv_pantai_parangtritis,
                "Senin-Minggu 24 Jam",
                "-",
                R.drawable.iv_pantai_parangtritis1,
                R.drawable.iv_pantai_parangtritis2,
                R.drawable.iv_pantai_parangtritis3,
                R.drawable.iv_pantai_parangtritis4,
                R.drawable.map,
                "Pantai Parangtritis terletak di Bantul, Yogyakarta. Pantai ini terkenal dengan ombaknya yang besar dan legenda tentang Nyi Roro Kidul. Menjadi salah satu tujuan wisata favorit di Yogyakarta."
            )
        )

        kategoriAdapter = KategoriAdapter(this, wisataList)
        recyclerView.adapter = kategoriAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}
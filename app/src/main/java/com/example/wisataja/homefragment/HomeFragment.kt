package com.example.wisataja.homefragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataja.ForgotPasswordActivity
import com.example.wisataja.R
import com.example.wisataja.adapter.WisataAdapter
import com.example.wisataja.kategori.CandiActivity
import com.example.wisataja.model.Wisata


class HomeFragment : Fragment() {

    private lateinit var wisataAdapter: WisataAdapter
    private lateinit var wisataList: MutableList<Wisata>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewWisata)

        val cvCandi = view.findViewById<CardView>(R.id.cvCandi)
        val cvPantai = view.findViewById<CardView>(R.id.cvPantai)
        val cvMerapi = view.findViewById<CardView>(R.id.cvMerapi)

        cvCandi.setOnClickListener {
            startActivity(Intent(requireContext(), CandiActivity::class.java))
        }



        wisataList = mutableListOf(
            Wisata("Candi Prambanan", "4.7", "Jl. Raya Solo - Yogyakarta No.16, Prambanan", R.drawable.iv_prambanan, "Senin-Minggu 06:00 - 17:00", "Rp 50.000", R.drawable.iv_prambanan1, R.drawable.iv_prambanan2, R.drawable.iv_prambanan3, R.drawable.iv_prambanan4, R.drawable.map, "Candi Prambanan adalah kompleks candi Hindu terbesar di Indonesia yang dibangun pada abad ke-9 masehi. Candi ini terletak di kecamatan Prambanan, Sleman dan kecamatan Prambanan, Klaten. Candi ini dipersembahkan untuk Trimurti, tiga dewa utama Hindu yaitu Brahma sebagai dewa pencipta, Wisnu sebagai dewa pemelihara, dan Siwa sebagai dewa pemusnah. Candi Prambanan adalah Situs Warisan Dunia UNESCO, candi Hindu terbesar di Indonesia, dan salah satu candi terindah di Asia Tenggara."),
            Wisata("Candi Ijo", "4.3", "Bukit Ijo, Sambirejo, Prambanan, Sleman, Yogyakarta", R.drawable.iv_candi_ijo, "Senin-Minggu 06:00 - 17:00", "Rp 10.000", R.drawable.iv_candi_ijo1, R.drawable.iv_candi_ijo2, R.drawable.iv_candi_ijo3, R.drawable.iv_candi_ijo4, R.drawable.map, "Candi Ijo adalah candi Hindu yang terletak di atas Bukit Ijo, yang merupakan bukit tertinggi di Yogyakarta. Candi ini dibangun pada abad ke-10 hingga 11 dan menawarkan pemandangan yang indah dari ketinggian. Candi Ijo terdiri dari beberapa candi kecil yang tersebar di area bukit."),
            Wisata("Candi Borobudur", "4.9", "Borobudur, Magelang, Jawa Tengah", R.drawable.iv_borobudur, "Senin-Minggu 06:00 - 17:00", "Rp 50.000", R.drawable.iv_borobudur1, R.drawable.iv_borobudur2, R.drawable.iv_borobudur3, R.drawable.iv_borobudur4, R.drawable.map, "Candi Borobudur adalah candi Buddha terbesar di dunia yang terletak di Magelang, Jawa Tengah. Candi ini dibangun pada abad ke-9 oleh Dinasti Syailendra. Borobudur adalah salah satu situs Warisan Dunia UNESCO dan merupakan salah satu keajaiban dunia. Candi ini memiliki arsitektur yang megah dengan relief yang menggambarkan ajaran Buddha."),
            Wisata("Candi Plaosan", "4.5", "Bugisan, Prambanan, Klaten, Jawa Tengah", R.drawable.iv_plaosan, "Senin-Minggu 06:00 - 17:00", "Rp 15.000", R.drawable.iv_plaosan1, R.drawable.iv_plaosan2, R.drawable.iv_plaosan3, R.drawable.iv_plaosan4, R.drawable.map, "Candi Plaosan adalah kompleks candi Buddha yang terletak di dekat Candi Prambanan. Candi ini dibangun pada abad ke-9 oleh Rakai Pikatan dan Sri Kahulunan dari Dinasti Syailendra. Plaosan terdiri dari dua candi utama, Plaosan Lor dan Plaosan Kidul, yang dikelilingi oleh stupa dan candi perwara. Candi ini memiliki arsitektur yang unik dengan perpaduan gaya Hindu dan Buddha.")
        )

        wisataAdapter = WisataAdapter(requireContext(), wisataList)
        recyclerView.adapter = wisataAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return view
    }
}
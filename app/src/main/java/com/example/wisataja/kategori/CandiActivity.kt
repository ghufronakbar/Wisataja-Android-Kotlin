package com.example.wisataja.kategori

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataja.R
import com.example.wisataja.adapter.KategoriAdapter
import com.example.wisataja.adapter.WisataAdapter
import com.example.wisataja.model.Wisata

class CandiActivity : AppCompatActivity() {

    private lateinit var kategoriAdapter: KategoriAdapter
    private lateinit var wisataList: MutableList<Wisata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewKategori)

        wisataList = mutableListOf(
            Wisata("Tugu Jogja", "4.5", "Jl.Jendral Sudirman", R.drawable.iv_tugu, "Senin-Minggu 24 Jam", "-", R.drawable.iv_tugu1, R.drawable.iv_tugu2, R.drawable.iv_tugu3, R.drawable.iv_tugu4, R.drawable.map, "Tugu Yogyakarta adalah sebuah tugu atau monumen yang sering dipakai sebagai simbol atau lambang dari Kota Yogyakarta, Daerah Istimewa Yogyakarta. Tugu yang dibangun pada tahun 1755 oleh Hamengkubuwono I, pendiri Kraton Yogyakarta, mempunyai nilai simbolis dan merupakan garis yang bersifat magis yang menghubungkan laut selatan, Kraton Jogja, dan Gunung Merapi. Konon Sultan pada saat melakukan meditasi menjadikan tugu ini sebagai patokan arah menghadap Gunung Merapi."),
            Wisata("Malioboro", "4.1", "Jl.Malioboro,Kota Yogyakarta", R.drawable.iv_malioboro, "Senin-Minggu 24 Jam", "-", R.drawable.iv_malioboro1, R.drawable.iv_malioboro2, R.drawable.iv_malioboro3, R.drawable.iv_malioboro4, R.drawable.map, "Malioboro adalah salah satu kawasan jalan dari tiga jalan di Kota Yogyakarta yang membentang dari Tugu Yogyakarta hingga ke persimpangan Titik Nol Kilometer Yogyakarta. Secara keseluruhan, kawasan Malioboro terdiri atas Jalan Margo Utomo, Jalan Malioboro, dan Jalan Margo Mulyo."),
            Wisata("Keraton", "4.1", "Jl.Rotowijayan, Kota Yogyakarta", R.drawable.iv_keraton, "Senin-Minggu 24 Jam", "-", R.drawable.iv_keraton1, R.drawable.iv_keraton2, R.drawable.iv_keraton3, R.drawable.iv_keraton4, R.drawable.map, "Keraton Ngayogyakarta Hadiningrat atau Keraton Yogyakarta merupakan istana resmi Kesultanan Ngayogyakarta Hadiningrat yang kini berlokasi di Kota Yogyakarta. Keraton ini didirikan oleh Sri Sultan Hamengkubuwana I pada tahun 1755 sebagai Istana/Keraton Yogyakarta yang baru berdiri akibat perpecahan Mataram Islam dengan adanya Perjanjian Giyanti. Keraton ini adalah pecahan dari Keraton Surakarta Hadiningrat dari Mataram Islam Surakarta (Kerajaan Surakarta). Sehingga dinasti Mataram diteruskan oleh 2 Kerajaan yakni Kesultanan Yogyakarta dan Kesunanan Surakarta. Total luas wilayah keseluruhan keraton yogyakarta mencapai 144 hektar, yakni meliputi seluruh area di dalam benteng Baluwarti, alun-alun Lor, alun-alun Kidul, gapura Gladak, dan kompleks Masjid Gedhe Yogyakarta. Sementara luas dari kedhaton (inti keraton) mencapai 13 hektar."),
            Wisata("Candi Prambanan", "4.7", "Jl. Raya Solo - Yogyakarta No.16, Prambanan", R.drawable.iv_prambanan, "Senin-Minggu 06:00 - 17:00", "Rp 50.000", R.drawable.iv_prambanan1, R.drawable.iv_prambanan2, R.drawable.iv_prambanan3, R.drawable.iv_prambanan4, R.drawable.map, "Candi Prambanan adalah kompleks candi Hindu terbesar di Indonesia yang dibangun pada abad ke-9 masehi. Candi ini terletak di kecamatan Prambanan, Sleman dan kecamatan Prambanan, Klaten. Candi ini dipersembahkan untuk Trimurti, tiga dewa utama Hindu yaitu Brahma sebagai dewa pencipta, Wisnu sebagai dewa pemelihara, dan Siwa sebagai dewa pemusnah. Candi Prambanan adalah Situs Warisan Dunia UNESCO, candi Hindu terbesar di Indonesia, dan salah satu candi terindah di Asia Tenggara."),
            Wisata("Gunung Merapi", "4.8", "Kaliurang, Sleman, Yogyakarta", R.drawable.iv_merapi, "Senin-Minggu 24 Jam", "Rp 20.000", R.drawable.iv_merapi1, R.drawable.iv_merapi2, R.drawable.iv_merapi3, R.drawable.iv_merapi4, R.drawable.map, "Gunung Merapi adalah gunung berapi di bagian tengah Pulau Jawa dan merupakan salah satu gunung api teraktif di Indonesia. Merapi memiliki ketinggian puncak 2.930 meter dan telah meletus sebanyak 68 kali sejak 1548. Kawasan wisata Gunung Merapi menawarkan pemandangan alam yang indah dan aktivitas petualangan seperti pendakian gunung, tur jeep lava, dan kunjungan ke museum vulkanik."),
            Wisata("Bungker Kali Adem", "4.4", "Kaliadem, Sleman, Yogyakarta", R.drawable.iv_bungker, "Senin-Minggu 07:00 - 17:00", "Rp 10.000", R.drawable.iv_bungker1, R.drawable.iv_bungker2, R.drawable.iv_bungker3, R.drawable.iv_bungker4, R.drawable.map, "Bungker Kaliadem adalah sebuah bungker perlindungan yang terletak di lereng Gunung Merapi. Bungker ini dibangun sebagai tempat perlindungan dari letusan Gunung Merapi. Kini, Bungker Kaliadem menjadi salah satu destinasi wisata menarik di kawasan lereng Merapi yang menawarkan pemandangan alam yang indah serta sejarah letusan Merapi."),
            Wisata("Merapi Lava Tour", "4.6", "Kaliurang, Sleman, Yogyakarta", R.drawable.iv_lava_tour, "Senin-Minggu 07:00 - 17:00", "Rp 350.000 (per jeep)", R.drawable.iv_lava_tour1, R.drawable.iv_lava_tour2, R.drawable.iv_lava_tour3, R.drawable.iv_lava_tour4, R.drawable.map, "Merapi Lava Tour adalah wisata petualangan yang menggunakan jeep untuk mengelilingi area lereng Gunung Merapi yang terkena dampak letusan. Tur ini menawarkan pengalaman yang menantang dengan pemandangan alam yang menakjubkan dan sejarah letusan Merapi."),
            Wisata("Candi Ijo", "4.3", "Bukit Ijo, Sambirejo, Prambanan, Sleman, Yogyakarta", R.drawable.iv_candi_ijo, "Senin-Minggu 06:00 - 17:00", "Rp 10.000", R.drawable.iv_candi_ijo1, R.drawable.iv_candi_ijo2, R.drawable.iv_candi_ijo3, R.drawable.iv_candi_ijo4, R.drawable.map, "Candi Ijo adalah candi Hindu yang terletak di atas Bukit Ijo, yang merupakan bukit tertinggi di Yogyakarta. Candi ini dibangun pada abad ke-10 hingga 11 dan menawarkan pemandangan yang indah dari ketinggian. Candi Ijo terdiri dari beberapa candi kecil yang tersebar di area bukit."),
            Wisata("Candi Borobudur", "4.9", "Borobudur, Magelang, Jawa Tengah", R.drawable.iv_borobudur, "Senin-Minggu 06:00 - 17:00", "Rp 50.000", R.drawable.iv_borobudur1, R.drawable.iv_borobudur2, R.drawable.iv_borobudur3, R.drawable.iv_borobudur4, R.drawable.map, "Candi Borobudur adalah candi Buddha terbesar di dunia yang terletak di Magelang, Jawa Tengah. Candi ini dibangun pada abad ke-9 oleh Dinasti Syailendra. Borobudur adalah salah satu situs Warisan Dunia UNESCO dan merupakan salah satu keajaiban dunia. Candi ini memiliki arsitektur yang megah dengan relief yang menggambarkan ajaran Buddha."),
            Wisata("Candi Plaosan", "4.5", "Bugisan, Prambanan, Klaten, Jawa Tengah", R.drawable.iv_plaosan, "Senin-Minggu 06:00 - 17:00", "Rp 15.000", R.drawable.iv_plaosan1, R.drawable.iv_plaosan2, R.drawable.iv_plaosan3, R.drawable.iv_plaosan4, R.drawable.map, "Candi Plaosan adalah kompleks candi Buddha yang terletak di dekat Candi Prambanan. Candi ini dibangun pada abad ke-9 oleh Rakai Pikatan dan Sri Kahulunan dari Dinasti Syailendra. Plaosan terdiri dari dua candi utama, Plaosan Lor dan Plaosan Kidul, yang dikelilingi oleh stupa dan candi perwara. Candi ini memiliki arsitektur yang unik dengan perpaduan gaya Hindu dan Buddha.")
        )
        kategoriAdapter = KategoriAdapter(this, wisataList)
        recyclerView.adapter = kategoriAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}
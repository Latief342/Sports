package com.example.sports

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AthleteViewModel : ViewModel() {

    private val allAthletes = listOf(
        Athlete("Cristiano Ronaldo", "Sepak Bola", "Rp 4.160 Miliar", "Megabintang Portugal yang kini bermain untuk Al Nassr. Ia menjadi atlet dengan bayaran tertinggi berkat kontrak fantastis di liga Arab Saudi dan sponsor besar.", R.drawable.ronaldo),
        Athlete("Jon Rahm", "Golf", "Rp 3.488 Miliar", "Pegolf profesional asal Spanyol yang mendapatkan bayaran masif setelah bergabung dengan liga LIV Golf yang didanai PIF Arab Saudi.", R.drawable.rahm),
        Athlete("Lionel Messi", "Sepak Bola", "Rp 2.160 Miliar", "Legenda sepak bola Argentina yang bermain di Inter Miami. Penghasilannya berasal dari gaji klub, bagi hasil Apple TV, dan sponsor abadi dengan Adidas.", R.drawable.messi),
        Athlete("LeBron James", "Basket", "Rp 2.051 Miliar", "Ikon NBA dari Los Angeles Lakers. Selain gaji besar di lapangan, ia memiliki portofolio investasi dan kerajaan bisnis hiburannya sendiri.", R.drawable.lebron),
        Athlete("Giannis Antetokounmpo", "Basket", "Rp 1.776 Miliar", "Bintang Milwaukee Bucks asal Yunani ini baru saja menandatangani perpanjangan kontrak besar dan memiliki kesepakatan sepatu yang sangat menguntungkan.", R.drawable.giannis),
        Athlete("Kylian Mbappé", "Sepak Bola", "Rp 1.760 Miliar", "Penyerang mematikan Prancis. Kontrak besarnya di Real Madrid serta berbagai dukungan sponsor menjadikannya atlet muda terkaya.", R.drawable.mbappe),
        Athlete("Neymar", "Sepak Bola", "Rp 1.728 Miliar", "Bintang Brasil yang pindah ke Al Hilal. Kesepakatan transfernya tidak hanya mencakup gaji pokok, tetapi juga fasilitas mewah dan bonus komersial.", R.drawable.neymar),
        Athlete("Karim Benzema", "Sepak Bola", "Rp 1.696 Miliar", "Striker asal Prancis yang memenangkan Ballon d'Or. Ia bergabung dengan Al-Ittihad dengan kontrak multi-tahun yang sangat menggiurkan.", R.drawable.benzema),
        Athlete("Stephen Curry", "Basket", "Rp 1.632 Miliar", "Penembak jitu terbaik sejarah NBA dari Golden State Warriors. Ia memiliki brand sendiri di bawah naungan Under Armour.", R.drawable.curry),
        Athlete("Lamar Jackson", "American Football", "Rp 1.608 Miliar", "Quarterback bintang Baltimore Ravens yang menandatangani kontrak perpanjangan rekor di NFL pada tahun lalu.", R.drawable.lamar)
    )

    private val _athletes = MutableStateFlow(allAthletes)
    val athletes: StateFlow<List<Athlete>> = _athletes.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    fun searchAthletes(query: String) {
        _searchQuery.value = query
        if (query.isEmpty()) {
            _athletes.value = allAthletes
        } else {
            _athletes.value = allAthletes.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }
}
package com.example.sports

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class AthleteViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {

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

    private val searchQueryKey = stringPreferencesKey("search_query")

    init {
        viewModelScope.launch {
            val savedQuery = dataStore.data
                .map { preferences -> preferences[searchQueryKey] ?: "" }
                .first()

            _searchQuery.value = savedQuery
            filterAthletes(savedQuery)
        }
    }

    fun searchAthletes(query: String) {
        _searchQuery.value = query
        filterAthletes(query)

        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[searchQueryKey] = query
            }
        }
    }

    private fun filterAthletes(query: String) {
        if (query.isEmpty()) {
            _athletes.value = allAthletes
        } else {
            _athletes.value = allAthletes.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }
}
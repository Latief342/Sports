package com.example.sports

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sports.network.ApiAthlete
import com.example.sports.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AthleteViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val apiService: ApiService
) : ViewModel() {

    private val _athletes = MutableStateFlow<List<Athlete>>(emptyList())
    val athletes: StateFlow<List<Athlete>> = _athletes.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _apiAthletes = MutableStateFlow<List<ApiAthlete>>(emptyList())
    val apiAthletes: StateFlow<List<ApiAthlete>> = _apiAthletes.asStateFlow()

    private val searchQueryKey = stringPreferencesKey("search_query")

    init {
        loadSavedSearch()
        fetchAthletesFromApi()
    }

    private fun loadSavedSearch() {
        viewModelScope.launch {
            val savedQuery = dataStore.data
                .map { preferences ->
                    preferences[searchQueryKey] ?: ""
                }
                .first()

            _searchQuery.value = savedQuery
        }
    }

    fun fetchAthletesFromApi() {
        viewModelScope.launch {
            try {
                val response = apiService.getAthletes()

                _apiAthletes.value = response

                val athleteList = response.map {
                    convertApiToAthlete(it)
                }

                _athletes.value = athleteList

                println("Jumlah atlet dari API = ${response.size}")

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun convertApiToAthlete(apiAthlete: ApiAthlete): Athlete {
        return Athlete(
            name = apiAthlete.name,
            sport = apiAthlete.sport,
            earnings = apiAthlete.earnings,
            description = apiAthlete.description,
            imageRes = when (apiAthlete.name) {
                "Cristiano Ronaldo" -> R.drawable.ronaldo
                "Jon Rahm" -> R.drawable.rahm
                "Lionel Messi" -> R.drawable.messi
                "LeBron James" -> R.drawable.lebron
                "Giannis Antetokounmpo" -> R.drawable.giannis
                "Kylian Mbappé" -> R.drawable.mbappe
                "Neymar" -> R.drawable.neymar
                "Karim Benzema" -> R.drawable.benzema
                "Stephen Curry" -> R.drawable.curry
                "Lamar Jackson" -> R.drawable.lamar
                else -> R.drawable.ronaldo
            }
        )
    }

    fun searchAthletes(query: String) {
        _searchQuery.value = query

        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[searchQueryKey] = query
            }

            val filteredList =
                if (query.isBlank()) {
                    _apiAthletes.value.map { convertApiToAthlete(it) }
                } else {
                    _apiAthletes.value
                        .filter {
                            it.name.contains(
                                query,
                                ignoreCase = true
                            )
                        }
                        .map {
                            convertApiToAthlete(it)
                        }
                }

            _athletes.value = filteredList
        }
    }
}

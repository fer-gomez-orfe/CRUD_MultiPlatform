package org.montra.crudmuliplatform.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.montra.crudmuliplatform.data.repository.SparePartsRepository
import org.montra.crudmuliplatform.data.model.SparePartModel



@OptIn(FlowPreview::class)
class SparePartsCatalogViewModel(
    private val repository: SparePartsRepository
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    //private val _spareParts = MutableStateFlow(listOf<SparePartModel>())
    private val _spareParts = MutableStateFlow<List<SparePartModel>>(emptyList())
    val spareParts = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_spareParts) { text, sparePart ->
            if(text.isBlank()) {
                sparePart
            } else {
                delay(2000L)
                sparePart.filter {
                    it.doesMatchSearchQuery(text)

                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _spareParts.value
        )

    init {
        loadSpareParts()
    }

    fun loadSpareParts() {
        viewModelScope.launch {
            try {
                val parts = repository.fetchSpareParts()
                _spareParts.value = parts
            } catch (e: Exception) {
                // Manejo de errores
                Logger.e { "Error al cargar datos" }

            }
        }
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

}




package org.montra.crudmuliplatform.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.montra.crudmuliplatform.data.model.SparePartModel
import org.montra.crudmuliplatform.data.repository.SparePartsRepository

@OptIn(FlowPreview::class)
class UpdateSparePartsViewModel (
    private val repository: SparePartsRepository
) : ViewModel() {

    private val _searchText = MutableStateFlow ("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _spareParts = MutableStateFlow<List<SparePartModel>>(emptyList())

    private val _filteredSpareParts = MutableStateFlow<List<SparePartModel>>(emptyList())
    val filteredSpareParts = _filteredSpareParts.asStateFlow()

    fun onSearchTextChange(text : String) {
        _searchText.value = text
    }

    init {
        loadSpareParts()
    }

    fun onButtonSearchClick(){
        viewModelScope.launch {
            _isSearching.value = true
            delay(500L)

            val text = _searchText.value
            val parts = _spareParts.value

            _filteredSpareParts.value = if(text.isBlank()){
                parts
            }else{
                parts.filter {
                    it.checkIfExist(text)
                }
            }
            _isSearching.value = false
        }
    }

    private fun loadSpareParts() {
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



}
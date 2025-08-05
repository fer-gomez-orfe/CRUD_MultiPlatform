package org.montra.crudmuliplatform.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import org.montra.crudmuliplatform.data.model.SparePartModel

@OptIn(FlowPreview::class)
class UpdateSparePartsViewModel : ViewModel() {

    private val _searchText = MutableStateFlow ("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _spareParts = MutableStateFlow<List<SparePartModel>>(emptyList())

    val spareParts = searchText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_spareParts) {text, sparePart ->
            if(text.isBlank()) {
                sparePart
            } else {
                delay(1000L)
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

    fun onSearchTextChange(text : String) {
        _searchText.value = text
    }



}
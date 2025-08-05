package org.montra.crudmuliplatform.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SparePartModel (
    val item_Eng: String,
    val item_Esp: String,
    val description: String,
    val serial_number: String,
    val ult_actualizacion: String,
    val cantidad: Int,
    val notas: String,
    val part_number: String
){
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            item_Eng,
            item_Esp,
            serial_number,
            part_number,
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
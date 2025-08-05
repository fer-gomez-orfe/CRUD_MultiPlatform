package org.montra.crudmuliplatform.data.repository

import org.montra.crudmuliplatform.data.model.SparePartModel
import org.montra.crudmuliplatform.data.network.SparePartService

class SparePartsRepository(private val service: SparePartService){

    suspend fun fetchSpareParts(): List<SparePartModel> {
        return service.getSpareParts()
    }
}
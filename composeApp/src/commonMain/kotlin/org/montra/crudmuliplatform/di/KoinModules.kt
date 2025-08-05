package org.montra.crudmuliplatform.di


import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.montra.crudmuliplatform.data.network.KtorClientProvider
import org.montra.crudmuliplatform.data.network.SparePartService
import org.montra.crudmuliplatform.data.repository.SparePartsRepository
import org.montra.crudmuliplatform.ui.viewmodel.SparePartsCatalogViewModel
import org.montra.crudmuliplatform.ui.viewmodel.UpdateSparePartsViewModel


val dataModule = module {
    factoryOf(::SparePartsRepository)
    factoryOf(::SparePartService)
    single { KtorClientProvider.create() }
}

val viewModelsModule = module {
    viewModelOf(::SparePartsCatalogViewModel)
    viewModelOf(::UpdateSparePartsViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin{
        config?.invoke(this)
        modules(dataModule, viewModelsModule)
    }
}
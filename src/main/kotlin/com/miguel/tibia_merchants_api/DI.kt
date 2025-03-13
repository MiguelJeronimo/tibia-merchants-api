package com.miguel.tibia_merchants_api

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepository
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepositoryImp
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseCatalog
import org.koin.dsl.module

class DI {
    //dependences injection configuration
    val appModules = module {
        single <CatalogRepository>{
            CatalogRepositoryImp(Tibia())
        }

        single <UseCaseCatalog>{
            UseCaseCatalog(get())
        }
    }
}
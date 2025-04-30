package com.miguel.tibia_merchants_api

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.BlessingsRepository
import com.miguel.tibia_merchants_api.data.repositories.BlessingsRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepository
import com.miguel.tibia_merchants_api.data.repositories.CatalogRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepository
import com.miguel.tibia_merchants_api.data.repositories.ItemsRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.NPCRepository
import com.miguel.tibia_merchants_api.data.repositories.NPCRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.SpellsRepository
import com.miguel.tibia_merchants_api.data.repositories.SpellsRepositoryImp
import com.miguel.tibia_merchants_api.data.repositories.VocationsRepository
import com.miguel.tibia_merchants_api.data.repositories.VocationsRepositoryImp
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseBlessings
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseCatalog
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseItems
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseNPC
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseSpells
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseVocations
import org.koin.dsl.module

class DI {
    //dependences injection configuration
    val appModules = module {
        //injection in Catalogs
        single <CatalogRepository>{
            CatalogRepositoryImp(Tibia())
        }

        single <UseCaseCatalog>{
            UseCaseCatalog(get())
        }

        //injection dependencies in Blessigs
        single<BlessingsRepository> {
            BlessingsRepositoryImp(Tibia())
        }

        single <UseCaseBlessings>{
            UseCaseBlessings(get())
        }
        //injection dependencies in npcInfo
        single <NPCRepository>{
            NPCRepositoryImp(Tibia())
        }

        single <UseCaseNPC>{
            UseCaseNPC(get())
        }
        //injection dependencies in Items
        single <ItemsRepository>{
            ItemsRepositoryImp(Tibia())
        }

        single <UseCaseItems>{
            UseCaseItems(get())
        }
        //injection dependencies in Spells
        single <SpellsRepository>{
            SpellsRepositoryImp(Tibia())
        }

        single <UseCaseSpells>{
            UseCaseSpells(get())
        }
        //injection dependencies in Vocations
        single <VocationsRepository>{
            VocationsRepositoryImp(Tibia())
        }

        single <UseCaseVocations>{
            UseCaseVocations(get())
        }
    }
}
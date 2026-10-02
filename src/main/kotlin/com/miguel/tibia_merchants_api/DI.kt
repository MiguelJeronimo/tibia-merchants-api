package com.miguel.tibia_merchants_api

import com.miguel.tibia_merchants_api.data.network.Tibia
import com.miguel.tibia_merchants_api.data.repositories.*
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeProfilesRepository
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeProfilesRepositoryImpl
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeRepository
import com.miguel.tibia_merchants_api.data.repositories.trade.TradeRepositoryImpl
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibia
import com.miguel.tibia_merchants_api.data.repositories.wikipediaapi.RepositoryWikiTibiaImpl
import com.miguel.tibia_merchants_api.domain.usecase.*
import org.koin.dsl.module

class DI {
    //dependences injection configuration
    val appModules = module {
        //injection in Catalogs
        single<RepositoryWikiTibia>{
            RepositoryWikiTibiaImpl()
        }

        single <CatalogRepository>{
            CatalogRepositoryImp(Tibia())
        }

        single <UseCaseCatalog>{
            UseCaseCatalog(get(), get())
        }

        //injection dependencies in Blessigs
        single<BlessingsRepository> {
            BlessingsRepositoryImp(Tibia())
        }

        single <UseCaseBlessings>{
            UseCaseBlessings(get(), get())
        }
        //injection dependencies in npcInfo
        single <NPCRepository>{
            NPCRepositoryImp(Tibia())
        }

        single <UseCaseNPC>{
            UseCaseNPC(get(), get())
        }
        //injection dependencies in Items
        single <ItemsRepository>{
            ItemsRepositoryImp(Tibia())
        }

        single <UseCaseItems>{
            UseCaseItems(get(), get())
        }
        //injection dependencies in Spells
        single <SpellsRepository>{
            SpellsRepositoryImp(Tibia())
        }

        single <UseCaseSpells>{
            UseCaseSpells(get(), get())
        }
        //injection dependencies in Vocations
        single <VocationsRepository>{
            VocationsRepositoryImp(Tibia())
        }

        single <UseCaseVocations>{
            UseCaseVocations(get())
        }
        //injection dependencies in Embuiments
        single <EmbuimentsRepository>{
            EmbuimentsRepositoryImp(Tibia())
        }

        single <UseCaseEmbuiments>{
            UseCaseEmbuiments(get(), get())
        }
        //Trade
        single<TradeRepository> {
           TradeRepositoryImpl()
        }

        single<UseCaseTrade>{
            UseCaseTrade(repository = get())
        }

        single<TradeProfilesRepository> { TradeProfilesRepositoryImpl() }
        single<UseCaseTradeProfiles> { UseCaseTradeProfiles(get()) }
    }
}
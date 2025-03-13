package com.miguel.tibia_merchants_api

import org.koin.core.context.startKoin
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TibiaMerchantsApiApplication{
	fun initKoin(){
		startKoin {
			modules(DI().appModules)
		}
	}
}

fun main(args: Array<String>) {
	val app = TibiaMerchantsApiApplication()
	app.initKoin()
	runApplication<TibiaMerchantsApiApplication>(*args)
}

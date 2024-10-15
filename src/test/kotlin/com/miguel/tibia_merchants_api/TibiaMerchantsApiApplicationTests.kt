package com.miguel.tibia_merchants_api

import com.miguel.tibia_merchants_api.data.network.Tibia
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TibiaMerchantsApiApplicationTests {

	@Test
	fun blessingsTest() {
		Tibia().blessings().blessingsInformation().blessings?.forEach {
			println(it)
		}
	}

}

package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.trade.TradeProfileParamDto
import com.miguel.tibia_merchants_api.domain.usecase.UseCaseTradeProfiles
import com.miguel.tibia_merchants_api.utils.exceptions.ResourceNotFoundException
import org.apache.logging.log4j.LogManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class ControllerTradeProfiles: KoinComponent {
    private val logger = LogManager.getLogger(this.javaClass)
    private val useCase: UseCaseTradeProfiles by inject()

    @GetMapping("/trade/item-profiles")
    suspend fun getTradeProfiles(
        @RequestParam("id") id: Long?,
        @RequestParam("itemId") itemId: Long?,
        @RequestParam("itemTear") itemTear: Int?,
        @RequestParam("currencyType") currencyType: Int?,
        @RequestParam("type") type: Int?
    ): ResponseEntity<out Any?> {
       return try {
            val params = TradeProfileParamDto(
                id = id,
                itemId = itemId,
                itemTear = itemTear,
                currencyType = currencyType,
                type = type
            )
            val tradeProfiles = useCase.itemProfile(params)
            ResponseEntity.ok().body(tradeProfiles)
        } catch (e: ResourceNotFoundException) {
            logger.error(e)
            val error = Errors(statusCode = 400, error = "Resource not found")
            ResponseEntity.badRequest().body(error)
        } catch (e: Exception) {
            logger.error(e)
            val error = Errors(statusCode = 500, error = "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }

    @GetMapping("/trade/user-profile")
    suspend fun getUserProfile(
       @RequestParam("username") username: String,
       @RequestParam("productType", required = false) productType: String?,
       @RequestParam("sortType", defaultValue = "3") sortType: Int,
       @RequestParam("page", defaultValue = "1") page: Int
    ): ResponseEntity<out Any?> {
       return try {
           val result = useCase.userProfile(
               username = username,
               productType = productType,
               sortType = sortType,
               page = page
           )
           ResponseEntity.ok().body(result)
       } catch (e: ResourceNotFoundException) {
           logger.error(e)
           val error = Errors(statusCode = 400, error = "User profile not found")
           ResponseEntity.badRequest().body(error)
       } catch (e: Exception) {
           logger.error(e)
           val error = Errors(statusCode = 500, error = "Fatal Error, contact to support")
           ResponseEntity.internalServerError().body(error)
       }
    }
}
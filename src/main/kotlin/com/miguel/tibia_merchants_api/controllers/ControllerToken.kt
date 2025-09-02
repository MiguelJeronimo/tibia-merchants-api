package com.miguel.tibia_merchants_api.controllers

import com.miguel.tibia_merchants_api.domain.models.Errors
import com.miguel.tibia_merchants_api.domain.models.TokenModel
import com.miguel.tibia_merchants_api.security.SecurityConf
import com.miguel.tibia_merchants_api.utils.Constants
import mx.org.frd.wnspproteccionreport.utils.validator.SchemaValidator
import org.apache.logging.log4j.LogManager
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class ControllerToken {
private val validate = SchemaValidator(Constants.JsonSchemaToken.route)
    private val logger = LogManager.getLogger(ControllerToken::class.java)
    @PostMapping("/token")
    fun generateToken(@RequestBody body: TokenModel): ResponseEntity<out Any?> {
        return try {
            val validate = validate.validate(body = body)
            logger.info(validate)
            if (validate.isNullOrEmpty()){
                val securityConf = SecurityConf(secret = body.secret!!)
                    .generateToken(username = body.username!!)
                ResponseEntity.ok().body(hashMapOf("Token" to securityConf))
            } else{
                val response = validate.map {
                    it.message
                }
                ResponseEntity.badRequest().body(hashMapOf("Errors:" to response))
            }
        } catch (e: Exception){
            logger.fatal(e)
            val error = Errors(500, "Fatal Error, contact to support")
            ResponseEntity.internalServerError().body(error)
        }
    }
}
package com.miguel.tibia_merchants_api.security

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey

class SecurityConf (private val secret:String){

    val key: SecretKey = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))

    fun generateToken(username:String): String? {
        // 1 hora de expiración
        val currentDate = Date()
        val now = System.currentTimeMillis()
        val expiresAt = Date(now + 3600 * 1000) // 1 hora
        return Jwts.builder()
            .subject(username)
            .claim("role","ROLE_USER")
            .issuedAt(currentDate)
            .expiration(expiresAt)
            .signWith(key)
            .compact()
    }

    fun validateToken(token:String): Boolean {
        return try {
            val claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
            val exp = claims.payload.expiration
            exp == null || !exp.before(Date())//Validate token without defeat time or defeat token
        }catch (e: JwtException){
            false
        }catch (e: Exception){
            false
        }
    }

    fun getUsuario(token: String): String? {
        return try {
            val claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
            claims.payload.subject
        } catch (e: Exception) {
            null
        }
    }
}
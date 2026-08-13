package com.help.ukraine.tranzzosdkexample

import android.content.Context
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys

object Hardcode {

        @Suppress("MagicNumber")
        fun generateJWTToken(context: Context): String {
            val timestamp = System.currentTimeMillis() / 1000
            val key = context.getString(R.string.key)
            val secretKey = Keys.hmacShaKeyFor(key.toByteArray())
            return Jwts.builder()
                .header().type("JWT").and()
                .claims(getClaims(timestamp))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact()
        }

        private fun getClaims(timestamp: Long): Map<String, Any> {
            return mapOf(
                "sub" to "1234567890",
                "name" to "John Doe",
                "iat" to timestamp,
            )
        }
    }

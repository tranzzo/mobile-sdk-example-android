package com.help.ukraine.tranzzosdkexample

import android.content.Context
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.json.JSONObject
import java.security.Key

object Hardcode {

        @Suppress("MagicNumber")
        fun generateJWTToken(context: Context): String {
            val headers = getHeaders()
            val timestamp = System.currentTimeMillis() / 1000
            val payload = getPayload(timestamp)
            val key = context.getString(R.string.key)
            val secretKeyBytes: Key = Keys.hmacShaKeyFor(key.toByteArray())
            return Jwts.builder()
                .setHeader(headers)
                .setPayload(payload)
                .signWith(secretKeyBytes, SignatureAlgorithm.HS256)
                .compact()
        }

        private fun getHeaders(): Map<String, String> {
            return mapOf(
                "alg" to "HS256",
                "typ" to "JWT",
            )
        }

        private fun getPayload(timestamp: Long): String {
            val jsonObject = JSONObject().apply {
                put("sub", "1234567890")
                put("name", "John Doe")
                put("iat", timestamp)
            }
            return jsonObject.toString()
        }
    }

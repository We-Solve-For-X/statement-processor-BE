package com.solveforx.statementprocessor.aApplication.router

import com.solveforx.statementprocessor.bService.authentication.AuthenticationService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.routing.Routing
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class AppRouter(val authService: AuthenticationService) {

    val server: NettyApplicationEngine = embeddedServer(Netty, 8080) {
        routing {
            login()
            categories()
        }
    }

    fun Routing.login() {
        get("/login") {
            call.respondText { authService.login("username", "password").toString() }
        }
        get("/logout") {
            call.respondText("logout")
        }
    }

    fun Routing.categories() {
        get("/categories") {
            call.respondText("categories")
        }
    }


    fun start(): NettyApplicationEngine = server.start(true)



}
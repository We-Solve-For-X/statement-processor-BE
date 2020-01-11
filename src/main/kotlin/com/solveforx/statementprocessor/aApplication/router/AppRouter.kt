package com.solveforx.statementprocessor.aApplication.router

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.routing.Routing
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class AppRouter {

    val server: NettyApplicationEngine = embeddedServer(Netty, 8080) {
        routing {
            login()
            categories()
        }
    }

    fun Routing.login() {
        get("/login") {
            call.respondText("login")
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
package com.solveforx.statementprocessor.aApplication.router

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.solveforx.common.genesis.Server.ServerBase
import com.solveforx.statementprocessor.bService.authentication.AuthenticationService
import com.solveforx.statementprocessor.cDomain.authentication.Login
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AppServer(val authService: AuthenticationService) : ServerBase {

    val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    private val logger: Logger = LoggerFactory.getLogger("authService logger")

    val server: NettyApplicationEngine = embeddedServer(Netty, 8080) {
        install(DefaultHeaders)
        install(ContentNegotiation) {
            register(ContentType.Application.Json, GsonConverter())
        }
        routing {
            login()
            categories()
        }
    }

    fun Routing.login() {
        post("/login") {
            val request  = call.receive<Login>()
            val result   = authService.login(request)
            val response = handleResponse(result)
            call.respond(response)
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

    fun start(): NettyApplicationEngine {
        logger.info("HTTP Server starting")
        return server.start(true)
    }

}
package com.solveforx.statementprocessor.aApplication.router

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class LoginRouter {

    //TODO: move login-related routes here
    fun Routing.login() {
        get("/login") {
            call.respondText("you have been logged in")
        }
    }

}
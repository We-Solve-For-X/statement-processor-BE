package com.solveforx.statementprocessor.aApplication.router

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class CategoriesRouter {

    //TODO: move categories-related routes here
    fun Routing.employees() {
        get("/cat") {
            call.respondText("your category is: ...")
        }
    }

}
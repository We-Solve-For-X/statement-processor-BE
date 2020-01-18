package com.solveforx.common.genesis.Server

import com.solveforx.common.genesis.ErrorHandling.ErrorPackage
import org.funktionale.either.Either

interface ServerBase {

    fun <A>handleResponse(result: Either<ErrorPackage, A>): ServerResponse<out Any?> {
        val response = if (result.isRight()) {
            ServerResponse(200, result.right().get())
        } else {
            ServerResponse(500, result.left().get())
        }
        return response
    }


}
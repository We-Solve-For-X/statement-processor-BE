package com.solveforx.common.genesis.Server

import com.sun.security.ntlm.Server
import org.funktionale.either.Either


data class ServerResponse<A>(val code: Int,
                             val body: A)




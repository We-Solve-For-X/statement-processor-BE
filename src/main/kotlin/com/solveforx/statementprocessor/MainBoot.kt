package com.solveforx.statementprocessor

import com.solveforx.statementprocessor.aApplication.router.AppServer
import com.solveforx.statementprocessor.bService.authentication.AuthenticationService
import com.solveforx.statementprocessor.dRepository.DataRepoInstances

fun main() {

    val dataRepoInstances = DataRepoInstances()
    val authService   = AuthenticationService(dataRepoInstances.authRepo, dataRepoInstances.usersRepo)

    val router        = AppServer(authService)
    router.start()
}
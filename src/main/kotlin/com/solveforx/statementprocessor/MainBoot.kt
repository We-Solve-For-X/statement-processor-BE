package com.solveforx.statementprocessor

import com.solveforx.common.genesis.DataRepository.MongoRepositoryBase
import com.solveforx.statementprocessor.aApplication.router.AppRouter
import com.solveforx.statementprocessor.bService.authentication.AuthenticationService
import com.solveforx.statementprocessor.cDomain.authentication.AuthProfile
import com.solveforx.statementprocessor.cDomain.user.User
import com.solveforx.statementprocessor.dRepository.DataRepoInstances
import java.util.*

fun main() {

    val repoInstances = DataRepoInstances()

    val authService = AuthenticationService(repoInstances.authRepo, repoInstances.usersRepo)
    val router = AppRouter(authService)

    println("inited A")


//    val idd = UUID.randomUUID().toString()
//    repoInstances.usersRepo.insertOne(User("name", "0b823f97-53ad-46a1-8e0f-022ca167d7ea"))
//
//    println("inserted")

//    val res = authServ.login("username", "password")
//    println("retrieveed" + res)
//
    router.start()
//    println("strated")




}
package com.solveforx.statementprocessor.dRepository

import com.solveforx.common.genesis.DataRepository.MongoRepositoryBase
import com.solveforx.statementprocessor.cDomain.authentication.AuthProfile
import com.solveforx.statementprocessor.cDomain.user.User
import org.litote.kmongo.*
import com.solveforx.common.genesis.DataRepository.MongoRepo

class DataRepoInstances : MongoRepositoryBase("StatementProcessor") {

    private val usersCollection = database.getCollection<User>("users")
    private val authCollection  = database.getCollection<AuthProfile>("authentication")

    val usersRepo = MongoRepo<User>(usersCollection)
    val authRepo  = MongoRepo<AuthProfile>(authCollection)

}
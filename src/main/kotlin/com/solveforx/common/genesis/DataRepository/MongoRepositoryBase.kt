package com.solveforx.common.genesis.DataRepository

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

abstract class MongoRepositoryBase(val dbName: String) {

    private val client: MongoClient = KMongo.createClient()
    val database: MongoDatabase     = client.getDatabase(dbName)

}


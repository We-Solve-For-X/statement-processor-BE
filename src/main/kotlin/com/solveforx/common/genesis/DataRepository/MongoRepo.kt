package com.solveforx.common.genesis.DataRepository

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.litote.kmongo.findOne

class MongoRepo<A>(private val collection: MongoCollection<A>) {

    fun insertOne(doc: A): Unit = collection.insertOne(doc)

    fun findById(id: String): A? = collection.findOne<A>(Filters.eq("id", id))

    fun findByField(field: String, value: String): A? = collection.findOne<A>(Filters.eq(field, value))

    fun two() = 9

}
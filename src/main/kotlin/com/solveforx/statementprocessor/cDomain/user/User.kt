package com.solveforx.statementprocessor.cDomain.user

import com.solveforx.common.genesis.DataRepository.RepoMeta
import java.time.OffsetDateTime
import java.util.*

data class User (
        val name: String,
        val authProfileId: String,
        override val id: String = UUID.randomUUID().toString(),
        override val createdOn: OffsetDateTime = OffsetDateTime.now()) : RepoMeta
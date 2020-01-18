package com.solveforx.statementprocessor.cDomain.authentication

import com.solveforx.common.genesis.DataRepository.RepoMeta
import java.time.OffsetDateTime
import java.util.*

data class AuthProfile(val username: String,
                       val password: String,
                       override val id: String = UUID.randomUUID().toString(),
                       override val createdOn: OffsetDateTime = OffsetDateTime.now()) : RepoMeta
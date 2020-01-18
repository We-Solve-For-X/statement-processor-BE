package com.solveforx.common.genesis.DataRepository

import java.time.OffsetDateTime

interface RepoMeta {
    val id: String
    val createdOn: OffsetDateTime
}
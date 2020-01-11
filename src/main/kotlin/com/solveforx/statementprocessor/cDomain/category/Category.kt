package com.solveforx.statementprocessor.cDomain.category

import java.util.*

/**
 * Income category, owned by a group
 */
data class Category(val id: UUID,
                    val name: String,
                    val groupingId: UUID,
                    val keys: List<String>)
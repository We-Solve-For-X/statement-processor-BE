package com.solveforx.statementprocessor.cDomain.category

import java.util.*

/**
 * Expense group, containing 0+ Categories
 */
data class Group(val id: UUID,
                 val name: String,
                 val userId: UUID)
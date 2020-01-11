package com.solveforx.statementprocessor.cDomain.category

import java.util.*

/**
 * return body for a grouping together with it's category.
 * A List<GroupingProfile> will be returned for a user's profile of categories
 */
data class GroupingProfile(val groupingId: UUID,
                           val groupingName: String,
                           val categories: List<Category>)
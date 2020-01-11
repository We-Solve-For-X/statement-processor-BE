package com.solveforx.statementprocessor.cDomain.authentication

import java.util.*
import javax.print.attribute.standard.JobOriginatingUserName

data class AuthProfile(val id: UUID,
                       val userName: String,
                       val password: String)
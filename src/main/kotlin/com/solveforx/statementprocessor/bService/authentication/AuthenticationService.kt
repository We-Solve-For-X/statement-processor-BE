package com.solveforx.statementprocessor.bService.authentication

import com.solveforx.statementprocessor.cDomain.user.User
import java.util.*

class AuthenticationService {

    /**
     * Takes username & password
     *
     * @return User()
     */
    fun login(username: String, password: String): User {
        println("logging in")
        return User("Name", UUID.randomUUID())
    }

    /**
     * Creates a new user
     */
    fun createUser(username: String, password: String) {

    }

}
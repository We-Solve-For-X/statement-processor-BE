package com.solveforx.statementprocessor.bService.authentication

import com.solveforx.common.genesis.DataRepository.MongoRepo
import com.solveforx.common.genesis.ErrorHandling.ErrorPackage
import com.solveforx.statementprocessor.cDomain.authentication.AuthProfile
import com.solveforx.statementprocessor.cDomain.authentication.Login
import com.solveforx.statementprocessor.cDomain.user.User
import org.funktionale.either.Either
import org.funktionale.either.Either.*
import org.funktionale.either.flatMap
import org.funktionale.either.toEitherRight
import org.funktionale.option.toOption
import java.util.*

class AuthenticationService(private val authRepo: MongoRepo<AuthProfile>, private val usersrepo: MongoRepo<User>) {

    /**
     * Takes username & password
     *
     * @return User()
     */
    fun login(loginReq: Login): Either<ErrorPackage, User> {
        val authProfile: Either<ErrorPackage, AuthProfile> = authRepo
                .findByField("username", loginReq.username)
                .toOption()
                .toEitherRight { ErrorPackage("User Not Found") }

        val passCorrect: Either<ErrorPackage, String> = if (authProfile.component2()?.password?: "" == loginReq.password) {
            authProfile
                    .right()
                    .map { profile -> profile.id }
        } else {
            Left<ErrorPackage, String>(ErrorPackage("Password Incorrect"))
        }

        val user: Either<ErrorPackage, User> = passCorrect
                .right()
                .flatMap { id -> usersrepo.findByField("authProfileId", id ).toOption().toEitherRight { ErrorPackage("User Not Found") }}

        return user
    }

    /**
     * Creates a new user
     */
    fun createUser(username: String, password: String) {

    }

}
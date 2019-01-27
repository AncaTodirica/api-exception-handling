package com.apiexceptions.tests.rest

import com.apiexceptions.tests.domain.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v3")
class UserResponseStatusExceptionController {

    @GetMapping("/user/{id}")
    fun user(@PathVariable id: String): User {
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "User with id $id not found")
    }
}

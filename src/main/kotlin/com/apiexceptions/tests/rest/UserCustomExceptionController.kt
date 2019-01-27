package com.apiexceptions.tests.rest

import com.apiexceptions.tests.domain.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v2")
class UserExceptionHandlerController {

    @GetMapping("/user/{id}")
    fun user(@PathVariable id: String): User {
        throw UserNotFoundException(id)
    }
}

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class UserNotFoundException(id: String) : RuntimeException(){
    override val message: String = "User with id $id not found"
}


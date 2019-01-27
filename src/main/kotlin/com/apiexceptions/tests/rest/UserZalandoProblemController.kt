package com.apiexceptions.tests.rest

import com.apiexceptions.tests.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zalando.problem.AbstractThrowableProblem
import org.zalando.problem.Exceptional
import org.zalando.problem.Problem
import org.zalando.problem.Status


@RestController
@RequestMapping("/api/v1")
class UserZalandoProblemController {

    @GetMapping("/user/{id}")
    fun user(@PathVariable id: String): User {
        throw NotFoundProblem(id)
//        throw Problem.valueOf(Status.ACCEPTED, "User not found")
    }
}


class NotFoundProblem(userId: String) :
    AbstractThrowableProblem(null, "Not found", Status.NOT_FOUND, String.format("User  with id '%s' is not found", userId)) {

    override fun getCause(): Exceptional {
        return Problem.valueOf(Status.NOT_FOUND)
    }
}

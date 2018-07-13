package com.kroger.checkout.person.controller

import com.kroger.checkout.person.model.Person
import com.kroger.checkout.person.service.PersonService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@Validated
@RestController
@RequestMapping("/v1/persons", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
class PersonGetController(
    private val personService: PersonService
) {

    @GetMapping("/{id}", produces = ["application/json"])
    fun getPerson(
        @Size(max = 10)
        @PathVariable("id") id: String
    ): ResponseEntity<Person> {
        println("username - $id")
        return ResponseEntity.ok(personService.getPerson())
    }

}
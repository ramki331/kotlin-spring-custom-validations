package com.kroger.checkout.person.controller

import com.kroger.checkout.person.model.CreatePerson
import com.kroger.checkout.person.model.Person
import com.kroger.checkout.person.service.PersonService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/persons", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
class PersonController(
    private val personService: PersonService
) {

    @PostMapping(produces = ["application/json"])
    fun addPerson(
        @Valid
        @RequestBody
        personReq: CreatePerson
    ):ResponseEntity<Person> {
        personService.createPerson(personReq.person)
        return ResponseEntity.status(201).body(personReq.person)
    }

}
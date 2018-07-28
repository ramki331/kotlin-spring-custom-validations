package com.kroger.checkout.person.controller

import com.kroger.checkout.person.model.CreatePerson
import com.kroger.checkout.person.model.Person
import com.kroger.checkout.person.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/persons", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
@Validated
class PersonController(
    private val personService: PersonService
) {

    @PostMapping(produces = ["application/json"])
    fun addPerson(
        @Valid
        @Validated
        @RequestBody
        personReq: CreatePerson
    ):ResponseEntity<Person> {
        personService.createPerson(personReq.person)
        return ResponseEntity.status(201).body(personReq.person)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(e: MethodArgumentNotValidException): ResponseEntity<String> {
       val errors =
        (e.bindingResult.fieldErrors.map {fieldError ->
            fieldError.defaultMessage
        })
        return ResponseEntity.ok(" ")
    }


}
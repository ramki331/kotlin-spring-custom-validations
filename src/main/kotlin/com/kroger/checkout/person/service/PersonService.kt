package com.kroger.checkout.person.service

import com.kroger.checkout.person.model.Address
import com.kroger.checkout.person.model.Person
import org.springframework.stereotype.Component

@Component
class PersonService {

    fun getPerson() : Person {
        return Person(
            "rk", "test@test.com", listOf(Address("test1","test1"))
        )
    }

    fun createPerson(person: Person) = println("created $person")

}
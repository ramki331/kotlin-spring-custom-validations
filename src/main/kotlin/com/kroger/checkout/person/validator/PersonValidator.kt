package com.kroger.checkout.person.validator

import com.kroger.checkout.person.ValidPerson
import com.kroger.checkout.person.model.Address
import com.kroger.checkout.person.model.Person
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PersonValidator: ConstraintValidator<ValidPerson, Person> {

    override fun initialize(constraintAnnotation: ValidPerson) {
        super.initialize(constraintAnnotation)

        println("person validator initialize....")

    }

    override fun isValid(value: Person?, context: ConstraintValidatorContext?): Boolean = when {
        value != null -> {
            println("person is valid...")
            true
        }
        else -> {
            println("person is not valid...")
            false
        }
    }

}
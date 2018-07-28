package com.kroger.checkout.person.validator

import com.kroger.checkout.person.ValidEmail
import com.kroger.checkout.person.model.CreatePerson
import com.kroger.checkout.person.model.Person
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.ConstraintViolationException

class EmailValidator: ConstraintValidator<ValidEmail, String> {

    override fun initialize(constraintAnnotation: ValidEmail) {
        super.initialize(constraintAnnotation)

        println("email validator initialize....")

    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean = when {
        value != null -> {
            println("email is valid...")
            true
        }
        else -> {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("email is required xxxxxxxxxxxxx")
                //.addPropertyNode("person")
                         //.addBeanNode()
                         //.addConstraintViolation()
                .addConstraintViolation()
            //throw ConstraintViolationException("email is required", setOf())
            false
        }
    }

}
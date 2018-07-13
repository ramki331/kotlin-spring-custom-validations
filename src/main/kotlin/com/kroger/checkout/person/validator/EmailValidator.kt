package com.kroger.checkout.person.validator

import com.kroger.checkout.person.ValidEmail
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailValidator: ConstraintValidator<ValidEmail, String> {

    override fun initialize(constraintAnnotation: ValidEmail) {
        super.initialize(constraintAnnotation)

        println("email validator initialize....")

    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean = when {
        value != null -> {
            println("email is valid...")
            true
        }
        else -> {
            println("email is not valid...")
            false
        }
    }

}
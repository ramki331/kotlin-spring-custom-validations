package com.kroger.checkout.person.validator

import com.kroger.checkout.person.model.Address
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class AddressValidator: ConstraintValidator<ValidAddress, List<Address>> {

    override fun initialize(constraintAnnotation: ValidAddress) {
        super.initialize(constraintAnnotation)

        println("address validator initialize....")

    }

    override fun isValid(value: List<Address>, context: ConstraintValidatorContext?): Boolean = when {
        value.isNotEmpty() -> {
            println("address is valid...")
            true
        }
        else -> {
            println("ADDRESS is not valid...")
            false
        }
    }

}
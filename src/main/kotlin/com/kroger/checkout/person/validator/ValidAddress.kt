package com.kroger.checkout.person.validator

import javax.validation.Constraint
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [AddressValidator::class])
annotation class ValidAddress (
    val message: String = "address is invalid",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = []
)
package com.kroger.checkout.person

import com.kroger.checkout.person.validator.EmailValidator
import com.kroger.checkout.person.validator.PersonValidator
import javax.validation.Constraint
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PersonValidator::class])
annotation class ValidPerson (
    val message: String = "person is invalid",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Any>> = []
)

package com.kroger.checkout.person.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.kroger.checkout.person.ValidEmail
import com.kroger.checkout.person.validator.ValidAddress
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.groups.Default

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreatePerson (
    val id: String,
    @field:Valid
    val person: Person
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Person (
    @field:NotNull
    val username: String,
    @field:ValidEmail(groups = [Default::class])
    val email: String?,
    @field:ValidAddress(groups = [Default::class])
    val address: List<Address>?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Address (
    val address1: String?,
    val address2: String?
)
package br.com.msansone.securityapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
data class Usuario (
        @Id
        @GeneratedValue(strategy =IDENTITY)
        val id: Long?,
        @NotBlank
        @Min(3)
        @Max(100)
        var nome: String?,
        @NotBlank
        @Email
        var email: String,
        @NotBlank
        var senha: String,
        var superUsuario: Boolean?,

        )
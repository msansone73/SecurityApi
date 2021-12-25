package br.com.msansone.securityapi.repository

import br.com.msansone.securityapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    abstract fun findByEmailAndSenha(email: String, senha: String): Optional<Usuario>
}
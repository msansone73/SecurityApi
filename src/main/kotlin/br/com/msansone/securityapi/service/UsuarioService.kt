package br.com.msansone.securityapi.service

import br.com.msansone.securityapi.model.Usuario
import java.util.*

interface UsuarioService {
    abstract fun getAll(): List<Usuario>?
    abstract fun addUsuario(usuario: Usuario): Usuario
    abstract fun getUsuarioById(id: Long): Optional<Usuario>
    abstract fun getUsuarioByEmailSenha(email: String, senha: String): Optional<Usuario>
    abstract fun updateUsuario(id: Long, usuario: Usuario): Usuario
}
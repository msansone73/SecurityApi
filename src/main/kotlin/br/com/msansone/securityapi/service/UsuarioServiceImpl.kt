package br.com.msansone.securityapi.service

import br.com.msansone.securityapi.model.Usuario
import br.com.msansone.securityapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioServiceImpl: UsuarioService {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    override fun getAll(): List<Usuario>? {
        return usuarioRepository.findAll()
    }

    override fun addUsuario(usuario: Usuario): Usuario {
        return  usuarioRepository.save(usuario)
    }

    override fun getUsuarioById(id: Long): Optional<Usuario> {
        return usuarioRepository.findById(id)
    }

    override fun getUsuarioByEmailSenha(email: String, senha: String): Optional<Usuario> {
        return usuarioRepository.findByEmailAndSenha(email, senha)
    }

    override fun updateUsuario(id: Long, usuario: Usuario): Usuario {
        var usuarioAtual:Usuario = usuarioRepository.findById(id).orElse(throw RuntimeException("não encontrado"))
        usuarioAtual.nome=usuario.nome
        usuarioAtual.email=usuario.email
        usuarioAtual.superUsuario=usuarioAtual.superUsuario
        usuarioRepository.save(usuarioAtual)
        return usuarioAtual
    }
}
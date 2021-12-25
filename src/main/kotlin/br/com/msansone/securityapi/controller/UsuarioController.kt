package br.com.msansone.securityapi.controller

import br.com.msansone.securityapi.model.Usuario
import br.com.msansone.securityapi.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun getAll(): ResponseEntity<List<Usuario>>{
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    fun getuserById(@PathVariable id:Long ): ResponseEntity<Usuario> {
        val usuario = usuarioService.getUsuarioById(id)
        if (usuario.isPresent){
            return ResponseEntity.ok( usuario.get())
        } else {
            return ResponseEntity.notFound().build<Usuario>()
        }
    }

    @PostMapping
    fun addUsuario(@RequestBody usuario: Usuario): ResponseEntity<Usuario>{
        return ResponseEntity.ok(usuarioService.addUsuario(usuario))
    }

    @PutMapping("/{id}")
    fun updateUsuario(@PathVariable id:Long, @RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuario))
    }

    @PostMapping("/login")
    fun loginUsuario(@RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        val usuario = usuarioService.getUsuarioByEmailSenha(usuario.email, usuario.senha)
        if (usuario.isPresent){
            return ResponseEntity.ok( usuario.get())
        } else {
            return ResponseEntity.notFound().build<Usuario>()
        }
    }




}
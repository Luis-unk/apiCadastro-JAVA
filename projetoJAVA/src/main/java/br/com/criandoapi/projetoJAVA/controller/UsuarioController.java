package br.com.criandoapi.projetoJAVA.controller;

import br.com.criandoapi.projetoJAVA.repository.IUsuario;
import br.com.criandoapi.projetoJAVA.model.Usuario;
import br.com.criandoapi.projetoJAVA.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    /* Autowired -> faz a injeção de dependências; */
    @Autowired
    private IUsuario repository;

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario (@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.editarUsuario(usuario));
    }

    /* @PathVariable é utilizado para manipular dados através da URI da pagina; */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha (@RequestBody Usuario usuario) {
        Boolean valid = usuarioService.validarSenha(usuario);
        if(!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }

}

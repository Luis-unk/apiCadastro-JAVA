package br.com.criandoapi.projetoJAVA.controller;

import br.com.criandoapi.projetoJAVA.DAO.IUsuario;
import br.com.criandoapi.projetoJAVA.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    /* Autowired -> faz a injeção de dependências; */
    @Autowired
    private IUsuario dao;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> lista = (List<Usuario>) dao.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return ResponseEntity.status(201).body(usuarioNovo);
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario (@RequestBody Usuario usuario) {
        Usuario usuarioUpdate = dao.save(usuario);
        return ResponseEntity.status(201).body(usuarioUpdate);
    }

    /* @PathVariable é utilizado para manipular dados através da URI da pagina; */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}

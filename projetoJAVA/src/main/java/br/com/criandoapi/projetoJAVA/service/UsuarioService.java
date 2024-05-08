package br.com.criandoapi.projetoJAVA.service;

import br.com.criandoapi.projetoJAVA.model.Usuario;
import br.com.criandoapi.projetoJAVA.repository.IUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario updateUsuario = repository.save(usuario);
        return updateUsuario;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }


    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}

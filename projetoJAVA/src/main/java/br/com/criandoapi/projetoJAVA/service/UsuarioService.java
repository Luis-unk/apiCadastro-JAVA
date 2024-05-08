package br.com.criandoapi.projetoJAVA.service;

import br.com.criandoapi.projetoJAVA.model.Usuario;
import br.com.criandoapi.projetoJAVA.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario editarUsuario(Usuario usuario) {
        Usuario updateUsuario = repository.save(usuario);
        return updateUsuario;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }


}

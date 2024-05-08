package br.com.criandoapi.projetoJAVA.repository;

import br.com.criandoapi.projetoJAVA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/* Interface CrudRepository<T,ID>  recebe como parametro o tipo de dado, e o tipo do dado do ID(primary key) ->
* neste exemplo utilizamos o Usuario, e o tipo Integer que é o tipo da primary key do BDD MySQL que foi utilizado.
*
* Permite com que a gente tenha acesso ao banco de maneira mais fácil através de alguns métodos.
* */

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}

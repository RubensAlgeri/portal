package br.com.algeri.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.algeri.portal.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}

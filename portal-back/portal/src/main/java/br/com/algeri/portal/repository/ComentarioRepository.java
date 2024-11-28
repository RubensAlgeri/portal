package br.com.algeri.portal.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.algeri.portal.model.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Integer> {

}

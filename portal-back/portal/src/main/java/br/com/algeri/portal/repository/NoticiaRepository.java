package br.com.algeri.portal.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.algeri.portal.model.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {

}
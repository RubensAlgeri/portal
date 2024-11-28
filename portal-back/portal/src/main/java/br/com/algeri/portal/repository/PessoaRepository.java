package br.com.algeri.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.algeri.portal.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

}
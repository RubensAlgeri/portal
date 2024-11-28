package br.com.algeri.portal.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.algeri.portal.model.Categoria;
import br.com.algeri.portal.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
@RequestMapping(value = "categoria")
public class CategoriaController extends GenericController<Categoria, Integer> {
      @Autowired
    CategoriaRepository categoriaRepository;

    @RequestMapping(value = "listartodos", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok((List<Categoria>) categoriaRepository.findAll());

    }
}

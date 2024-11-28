package br.com.algeri.portal.controller;

import br.com.algeri.portal.model.Noticia;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "noticia")
public class NoticiaController extends GenericController<Noticia, Integer> {
    // Nenhuma implementação adicional necessária, pois herda o CRUD genérico
}

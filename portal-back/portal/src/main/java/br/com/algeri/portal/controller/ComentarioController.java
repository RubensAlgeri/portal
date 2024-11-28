package br.com.algeri.portal.controller;

import br.com.algeri.portal.model.Comentario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comentario")
public class ComentarioController extends GenericController<Comentario, Integer> {
    // Nenhuma implementação adicional necessária, pois herda o CRUD genérico
}

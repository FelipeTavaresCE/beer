package br.com.beer.controller;

import br.com.beer.model.Cerveja;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by felipe.tavares on 29/08/16.
 */

@RestController
@RequestMapping("/cerveja")
public class CervejaController extends AbstractController<Cerveja, Long> {

    public CervejaController(){
        super(Cerveja.class);
    }
}

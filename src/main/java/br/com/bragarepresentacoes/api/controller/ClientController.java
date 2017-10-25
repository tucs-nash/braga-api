package br.com.bragarepresentacoes.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.Client;
import br.com.bragarepresentacoes.api.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController extends CrudController<ClientService, Client> {

}

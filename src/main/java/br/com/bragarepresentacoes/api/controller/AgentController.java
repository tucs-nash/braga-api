package br.com.bragarepresentacoes.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.Agent;
import br.com.bragarepresentacoes.api.service.AgentService;

@Controller
@RequestMapping("/agent")
public class AgentController extends CrudController<AgentService, Agent> {
 
}

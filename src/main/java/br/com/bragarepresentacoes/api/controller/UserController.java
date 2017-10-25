package br.com.bragarepresentacoes.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.ApiUser;
import br.com.bragarepresentacoes.api.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends CrudController<UserService, ApiUser>{

}

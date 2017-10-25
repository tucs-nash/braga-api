package br.com.bragarepresentacoes.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.Company;
import br.com.bragarepresentacoes.api.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController extends CrudController<CompanyService, Company>{

}

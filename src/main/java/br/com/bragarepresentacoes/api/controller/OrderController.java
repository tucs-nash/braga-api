package br.com.bragarepresentacoes.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.Order;
import br.com.bragarepresentacoes.api.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends CrudController<OrderService, Order> {

}

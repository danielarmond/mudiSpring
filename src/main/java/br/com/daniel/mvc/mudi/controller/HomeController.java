	package br.com.daniel.mvc.mudi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.daniel.mvc.mudi.model.Pedido;
import br.com.daniel.mvc.mudi.model.StatusPedido;
import br.com.daniel.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		Iterable<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		model.addAttribute("pedidos",pedidos);
		return "home";
	}
	
	@GetMapping("/home/{status}")
	public String porStatus(@PathVariable("status")String status, Model model) {
		Iterable<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()), null);
		model.addAttribute("pedidos",pedidos);
		model.addAttribute("status", status);
		return "home";
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
		
	}
}

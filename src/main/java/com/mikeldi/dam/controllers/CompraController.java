package com.mikeldi.dam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

@Controller
@RequestMapping("/lista")
public class CompraController {
	@Autowired
	private JsonMapper mapper;  

	@GetMapping("/compra")
	public String verLista(Model model) {
		return "listaCompra"; 
	}
	
	@PostMapping("/imprimir")
	public String imprimir(@RequestParam("listado") String listado, Model model) {
		List<String> listaCompra = mapper.readValue(listado, new TypeReference<List<String>>() {});
		model.addAttribute("listaCompra", listaCompra);
		return "listaImprimir";
	}
}




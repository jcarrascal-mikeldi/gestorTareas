package com.mikeldi.dam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikeldi.dam.component.TareaComp;
import com.mikeldi.dam.models.entity.Tarea;
import com.mikeldi.dam.service.ITareaService;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;


@Controller
@RequestMapping("/gestor")
public class TareaController {
	
	
	@Autowired 
	private ITareaService serviceTarea;

	@Autowired 
	private TareaComp tarea;
	
    @Autowired
    private JsonMapper mapper;  
	
	@GetMapping("/tareas")
	public String verTareas(Model model) {
		List<Tarea> tareas =serviceTarea.findAll();
		
		model.addAttribute("tareas", tareas);

		return "gestorTareas"; 

	}
	
	 @PostMapping("/guardarTareas")
	    public String guardarTareas(
	            @RequestParam("listadoTareas") String listadoTareas,
	            @RequestParam("listadoRealizadas") String listadoRealizadas) throws Exception {

	        // 1) Convertir los JSON (que vienen como String) a List<String>
		  List<String> pendientes = mapper.readValue(
	                listadoTareas,
	                new TypeReference<List<String>>() {}
	        );

	        List<String> realizadas = mapper.readValue(
	                listadoRealizadas,
	                new TypeReference<List<String>>() {}
	        );

	        // 2) Ejemplo de estrategia: borrar lo que hubiera y volver a guardar todo
	        serviceTarea.borrarTodas();  // opcional, depende de tu diseño

	        // 3) Guardar pendientes en BD (realizada = false)
	        for (String texto : pendientes) {
	            if (texto == null || texto.trim().isEmpty()) {
	                continue;
	            }
	            Tarea t = new Tarea();
	            t.setTarea(texto.trim());
	            t.setRealizada(false);
	            serviceTarea.guardar(t);
	        }

	        // 4) Guardar realizadas en BD (realizada = true)
	        for (String texto : realizadas) {
	            if (texto == null || texto.trim().isEmpty()) {
	                continue;
	            }
	            Tarea t = new Tarea();
	            t.setTarea(texto.trim());
	            t.setRealizada(true);
	            serviceTarea.guardar(t);
	        }

	        // 5) Volver a la página del gestor
	        return "redirect:/gestor/tareas";
	    }
	}


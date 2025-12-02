package com.mikeldi.dam.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mikeldi.dam.models.entity.Tarea;


public interface ITareaService {

	public List<Tarea> findAll();

	public void saveList(List<Tarea>  tareas);
	
	public void guardar(Tarea t);
	
	public void borrarTodas();
	

}

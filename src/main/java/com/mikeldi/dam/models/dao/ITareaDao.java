package com.mikeldi.dam.models.dao;

import java.util.List;

import com.mikeldi.dam.models.entity.Tarea;


public interface ITareaDao {

	public List<Tarea> findAll();

	public void save(List<Tarea> tareas);
	
	public void guardar(Tarea t);
	
	public void deleteAll();
}

package com.mikeldi.dam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikeldi.dam.models.dao.ITareaDao;
import com.mikeldi.dam.models.entity.Tarea;



@Service
public class TareaServiceImpl implements ITareaService {
	@Autowired
	private ITareaDao tareaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return tareaDao.findAll();
	}

	@Override
	@Transactional
	public void saveList(List<Tarea> tareas) {
		tareaDao.save(tareas);
		
	}
	
	@Override
	@Transactional
	public void guardar(Tarea t) {
		tareaDao.guardar(t);
		
	}
	
	@Override
	@Transactional
	public void borrarTodas() {
		tareaDao.deleteAll();
		
	}

}


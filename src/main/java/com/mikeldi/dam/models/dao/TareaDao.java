package com.mikeldi.dam.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mikeldi.dam.models.entity.Tarea;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TareaDao implements ITareaDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional(readOnly = true)
	@Override
	public List<Tarea> findAll() {
		return em.createQuery("select c from Tarea c").getResultList();
	}

	@Override
	@Transactional
	public void save(List<Tarea> tareas) {
		if (tareas != null) {
			em.merge(tareas);
		} else {
			em.persist(tareas);
		}
	}
	
	@Override
	@Transactional
	public void guardar(Tarea t) {
		if (t != null) {
			em.merge(t);
		} else {
			em.persist(t);
		}
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		em.createNativeQuery("DELETE FROM tareas").executeUpdate();
	}
}


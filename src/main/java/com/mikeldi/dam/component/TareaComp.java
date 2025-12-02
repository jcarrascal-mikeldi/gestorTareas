package com.mikeldi.dam.component;

import org.springframework.stereotype.Component;

@Component
public class TareaComp {
	private String tarea;
	private boolean realizada;
	private int prioridad;
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public boolean isRealizada() {
		return realizada;
	}
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	

}


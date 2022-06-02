package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

import Logic.Actividad;
import Logic.Participante;
import Logic.Proyecto;
import Logic.Tarea;
import Logic.TipoActividad;
import Logic.TipoTarea;
import Logic.Cronometro;
import Logic.Equipo;
import Logic.PaqueteDeTrabajo;

public class Controlador {
	private Proyecto proyecto;
	private ArrayList<Participante>participantes;
	private Cronometro timer = new Cronometro();
	
	public Controlador() {
		this.proyecto =new Proyecto();
		this.participantes =new ArrayList<>();
	}
	
	//Todas estas funciones sirven como mediador entre la consola y la lógica. Esto es para un menos acoplamiento
	public Participante crearParticipante(String nombre,String correo ) {
		Participante participante = new Participante(nombre,correo);
		//participantes.add(participante);
		proyecto.agregarParticipante(participante);
		return participante;
		
	}
	
	public Proyecto crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion,Participante propietario, PaqueteDeTrabajo paquete) 
	{
		proyecto = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion, propietario, paquete);
		proyecto.agregarParticipante(propietario);
		
		return proyecto;
	}
	
	public Actividad crearActividad(String titulo, String descripcion, TipoActividad tipo, String fecharealizacion,String horainicio,String horafin, Participante participante, Proyecto proyecto, String tarea, int Tiempo)
	{
		Actividad actividad = new Actividad(titulo, descripcion, tipo, fecharealizacion, horainicio, horafin, participante);
		actividad.setTiempoTotal(Tiempo);
		proyecto.agregarActividad(actividad);
		asociarActividadConTarea(actividad, tarea);
		return actividad;	
	}
	
	public PaqueteDeTrabajo crearPaqueteInicial(String nombre, String descripcion)
	{
		PaqueteDeTrabajo paquete = new PaqueteDeTrabajo(nombre, descripcion);
		return paquete;
	}
	
	public PaqueteDeTrabajo crearPaquete(String nombre, String descripcion, PaqueteDeTrabajo paquetePadre)
	{
		PaqueteDeTrabajo paquete = new PaqueteDeTrabajo(nombre, descripcion);
		paquetePadre.agregarPaquete(paquete);
		return paquete;
	}
	
	public Tarea crearTarea(String nombre, String descripcion, TipoTarea tipo, PaqueteDeTrabajo paquete,Equipo equipo)
	{
		Tarea tarea = new Tarea(nombre, descripcion, tipo);
		paquete.agregarTarea(tarea);
		equipo.getTareasAsignadas().add(tarea);
		equipo.getTareasPendientes().add(tarea);
		return tarea;
		
	}
	
	public void asignarTipoActividad(String[] tipo) {
		ArrayList<TipoActividad> arrayTipos = new ArrayList<>();
		for (String tipoA: tipo) {
			TipoActividad tipoActividad = new TipoActividad();
			tipoActividad.setNombreTipoActividad(tipoA);
			tipoActividad.setProyecto(proyecto);
			arrayTipos.add(tipoActividad);
		}
		proyecto.setTipoActividades(arrayTipos);
	}
	
	public void asignarTipoTarea(String[] tipo) {
		ArrayList<TipoTarea> arrayTiposTarea = new ArrayList<>();
		for (String tipoT: tipo) {
			TipoTarea tipoTarea = new TipoTarea();
			tipoTarea.setNombreTipoTarea(tipoT);
			tipoTarea.setProyecto(proyecto);
			arrayTiposTarea.add(tipoTarea);
		}
		proyecto.setTipoTareas(arrayTiposTarea);;
	}
	
	public ArrayList<Tarea> obtenerTareas(Proyecto proyecto) {
		return proyecto.getPaquete().getTareas();
	}
	
	public Equipo crearEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		proyecto.getEquipos().add(equipo);
		return equipo;
	}
	
	public void agregarIntegranteEquipo(String nombre,int posParticipante) {
		Equipo equipo = obtenerEquipo(nombre);
		if (equipo==null) {
			equipo=crearEquipo(nombre);
		}
		Participante participante=obtenerParticipante(posParticipante);
		equipo.getIntegrantes().add(participante);
		proyecto.getParticipantesDisponibles().remove(participante);
	}
	private Equipo obtenerEquipo(String nombre) {
		for(Equipo equipo:proyecto.getEquipos()) {
			if (equipo.getNombre().equals(nombre)) {
				return equipo;
			}
				
		}
		return null;
	}
	
	private Participante obtenerParticipante(int posParticipante) {
		return proyecto.getParticipantesDisponibles().get(posParticipante);
		
	}
	
	public void asociarActividadConTarea(Actividad actividad, String tareaAct) {
		for (Tarea tarea : proyecto.getPaquete().getTareas()) {
			if (tareaAct == tarea.getNombre()) {
				tarea.getActividades().add(actividad);
			}
		}
	}
	public String obtenerNombre() {
		return proyecto.getNombre();
	
	}
	
	public String cantidadEquipos() {
		return String.valueOf(proyecto.getEquipos().size());
	}
	
	public String cantidadPartipantes() {
		return String.valueOf(proyecto.getParticipantes().size());
		
	}
	
	public String cantidadTareas() {
		return String.valueOf(proyecto.cantidad.size());
	}
	

	public Proyecto getProyecto() {
		return proyecto;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	public void startCronometro() {
		timer.startTime();
	}
	
	public void stopCronometro() {
		timer.stopTime();
	}
	public int getTiempo() {
		return timer.tiempoEnMins();
	}

}

package Logic;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private ArrayList<Participante> integrantes;
	private ArrayList<Tarea> tareasPendientes;
	private ArrayList<Tarea> tareasAsignadas;
	private ArrayList<Tarea> tareasTerminadas;

	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.integrantes = new ArrayList<>();
		this.tareasPendientes = new ArrayList<>();
		this.tareasAsignadas = new ArrayList<>();
		this.tareasTerminadas = new ArrayList<>();

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Participante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Participante> integrantes) {
		this.integrantes = integrantes;
	}

	public ArrayList<Tarea> getTareasPendientes() {
		return tareasPendientes;
	}

	public void setTareasPendientes(ArrayList<Tarea> tareasPendientes) {
		this.tareasPendientes = tareasPendientes;
	}

	public ArrayList<Tarea> getTareasAsignadas() {
		return tareasAsignadas;
	}

	public void setTareasAsignadas(ArrayList<Tarea> tareasAsignadas) {
		this.tareasAsignadas = tareasAsignadas;
	}

	public ArrayList<Tarea> getTareasTerminadas() {
		return tareasTerminadas;
	}

	public void setTareasTerminadas(ArrayList<Tarea> tareasTerminadas) {
		this.tareasTerminadas = tareasTerminadas;
	}

}

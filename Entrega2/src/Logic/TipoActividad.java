package Logic;

import java.util.ArrayList;
import java.util.HashMap;

public class TipoActividad 
{

	private String nombreTipoActividad;
	private Proyecto proyecto;
	private HashMap<String, ArrayList<Integer>> tiempoParticipantes = new HashMap<>();
	
	
	
	
	//Getters and Setters
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public String getNombreTipoActividad() {
		return nombreTipoActividad;
	}
	public void setNombreTipoActividad(String nombreTipoActividad) {
		this.nombreTipoActividad = nombreTipoActividad;
	}
	public HashMap<String, ArrayList<Integer>> getTiempoParticipantes() {
		return tiempoParticipantes;
	}
	public void setTiempoParticipantes(HashMap<String, ArrayList<Integer>> tiempoParticipantes) {
		this.tiempoParticipantes = tiempoParticipantes;
	}
	
	
}

package Logic;

import java.util.ArrayList;
import java.util.HashMap;

public class TipoTarea 
{

	private String nombreTipoTarea;
	private Proyecto proyecto;
	private HashMap<String, ArrayList<Integer>> tiempoParticipantes = new HashMap<>();
	
	
	
	//Getters and Setters
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public String getNombreTipoTarea() {
		return nombreTipoTarea;
	}
	public void setNombreTipoTarea(String nombreTipoTarea) {
		this.nombreTipoTarea = nombreTipoTarea;
	}
	public HashMap<String, ArrayList<Integer>> getTiempoParticipantes() {
		return tiempoParticipantes;
	}
	public void setTiempoParticipantes(HashMap<String, ArrayList<Integer>> tiempoParticipantes) {
		this.tiempoParticipantes = tiempoParticipantes;
	}
	
	
}

package Logic;

import java.util.ArrayList;

public class Tarea {

	//Atributos
		private String nombre;
		private String descripcion;
		private TipoTarea tipo;
		private ArrayList<Actividad> actividades;
		private int tiempoTotal;
		private boolean finalizada;
		
		//Constructor


		public Tarea(String nombre, String descripcion, TipoTarea tipo) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.tipo = tipo;
			this.actividades = new ArrayList<>();
			this.tiempoTotal = 0;
		}

		
		
	//Getters and Setters
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public TipoTarea getTipo() {
			return tipo;
		}

		public void setTipo(TipoTarea tipo) {
			this.tipo = tipo;
		}
		
		public ArrayList<Actividad> getActividades() {
			return actividades;
		}

		public void setActividades(ArrayList<Actividad> actividades) {
			this.actividades = actividades;
		}
		
		public void obtenerTiempoTotal() {
			ArrayList<Actividad> arrayActs = getActividades();
			for (Actividad actividad : arrayActs) {
				tiempoTotal += actividad.getTiempoTotal();
			}
		}
		
		public void setFinalizada(boolean finalizada) {
			this.finalizada = finalizada;
		}
		
		public boolean getFinalizada() {
			return finalizada;
		}
}

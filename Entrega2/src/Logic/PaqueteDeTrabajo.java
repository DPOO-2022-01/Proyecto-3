package Logic;

import java.util.ArrayList;

public class PaqueteDeTrabajo  {

	//Atributos

		private String nombre;
		private String descripcion;
		private ArrayList<PaqueteDeTrabajo> paquetes;
		private ArrayList<Tarea> tareas;
		
	//Constructor
		
		public PaqueteDeTrabajo(String nombre, String descripcion) {
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.tareas = new ArrayList<Tarea>();
			this.paquetes = new ArrayList<PaqueteDeTrabajo>();
		}

		
		//Métodos
		
		public void agregarPaquete(PaqueteDeTrabajo paquete)
		{
			this.paquetes.add(paquete);
		}
		
		public void agregarTarea(Tarea tarea)
		{
			this.tareas.add(tarea);
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


		public ArrayList<PaqueteDeTrabajo> getPaquetes() {
			return paquetes;
		}


		public void setPaquetes(ArrayList<PaqueteDeTrabajo> paquetes) {
			this.paquetes = paquetes;
		}


		public ArrayList<Tarea> getTareas() {
			return tareas;
		}


		public void setTareas(ArrayList<Tarea> tareas) {
			this.tareas = tareas;
		}
		
		
}

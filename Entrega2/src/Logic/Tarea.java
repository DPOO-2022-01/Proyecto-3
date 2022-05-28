package Logic;

public class Tarea {

	//Atributos
		private String nombre;
		private String descripcion;
		private String tipo;
		
		//Constructor
		
		public Tarea(String nombre, String descripcion, String tipo) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.tipo = tipo;
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

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		
		
}

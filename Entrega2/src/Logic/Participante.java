package Logic;

public class Participante {

	//Atributos
	private String nombre;
	private String email;


	//Constructor
	public Participante(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;


	}

	//Getters


	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", email=" + email + "]";
	}

	public String getNombre() {
		return nombre;
	}

}
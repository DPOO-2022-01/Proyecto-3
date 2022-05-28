package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un nodo del �rbol del WBS.
 */

public class NodoWBS<T> {

	 // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	private PaqueteDeTrabajo paquete;
    /**
     * Tipo del nodo.
     */
    private String tipo;

    /**
     * Identificador del nodo.
     */
    private String identificador;
    
    /**
     * El nombre del nodo.
     */
    private String nombre;
    
    private T dato;
    private List<NodoWBS<T>> hijos;
    private NodoWBS<T> padre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo nodo.<br>
     * <b>post: </b> Los atributos identificador y tipo se inicializaron con los valores dados por par�metro.
     * @param pTipo Tipo del nodo. pTipo != null && pTipo != "".
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @param pNombre Nombre del nodo. pNombre != null && pNombre != "".
     */
    public NodoWBS(T dato, String pTipo, String pNombre )
    {
        tipo = pTipo;
        nombre = pNombre;
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el identificador del nodo.
     * @return Identificador del nodo.
     */
    public String darIdentificador( )
    {
        return identificador;
    }

    /**
     * Retorna el tipo del nodo.
     * @return Tipo del nodo.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el nombre del nodo.
     * @return Nombre del nodo.
     */
    public String darNombre(){
        return nombre;
    }
    
    /**
     * Busca el nodo con el identificador dado.
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @return NodoAlmacen con el identificador dado o null si no se encontr� el nodo.
     */
    public NodoWBS buscarNodo( String pIdentificador ) {
    	return null;
    }

    /**
     * Crea un nodo a partir de la informaci�n del lector.
     * @param pLector Lector que contiene la informaci�n. pLector != null.
     * @return NodoAlmacen creado.
     * @throws AlmacenException Si ocurre alg�n error al leer la informaci�n.
     */
    
    public NodoWBS(NodoWBS<T> nodo) {
    	this.dato = (T) nodo.getDato();
    	hijos = new ArrayList<>();
    	
    }
    
    public void agregarHijo(NodoWBS<T> hijo) {
    	hijo.setPadre(this);
    	hijos.add(hijo);
    }
    
    @Override   public boolean equals(Object obj) {     
    if (null == obj)       
    	return false;      
    if (obj instanceof NodoWBS) 
    {       if (((NodoWBS<?>) obj).getDato().equals(this.dato))         
    	return true;     
    }      
    return false;   
    }
  
   
	/**
     * Retorna la representaci�n en string de este objeto.<br>
     * @return Nombre del nodo.
     */
    @Override
    public String toString( )
    {
        return nombre;
    }
    
    
    //Getters and Setters

	public PaqueteDeTrabajo getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteDeTrabajo paquete) {
		this.paquete = paquete;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setHijos(List<NodoWBS<T>> hijos) {
		for(NodoWBS<T> hijo : hijos)
			hijo.setPadre(this);
		
		this.hijos = hijos;
	}

	public NodoWBS<T> getPadre() {
		return padre;
	}

	public void setPadre(NodoWBS<T> padre) {
		this.padre = padre;
	}
	
	public T getDato() {
		return this.dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public List<NodoWBS<T>> getHijos(){
		return this.hijos;
	}

    
}



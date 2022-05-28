package Logic;

import java.util.ArrayList;

public class WBS<T> {

	//Atributos
	
	private NodoWBS<T> paqueteRaiz;
	
	
	//Constructor
	public WBS(NodoWBS<T> paqueteRaiz) {
		this.paqueteRaiz = paqueteRaiz;
	}
	
	public boolean vacio() {
		return paqueteRaiz == null;
	}
	
	public NodoWBS<T> getPaqueteRaiz(){
		return paqueteRaiz;
	}
	
	public void setPaqueteRaiz(NodoWBS<T> paqueteRaiz) {
		this.paqueteRaiz = paqueteRaiz;
	}
	
	public boolean existe(T clave) {
		return encontrar(paqueteRaiz, clave);
	}

	public int getNumeroNodos() {
		return getNumeroDescendientes(paqueteRaiz) + 1;
	}

	private int getNumeroDescendientes(NodoWBS<T> nodo) {
		int n = nodo.getHijos().size();
		for (NodoWBS<T> hijo: nodo.getHijos())
			n += getNumeroDescendientes(hijo);
		
		return n;
	}
	
	private boolean encontrar(NodoWBS<T> nodo, T nodoClave) {
		boolean res = false;
		if (nodo.getDato().equals(nodoClave))
			return true;
		else {
			for (NodoWBS<T> hijo: nodo.getHijos())
				if (encontrar(hijo, nodoClave))
					res = true;
		}
		
		return res;
	}
	
	 private NodoWBS<T> encontrarNodo(NodoWBS<T> nodo, T nodoClave){
		 if(nodo == null)
			 return null;
		 
		 if(nodo.getDato().equals(nodoClave))
			 return nodo;
		 else
		 {
			 NodoWBS<T> cnodo = null;
			 for (NodoWBS<T> hijo: nodo.getHijos())
				 if((cnodo = encontrarNodo(hijo, nodoClave)) != null)
					 return cnodo;
		 }
		 return null;
	 }
	
	
}

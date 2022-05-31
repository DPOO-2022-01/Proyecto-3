package Logic;

import java.util.ArrayList;


public class Proyecto {

    //Atributos
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinalizacion;
    private Participante propietario;
    private ArrayList<Participante> participantes;
    private ArrayList<TipoActividad> tipoActividades;
    private ArrayList<Actividad> actividades;
    private PaqueteDeTrabajo paquete;
    private ArrayList<TipoTarea> tipoTareas;

    //Constructor
    public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion, Participante propietario, PaqueteDeTrabajo paquete) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.propietario = propietario;
        this.participantes = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.paquete = paquete;
    }

    public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion,  PaqueteDeTrabajo paquete) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.participantes = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.paquete = paquete;
    }

    public Proyecto(){
        super();
        this.nombre = "";
        this.descripcion = "";
        this.fechaInicio = "";
        this.fechaFinalizacion = "";
        this.participantes = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    //Metodos
    //Este metodo agrega a la lista de participantes, un participante
    public void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    //Este metodo agrega a la lista de actividades, una actividad
    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }


    //Getters and Setters

    public Participante getPropietario() {
        return propietario;
    }

    public void setPropietario(Participante propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<TipoActividad> getTipoActividades() {
        return tipoActividades;
    }

    public void setTipoActividades(ArrayList<TipoActividad> tipoActividades) {
        this.tipoActividades = tipoActividades;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    

	public ArrayList<TipoTarea> getTipoTareas() {
		return tipoTareas;
	}

	public void setTipoTareas(ArrayList<TipoTarea> tipoTareas) {
		this.tipoTareas = tipoTareas;
	}

	public PaqueteDeTrabajo getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteDeTrabajo paquete) {
		this.paquete = paquete;
	}


    
}


package UI;

import Controller.Controlador;
import Logic.PaqueteDeTrabajo;
import Logic.Participante;
import Logic.TipoTarea;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

	private Controlador controller;
	private BorderLayout borderLayout;

	private PanelDescripcion panelDescripcion;
	private PCalendarioActividad panelCalendario;
	private PanelListaParticipantes panelListaParticipantes;
	private PanelCrearParticipante panelCrearParticipante;
	private PanelIzquierdo panelIzquierdo;
	private PanelSuperior panelSuperior;
	private PCuenta panelCuenta;

	public VentanaPrincipal() {
		super("Project Manager");
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		borderLayout = new BorderLayout();
		setLayout(borderLayout);

		// Inicia el mediador a funcionar
		controller = new Controlador();
		iniciarPanelCuenta();
	}
	
	public VentanaPrincipal(Controlador c) {
		super("Project Manager");
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		borderLayout = new BorderLayout();
		setLayout(borderLayout);

		// Inicia el mediador a funcionar
		controller = c;
		begin();
		
	}

	public void begin() {
		panelCalendario = new PCalendarioActividad();
		panelSuperior = new PanelSuperior(this);
		panelIzquierdo = new PanelIzquierdo(this);

		add(panelIzquierdo, BorderLayout.WEST);
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCalendario, BorderLayout.CENTER);
		setVisible(true);
		if (panelCuenta!=null) {
			panelCuenta.setVisible(false);
		}

	}

	public void iniciarPanelCuenta() {
		panelCuenta = new PCuenta(this);
		add(panelCuenta, BorderLayout.CENTER);
		setVisible(true);
	}

	public PanelDescripcion getPanelDescripcion() {
		return panelDescripcion;
	}

	public PanelListaParticipantes getPanelListaParticipantes() {
		return panelListaParticipantes;
	}

	public PanelCrearParticipante getPanelCrearParticipante() {
		return panelCrearParticipante;
	}

	public Controlador getControlador() {
		return controller;
	}

	public BorderLayout getBorderLayout() {
		return borderLayout;
	}

	public String getNombreParticipante() {
		return panelCuenta.getNombreParticipante();
	}
	public PCuenta getPanelCuenta() {
		return panelCuenta;
	}

	public String getEmailParticipante() {
		return panelCuenta.getCorreoParticipante();
	}

	public void Salida() {
		panelCalendario.setVisible(false);
		panelSuperior.setVisible(false);
		panelIzquierdo.setVisible(false);
		iniciarPanelCuenta();
	}

	public static void main(String[] args) {
    	new VentanaPrincipal();
		
		
    	/*Participante propietario =new Participante( "Natalia","n.mendivelsog@uniandes.edu.co");
    	PaqueteDeTrabajo paquetePrincipal=new PaqueteDeTrabajo("Paquete raiz", "descripcion");
    	
    	
    	 Controlador controlador1= new Controlador();
    	 controlador1.crearProyecto("DPOO", "se pretende elaborar el proyecto final del semestre" , "12/05/2022", "2/06/2022", propietario, paquetePrincipal);
    	 controlador1.crearPaquete("1.1", "descripcion", paquetePrincipal);
    	 controlador1.crearPaquete("1.2", "descripcion", paquetePrincipal);
    	 controlador1.crearParticipante("Jesed","j.dominguezp@uniandes.edu.co");
    	 controlador1.crearParticipante("Paula","p.dazad@uniandes.edu.co");
    	 controlador1.crearEquipo("Grupo 1");
    	 controlador1.agregarIntegranteEquipo("Grupo 1", 0);
    	 controlador1.agregarIntegranteEquipo("Grupo 1", 0);
    	 controlador1.agregarIntegranteEquipo("Grupo 1", 0);
    	 TipoTarea tipotarea= new TipoTarea();
     	 tipotarea.setNombreTipoTarea("diseñar");
     	 tipotarea.setProyecto(controlador1.getProyecto());
    	 controlador1.crearTarea("Documeto de diseño", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.crearTarea("Documeto de analisis", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.crearTarea("Documeto de algoritmos", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.crearTarea("logica", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.crearTarea("interfaz", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.crearTarea("documento final", "descripcion", tipotarea, paquetePrincipal, controlador1.getProyecto().getEquipos().get(0));
    	 controlador1.getProyecto().getPaquete().getTareas().get(0).setFinalizada(true);
    	 controlador1.getProyecto().getPaquete().getTareas().get(1).setFinalizada(true);
    	 controlador1.getProyecto().getPaquete().getTareas().get(2).setFinalizada(true);
    	 controlador1.getProyecto().getPaquete().getTareas().get(3).setFinalizada(true);
    	 
    	 new VentanaPrincipal(controlador1);*/
	}

}
package UI;

import Controller.Controlador;

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

    public VentanaPrincipal(){
        super("Project Manager");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        borderLayout = new BorderLayout();
        setLayout(borderLayout);

        //Inicia el mediador a funcionar
        controller = new Controlador();
        iniciarPanelCuenta();

    }

    public void begin() {
    	panelCalendario = new PCalendarioActividad();
        panelSuperior = new PanelSuperior(this);
        panelIzquierdo = new PanelIzquierdo(this);
        
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCalendario, BorderLayout.CENTER);
        setVisible(true);
        panelCuenta.setVisible(false);
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
    
    public String getEmailParticipante () {
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
	}
}
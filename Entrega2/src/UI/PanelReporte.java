package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelReporte extends JPanel {

    private VentanaPrincipal padre;
    private JLabel labelNombre;
    private JTextArea textArea;
    private JScrollBar scrollBar;
  

    private Font principalFont;
    private Font secondaryFont;

    public PanelReporte(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(91, 190, 247));
        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);

        labelNombre = new JLabel("Reporte del proyecto:");
        labelNombre.setPreferredSize(new Dimension(600, 60));
        labelNombre.setBackground(Color.WHITE);
        labelNombre.setOpaque(true);
        labelNombre.setFont(principalFont);
        labelNombre.setForeground(new Color(91, 190, 247));
        
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(350, 400));
        //textArea.setFont(secondaryFont);
        llenarReporte();

        

        add(labelNombre);
        add(textArea);
        
        
    }
    
    public void llenarReporte() {
    	String datos ="";
    	datos+="Nombre del Proyecto: "+padre.getControlador().obtenerNombre()+"\n";
    	datos+="Descripcion del Proyecto: "+padre.getControlador().obtenerDescripcion()+"\n";
    	datos+="Propietario del Proyecto: "+padre.getControlador().obtenerPropietario()+"\n";
    	datos+="Paquetes del Proyecto: "+padre.getControlador().ObtenerPaquetes()+"\n";
    	datos+="Tareas del Proyecto: "+padre.getControlador().ObtenerTareas()+"\n";
    	datos+="cantidad de equipos del Proyecto: "+padre.getControlador().cantidadEquipos()+"\n";
    	datos+="Cantidad de participantes del Proyecto: "+padre.getControlador().cantidadPartipantes()+"\n";
    	textArea.setText(datos);
    }

    
    
   

    

    
}


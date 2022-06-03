package UI;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

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
        textArea.setPreferredSize(new Dimension(600, 150));
        //textArea.setFont(secondaryFont);
        llenarReporte();

        
        PieChart graficaTareas=new PieChartBuilder().title ("Tareas").width(450).height(350).build();
        graficaTareas.addSeries("Pendientes", padre.getControlador().ObtenerTareasPendientes());
        graficaTareas.addSeries("Terminadas", padre.getControlador().ObtenerTareasFinalizadas());
        JPanel chartPanel = new XChartPanel<PieChart>(graficaTareas);
        add(labelNombre);
        add(textArea);
        add(chartPanel);
        //padre.add(chartPanel,BorderLayout.SOUTH);
        
    }
    
    public void llenarReporte() {
    	String datos ="";
    	datos+="Nombre del Proyecto: "+padre.getControlador().obtenerNombre()+"\n";
    	datos+="Descripcion del Proyecto: "+padre.getControlador().obtenerDescripcion()+"\n";
    	datos+="Propietario del Proyecto: "+padre.getControlador().obtenerPropietario()+"\n";
    	datos+="Paquetes del Proyecto: "+padre.getControlador().ObtenerPaquetes()+"\n";
    	datos+="Tareas del Proyecto: "+padre.getControlador().ObtenerTareas()+"\n";
    	datos+="Tareas Pendientes del Proyecto: "+padre.getControlador().ObtenerTareasPendientes()+"\n";
    	datos+="Tareas finalizadas del Proyecto: "+padre.getControlador().ObtenerTareasFinalizadas()+"\n";
    	datos+="cantidad de equipos del Proyecto: "+padre.getControlador().cantidadEquipos()+"\n";
    	datos+="Cantidad de participantes del Proyecto: "+padre.getControlador().cantidadPartipantes()+"\n";
    	textArea.setText(datos);
    }

    
    
   

    

    
}


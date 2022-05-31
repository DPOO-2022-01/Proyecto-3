package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Controlador;
import Logic.PaqueteDeTrabajo;
import Logic.Proyecto;
import Logic.Tarea;
import Logic.TipoActividad;
import Logic.TipoTarea;

public class PTarea extends JPanel implements ActionListener, Observer{

	private JPanel panelPrincipal, panelCrear;
	private JLabel nombrePrincipal;
	private VentanaPrincipal padre;
	private JButton btnCrear;
	private ButtonGroup grupoTiposTarea, grupoPaquete;

    public PTarea(VentanaPrincipal padre) {
        this.padre = padre;
        nombrePrincipal = new JLabel("Tareas del Proyecto");
		panelPrincipal = new JPanel();
        beginComponents();
    }

	private void beginComponents() {
		panelPrincipal.setSize(this.getWidth(), this.getHeight());
		this.setBackground(new Color(91, 190, 247));
		JPanel panelBotones = new JPanel();
		JPanel panelSuperior = new JPanel();
		JLabel nombreTitulo = new JLabel();
		JPanel panelContenido = new JPanel();
		
		panelBotones.setLayout(new BorderLayout());
		btnCrear = new JButton("Crear tarea");
		btnCrear.setSize(50, 30);
		
		btnCrear.addActionListener(this);
		
		panelSuperior.setLayout(new BorderLayout());
		nombreTitulo.setText("Tareas del Proyecto");
		nombreTitulo.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		nombreTitulo.setPreferredSize(new Dimension(600, 60));
		nombreTitulo.setBackground(Color.WHITE);
		nombreTitulo.setOpaque(true);
		nombreTitulo.setForeground(new Color(91, 190, 247));
		panelSuperior.add(nombreTitulo, BorderLayout.NORTH);
		
		panelPrincipal.setLayout(new BorderLayout());
		
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(btnCrear, BorderLayout.SOUTH);
		this.add(panelPrincipal, BorderLayout.CENTER);
		
	}

	private void mostrarPanelCrear() {
		panelCrear = new JPanel();
		panelCrear.setSize(this.getWidth(), this.getHeight());
		JPanel panelContenidoNueva = new JPanel();
		JPanel panelSuperiorNueva = new JPanel();
		JPanel panelInferior = new JPanel();
		JLabel ingresarTitulo = new JLabel();
		JLabel nombrePanel = new JLabel();
		JTextField fieldNombre = new JTextField();
		JTextField fieldDescripcion = new JTextField();
		
		JButton bntTarea = new JButton("Crear tarea");
		JButton btnVolver = new JButton("Volver");
		
		panelCrear.setLayout(new BorderLayout());
		panelInferior.setBackground(new Color(91, 190, 247));
		panelSuperiorNueva.setBackground(new Color(91, 190, 247));
		panelContenidoNueva.setLayout(new BoxLayout(panelContenidoNueva, BoxLayout.Y_AXIS));
		panelContenidoNueva.setSize(this.getWidth(), this.getHeight());
		
		nombrePanel.setText("Nueva Tarea");
		nombrePanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		nombrePanel.setPreferredSize(new Dimension(600, 60));
		nombrePanel.setBackground(Color.WHITE);
		nombrePanel.setOpaque(true);
		nombrePanel.setForeground(new Color(91, 190, 247));
		
		ingresarTitulo.setText("Ingresa el nombre de la tarea");
		panelSuperiorNueva.add(nombrePanel);
		panelContenidoNueva.add(ingresarTitulo);
		panelContenidoNueva.add(fieldNombre);
		
		JLabel ingresarDescripcion = new JLabel("Ingresa una descripción corta de la tarea");
		
		panelContenidoNueva.add(ingresarDescripcion);
		panelContenidoNueva.add(fieldDescripcion);
		
		JLabel escogerTipoTarea = new JLabel("Escoge el tipo de tarea a realizar");
		panelContenidoNueva.add(escogerTipoTarea);
		grupoTiposTarea = new ButtonGroup();
		
		Proyecto proyecto = padre.getControlador().getProyecto();
		for (TipoTarea tipoT: proyecto.getTipoTareas()) {
			JRadioButton tiposTarea = new JRadioButton(tipoT.getNombreTipoTarea());
			grupoTiposTarea.add(tiposTarea);
			panelContenidoNueva.add(tiposTarea);
		}
		
		JLabel escogerPaquete = new JLabel("Escoge el paquete de trabajo que se le asignará a la tarea");
		panelContenidoNueva.add(escogerPaquete);
		grupoPaquete = new ButtonGroup();
		
		for (PaqueteDeTrabajo tipoP: proyecto.getPaquetes()) {
			JRadioButton tiposPaquetes = new JRadioButton(tipoP.getNombre());
			grupoPaquete.add(tiposPaquetes);
			panelContenidoNueva.add(tiposPaquetes);
		}
		
		
		bntTarea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = fieldNombre.getText();
				String descripcion =  fieldDescripcion.getText();
				String tipoTFinal = null;
				String paqueteF = null;
				TipoTarea tipo = null;
				PaqueteDeTrabajo paquete = null;
				
				for (Enumeration<AbstractButton> botonesTipo = grupoTiposTarea.getElements(); botonesTipo.hasMoreElements();) {
		            AbstractButton botonTipo = botonesTipo.nextElement();

		            if (botonTipo.isSelected()) {
		                tipoTFinal = botonTipo.getText();
		            }
		        }
				
				for (TipoTarea tipoT: proyecto.getTipoTareas()) {
					if (tipoT.getNombreTipoTarea().equals(tipoTFinal)) {
						tipo = tipoT;
					}
				}
				
				for (Enumeration<AbstractButton> botonesP = grupoPaquete.getElements(); botonesP.hasMoreElements();) {
		            AbstractButton botonP = botonesP.nextElement();

		            if (botonP.isSelected()) {
		            	paqueteF = botonP.getText();
		            }
		        }
				
				for (PaqueteDeTrabajo paqueteS: proyecto.getPaquetes()) {
					if (paqueteS.getNombre().equals(paqueteF)) {
						paquete = paqueteS;
					}
				}
				
				
				Tarea tarea = padre.getControlador().crearTarea(nombre, descripcion, tipo, paquete);
				if ( tarea != null)
				{
					JOptionPane.showMessageDialog(panelCrear, "Se ha creado con éxito la tarea \n" + tarea.getNombre(), "Atencion!",
							JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelCrear.setVisible(false);
				panelInferior.setVisible(false);
			}
		});
		
		panelInferior.add(btnVolver);
		panelContenidoNueva.add(bntTarea);
		panelCrear.setBackground(Color.WHITE);
		panelCrear.add(panelContenidoNueva, BorderLayout.CENTER);
		panelCrear.add(panelSuperiorNueva, BorderLayout.NORTH);
		this.add(panelCrear,BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrear) {
			panelPrincipal.setVisible(false);
			mostrarPanelCrear();
			panelCrear.setVisible(true);
			
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

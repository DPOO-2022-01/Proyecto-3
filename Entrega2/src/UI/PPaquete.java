package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Controlador;
import Logic.PaqueteDeTrabajo;
import Logic.Proyecto;

public class PPaquete extends JPanel implements ActionListener, Observer{
	
	private JPanel panelPrincipal, panelCrear;
	private JLabel nombrePrincipal;
	private VentanaPrincipal padre;
	private JButton btnCrear;
	private ButtonGroup grupoPaquete;
	private JRadioButton tiposPaquetes;
	private JPanel panelContenidoNueva;
    public PPaquete(VentanaPrincipal padre) {
        this.padre = padre;
        nombrePrincipal = new JLabel("Paquete de Trabajo");
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
		btnCrear = new JButton("Crear paquete");
		btnCrear.setSize(50, 30);
		
		btnCrear.addActionListener(this);
		
		panelSuperior.setLayout(new BorderLayout());
		nombreTitulo.setText("Paquetes del Proyecto");
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
		panelContenidoNueva = new JPanel();
		JPanel panelSuperiorNueva = new JPanel();
		JPanel panelInferior = new JPanel();
		JLabel ingresarTitulo = new JLabel();
		JLabel nombrePanel = new JLabel();
		JTextField fieldNombre = new JTextField();
		JTextField fieldDescripcion = new JTextField();
		
		JButton bntPaquete = new JButton("Crear paquete");
		JButton btnVolver = new JButton("Volver");
		
		panelCrear.setLayout(new BorderLayout());
		panelInferior.setBackground(new Color(91, 190, 247));
		panelSuperiorNueva.setBackground(new Color(91, 190, 247));
		panelContenidoNueva.setLayout(new BoxLayout(panelContenidoNueva, BoxLayout.Y_AXIS));
		panelContenidoNueva.setSize(this.getWidth(), this.getHeight());
		
		nombrePanel.setText("Nuevo Paquete");
		nombrePanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		nombrePanel.setPreferredSize(new Dimension(600, 60));
		nombrePanel.setBackground(Color.WHITE);
		nombrePanel.setOpaque(true);
		nombrePanel.setForeground(new Color(91, 190, 247));
		
		ingresarTitulo.setText("Ingresa el nombre del paquete");
		panelSuperiorNueva.add(nombrePanel);
		panelContenidoNueva.add(ingresarTitulo);
		panelContenidoNueva.add(fieldNombre);
		
		JLabel ingresarDescripcion = new JLabel("Ingresa una descripción corta del paquete");
		
		panelContenidoNueva.add(ingresarDescripcion);
		panelContenidoNueva.add(fieldDescripcion);
		
		Proyecto proyecto = padre.getControlador().getProyecto();
		JLabel escogerPaquete = new JLabel("Escoge el paquete de trabajo que se le asignará a la tarea");
		panelContenidoNueva.add(escogerPaquete);
		grupoPaquete = new ButtonGroup();
		tiposPaquetes = null;
		for (PaqueteDeTrabajo tipoP: proyecto.getPaquetes()) {
			tiposPaquetes = new JRadioButton(tipoP.getNombre());
			grupoPaquete.add(tiposPaquetes);
			panelContenidoNueva.add(tiposPaquetes);
			buscarHijo(tipoP);
		}
		
		
		bntPaquete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = fieldNombre.getText();
				String descripcion =  fieldDescripcion.getText();
				String paqueteF = null;
				PaqueteDeTrabajo paquete = null;
				for (Enumeration<AbstractButton> botonesP = grupoPaquete.getElements(); botonesP.hasMoreElements();) {
		            AbstractButton botonP = botonesP.nextElement();

		            if (botonP.isSelected()) {
		            	paqueteF = botonP.getText();
		            }
		        }
				
				for (PaqueteDeTrabajo paqueteS: proyecto.getPaquetes()) {
					if (paquete == null) {
						if (paqueteS.getNombre().equals(paqueteF))
						{
							paquete = paqueteS;
						}
						else if (paqueteS.getPaquetes().size()>0)	
						{
							paquete = buscarHijoRadioButton(paqueteS, paqueteF, paquete);	
						}
					}
				}
				
				if (paquete == null) {
					JOptionPane.showMessageDialog(panelCrear, "Debes seleccionar un paquete padre", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
				padre.getControlador().crearPaquete(nombre, descripcion, paquete);
				JOptionPane.showMessageDialog(panelCrear, "Se ha creado con éxito el paquete \n" + fieldNombre.getText(), "Atencion!",
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
		panelContenidoNueva.add(bntPaquete);
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
	
	public void buscarHijo(PaqueteDeTrabajo tipoP) {
		if(tipoP.getPaquetes().size()>0){
			for (PaqueteDeTrabajo hijo: tipoP.getPaquetes()) {
				tiposPaquetes = new JRadioButton(hijo.getNombre());
				grupoPaquete.add(tiposPaquetes);
				panelContenidoNueva.add(tiposPaquetes);
				buscarHijo(hijo);
			}
		}
	}
	
	public PaqueteDeTrabajo buscarHijoRadioButton(PaqueteDeTrabajo tipoP, String paqueteS, PaqueteDeTrabajo paquete) {
		if (tipoP.getPaquetes().size()>0) {
			for (PaqueteDeTrabajo hijo: tipoP.getPaquetes()) {
				if (hijo.getNombre().equals(paqueteS)) {
					paquete = hijo;
					break;
				}
				if(paquete == null) {
					buscarHijoRadioButton(hijo, paqueteS, paquete);
				}
			}
		}
		return paquete;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

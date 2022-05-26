package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PCuenta extends JPanel{
	
	private VentanaPrincipal padre;
	private JPanel panelPrincipal;
	private JLabel nombrePrincipal;
	private JTextField fieldNombre;
	private JTextField fieldCorreo;
	private JTextField fieldProyecto;
	private PCrearProyecto pCrearProyecto;
	
	
	public PCuenta(VentanaPrincipal padre) {
		setLayout(new BorderLayout());
		nombrePrincipal = new JLabel("Titulo");
		panelPrincipal = new JPanel();
		this.padre = padre;
		iniciarPanelCuenta();
	}

	public void iniciarPanelCuenta() {
		panelPrincipal.setSize(this.getWidth(), this.getHeight());
		Color color = new Color(88, 144, 234);
		JPanel panelSuperior = new JPanel();
		JPanel panelOpcion = new JPanel();
		JPanel panelSi = new JPanel();
		JPanel panelContenido = new JPanel();
		JLabel ingresarNombre = new JLabel("Ingresa tu nombre completo: ");
		fieldNombre = new JTextField();
		JLabel ingresarCorreo = new JLabel("Ingresa tu correo: ");
		fieldCorreo = new JTextField();
		JLabel ingresarProyecto = new JLabel("¿Tienes ya un proyecto?");
		JButton btnSiProyecto = new JButton("Sí");
		JButton btnNoProyecto = new JButton("No");
		JButton btnEntrar = new JButton("Entrar");
		JLabel SiProyecto = new JLabel("Ingresa el nombre de tu proyecto:");
		fieldProyecto = new JTextField();
		
		panelSuperior.setLayout(new BorderLayout());
		panelSi.setLayout(new BoxLayout(panelSi, BoxLayout.Y_AXIS));
		nombrePrincipal.setText("Ingresa a ProyectManajer");
		nombrePrincipal.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		panelSuperior.add(nombrePrincipal);
		panelSi.add(SiProyecto);
		panelSi.add(fieldProyecto);
		panelSi.add(btnEntrar);
		panelSi.setVisible(false);
		panelOpcion.setLayout(new BorderLayout());
		panelOpcion.add(btnSiProyecto, BorderLayout.WEST);
		panelOpcion.add(btnNoProyecto, BorderLayout.EAST);
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		
		panelContenido.add(panelSuperior);
		panelContenido.add(ingresarNombre);
		panelContenido.add(fieldNombre);
		panelContenido.add(ingresarCorreo);
		panelContenido.add(fieldCorreo);
		panelContenido.add(ingresarProyecto);
		panelContenido.add(panelOpcion);
		panelContenido.add(panelSi);
		
		ActionListener botonSi = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				panelSi.setVisible(true);
			}
		};
		
		ActionListener botonNo = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				panelPrincipal.setVisible(false);
				iniciarPanelCrearProyecto();
				
			}
		};
		
		ActionListener botonEntrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				panelPrincipal.setVisible(false);
				padre.begin();
			
			}
		};
		
		btnSiProyecto.addActionListener(botonSi);
		btnEntrar.addActionListener(botonEntrar);
		btnNoProyecto.addActionListener(botonNo);
		
		
		panelPrincipal.add(panelContenido, BorderLayout.NORTH);
		this.add(panelPrincipal, BorderLayout.CENTER);
		
	}
	
	public void iniciarPanelCrearProyecto() {
		pCrearProyecto = new PCrearProyecto(padre);
		add(pCrearProyecto, BorderLayout.CENTER);
	}
	
	
	public String getNombreParticipante() {
		return fieldNombre.getText();
		
	}
	
	public String getCorreoParticipante() {
		return fieldCorreo.getText();
		
	}
	
	public String getProyectoParticipante() {
		return fieldCorreo.getText();
		
	}

}

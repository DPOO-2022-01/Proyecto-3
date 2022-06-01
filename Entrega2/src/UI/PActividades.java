package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
 
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Controller.Controlador;
import Logic.Actividad;
import Logic.Participante;
import Logic.Proyecto;
import Logic.Tarea;
import Logic.TipoActividad;

public class PActividades extends JPanel implements ActionListener, Observer{
	private JPanel panelEditar, panelNueva, panelPrincipal, panelCronometro;
	private JLabel nombreTitulo;
	private JButton btnNueva, btnEditar;
	private VentanaPrincipal framePrincipal;
	private String tiempo;
	private JTextField fieldTitulo, fieldDescripcion, fieldFecha, fieldHora;
	private ButtonGroup grupoTiposActividad, grupoBtnsTarea;
	
	JLabel temporalTiempo = new JLabel();
	
	public PActividades(VentanaPrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
		fieldTitulo = new JTextField();
		fieldDescripcion = new JTextField();
		fieldFecha = new JTextField();
		fieldFecha = new JTextField();
		fieldHora = new JTextField();
		grupoTiposActividad = new ButtonGroup();
		
		setLayout(new BorderLayout());
		nombreTitulo = new JLabel("No");
		panelNueva = new JPanel();
		panelEditar = new JPanel();
		panelPrincipal = new JPanel();
		panelCronometro = new JPanel();
		iniciarPanelPrincipal();
	}
	
	public void iniciarPanelPrincipal() {
		panelPrincipal.setSize(this.getWidth(), this.getHeight());
		this.setBackground(new Color(91, 190, 247));
		JPanel panelBotones = new JPanel();
		JPanel panelSuperior = new JPanel();
		JPanel panelContenido = new JPanel();
		String[] proyectos = {"Ninguno"};
		JList<String> listaProyectos = new JList<>(proyectos);
		
		panelBotones.setLayout(new BorderLayout());
		btnNueva = new JButton("Nueva Actividad");
		btnEditar = new JButton("Editar Actividad");
		
		btnNueva.addActionListener(this);
		btnEditar.addActionListener(this);
		
		panelBotones.add(btnNueva, BorderLayout.NORTH);
		panelBotones.add(btnEditar, BorderLayout.SOUTH);
		
		panelSuperior.setLayout(new FlowLayout());
		nombreTitulo.setText("Actividades del Proyecto");
		nombreTitulo.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		panelSuperior.add(nombreTitulo);
		panelSuperior.add(panelBotones);
		
		panelContenido.setLayout(new BorderLayout());
		panelContenido.add(panelSuperior, BorderLayout.NORTH);
		panelContenido.add(listaProyectos, BorderLayout.CENTER);
		
		panelPrincipal.add(panelContenido);
		this.add(panelPrincipal, BorderLayout.CENTER);
		
	}
	
	public void mostrarPanelNueva() {
		panelNueva = new JPanel();
		JPanel panelContenidoNueva = new JPanel();
		JLabel ingresarTitulo = new JLabel();
		JLabel nombrePanel = new JLabel();
		
		JButton bntiniciarActividad = new JButton("Iniciar Actividad");
		JButton btnVolver = new JButton("Volver");
		
		panelNueva.setLayout(new BorderLayout());
		panelContenidoNueva.setLayout(new BoxLayout(panelContenidoNueva, BoxLayout.Y_AXIS));
		
		nombrePanel.setText("Nueva Actividad");
		nombrePanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		ingresarTitulo.setText("Ingresa el título de la actividad a realizar");
		panelContenidoNueva.add(nombrePanel);
		panelContenidoNueva.add(ingresarTitulo);
		panelContenidoNueva.add(fieldTitulo);
		
		JLabel ingresarDescripcion = new JLabel("Ingresa una descripción corta de la actividad");
		
		panelContenidoNueva.add(ingresarDescripcion);
		panelContenidoNueva.add(fieldDescripcion);
		
		JLabel fechaActividad = new JLabel("Ingrese la fecha en la que se realiza la actividad (formato: DD/MM/AA): ");
		
		panelContenidoNueva.add(fechaActividad);
		panelContenidoNueva.add(fieldFecha);
		
		JLabel ingresarHora = new JLabel("Ingrese la hora de comienzo: ");
		panelContenidoNueva.add(ingresarHora);
		panelContenidoNueva.add(fieldHora);
		
		JLabel escogerTipoAct = new JLabel("Escoge el tipo de actividad a realizar");
		grupoTiposActividad = new ButtonGroup();
		
		JLabel asociarTarea = new JLabel("Escoge la tarea que deseas asociar");
		grupoBtnsTarea = new ButtonGroup();
		
		panelContenidoNueva.add(escogerTipoAct);
		
		panelNueva.setBackground(Color.LIGHT_GRAY);
		bntiniciarActividad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Para hacer un botón de volver es sólo cambiar el visible de los paneles
				MostrarpanelCronometro();
				panelNueva.setVisible(false);
				panelCronometro.setVisible(true);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelNueva.setVisible(false);
			}
		});
		
		Proyecto proyecto = framePrincipal.getControlador().getProyecto();
		for (TipoActividad tipoAct: proyecto.getTipoActividades()) {
			JRadioButton tiposActividad = new JRadioButton(tipoAct.getNombreTipoActividad());
			grupoTiposActividad.add(tiposActividad);
			panelContenidoNueva.add(tiposActividad);
		}
		
		panelContenidoNueva.add(asociarTarea);
		
		for (Tarea TareAct: proyecto.getPaquete().getTareas()) {
			JRadioButton Tareas = new JRadioButton(TareAct.getNombre());
			grupoBtnsTarea.add(Tareas);
			panelContenidoNueva.add(Tareas);
		}
		
		panelContenidoNueva.add(bntiniciarActividad);
		panelNueva.setBackground(Color.LIGHT_GRAY);
		panelNueva.add(panelContenidoNueva, BorderLayout.CENTER);
		panelNueva.add(btnVolver, BorderLayout.SOUTH);
		this.add(panelNueva,BorderLayout.CENTER);
	}
	
	public void mostrarPanelEditar() {
		panelEditar = new JPanel();
		JLabel nombrePanel = new JLabel();
		nombrePanel.setText("Modificar Actividad");
		nombrePanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		
		JButton btnVolver = new JButton("Volver");
		JButton btnGuardarActividad = new JButton("Guardar Actividad");
		JPanel panelContenidoEditar = new JPanel();
		JLabel tituloModificar = new JLabel("Ingresa el título de la actividad a modificar");
		JTextField fieldTituloModificar = new JTextField();
		JLabel fechaActividad = new JLabel("Ingresa la nueva fecha en la que se realizó la actividad (formato: DD/MM/AA)");
		JTextField fieldFechaNueva = new JTextField();
		JLabel horaInicioFinAct = new JLabel("Indica la hora en la que se realizó la actividad (formato: HH:MM - HH:MM)");
		JTextField fieldHoraNueva = new JTextField();
		
		//Con la lógica para guardar actividad implementarlo en el btn
		btnGuardarActividad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Proyecto proyecto = framePrincipal.getControlador().getProyecto();
				for(Actividad actividad: proyecto.getActividades()) {
					if (actividad.getTitulo().equals(fieldTituloModificar.getText())) {
						actividad.setFecharealizacion(fieldFechaNueva.getText());
						String[] horaCompleta = fieldHoraNueva.getText().split("-");
						actividad.setHorainicio(horaCompleta[0]);
						actividad.setHorafin(horaCompleta[1]);
					}
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelEditar.setVisible(false);
			}
		});
		
		panelContenidoEditar.setLayout(new BoxLayout(panelContenidoEditar, BoxLayout.Y_AXIS));
		panelContenidoEditar.add(nombrePanel);
		panelContenidoEditar.add(tituloModificar);
		panelContenidoEditar.add(fieldTituloModificar);
		panelContenidoEditar.add(fechaActividad);
		panelContenidoEditar.add(fieldFechaNueva);
		panelContenidoEditar.add(horaInicioFinAct);
		panelContenidoEditar.add(fieldHoraNueva);
		
		panelEditar.add(panelContenidoEditar, BorderLayout.CENTER);
		panelEditar.add(btnVolver, BorderLayout.SOUTH);
		panelEditar.add(btnGuardarActividad, BorderLayout.SOUTH);
		this.add(panelEditar, BorderLayout.CENTER);
		
	}
	
	public void MostrarpanelCronometro() {
		
		panelCronometro = new JPanel();
		panelCronometro.setLayout(new BorderLayout());
		JLabel nombrePanel = new JLabel();
		nombrePanel.setText("Crónometro de Actividad");
		nombrePanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));	
		JLabel tiempoTrans = new JLabel("Tiempo transcurrido");
		tiempoTrans.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		temporalTiempo.setText(tiempo);
		temporalTiempo.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 30));
		
		JButton btnPausar = new JButton("Pausar");
		JButton btnReanudar = new JButton("Reanudar");
		JButton btnTerminarActivdad = new JButton("Terminar Actividad");
		
		JPanel contenidoCronometro = new JPanel();
		contenidoCronometro.setLayout(new BoxLayout(contenidoCronometro, BoxLayout.Y_AXIS));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		
		framePrincipal.getControlador().startCronometro();
		
		btnTerminarActivdad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCronometro.setVisible(false);
				panelPrincipal.setVisible(true);
				framePrincipal.getControlador().stopCronometro();
				int tiempoActividad = framePrincipal.getControlador().getTiempo();
				
				JFrame VentanaHoraFin = new JFrame();
				VentanaHoraFin.setSize(200, 200);
				VentanaHoraFin.setLayout(new BorderLayout());
				JLabel horaFin = new JLabel("Ingrese la hora de finalización:");
				JTextField fieldHoraFin = new JTextField();
				JButton cerrarVentana = new JButton("Guardar");
				VentanaHoraFin.add(horaFin, BorderLayout.NORTH);
				VentanaHoraFin.add(fieldHoraFin, BorderLayout.CENTER);
				VentanaHoraFin.setVisible(true);
				cerrarVentana.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaHoraFin.setVisible(false);
					}
				});
				
				TipoActividad tipoActFinal = null;
				String tareaAsociada = "";
				
				for(TipoActividad tipoact: framePrincipal.getControlador().getProyecto().getTipoActividades()) {
					if(tipoact.getNombreTipoActividad() == grupoTiposActividad.getSelection().getActionCommand()) {
						tipoActFinal = tipoact;
					}
				}
				for(Tarea tareaAct: framePrincipal.getControlador().getProyecto().getPaquete().getTareas()) {
					if(tareaAct.getNombre() == grupoBtnsTarea.getSelection().getActionCommand()) {
						tareaAsociada = tareaAct.getNombre();
					}
				}
				Participante participante = null;
				for(Participante participanteActual : framePrincipal.getControlador().getParticipantes()) {
					if(participanteActual.getNombre() == framePrincipal.getName()){
						participante = participanteActual;
					}
				}
				framePrincipal.getControlador().crearActividad(fieldDescripcion.getText(),
						fieldDescripcion.getText(),
						tipoActFinal,
						fieldFecha.getText(),
						fieldHora.getText(),
						fieldHoraFin.getText(),
						participante,
						framePrincipal.getControlador().getProyecto(),
						tareaAsociada,
						tiempoActividad);
			}
		});
		
		btnPausar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.getControlador().stopCronometro();
			}
		});
		
		btnReanudar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.getControlador().startCronometro();
			}
		});
		
		panelBotones.add(btnPausar);
		panelBotones.add(btnReanudar);
		
		contenidoCronometro.add(tiempoTrans);
		contenidoCronometro.add(temporalTiempo);
		contenidoCronometro.add(panelBotones);
		
		panelCronometro.add(nombrePanel, BorderLayout.NORTH);
		panelCronometro.add(contenidoCronometro, BorderLayout.CENTER);
		panelCronometro.add(btnTerminarActivdad, BorderLayout.SOUTH);
		this.add(panelCronometro, BorderLayout.CENTER);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNueva) {
			panelPrincipal.setVisible(false);
			mostrarPanelNueva();
			panelNueva.setVisible(true);
			
		}
		if (e.getSource() == btnEditar) {
			panelPrincipal.setVisible(false);
			mostrarPanelEditar();
			panelEditar.setVisible(true);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	
}

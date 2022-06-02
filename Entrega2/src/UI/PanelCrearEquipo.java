package UI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearEquipo extends JPanel {

	private VentanaPrincipal padre;
	private JLabel labelNombre;
	private JLabel label;
	private JLabel label1;
	private JTextField text;
	private JComboBox<String> participantes;
	private JButton agregarEquipo;
	private JButton actualizarEquipo;

	private Font principalFont;
	private Font secondaryFont;

	public PanelCrearEquipo(VentanaPrincipal padre) {
		this.padre = padre;
		beginComponents();
		setVisible(true);
	}

	public void beginComponents() {
		this.setBackground(new Color(100, 140, 241));

		principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);
		secondaryFont = new Font("Bahnschrift Light", Font.PLAIN, 14);

		agregarEquipo = new JButton("Agregar");
		agregarEquipo.setPreferredSize(new Dimension(200, 30));

		actualizarEquipo = new JButton("Actualizar");
		actualizarEquipo.setPreferredSize(new Dimension(200, 30));
		addFncButton();

		labelNombre = new JLabel("Crear un equipo: ");
		labelNombre.setPreferredSize(new Dimension(450, 60));
		labelNombre.setBackground(Color.WHITE);
		labelNombre.setOpaque(true);
		labelNombre.setFont(principalFont);
		labelNombre.setForeground(new Color(91, 190, 247));

		label = new JLabel("Ingresa el nombre completo del equipo:");
		label.setPreferredSize(new Dimension(400, 30));
		label.setBackground(new Color(93, 131, 227));
		label.setOpaque(true);
		label.setForeground(Color.white);
		label.setFont(secondaryFont);

		label1 = new JLabel("seleccione los participantes:");
		label1.setPreferredSize(new Dimension(400, 30));
		label1.setBackground(new Color(93, 131, 227));
		label1.setOpaque(true);
		label1.setFont(secondaryFont);
		label1.setForeground(Color.white);

		text = new JTextField();
		text.setPreferredSize(new Dimension(400, 30));
		text.setBackground(Color.WHITE);
		text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		text.setOpaque(true);

		participantes = new JComboBox<String>();
		participantes.setPreferredSize(new Dimension(400, 30));
		participantes.setBackground(Color.WHITE);
		participantes.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		participantes.setOpaque(true);
		agregarParticipantes();

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setPreferredSize(new Dimension(650, 70));
		horizontalBox.setBackground(Color.white);
		horizontalBox.setOpaque(true);
		horizontalBox.add(Box.createRigidArea(new Dimension(20, 0)));
		horizontalBox.add(labelNombre);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setPreferredSize(new Dimension(650, 300));
		verticalBox.setBackground(Color.white);
		verticalBox.setOpaque(true);

		add(horizontalBox);
		add(label);
		add(Box.createRigidArea(new Dimension(400, 0)));
		add(text);
		add(Box.createRigidArea(new Dimension(400, 0)));
		add(label1);
		add(Box.createRigidArea(new Dimension(400, 0)));
		add(participantes);
		add(Box.createRigidArea(new Dimension(600, 15)));
		add(actualizarEquipo);
		add(Box.createRigidArea(new Dimension(600, 15)));
		add(agregarEquipo);

	}

	public void addFncButton() {
		agregarEquipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//padre.getControlador().crearEquipo(text.getText());
				JOptionPane.showMessageDialog(null, "Se ha agregado un equipo");
				padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
				padre.add(BorderLayout.CENTER, new PanelListaEquipos(padre));
				padre.revalidate();
				padre.repaint();
			}
		});

		actualizarEquipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.getControlador().agregarIntegranteEquipo( text.getText(),participantes.getSelectedIndex());
				JOptionPane.showMessageDialog(null, "Se ha agregado un  integrante al equipo");
				/*padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
				padre.add(BorderLayout.CENTER, new PanelListaEquipos(padre));
				padre.revalidate();
				padre.repaint();*/
			}
		});
	}
	private void agregarParticipantes() {
		for (int i = 0; i < padre.getControlador().getProyecto().getParticipantesDisponibles().size(); i++) {
			participantes.addItem(padre.getControlador().getProyecto().getParticipantesDisponibles().get(i).getNombre());
			
		}
	}

}
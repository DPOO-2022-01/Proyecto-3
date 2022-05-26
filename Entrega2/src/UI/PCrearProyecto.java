package UI;

import javax.swing.*;

import Logic.Participante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCrearProyecto extends JPanel {

    private VentanaPrincipal padre;
    private JLabel labelNombre;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField nombreProyecto;
    private JTextField descripcionProyecto;
    private JTextField fechaProyecto;
    private JTextField tiposActividad;
    private JButton btnCrearProyecto;
    private JScrollPane scrollBar;

    private Font principalFont;
    private Font secondaryFont;

    public PCrearProyecto(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(100, 140, 241));

        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);
        secondaryFont = new Font("Bahnschrift Light", Font.PLAIN, 14);

        btnCrearProyecto = new JButton("Crear proyecto");
        btnCrearProyecto.setPreferredSize(new Dimension(200, 30));
        addFncButton();

        //agregarDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
        //agregarDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        labelNombre = new JLabel("Crea tu proyecto! ");
        labelNombre.setPreferredSize(new Dimension(450, 60));
        labelNombre.setBackground(Color.WHITE);
        labelNombre.setOpaque(true);
        labelNombre.setFont(principalFont);
        labelNombre.setForeground(new Color(91, 190, 247));
        

        label = new JLabel("Ingresa el nombre de tu proyecto:");
        label.setPreferredSize(new Dimension(50, 80));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setFont(secondaryFont);
        
        label1 = new JLabel("Ingresa una descripción corta de tu proyecto:");
        label1.setPreferredSize(new Dimension(50, 80));
        label1.setBackground(Color.WHITE);
        label1.setOpaque(true);
        label1.setFont(secondaryFont);
        
        label2 = new JLabel("Ingresa la fecha estimada de finalización (no es obligatorio):");
        label2.setPreferredSize(new Dimension(50, 80));
        label2.setBackground(Color.WHITE);
        label2.setOpaque(true);
        label2.setFont(secondaryFont);
        
        
        label3 = new JLabel("Ingresa los tipos de actividad que tendrá tu proyecto (separados por coma): ");
        label3.setPreferredSize(new Dimension(50, 80));
        label3.setBackground(Color.WHITE);
        label3.setOpaque(true);
        label3.setFont(secondaryFont);
        
        //textfield nombreproyecto
        nombreProyecto=new JTextField();
        nombreProyecto.setPreferredSize(new Dimension(50,20));
        nombreProyecto.setBackground(Color.WHITE);
        nombreProyecto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        nombreProyecto.setOpaque(true);
        
        //textfield descripcionproyecto
        descripcionProyecto=new JTextField();
        descripcionProyecto.setPreferredSize(new Dimension(50,20));
        descripcionProyecto.setBackground(Color.WHITE);
        descripcionProyecto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        descripcionProyecto.setOpaque(true);
        
        //textfield fecha
        fechaProyecto=new JTextField();
        fechaProyecto.setPreferredSize(new Dimension(50,20));
        fechaProyecto.setBackground(Color.WHITE);
        fechaProyecto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fechaProyecto.setOpaque(true);
        
        //textfield tiposActividad
        tiposActividad=new JTextField();
        tiposActividad.setPreferredSize(new Dimension(50,20));
        tiposActividad.setBackground(Color.WHITE);
        tiposActividad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        tiposActividad.setOpaque(true);
        
        
        
        
   

        //scrollBar = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                //JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollBar.setPreferredSize(new Dimension(650, 250));

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setPreferredSize(new Dimension(650, 70));
        horizontalBox.setBackground(Color.white);
        horizontalBox.setOpaque(true);
        
        horizontalBox.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalBox.add(labelNombre);
        
        add(horizontalBox);
        

        
        
        
        Box horizontal = Box.createVerticalBox();
        horizontal.setPreferredSize(new Dimension(650, 300));
        horizontal.setBackground(Color.white);
        horizontal.setOpaque(true);
        horizontal.add(label);
        horizontal.add(nombreProyecto);
        horizontal.add(label1);
        horizontal.add(descripcionProyecto);
        horizontal.add(label2);
        horizontal.add(fechaProyecto);
        horizontal.add(label3);
        horizontal.add(tiposActividad);
        
        add(horizontal);
        add(btnCrearProyecto);
        
        
        
        
        
        
        //add(agregarDescripcion);
    }

    //public JTextField getTextNombre() {
        //return textNombre;
    //}

    public void addFncButton() {
        btnCrearProyecto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO
            	String[] tiposAct = tiposActividad.getText().split(",");
            	Participante participante = new Participante(padre.getNombreParticipante(), padre.getEmailParticipante());
            	padre.getControlador().crearProyecto(nombreProyecto.getText(), descripcionProyecto.getText(), fechaProyecto.getText(), "", participante);
            	padre.getControlador().getProyecto();
            	padre.getControlador().asignarTipoActividad(tiposAct);
				setVisible(false);
				padre.begin();
            }

        });
    }
}

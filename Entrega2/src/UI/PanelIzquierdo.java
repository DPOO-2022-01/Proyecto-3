package UI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelIzquierdo extends JPanel {

    private VentanaPrincipal padre;
    private JButton descripcion;
    private JButton participantes ;
    private JButton tiposDeActividad;
    private JButton actividad;
    private JButton paquete;
    private JButton tarea;
    private JButton salir;
    private Font principalFont;

    public PanelIzquierdo(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(255, 255, 255));
        this.setPreferredSize(new Dimension(230, 500));

        principalFont = new Font("Bahnschrift SemiBold SemiConden", Font.BOLD, 14);

        descripcion = new JButton("Descripcion");
        descripcion.setPreferredSize(new Dimension(215, 50));
        descripcion.setBackground(Color.WHITE);
        descripcion.setFont(principalFont);
        descripcion.setOpaque(true);
        descripcion.setBorderPainted(false);
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon iconoDescripcion = new ImageIcon("./img/descripcionMin.png");
        descripcion.setIcon(iconoDescripcion);

        participantes = new JButton("Participantes");
        participantes.setPreferredSize(new Dimension(215, 50));
        participantes.setBackground(Color.WHITE);
        participantes.setBorderPainted(false);
        participantes.setFont(principalFont);
        participantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon iconoParticipantes = new ImageIcon("./img/participantesMin.png");
        participantes.setIcon(iconoParticipantes);

        tiposDeActividad = new JButton("Tipos de actividad");
        tiposDeActividad.setPreferredSize(new Dimension(215, 50));
        tiposDeActividad.setBackground(Color.WHITE);
        tiposDeActividad.setBorderPainted(false);
        tiposDeActividad.setFont(principalFont);
        tiposDeActividad.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon iconoTipoActividades = new ImageIcon("./img/tipoActividadesMin.png");
        tiposDeActividad.setIcon(iconoTipoActividades);

        actividad = new JButton("Actividad");
        actividad.setPreferredSize(new Dimension(215, 50));
        actividad.setBackground(Color.WHITE);
        actividad.setBorderPainted(false);
        actividad.setFont(principalFont);
        actividad.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon iconoActividad = new ImageIcon("./img/actividadesMin.png");
        actividad.setIcon(iconoActividad);
        
        paquete = new JButton("Paquete de Trabajo ");
        paquete.setPreferredSize(new Dimension(215, 50));
        paquete.setBackground(Color.WHITE);
        paquete.setBorderPainted(false);
        paquete.setFont(principalFont);
        paquete.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        tarea = new JButton("Tarea");
        tarea.setPreferredSize(new Dimension(215, 50));
        tarea.setBackground(Color.WHITE);
        tarea.setBorderPainted(false);
        tarea.setFont(principalFont);
        tarea.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        salir = new JButton("Salir");
        salir.setPreferredSize(new Dimension(215, 50));
        salir.setBackground(Color.WHITE);
        salir.setBorderPainted(false);
        salir.setFont(principalFont);
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImageIcon iconoSalir = new ImageIcon("./img/salir.png");
        salir.setIcon(iconoSalir);


        addFncButton();


        add(Box.createRigidArea(new Dimension(200,50)));
        add(descripcion);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(participantes);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(tiposDeActividad);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(actividad);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(paquete);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(tarea);
        add(Box.createRigidArea(new Dimension(80,10)));
        add(salir);
    }

    public void addFncButton() {
        descripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PanelDescripcion(padre));
                padre.revalidate();
                padre.repaint();
            }
        });

        participantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PanelListaParticipantes(padre));
                padre.revalidate();
                padre.repaint();
          
            }
        });
        
        tiposDeActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PTipoActividad(padre));
                padre.revalidate();
                padre.repaint();
            }
        });
        
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.Salida();
            }
        });
        
        actividad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PActividades(padre));
                padre.revalidate();
                padre.repaint();
			}
        });
		
        
        paquete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PPaquete(padre));
                padre.revalidate();
                padre.repaint();
			}
   });
        tarea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PTarea(padre));
                padre.revalidate();
                padre.repaint();
			}
   });
    }
    public void reiniciarPaneles() {
    	
    }
}


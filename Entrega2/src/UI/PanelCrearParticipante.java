package UI;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class PanelCrearParticipante extends JPanel {

	    private VentanaPrincipal padre;
	    private JLabel labelNombre;
	    private JLabel label;
	    private JLabel label1;
	    private JTextField text;
	    private JTextField text1;
	    private JButton agregarParticipante;

	    private Font principalFont;
	    private Font secondaryFont;

	    public PanelCrearParticipante(VentanaPrincipal padre) {
	        this.padre = padre;
	        beginComponents();
	        setVisible(true);
	    }

	    public void beginComponents() {
	        this.setBackground(new Color(100, 140, 241));

	        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);
	        secondaryFont = new Font("Bahnschrift Light", Font.PLAIN, 14);

	        agregarParticipante = new JButton("Agregar");
	        agregarParticipante.setPreferredSize(new Dimension(200, 30));
	        addFncButton();

	        labelNombre = new JLabel("Agrega un participante: ");
	        labelNombre.setPreferredSize(new Dimension(450, 60));
	        labelNombre.setBackground(Color.WHITE);
	        labelNombre.setOpaque(true);
	        labelNombre.setFont(principalFont);
	        labelNombre.setForeground(new Color(91, 190, 247));

	        label = new JLabel("Ingresa el nombre completo del nuevo participante:");
	        label.setPreferredSize(new Dimension(400, 30));
	        label.setBackground(new Color(93, 131, 227));
	        label.setOpaque(true);
	        label.setForeground(Color.white);
	        label.setFont(secondaryFont);

	        label1 = new JLabel("Correo (personal o profesional):");
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

	        text1 = new JTextField();
	        text1.setPreferredSize(new Dimension(400, 30));
	        text1.setBackground(Color.WHITE);
	        text1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	        text1.setOpaque(true);

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
	        add(text1);
	        add(Box.createRigidArea(new Dimension(600, 15)));
	        add(agregarParticipante);
	    }

	    public void addFncButton() {
	        agregarParticipante.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                padre.getControlador().crearParticipante(
	                        text.getText(), text1.getText()
	                );
	                text.setText("");
	                text1.setText("");
	                JOptionPane.showMessageDialog(null, "Se ha agregado un nuevo participante");
	                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
	                padre.add(BorderLayout.CENTER, new PanelListaParticipantes(padre));
	                padre.revalidate();
	                padre.repaint();
	            }
	        });
	    }
	}

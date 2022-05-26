package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDescripcion extends JPanel {

    private VentanaPrincipal padre;
    private JLabel labelNombre;
    private JTextField textNombre;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton agregarDescripcion;

    private Font principalFont;
    private Font secondaryFont;

    public PanelDescripcion(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(100, 140, 241));

        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);
        secondaryFont = new Font("Arial", Font.PLAIN, 18);

        agregarDescripcion = new JButton("Agregar/Actualizar descripcion");
        //agregarDescripcion.setPreferredSize(new Dimension(220, 30));
        addFncButton();

        labelNombre = new JLabel("Descripcion de tu proyecto: ");
        labelNombre.setPreferredSize(new Dimension(450, 60));
        labelNombre.setBackground(Color.WHITE);
        labelNombre.setOpaque(true);
        labelNombre.setFont(principalFont);
        labelNombre.setForeground(new Color(91, 190, 247));

        textArea = new JTextArea(padre.getControlador().getProyecto().getDescripcion());
        textArea.setPreferredSize(new Dimension(350, 400));
        textArea.setFont(secondaryFont);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(650, 200));

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setPreferredSize(new Dimension(650, 70));
        horizontalBox.setBackground(Color.white);
        horizontalBox.setOpaque(true);

        horizontalBox.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalBox.add(labelNombre);

        add(horizontalBox);
        add(scrollPane);
        add(agregarDescripcion);
    }

    public JTextField getTextNombre() {
        return textNombre;
    }

    public void addFncButton() {
        agregarDescripcion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                padre.getControlador().getProyecto().setDescripcion(textArea.getText());

                JOptionPane.showMessageDialog(null, "Se ha guardado la descripción");
            }
        });
    }
}

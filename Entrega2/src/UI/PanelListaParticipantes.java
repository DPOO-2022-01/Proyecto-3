package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListaParticipantes extends JPanel {

    private VentanaPrincipal padre;
    private JLabel labelNombre;
    private JTextField textNombre;
    private JTextArea textArea;
    private JScrollBar scrollBar;
    private JButton btnCrear;
    private JTable table;

    private Font principalFont;
    private Font secondaryFont;

    public PanelListaParticipantes(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(91, 190, 247));
        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);

        labelNombre = new JLabel("Lista de participantes del proyecto:");
        labelNombre.setPreferredSize(new Dimension(600, 60));
        labelNombre.setBackground(Color.WHITE);
        labelNombre.setOpaque(true);
        labelNombre.setFont(principalFont);
        labelNombre.setForeground(new Color(91, 190, 247));

        btnCrear = new JButton("Crear participante");
        addFncButton();

        add(labelNombre);
        TablaModelo();
        add(btnCrear);
    }

    public void TablaModelo() {
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Rol");
        agregarFilas(model);

        JScrollPane js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(750, 400));
        this.add(js);
        //this.getContentPane().add(js);
    }

    public void agregarFilas(DefaultTableModel model) {
        for (int i = 0; i < padre.getControlador().getProyecto().getParticipantes().size(); i++) {
            String[] fila = new String[4];

            fila[0] = String.valueOf(i+1);
            fila[1] = padre.getControlador().getProyecto().getParticipantes().get(i).getNombre();
            fila[2] = padre.getControlador().getProyecto().getParticipantes().get(i).getEmail();
            fila[3] = "Participante";

            model.addRow(fila);
        }
    }

    public void addFncButton(){
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, padre.getPanelCrearParticipante());
                padre.revalidate();
                padre.repaint();
            }
        });
    }

    public JTextField getTextNombre() {
        return textNombre;
    }
}


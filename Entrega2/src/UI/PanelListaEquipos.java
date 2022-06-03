package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListaEquipos extends JPanel {

    private VentanaPrincipal padre;
    private JLabel labelNombre;
    private JTextField textNombre;
    private JTextArea textArea;
    private JScrollBar scrollBar;
    private JButton btnCrear;
    private JButton btnEditar;
    private JTable table;

    private Font principalFont;
    private Font secondaryFont;

    public PanelListaEquipos(VentanaPrincipal padre) {
        this.padre = padre;
        beginComponents();
        setVisible(true);
    }

    public void beginComponents() {
        this.setBackground(new Color(91, 190, 247));
        principalFont = new Font("Open Sans ExtraBold", Font.BOLD, 24);

        labelNombre = new JLabel("Lista de equipos del proyecto:");
        labelNombre.setPreferredSize(new Dimension(600, 60));
        labelNombre.setBackground(Color.WHITE);
        labelNombre.setOpaque(true);
        labelNombre.setFont(principalFont);
        labelNombre.setForeground(new Color(91, 190, 247));

        btnCrear = new JButton("Crear equipo");
        btnEditar = new JButton("Editar equipo");
        addFncButton();

        add(labelNombre);
        TablaModelo();
        add(btnCrear);
        add(btnEditar);
    }

    public void TablaModelo() {
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("");
        model.addColumn("Nombre");
        model.addColumn("N.integrantes");
        model.addColumn("N.pendientes");
        model.addColumn("N.asignadas");
        model.addColumn("N.terminadas");
        agregarFilas(model);

        JScrollPane js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(750, 400));
        this.add(js);
        //this.getContentPane().add(js);
    }

    public void agregarFilas(DefaultTableModel model) {
        for (int i = 0; i < padre.getControlador().getProyecto().getEquipos().size(); i++) {
            String[] fila = new String[6];

            fila[0] = String.valueOf(i+1);
            fila[1] = padre.getControlador().getProyecto().getEquipos().get(i).getNombre();
            fila[2] = String.valueOf( padre.getControlador().getProyecto().getEquipos().get(i).getIntegrantes().size());
            fila[3] = String.valueOf( padre.getControlador().getProyecto().getEquipos().get(i).getTareasPendientes().size());
            fila[4] = String.valueOf( padre.getControlador().getProyecto().getEquipos().get(i).getTareasAsignadas().size());
            fila[5] = String.valueOf( padre.getControlador().getProyecto().getEquipos().get(i).getTareasTerminadas().size());
           

            model.addRow(fila);
        }
    }

    public void addFncButton(){
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                padre.add(BorderLayout.CENTER, new PanelCrearEquipo(padre) );
                padre.revalidate();
                padre.repaint();
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.remove(padre.getBorderLayout().getLayoutComponent(BorderLayout.CENTER));
                //padre.add(BorderLayout.CENTER, new PanelEditarEquipo(padre) );
                padre.revalidate();
                padre.repaint();
            }
        });
    }

    public JTextField getTextNombre() {
        return textNombre;
    }
}


package UI;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {


    private VentanaPrincipal window;

    private JLabel logo;
    private JButton inicio;
    private JButton producto;
    private JButton nosotros;
    private JButton contacto;
    private JButton iniciarSesion;
    private JButton registrarse;
    private ImageIcon Ichange;

    public PanelSuperior(VentanaPrincipal window) {
        inicializador(window);
    }

    public void inicializador(VentanaPrincipal window) {
        this.window = window;
        setBackground(Color.white);
        setLayout(new FlowLayout());

        logo = new JLabel();
        logo.setPreferredSize(new Dimension(130, 60));
        Ichange = new ImageIcon("./img/logo_min.png");
        logo.setIcon(Ichange);

        //inicio = new JButton("INICIO");
        //inicio.setPreferredSize(new Dimension(115, 30));
        //inicio.setOpaque(false);

        //producto = new JButton("PRODUCTO");
        //producto.setPreferredSize(new Dimension(115, 30));
        //producto.setOpaque(false);

        //nosotros = new JButton("NOSOTROS");
        //nosotros.setPreferredSize(new Dimension(115, 30));
        //nosotros.setOpaque(false);

        //contacto = new JButton("CONTACTO");
        //contacto.setPreferredSize(new Dimension(115, 30));
        //contacto.setOpaque(false);

        //iniciarSesion = new JButton("INICIAR SESION");
        //iniciarSesion.setPreferredSize(new Dimension(140, 30));
        //iniciarSesion.setBorderPainted(false);
        //iniciarSesion.setBackground(Color.lightGray);
        //iniciarSesion.setForeground(Color.black);
        

        //registrarse = new JButton("REGISTRARSE");
        //registrarse.setPreferredSize(new Dimension(130, 30));
        //registrarse.setBackground(Color.LIGHT_GRAY);
        //registrarse.setForeground(Color.black);
        //registrarse.setBorderPainted(false);

        add(logo);
        add(Box.createRigidArea(new Dimension(450, 0)));
        //add(inicio);
        //add(producto);
        //add(nosotros);
        //add(contacto);
        add(Box.createRigidArea(new Dimension(300, 0)));
        //add(iniciarSesion);
        //add(registrarse);
    }

    public VentanaPrincipal getWindow() {
        return window;
    }

}

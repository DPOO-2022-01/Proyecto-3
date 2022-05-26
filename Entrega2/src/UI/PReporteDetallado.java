package UI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Controller.Controlador;
import Logic.Participante;
import Logic.Proyecto;
import Logic.TipoActividad;

public class PReporteDetallado extends JPanel {
	private JLabel tituloPanel;
	private VentanaPrincipal framePrincipal;
	
	public PReporteDetallado(VentanaPrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
		tituloPanel = new JLabel("Reporte específico de Actividades");
		tituloPanel.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 40));
		setLayout(new BorderLayout());
		add(tituloPanel, BorderLayout.NORTH);
		mostrarReporte();
	}
	
	public void mostrarReporte() {
		JLabel tituloTipoActividad = new JLabel();
		JPanel panelTipoActividad = new JPanel();
		JLabel nombreParticipante = new JLabel();
		JList<String> tiemposParticipante = new JList<>();
		Controlador controlador = framePrincipal.getControlador();
		
		Proyecto proyecto = controlador.getProyecto();
		for (Participante participante: proyecto.getParticipantes()) {
			int i = 0;
			nombreParticipante.setText(participante.getNombre());
			for (TipoActividad tipoAct: proyecto.getTipoActividades()) {

				if (tipoAct.getTiempoParticipantes().isEmpty()) {
					JLabel reporteNulo = new JLabel("No hay ninguna actividad registrada");
					reporteNulo.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 70));
					panelTipoActividad.add(reporteNulo);
					this.add(panelTipoActividad);
				}

				if (i < 1 && (!tipoAct.getTiempoParticipantes().isEmpty() == false)) {
					tituloTipoActividad.setText(tipoAct.getNombreTipoActividad());
					tituloTipoActividad.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 40));
					panelTipoActividad.add(tituloTipoActividad);
					i++;
				}			

				if(!tipoAct.getTiempoParticipantes().isEmpty() == false) {
					ArrayList<Integer> tiemposArray = tipoAct.getTiempoParticipantes().get(nombreParticipante.getText());
					String tiempoTotal = Integer.toString(tiemposArray.get(0));
					String tiempoPromedio = Integer.toString(tiemposArray.get(1));
					String tiempoDía = Integer.toString(tiemposArray.get(2));

					String[] listaTiemposMostrar = {"Tiempo Total: " + tiempoTotal,
							"Tiempo Promedio" + tiempoPromedio,
							"Tiempo por día: " + tiempoDía};
					tiemposParticipante.setListData(listaTiemposMostrar);

					panelTipoActividad.add(nombreParticipante);
					panelTipoActividad.add(tiemposParticipante);
					this.add(panelTipoActividad);
				}
			}
		}
	}
}

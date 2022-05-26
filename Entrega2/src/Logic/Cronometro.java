package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import javax.naming.InitialContext;
import javax.swing.Timer;

public class Cronometro {
    private javax.swing.Timer cronometro;
    private int centesimas_segundo = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private String tiempo = "";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ActionListener accion = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Esta funci�n lo que hace es a�adir a las variables el correspondiente valor seg�n pasa el tiempo
            //100 centesimas = 1 segundo
            //60 segundos = 1 min
            //60 mins = 1 hora
            centesimas_segundo++;
            if (centesimas_segundo == 100) {
                segundos++;
                centesimas_segundo = 0;
            }
            if (segundos == 60) {
                minutos++;
                segundos = 0;
            }
            if (minutos == 60) {
                horas++;
                minutos = 0;
            }
            actualizarTiempo();
        }
    };

    public void setCentesimas_segundo(int centesimas_segundo) {
        this.centesimas_segundo = centesimas_segundo;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    private void actualizarTiempo() {
        //Esto es para que mientras va corrieno el Timer, se actualicen las variables
        //Siempre se actualizaran en formato HH:MM:SS:CS
        String tiempo = (horas <= 9 ? "0" : "")
                + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":"
                + (segundos <= 9 ? "0" : "") + segundos + ":"
                + (centesimas_segundo <= 9 ? "0" : "") + centesimas_segundo;
        setTiempo(tiempo);
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }


    public Cronometro() {
        super();
        cronometro = new Timer(10, accion);
    }

    public void startTime() {
        cronometro.start();
    }
    
    public int tiempoEnMins() {
        String[] separado = this.tiempo.split(":");
        int horas_a_mins = Integer.parseInt(separado[0]) * 60;
        int mins = Integer.parseInt(separado[1]);
        int segs_a_mins = Integer.parseInt(separado[2]) / 60;
        int todoMinutos = horas_a_mins + mins + segs_a_mins;
        //Como ya se guarda el tiempo en otra variable llamada "separado". Usamos los setters para reiniciar el tiempo
        //Y que as� cada actividad inicie desde "00:00:00:00"
        String restart = "00:00:00:00";
        setTiempo(restart);
        setTiempo("00:00:00:00");
        setCentesimas_segundo(0);
        setHoras(0);
        setMinutos(0);
        setSegundos(0);
        return todoMinutos;
    }

	public void stopTime() {
		cronometro.stop();
		
	}

}
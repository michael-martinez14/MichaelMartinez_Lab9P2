/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michaelmartinez_lab9p2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Michael Martínez
 */
public class HiloFecha implements Runnable{
    private JLabel labelFecha;
    private JLabel labelHora;

    public HiloFecha(JLabel labelFecha, JLabel labelHora) {
        this.labelFecha = labelFecha;
        this.labelHora = labelHora;
    }

    public JLabel getLabelFecha() {
        return labelFecha;
    }

    public void setLabelFecha(JLabel labelFecha) {
        this.labelFecha = labelFecha;
    }

    public JLabel getLabelHora() {
        return labelHora;
    }

    public void setLabelHora(JLabel labelHora) {
        this.labelHora = labelHora;
    }

    @Override
    public void run() {
        
        while (true) {
            Date date = new Date();
            DateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");
            DateFormat hora= new SimpleDateFormat("hh:mm:ss");
            labelFecha.setText(fecha.format(date));

            labelHora.setText(hora.format(date));
            try {
                Thread.sleep(2);
            } catch (Exception e) {
            }
        }
       
    }
    
    
}

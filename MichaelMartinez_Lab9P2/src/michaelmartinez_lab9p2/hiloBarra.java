/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package michaelmartinez_lab9p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Michael Martínez
 */
public class hiloBarra implements Runnable{
    JProgressBar barra;
    JTextArea textArea;
    File file;

    public hiloBarra(JProgressBar barra, JTextArea textArea, File file) {
        this.barra = barra;
        this.textArea = textArea;
        this.file = file;
    }
    

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
    

    public hiloBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public hiloBarra(JProgressBar barra, JTextArea textArea) {
        this.barra = barra;
        this.textArea = textArea;
    }
    

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        int contador = 0;
        Boolean bandera = true;
        FileReader fr = null;
        BufferedReader br = null;

        while (bandera) {
            barra.setValue(contador);
            contador += 10;
            if (barra.getValue() == 100) {
                bandera = false;
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }

        }
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linea = "";
            try {
                while ((linea = br.readLine()) != null) {
                    textArea.append(linea);
                    textArea.append("\n");
                }
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(hiloBarra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (Exception e) {

        }

    }
}

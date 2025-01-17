/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irene Procopio
 */
public class Partecipante extends Thread {
    Posto sedie[];
    String nomeFile = "Risultato.txt";
    BufferedWriter br=null;
    LocalDate localDate = LocalDate.now(ZoneId.of("GMT+1"));
    
    /**
     * Metodo Costruttore: inizializzazione dell'array sedie[]
     * @param sedie array creato nella classe d'avvio (GiocoSedie) contenente degli oggetti di tipo Posto
     */
    public Partecipante(Posto sedie[]) {
	this.sedie = sedie;
        try {
            br = new BufferedWriter(new FileWriter(nomeFile, true));
        } catch (IOException ex) {
            Logger.getLogger(Partecipante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
	try {
            sleep((int) (Math.random() * 1000)); //Il thread finisce nell'area di sleeping per un numero di millisecondi generato randomicamente
            for (int i = 0; i < sedie.length; i++) {
		if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + i);
                    scrivi(i);
                    return;
		}
            }
            System.out.println("Sono il Thread " + this.getName() + ". Ho perso :((((");
	}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void scrivi(int i){
        try {
            if(i == 0){
                br.write("Gioco Sedie " + this.localDate);
                br.write("\n\r");
                br.write("Posto n° " + i + " - ID Partecipante: " + this.getId());
                br.write("\n\r");
            }
            else if(i == sedie.length - 1){
                br.write("Posto n° " + i + " - ID Partecipante: " + this.getId());
                br.write("\n\r");
                br.write("-----------------------------------");
                br.write("\n\r");
            }
            else{
                br.write("Posto n° " + i + " - ID Partecipante: " + this.getId());
                br.write("\n\r"); 
            }
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        }catch (IOException ex) {
            Logger.getLogger(Partecipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Partecipante.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}

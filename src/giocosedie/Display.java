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
public class Display extends Thread{
    private Posto sedie[];
    private boolean endgame;

    /**
     * Metodo Costruttore: inizializzazione dell'array sedie[]
     * @param sedie array creato nella classe d'avvio (GiocoSedie) contenente degli oggetti di tipo Posto
     */
    public Display(Posto sedie[]) {
	this.sedie = new Posto[sedie.length];
	for(int s = 0; s < sedie.length; s++)
            this.sedie[s] = sedie[s];
	}

    
    public void run() {
        try{
            while(!endgame){ //finché il gioco non finisce
                int count = 0;
                sleep((int) (Math.random() * 250)); //Il thread finisce nell'area di sleeping per un numero di millisecondi generato randomicamente
                for (int i = 0; i < sedie.length; i++) {  //Vengono controllati i posti: 
                    if (sedie[i].libero())      //se il posto risulta libero
                        System.out.print("0");  //viene stampato uno 0
                    else {                      //altrimenti
                        count++;
                        System.out.print("*");  //viene stampa un asterisco
                    }
                }
                System.out.println();
                endgame = (count == sedie.length);  //quando le sedie risultano tutte occupate il gioco termina
            }
        }catch (InterruptedException e) {
		throw new RuntimeException(e);
        }
    }
}

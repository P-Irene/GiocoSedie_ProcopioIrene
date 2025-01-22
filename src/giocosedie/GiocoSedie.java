/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giocosedie;

import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author Irene Procopio
 */
public class GiocoSedie {
    private static Logger logger = Logger.getLogger("GiocoSedie.GiocoSedie");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Scegliere il numero di partecipanti: ");
        int num = myObj.nextInt();
        
        Posto sedie[] = new Posto[num-1];

	for (int k = 0; k < sedie.length; k++)
            sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
 
	Partecipante array[] = new Partecipante[num];
        //Ciclo che permette di istanziare num numero di Partecipanti al gioco
	for (int i = 0; i < num; i++) {
            array[i] = new Partecipante(sedie);
            //System.out.println("Sto facendo partire il thread n." + array[i].getId());
            logger.info("Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie;

/**
 *
 * @author Irene Procopio
 */
public class Partecipante extends Thread {
    Posto sedie[];
    
    /**
     * Metodo Costruttore: inizializzazione dell'array sedie[]
     * @param sedie array creato nella classe d'avvio (GiocoSedie) contenente degli oggetti di tipo Posto
     */
    public Partecipante(Posto sedie[]) {
	this.sedie = sedie;

    }

    public void run() {
	try {
            sleep((int) (Math.random() * 1000)); //Il thread finisce nell'area di sleeping per un numero di millisecondi generato randomicamente
            for (int i = 0; i < sedie.length; i++) {
		if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + i);
                    return;
		}
            }
            System.out.println("Sono il Thread " + this.getName() + ". Ho perso :((((");
	} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
  }
}

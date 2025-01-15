/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie;

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
                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero())
                        System.out.print("0");
                    else {
                        count++;
                        System.out.print("*");
                    }
                }
                System.out.println();
                endgame = (count == sedie.length);
            }
        }catch (InterruptedException e) {
		throw new RuntimeException(e);
        }
	}
}

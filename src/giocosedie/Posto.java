/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie;

/**
 *
 * @author Irene Procopio
 */
public class Posto {
    private boolean occupato;
    
    /**
     * Metodo Costruttore
     */
    public Posto(){
	occupato = false;
    }
    
    /**
     * Controlla se il posto è libero
     * @return se il posto è libero restitutisce occupato = true, se il posto non è libero restitutisce occupato = false
     */
    public synchronized boolean libero() {
	return (!occupato);
    }
    
    /**
     * Controlla che il posto sia libero
     * @return false se il posto risulta occupato (occupato = true), mentre, ritorna occupato = true se il posto risulta libero (occupato = false)
     */
    public synchronized boolean occupa() {
	if (occupato)
            return false;
        else
            return occupato = true;
    }
}

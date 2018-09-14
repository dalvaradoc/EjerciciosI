/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

/**
 *
 * Esta clase es solo un array de dos integers. Además de esto, tiene un tipo 
 * de posicion llamado vacio el cual ayuda a comparar posiciones.
 * @author Alejandro Alvarado
 * @since 11/09/2018
 * @version 1.0
 */
public class Posicion {
    private int[] posicion;
    
    public static Posicion vacio = new Posicion(1234, 1234);

    /**
     * Constructor que asigna la memoria del arreglo posicion, y asigna los
     * valores del arreglo.
     * @param x
     * @param y
     */
    public Posicion(int x, int y) {
        posicion = new int[2];
        posicion[0] = y;
        posicion[1] = x;
    }

    /**
     * Metodo que devuelve el componente y de la posicion.
     * @return
     */
    public int getY () {
        return posicion[0];
    }
    
    /**
     * Metodo que devuelve el componente x de la posicion.
     * @return
     */
    public int getX () {
        return posicion[1];
    }
    
}

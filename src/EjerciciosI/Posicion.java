/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

/**
 *
 * @author Alejandro
 */
public class Posicion {
    private int[] posicion;
    
    public static Posicion vacio = new Posicion(1234, 1234);

    public Posicion(int x, int y) {
        posicion = new int[2];
        posicion[0] = y;
        posicion[1] = x;
    }

    public int getY () {
        return posicion[0];
    }
    
    public int getX () {
        return posicion[1];
    }
    
}

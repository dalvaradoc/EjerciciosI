/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import becker.robots.City;
import becker.robots.Direction;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Esta clase es una extensión de la clase Robot (becker.robots.Robot). Puede
 * recorrer el exterior del area en sentido de las manecillas del reloj, guarda
 * las intersecciones donde hay una pared y puede calcular los metros cuadrados
 * del area.
 * @author Alejandro Alvarado
 * @since 11/09/2018
 * @version 1.0
 */
public class RobotMedidor extends becker.robots.Robot {
    
    private ArrayList<Posicion> posiciones;
    
    /**
     * Constructor que crea el robot e inicializa la lista posiciones.
     * @param city
     * @param i
     * @param i1
     * @param drctn
     */
    public RobotMedidor(City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
        posiciones = new ArrayList<Posicion>();
    }
    
    /**
     * Metodo que busca si existe una posicion "pos" en la lista "posL".
     * @param posL
     * @param pos
     * @return
     */
    public boolean buscarPosicion (ArrayList<Posicion> posL, Posicion pos){
        for (int i = 0; i < posL.size(); i++){
            if (posL.get(i).getX() == pos.getX() && posL.get(i).getY() == pos.getY()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que mueve al robot por el exterior del area y asigna los valores
     * a la lista de posiciones mientras se mueve.
     */
    public void moverPorElArea (){
        boolean flag = true;
        while (flag){
            Posicion posicion = new Posicion(this.getAvenue(), this.getStreet());
            if (!buscarPosicion(posiciones, posicion)){
                posiciones.add(posicion);
            }
            if (this.canPickThing()){
                flag = false;
                return;
            }
            this.rot(3);
            if (this.frontIsClear()){
                this.move();
            } else {
                this.rot(1);
                if (this.frontIsClear()){
                    this.move();
                } else {
                    this.rot(1);
                    if (this.frontIsClear()){
                        this.move();
                    } else {
                        this.rot(1);
                        this.move();
                    }
                }
            }
        }
    }
    
        public void rot (int n){
        for (int i = 0; i < n; i++){
            this.turnLeft();
        }
    }
    
    /**
     * Metodo que gira el robot hasta que su direccion sea la especificada.
     * @param dir
     */
    public void rotUntilDir (Direction dir){
        while (this.getDirection() != dir){
            this.rot(1);
        }
    }

    /**
     * Metodo que devuelve la lista de posiciones.
     * @return
     */
    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }   
    
    /**
     * Metodo que imprime las posiciones.
     */
    public void mostrarPosiciones (){
        for (int i = 0; i < posiciones.size(); i++){
            System.out.println("x: " + posiciones.get(i).getX() + " y: " + posiciones.get(i).getY() + "\n");
        }
    }
    
    /**
     * Metodo que devuelve la ultima posicion de la lista "pos".
     * @param pos
     * @return
     */
    public int maximoX(ArrayList<Posicion> pos) {
        return pos.get(pos.size()-1).getX();
    }  
    
    /**
     * Metodo que devuelve la primera posicion de la lista "pos".
     * @param pos
     * @return
     */
    public int minimoX(ArrayList<Posicion> pos) {
        return pos.get(0).getX();
    }
    
    /**
     * Metodo que organiza la lista "posL". La organiza de menor a mayor en el
     * eje x, y luego en el eje y.
     * @param posL
     */
    public void sortPosiciones (ArrayList<Posicion> posL){
        for (int i = 0; i < posL.size()-1; i++){
            for (int j = i+1; j < posL.size();j++){
                if (posL.get(i).getX() > posL.get(j).getX()){
                    Posicion temp = posL.get(j);
                    posL.set(j, posL.get(i));
                    posL.set(i, temp);
                }
            }
        }
        for (int i = 0; i < posL.size()-1; i++){
            for (int j = i+1; j < posL.size();j++){
                if (posL.get(i).getX() == posL.get(j).getX()){
                    if (posL.get(i).getY() > posL.get(j).getY()){
                        Posicion temp = posL.get(j);
                        posL.set(j, posL.get(i));
                        posL.set(i, temp);
                    }
                }
            }
        }
    }
    
    /**
     * Metodo que calcula los metros cuadrados del area.
     * @return
     */
    public int calcularArea (){
        int area = 0;
        sortPosiciones(posiciones);
        int maxX = maximoX(posiciones);
        int minX = minimoX(posiciones);
        
        for (int i = 0; i < posiciones.size()-1; i++){
            Posicion pos1 = posiciones.get(i);
            Posicion pos2 = posiciones.get(i+1);
            
            if (!pos1.equals(Posicion.vacio) && !pos2.equals(Posicion.vacio) && pos1.getX() != maxX && pos1.getX() != minX) {
                if (pos1.getX() == pos2.getX()){
                    int diferencia = pos2.getY() - pos1.getY();
                    if (diferencia != 1){
                        area += diferencia - 1;
                        posiciones.set(i, Posicion.vacio);
                        posiciones.set(i+1, Posicion.vacio);
                    }
                }
            }
        }
        return area;
    }
    
}

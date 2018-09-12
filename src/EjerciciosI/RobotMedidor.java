/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import becker.robots.City;
import becker.robots.Direction;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class RobotMedidor extends becker.robots.Robot {
    
    private ArrayList<Posicion> posiciones;
    
    public RobotMedidor(City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
        posiciones = new ArrayList<Posicion>();
    }
    
    public boolean buscarPosicion (ArrayList<Posicion> posL, Posicion pos){
        for (int i = 0; i < posL.size(); i++){
            if (posL.get(i).getX() == pos.getX() && posL.get(i).getY() == pos.getY()){
                return true;
            }
        }
        return false;
    }
    
    public void moverPorElArea (){        
        boolean flag = true;
        while (flag){
            Posicion posicion = new Posicion(this.getAvenue(), this.getStreet());
            posiciones.add(posicion);
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
    
    public void rotUntilDir (Direction dir){
        while (this.getDirection() != dir){
            this.rot(1);
        }
    }

    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }   
    
    public void mostrarPosiciones (){
        for (int i = 0; i < posiciones.size(); i++){
            System.out.println("x: " + posiciones.get(i).getX() + " y: " + posiciones.get(i).getY() + "\n");
        }
    }
    
    public int maximoX(ArrayList<Posicion> pos) {
        int max = -1234;
        for (int i = 1; i < pos.size(); i++){
            if (pos.get(i).getX() != 1234 && pos.get(i).getX() > max){
                max = pos.get(i).getX();
            }
        }
        return max;
    }  
    
    public int minimoX(ArrayList<Posicion> pos) {
        int min = pos.get(0).getX();
        for (int i = 1; i < pos.size(); i++){
            if (pos.get(i).getX() < min){
                min = pos.get(i).getX();
            }
        }
        return min;
    }   
    
    public int calcularArea (){
        int area = 0;
        int maxX = maximoX(posiciones);
        int minX = minimoX(posiciones);
        for (int i = 0; i < posiciones.size() - 1; i++){
            if (!posiciones.get(i).equals(Posicion.vacio) && posiciones.get(i).getX() != maxX && posiciones.get(i).getX() != minX){
                for (int j = i+1; j < posiciones.size(); j++){
                    if (!posiciones.get(j).equals(Posicion.vacio)){
                        if (posiciones.get(i).getX() == posiciones.get(j).getX()){
                            if (j < posiciones.size()-1){
                                while (posiciones.get(j).getX() == posiciones.get(j+1).getX() && Math.abs(posiciones.get(j).getY() - posiciones.get(j+1).getY()) == 1){
                                    posiciones.set(j, Posicion.vacio);
                                    if (j < posiciones.size()){
                                        j++;
                                    }
                                }
                            }
                            int diferencia = Math.abs(posiciones.get(i).getY() - posiciones.get(j).getY());
                            if (diferencia == 1){
                                posiciones.set(i, Posicion.vacio);
                            } else {
                                area += diferencia - 1;
                                posiciones.set(i, Posicion.vacio);
                                posiciones.set(j, Posicion.vacio);
                            }
                            j = posiciones.size();
                        }
                    }
                }
            }
        }
        return area;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

/**
 *
 * @author Alejandro
 
 * 
 * 
 **/
import becker.*;
import becker.robots.City;
import becker.robots.Direction;
//import becker.robots.IPredicate;
//import becker.robots.Sim;
import becker.robots.Thing;
import java.time.Clock;

public class RobotParqueador extends becker.robots.Robot {
    
    private Seccion secciones[];

    public RobotParqueador(City city, int i, int i1, Direction drctn, Seccion s1, Seccion s2, Seccion s3) {
        super(city, i, i1, drctn);
        
        secciones = new Seccion[3];
        secciones[0] = s1;
        secciones[1] = s2;
        secciones[2] = s3;
    }
    
    public void mover (int n){
        for (int i = 0; i < n; i++){
            this.move();
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
    
    public void moveUntilThing (){
        while (!this.canPickThing()){
            this.mover(1);
        }
    }
    
    private Seccion getminSeccion() {
        Seccion minSec = secciones[0];
        for (int i = 1; i < 3; i++){
            if (minSec.getCantidad() > secciones[i].getCantidad()){
                minSec = secciones[i];
            }
        }
        return minSec;
    }
    
    public boolean IngresarVehiculo (long tiempo0) {
        //Mirar cual seccion es la que tiene menor cantidad de carros
        Seccion sec = getminSeccion();
        //Si la seccion con menos carros esta llena, retorna false
        if (sec.getCantidad() == 5){
            return false;
        }
        
        this.rotUntilDir(Direction.EAST);
        this.moveUntilThing();
        Carro carro = (Carro) this.examineThings().next();
        this.pickThing();
        this.rotUntilDir(Direction.WEST);
        this.mover(this.getAvenue() - sec.getNumber());
        this.rotUntilDir(Direction.NORTH);
        this.mover(5 - sec.getCantidad());
        this.putThing();
        sec.añadirCarro(carro, tiempo0);
        this.rotUntilDir(Direction.SOUTH);
        this.mover(6 - sec.getCantidad());
        
        return true;
        
    }
    
    public boolean sacarVehiculo (String placa, Seccion sec, long tiempoF){
        if (!sec.searchCarro(placa)){
            return false;
        }
        
        int tempCount = 0;
        
        while (true){
            if (sec.getNumber() > this.getAvenue()){
                this.rotUntilDir(Direction.EAST); 
                mover(sec.getNumber() - this.getAvenue());
            } else {
                this.rotUntilDir(Direction.WEST);            
                this.mover(this.getAvenue()- sec.getNumber());
            }

            this.rotUntilDir(Direction.NORTH);
            this.moveUntilThing();
            
            Carro carro = sec.getCarros()[this.getStreet()-1];
            
            if (carro.getPlaca() == placa){
                this.pickThing();
                rot(2);
                this.mover(6 - this.getStreet());
                this.rotUntilDir(Direction.EAST);
                this.mover(8 - this.getAvenue());
                this.putThing();
                sec.eliminarCarro(carro, tiempoF);
                while (tempCount > 0){
                    this.rotUntilDir(Direction.WEST);
                    this.mover(5 - tempCount);
                    this.rotUntilDir(Direction.NORTH);
                    this.mover(1);
                    this.pickThing();
                    this.rot(2);
                    this.mover(1);
                    this.rotUntilDir(Direction.WEST);
                    this.mover(this.getAvenue() - sec.getNumber());
                    this.rotUntilDir(Direction.NORTH);
                    this.mover(5 - sec.getCantidad() + tempCount);
                    this.putThing();
                    this.rotUntilDir(Direction.SOUTH);
                    this.mover(6 - this.getStreet());
                    this.rotUntilDir(Direction.EAST);
                    this.mover(8 - sec.getNumber());
                    tempCount--;
                }
                return true;
            } else {
                this.pickThing();
                rot(2);
                this.mover(6 - this.getStreet());
                this.rotUntilDir(Direction.EAST);
                this.mover(4 - this.getAvenue() + tempCount);
                this.rotUntilDir(Direction.NORTH);
                this.mover(1);
                this.putThing();
                tempCount++;
                this.rot(2);
                this.mover(1);
                this.rotUntilDir(Direction.WEST);
            }
        }
    }
}

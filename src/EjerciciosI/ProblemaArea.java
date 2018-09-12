/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class ProblemaArea {
    private City ciudad;
    private AreaA area;
    private RobotMedidor robot;
    private Thing meta;

    public ProblemaArea() {
        ciudad = new City(12, 15);
        area = new AreaA(ciudad, 1);
        robot = new RobotMedidor(ciudad, 10, 4, Direction.WEST);
        meta = new Thing(ciudad, 10, 5);
    }
    
    public void solucionarProblema (){
        robot.moverPorElArea();
        ArrayList<Posicion> posiciones = robot.getPosiciones();
        int area = robot.calcularArea();
        System.out.println("Area: " + area + " metros cuadrados");
    }
    
}

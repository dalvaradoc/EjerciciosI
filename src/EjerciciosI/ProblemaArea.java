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
 * Esta clase contiene el campo donde se crea el area, el 
 * robot medidor y el thing que empieza al lado del robot, es la clase que prueba el funcionamiento de 
 * las demas (en el caso de las areas).
 * @author Alejandro Alvarado
 * @since 11/09/2018
 * @version 1.0
 */
public class ProblemaArea {
    private City ciudad;
    private AreaA area;
    private RobotMedidor robot;
    private Thing meta;

    /**
     * Constructor que crea la ciudad, crea el area, el robot medidor y el 
     * objeto que se ingresa al lado del robot.
     */
    public ProblemaArea() {
        ciudad = new City(12, 15);
        area = new AreaA(ciudad, 1);
        robot = new RobotMedidor(ciudad, 10, 4, Direction.WEST);
        meta = new Thing(ciudad, 10, 5);
    }
    
    /**
     * Metodo que llama la funcion para que el robot recorra el exterior del 
     * area, llama la funcion que calcula los metros cuadrados del area y lo
     * asigna a una variable, para luego imprimir esta informacion.
     */
    public void solucionarProblema (){
        robot.moverPorElArea();
        ArrayList<Posicion> posiciones = robot.getPosiciones();
        int area = robot.calcularArea();
        System.out.println("Area: " + area + " metros cuadrados");
    }
    
}

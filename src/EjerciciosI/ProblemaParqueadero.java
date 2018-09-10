package EjerciciosI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */

import becker.robots.*;
import java.awt.Color;
import java.time.Clock;

public class ProblemaParqueadero {
    private City ciudad;
    private RobotParqueador robot;
    private Seccion seccion1;
    private Seccion seccion2;
    private Seccion seccion3;
    
    public Clock reloj;

    public ProblemaParqueadero() {
        
        reloj = Clock.systemDefaultZone();
        
        this.ciudad = new City();
        
        for (int i = 0; i < 3;i++){
            Wall wall = new Wall(ciudad, 1, 1+i, Direction.NORTH);
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                Wall wallE = new Wall(ciudad, 1+j, 1+i, Direction.EAST);
                Wall wallW = new Wall(ciudad, 1+j, 1+i, Direction.WEST);
            }
        }
        
        for (int i = 0; i < 4;i++){
            Wall wall = new Wall(ciudad, 5, 4+i, Direction.NORTH);
        }
        
        Wall finalWall = new Wall(ciudad, 5, 7, Direction.EAST);
        
        seccion1 = new Seccion(1);
        seccion2 = new Seccion(2);
        seccion3 = new Seccion(3);
        
        Carro carro1 = new Carro(ciudad, 1, 1, "ABC123");
        seccion1.añadirCarro(carro1, reloj.millis());
        
        Carro carro2 = new Carro(ciudad, 1, 2, "DEF456");
        Carro carro3 = new Carro(ciudad, 2, 2, "GHI789");
        seccion2.añadirCarro(carro2, reloj.millis());
        seccion2.añadirCarro(carro3, reloj.millis());
        
        Carro carro4 = new Carro(ciudad, 6, 8, "AAA111");
        Carro carro5 = new Carro(ciudad, 6, 8, "BBB222");
        Carro carro6 = new Carro(ciudad, 6, 8, "CCC333");
        Carro carro7 = new Carro(ciudad, 6, 8, "DDD444");
        Carro carro8 = new Carro(ciudad, 6, 8, "EEE555");
        Carro carro9 = new Carro(ciudad, 6, 8, "FFF666");
        
        robot = new RobotParqueador(ciudad, 6, 7, Direction.WEST, seccion1, seccion2, seccion3);
        
    }    
    
    public void solucionarProblema (){
        
        System.out.println(reloj.millis()/1000);
        
        for(int i = 0; i < 6; i++){
            this.robot.IngresarVehiculo(reloj.millis());
        }
        
        seccion1.mostrarSeccion();
        
        robot.sacarVehiculo("ABC123", seccion1, reloj.millis());
        robot.sacarVehiculo("BBB222", seccion1, reloj.millis());
        robot.sacarVehiculo("CCC333", seccion3, reloj.millis());
        
        System.out.println("Registro: " + "\n" + Seccion.getRegistro());
        System.out.println("Ganancias: " + Seccion.getGanancias());
        
    }
}

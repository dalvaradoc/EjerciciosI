/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Wall;

/**
 *
 * Esta clase crea las paredes de un area, puede crear 3 diferentes areas y se
 * puede elegir cual area elegir.
 * @author Alejandro Alvarado
 * @since 11/09/2018
 * @version 1.0
 */
public class AreaA {
    private City ciudad;

    /**
     * Constructor que llama a la funcion crearArea.
     * @param ciudad
     * @param n
     */
    public AreaA(City ciudad, int n) {
        this.ciudad = ciudad;
        crearArea(n);
    }
    
    /**
     * Este metodo es el que contiene la información para crear las areas, y se
     * elige cual area crear dependiendo de el integer n que se le asigne.
     * @param n
     */
    public void crearArea(int n) {
        switch (n){
            case 0:
                for (int i = 0; i < 4; i++){
                    Wall wall = new Wall(ciudad, 1, i+1, Direction.NORTH);
                }
                Wall wallx1 = new Wall(ciudad, 1, 4, Direction.EAST);
                Wall wallx2 = new Wall(ciudad, 2, 5, Direction.NORTH);
                for (int i = 0; i < 2; i++){
                    Wall wall = new Wall(ciudad, 2+i, 5, Direction.EAST);
                }
                for (int i = 0; i < 4; i++){
                    Wall wall = new Wall(ciudad, 3, 5-i, Direction.SOUTH);
                }
                for (int i = 0; i < 2; i++){
                    Wall wall = new Wall(ciudad, 3-i, 2, Direction.WEST);
                }
                Wall wall3 = new Wall(ciudad, 1, 1, Direction.WEST);
                Wall wall4 = new Wall(ciudad, 1, 1, Direction.SOUTH);
                break;
            case 1:
                for (int i = 0; i < 3; i++){
                    Wall wall = new Wall(ciudad, 1, 3+i, Direction.NORTH);
                }
                for (int i = 0; i < 3; i++){
                    Wall wall = new Wall(ciudad, 1+i, 5, Direction.EAST);
                }
                for (int i = 0; i < 3; i++){
                    Wall wall1 = new Wall(ciudad, 4-i, 6+i, Direction.NORTH);
                    Wall wall2 = new Wall(ciudad, 3-i, 7+i, Direction.WEST);
                }
                for (int i = 0; i < 3; i++){
                    Wall wall = new Wall(ciudad, 1, 9+i, Direction.NORTH);
                }
                for (int i = 0; i < 4; i++){
                    Wall wall1 = new Wall(ciudad, 1+i, 11-i, Direction.SOUTH);
                    Wall wall2 = new Wall(ciudad, 1+i, 11-i, Direction.EAST);
                }

                for (int i = 0; i < 4; i++){
                    Wall wall1 = new Wall(ciudad, 5+i, 7+i, Direction.EAST);
                    Wall wall2 = new Wall(ciudad, 6+i, 8+i, Direction.NORTH);
                }

                Wall wallborde1 = new Wall(ciudad, 9, 11, Direction.EAST);

                for (int i = 0; i < 3; i++){
                    Wall wall = new Wall(ciudad, 9, 11-i, Direction.SOUTH);
                }

                for (int i = 0; i < 2; i++){
                    Wall wall1 = new Wall(ciudad, 9-i, 9-i, Direction.WEST);
                    Wall wall2 = new Wall(ciudad, 8-i, 8-i, Direction.SOUTH);
                }

                for (int i = 0; i < 1; i++){
                    Wall wall = new Wall(ciudad, 7, 6-i, Direction.SOUTH);
                }

                Wall wallborde2 = new Wall(ciudad, 8, 5, Direction.EAST);
                Wall wallborde3 = new Wall(ciudad, 9, 6, Direction.NORTH);
                Wall wallborde4 = new Wall(ciudad, 9, 6, Direction.EAST);

                for (int i = 0; i < 4; i++){
                    Wall wall = new Wall(ciudad, 9, 6-i, Direction.SOUTH);
                }

                Wall wallborde5 = new Wall(ciudad, 9, 3, Direction.WEST);
                Wall wallborde6 = new Wall(ciudad, 9, 3, Direction.NORTH);

                for (int i = 0; i < 2; i++){
                    Wall wall = new Wall(ciudad, 8-i, 4, Direction.WEST);
                }

                Wall wallborde7 = new Wall(ciudad, 7, 4, Direction.NORTH);

                for (int i = 0; i < 2; i++){
                    Wall wall = new Wall(ciudad, 6-i, 5, Direction.WEST);
                }

                Wall wallborde8 = new Wall(ciudad, 4, 4, Direction.SOUTH);

                for (int i = 0; i < 3; i++){
                    Wall wall = new Wall(ciudad, 4-i, 4, Direction.WEST);
                }

                Wall wallborde9 = new Wall(ciudad, 1, 3, Direction.SOUTH);
                Wall wallborde10 = new Wall(ciudad, 1, 3, Direction.WEST);
                break;
            case 2:
                for (int i = 0; i < 4; i++){
                    Wall wall1 = new Wall(ciudad, i+2, i+3, Direction.EAST);
                    Wall wall2 = new Wall(ciudad, i+2, i+3, Direction.NORTH);
                }
                for (int i = 0; i < 4; i++){
                    Wall wall1 = new Wall(ciudad, i+3, i+3, Direction.WEST);
                    Wall wall2 = new Wall(ciudad, i+3, i+3, Direction.SOUTH);
                }
                Wall wallb1 = new Wall(ciudad, 2, 3, Direction.WEST);
                Wall wallb2 = new Wall(ciudad, 6, 6, Direction.EAST);
                break;
        }
    }
    
    
    
}

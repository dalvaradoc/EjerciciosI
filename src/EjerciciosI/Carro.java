/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import becker.robots.City;
import becker.robots.icons.Icon;
import java.awt.Color;

/**
 *
 * Esta clase es una extension de la clase Thing (becker.robots.Thing). Tiene un
 * atributo String el cual sirve para identificar el objeto.
 * @author Alejandro Alvarado
 * @since 09/09/2018
 * @version 1.0
 */
public class Carro extends becker.robots.Thing {
    
    private String placa;
    
    public Carro(City city, int i, int i1, String placa) {
        super(city, i, i1);
        this.placa = placa;
        super.getIcon().setLabel(placa);
        super.getIcon().setColor(new Color((int)(Math.random() * 0x1000000)));
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        super.getIcon().setLabel(placa);
    }
    
}

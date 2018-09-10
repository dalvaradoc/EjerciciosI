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
 * @author Alejandro
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

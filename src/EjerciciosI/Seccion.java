/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Clock;
//import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * Esta clase es la que contiene los objetos carros, los tiempos de entrada a 
 * la seccion, la cantidad de carros que hay en la seccion y un numero el cual
 * indica que seccion es, además de que es la que contiene la informacion de 
 * las ganancias que se consiguen en el dia laboral.
 * @author Alejandro Alvarado
 * @since 09/09/2018
 * @version 1.0
 */
public class Seccion {
    private Carro carros[];
    private long timeCarro[];
    private int cantidad;
    private int number;
    
    
    private static String registro;
    private static int precioPorMinuto = 60;
    private static int ganancias = 0;

    /**
     * Constructor el cual asigna memoria al arreglo de carros y al arreglo
     * de tiempos, inicializa la variable cantidad y la variable registro,
     * y asigna el numero de la sección.
     * seccion,
     * @param number
     */
    public Seccion(int number) {
        this.carros = new Carro[5];
        this.timeCarro = new long[5];
        cantidad = 0;
        this.number = number;
        registro = "";
    }
    
    /**
     * Metodo que busca si existe un carro con la placa especificada dentro de
     * la seccion.
     * @param placa
     * @return
     */
    public boolean searchCarro (String placa){
        for (int i = 0; i < cantidad; i++){
            if (carros[i].getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que agrega un carro en la seccion y agrega el tiempo de ingreso
     * al arreglo de tiempos.
     * @param carro
     * @param tiempo0
     * @return
     */
    public boolean añadirCarro (Carro carro, long tiempo0){
        for (int i = 0; i < 5; i++){
            if (carros[i] == null){
                carros[i] = carro;
                timeCarro[i] = tiempo0;
                cantidad++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que elimina el objeto carro de la seccion, añade la informacion
     * del tiempo de ingreso y de salida al registro y elimina la informacion
     * del arreglo de tiempos, además de llamar la funcion que aumenta las
     * ganancias.
     * @param carro
     * @param tiempoF
     * @return
     */
    public boolean eliminarCarro(Carro carro, long tiempoF){
        for (int i = 0; i < 5; i++){
            if (carros[i] != null && carros[i] == carro){
                
                int cobro = (int)(tiempoF - timeCarro[i])/1000 * precioPorMinuto;
                
                Date horaSalida = new Date(tiempoF);
                DateFormat formatterS = new SimpleDateFormat("HH:mm:ss.SSS");
                formatterS.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormattedS = formatterS.format(horaSalida);
                
                Date horaEntrada = new Date(timeCarro[i]);
                DateFormat formatterE = new SimpleDateFormat("HH:mm:ss.SSS");
                formatterE.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormattedE = formatterE.format(horaEntrada);
                
                registro += "Carro: " + carro.getPlaca() + ", hora entrada: " + dateFormattedE + " - salida: " + dateFormattedS + ". Total precio: " + cobro +"\n";
                carros[i] = null;
                
                aumentarGanancias(cobro);
                
                for (int j = i; j < cantidad; j++){
                    carros[j] = carros[j+1];
                    timeCarro[j] = timeCarro[j+1];
                }
                
                cantidad--;
                
                //Registrar hora de salida
                
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que devuelve la cantidad de carros de la seccion.
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo que devuelve el numero de la seccion.
     * @return
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * Metodo que devuelve el arreglo de carros que hay en la seccion.
     * @return
     */
    public Carro[] getCarros(){
        return carros;
    }

    /**
     * Metodo que devuelve el arreglo de tiempos de ingreso.
     * @return
     */
    public long[] getTimeCarro() {
        return timeCarro;
    }

    /**
     * Metodo que devuelve el registro de tiempos de ingreso y salida de los
     * carros.
     * @return
     */
    public static String getRegistro() {
        return registro;
    }

    /**
     * Metodo que devuelve las ganancias.
     * @return
     */
    public static int getGanancias() {
        return ganancias;
    }

    /**
     * Metodo que imprime las placas de los carros que hay en la seccion.
     */
    public void mostrarSeccion (){
        System.out.println("Seccion " + number);
        for (int i = 0; i < cantidad; i++){
            System.out.println("Carro " + i + ": " + carros[i].getPlaca());
        }
    }
    
    /**
     * Metodo que aumenta las ganancias sumandole el valor especificado.
     * @param valor
     */
    public void aumentarGanancias (int valor){
        ganancias += valor;
    }
    
}

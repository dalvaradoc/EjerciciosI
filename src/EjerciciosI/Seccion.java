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
 * @author Alejandro
 */
public class Seccion {
    private Carro carros[];
    private long timeCarro[];
    private int cantidad;
    private int number;
    
    
    private static String registro;
    private static int precioPorMinuto = 60;
    private static int ganancias = 0;

    public Seccion(int number) {
        this.carros = new Carro[5];
        this.timeCarro = new long[5];
        cantidad = 0;
        this.number = number;
        registro = "";
    }
    
    public boolean searchCarro (String placa){
        for (int i = 0; i < cantidad; i++){
            if (carros[i].getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }
    
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

    public int getCantidad() {
        return cantidad;
    }

    public int getNumber() {
        return number;
    }
    
    public Carro[] getCarros(){
        return carros;
    }

    public long[] getTimeCarro() {
        return timeCarro;
    }

    public static String getRegistro() {
        return registro;
    }

    public static int getGanancias() {
        return ganancias;
    }

    public void mostrarSeccion (){
        System.out.println("Seccion " + number);
        for (int i = 0; i < cantidad; i++){
            System.out.println("Carro " + i + ": " + carros[i].getPlaca());
        }
    }
    
    public void aumentarGanancias (int valor){
        ganancias += valor;
    }
    
}

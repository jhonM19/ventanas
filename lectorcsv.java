package ventanas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class lectorcsv {

    private final String SEPARATOR = ",";          //declaracion de una variable
    private ArrayList<String[]> datos;          //creacion de un arreglo

    public void extraerDatos(String url) {

        datos = new ArrayList<>();          //creacion de un nuevo arreglo
        BufferedReader br = null;          //lee un archivo csv

        try {

            br = new BufferedReader(new FileReader(url));          //creacion de una clase para lectura de un archivo
            String line = br.readLine();                  //declaracion de variables tipo texto
            while (null != line) {                 //ciclo repetitivo hasta que acabe la operacion
                String[] fields = line.split(SEPARATOR);
                datos.add(fields);
                line = br.readLine();
            }

        } catch (Exception e) {                //contiene sentencias 
            System.out.println(e);                //metodo para imprimir
        } finally {
            if (null != br) {                //metodo que proporciona instrucciones al programa
                try {    //se utiliza para tener escepciones en el programa
                    br.close();      //cierre de operacion
                } catch (IOException ex) {              //contiene sentencias 
                    Logger.getLogger(lectorcsv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void calcularPromedio(JTextArea txa) {                //metodo principal del programa 
        for (String[] x : datos) {     //ciclo repetitivo que recorre el programa hasta acabar todas las sentencias
            txa.append("Cod. Estudiante: " + x[0]);                //el txa.append recolecta la info que se especifica, en este caso es el codigo del estudiante
            txa.append("\nNombre: "+x[1]);                    //el txa.append recolecta la info que se especifica, en este caso es el nombre
            int promedio = (Integer.parseInt(x[2])+Integer.parseInt(x[3])+Integer.parseInt(x[4])+Integer.parseInt(x[5]))/4;        //declara una variable tipo entera
            txa.append("\nPromedio de notas: "+promedio+"\n\n");     //el txa.append recolecta la info que se especifica, en este caso es el resultado de promedio
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitxers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alto6500
 */
public class Caratula {
    /*atributs necessaris èr llegir un fitxer
      constructor necessari
      el archivo sera logo.pok*/
    
    
    /*recuperar datos
    
    */
    
        // Ruta al archivo que deseas leer
        String ruta = "fitxers/logo.pok";

        // Llamar al método para recuperar los datos del archivo
        ArrayList<String> lines = recuperarDatos(ruta);

        // Llamar al método para mostrar el contenido del ArrayList
    

    // Método para recuperar los datos del archivo y almacenarlos en un ArrayList
    public static ArrayList<String> recuperarDatos(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File archivo = new File(filePath);
            FileReader fichero_lectura = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fichero_lectura);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void mostrarContenido(ArrayList<String> lines) {
        // Mostrar cada línea del ArrayList por pantalla
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
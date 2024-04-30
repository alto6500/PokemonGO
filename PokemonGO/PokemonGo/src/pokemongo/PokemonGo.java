/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import BD.DBConnect;
import fitxers.Caratula;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuUtils.MenuDaw;
import menuUtils.OptionDuplicateException;
import model.Entrenador;
import model.EntrenadorDAO;

/**
 *
 * @author mabardaji
 */
public class PokemonGo {

    Scanner sc;
    EntrenadorDAO entrenadores;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PokemonGo app = new PokemonGo();
        app.run();
    }

    /* la ejecucion programa*/
    private void run() {
        
        try {
            boolean exit = false;
            mostrarLogo();
            
            MenuDaw menu = new MenuDaw("Manteniment Agenda ");
            
            DBConnect.loadDriver();
            
            addAllOptions(menu); 
            //introDadesProva(/* */);
            int opcio;
            entrenadores = new EntrenadorDAO();
            
            boolean existe_nuevo = pedirEntrenador();
            
            //tractar opcio escollida bucle fins que donis sortir no acabi CASA
            do
            {
                //mostrar el menu i escollir opcio CASA
                opcio = menu.displayMenu();
                switch(opcio)
                {
                    case 2:
                        altaEntrenador();
                        break;
                    case 3:
                        borrarEntrenador();
                        break;
                    case 4:
                        consultaEntrenador();
                        break;
                    case 5:
                        listarEntrenadores();
                        break;
                    case 6:
                        cazarPokemon();
                        break;
                    case 7:
                        listarMochila();
                        break;
                    case 8:
                        listarTodosPokemons();
                        break;
                    case 1: //Sortir
                        salir();
                        exit = true;
                        break;
                } 
            }while(!exit);
            
            
        } catch (SQLException ex) {
            System.out.println("Hay un error SQL " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
}

    private void mostrarLogo()  {
        try {
            Caratula logo = new Caratula();
            
            List<String> portada = logo.recuperarDatos();
            
            for (String lineas : portada) {
                System.out.println(lineas);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error leyendo fichero " + ex.getMessage());
        }
        
        
        
    }
    
    
    private static void addAllOptions(MenuDaw menu) {
        try {
            menu.addOption("Salir");
            menu.addOption("Dar de alta entrenador");
            menu.addOption("Dar de baja entrenador");
            menu.addOption("Consultar entrenador");
            menu.addOption("Listar entrenadores");            
            menu.addOption("Cazar Pokemon");
            menu.addOption("Listar Pokemons Cazados");
            menu.addOption("Listar tipos Pokemon existentes en juego");
            
        } catch (OptionDuplicateException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * pide datos al usuario para poder dar de alta a un entrenador
     */
    private void altaEntrenador() {
        try {
            sc = new Scanner(System.in);
            int insertado ;
            System.out.println("Pon el nombre del nuevo entrenador");
            String nombre = sc.nextLine();
            System.out.println("Pon el password");
            String password = sc.nextLine();
            Entrenador nuevo = new Entrenador(nombre, password);
            //llamar al dao existeEntrenador
            //if.... 
            insertado = entrenadores.altaEntrenador(nuevo);
            if (insertado > 0)
            {
                System.out.println("Se ha insertado el nuevo entrenador ");
            }
            else
            {
                System.out.println("Error insertando entrenador");
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL insertando entrenador" + ex.getMessage());
        }
        
    }

    private void borrarEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void ConsultaEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void consultaEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cazarPokemon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listarMochila() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listarTodosPokemons() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void salir() {
        try {
            System.out.println("Te esperamos pronto de vuelta... ");
            entrenadores.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("Error cerrar conexi�n " + ex.getMessage());
        }
    }

    private void listarEntrenadores() {
        try{
            List<Entrenador> todos = entrenadores.totsEntrenadors();
            for (Entrenador trainer : todos) {
                System.out.println(trainer);
            }
            System.out.println("Numero de entrenadores: " + todos.size());
        }catch(SQLException ex){
            System.out.println("Error al listar " + ex.getMessage());

        
        }  
    }
        
}
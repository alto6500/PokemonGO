/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import menuUtils.MenuDaw;
import menuUtils.OptionDuplicateException;

/**
 *
 * @author alto6500
 */
public class PokemonGO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PokemonGO app = new PokemonGO();
        app.run();
        
       MenuDaw menu = new MenuDaw("Gestio de cues");
       int opcio;
       boolean exit = false;
       addAllOptions(menu); 
       
       do
       {
          opcio = menu.displayMenu();
          switch(opcio)
            {
                case 1: altaEntrenador();
             
                    break;
                case 2:    bajaEntrenador();
            
                    break;
                case 3:    consultaEntrenador();
             
                    break;                    
                case 4:    CazarPokemon();
       
                    break;             
                case 5:    PokemonsCazados();
           
                    break; 
                case 6:    PokemonsExistentes();
           
                    break;     
                case 0: //Sortir
                    exit = true;
                    break;
            } 
       }while(!exit);
    }
    
    
    private static void addAllOptions(MenuDaw menu) {
        try {
            menu.addOption("Salir");
            menu.addOption("Dar de alta entrenador");
            menu.addOption("Dar de baja entrenador");
            menu.addOption("Consultar entrenador");
            menu.addOption("Cazar Pokemon");
            menu.addOption("Listar Pokemons cazados");
            menu.addOption("Listar tipos Pokemons existentes en el juego");
        } catch (OptionDuplicateException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void PokemonsExistentes() {
        System.out.println("Funcion del Pokemon creada");
    }

    private static void PokemonsCazados() {
        System.out.println("Funcion del Pokemon creada");
    }

    private static void CazarPokemon() {
        System.out.println("Funcion del Pokemon creada");
    }

    private static void consultaEntrenador() {
        System.out.println("Funcion del Pokemon creada");
    }

    private static void bajaEntrenador() {
        System.out.println("Funcion del Pokemon creada");
    }

    private static void altaEntrenador() {
        System.out.println("Funcion del Pokemon creada");
    }

    private void run() {
        /*mostrar caratula*/
        /*recuperar datos fichero de caratula*/
        /*mostrar por pantalla caratula*/
        /*recorrer ArraylistString y mostrarlo por pantalla*/
        
        
        /*mostrar el menu*/
        /*con o sale con las demas poner frase..."has elegido la opcion.."*/
        
        /*De la fase 2 hace modelo entitat-relació y model relacional*/

    }
    
}

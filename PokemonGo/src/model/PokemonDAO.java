/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mabardaji
 */
public class PokemonDAO {
//atribut per la conexió 
 //atribut per la conexió
    Connection conn_principal;

    public PokemonDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }    
    
    
    public List<Pokemon> getAllPokemons() throws SQLException
    {
        List<Pokemon> all_pokemon = null;
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select num,name,type"
                    + " from Pokedex";
            
            ResultSet cursor = stmt.executeQuery(query);
            all_pokemon = new ArrayList<>();
            while(cursor.next())
            {
                int num = cursor.getInt(1);
                String nom = cursor.getString("name");
                String contrasenya = cursor.getString("type");
                

                all_pokemon.add(new Pokemon(num, nom, contrasenya));
            }
             cursor.close();
        }
        return all_pokemon;        
    }
    
    public Pokemon getPokemonRandom() throws SQLException
    {
        List<Pokemon> all_pokemon = this.getAllPokemons();
        int max = all_pokemon.size();
        
        Random rd = new Random();
        int valor = rd.nextInt(max);
        
        return all_pokemon.get(valor);
        
    }
    
    public String getNombrePokemon(int num) throws SQLException
    {
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select name"
                    + " from Pokedex where num = " + num;
            
            ResultSet cursor = stmt.executeQuery(query);
            if (cursor.next())
            {
                return cursor.getString(1);
            }
        }
        return null;
    }
    
    public boolean existePokemon(String name) throws SQLException
    {
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            
            String query2 = "Select count(*) "
                    + " from pokedex where UPPER(name)"
                    + " = '" + name.toUpperCase() + "'";
            
            System.out.println(query2);
            ResultSet cursor = stmt.executeQuery(query2);
            if (cursor.next())
            {
                int registros = cursor.getInt(1);
                if (registros==1)
                {
                    return true;    
                }
                else
                {
                    return false;
                }
                
            }
            else
            {
                return false;
            }
        }
        return false;
        
    }
    
    public Pokemon esborrarPokemon(String name) throws SQLException
    {
        if (this.existePokemon(name))
        {
            Pokemon borrar = this.devolverPokemon(name);
            
            Statement stmt = conn_principal.createStatement();
            String query = "Delete "
                    + " from pokedex where upper(name) = '" + name.toUpperCase() + "'";
            
            int row = stmt.executeUpdate(query);
            if (row>0)
            {
                return borrar;
            }
            else
            {
                return null;
            }
            
        }
        else
            return null;
    }
    
    public Pokemon devolverPokemon(String name) throws SQLException
    {
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select num, name, type"
                    + " from pokedex where UPPER(name)"
                    + " = '" + name.toUpperCase() + "'";
            ResultSet cursor = stmt.executeQuery(query);
            if (cursor.next()) //existe //FETCH
            {
                int num = cursor.getInt(1);
                String nom = cursor.getString("name");
                String tipo = cursor.getString("type");
                
                Pokemon encontrado = new Pokemon(num, nom, tipo);
                return encontrado;
            }
            else
            {
                //return new Entrenador(0,"","");
                return null;
            }
            
        }
        else
        {
            return null;
        }
        
    }
}

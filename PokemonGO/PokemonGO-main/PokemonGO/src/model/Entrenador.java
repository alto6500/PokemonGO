/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alto6500
 */
public class Entrenador {
    private String nom;
    private String contrasenya;
    private int id;

    public Entrenador(String nom, String contrasenya, int id) {
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.id = id;
    }

    public Entrenador(String nom, String contrasenya) {
        this.id = 0;
        this.nom = nom;
        this.contrasenya = contrasenya;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "nom=" + nom + ", contrasenya=" + contrasenya + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entrenador)) {
            return false;
        }
        final Entrenador other = (Entrenador) obj;
        return this.id == other.id;
    }
    
    
    
}

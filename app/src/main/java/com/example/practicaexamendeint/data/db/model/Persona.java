package com.example.practicaexamendeint.data.db.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by carlos on 11/12/2017.
 */

public class Persona implements Comparable<Persona>, Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String pais;
    private String telefono;

    public Persona(String nombre, String apellido, int edad, String pais, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Orden por defecto por nombre
    @Override
    public int compareTo(@NonNull Persona persona) {
        return this.getNombre().compareTo(persona.apellido);
    }
}

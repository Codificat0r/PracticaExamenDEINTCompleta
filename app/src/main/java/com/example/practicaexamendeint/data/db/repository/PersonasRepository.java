package com.example.practicaexamendeint.data.db.repository;

import com.example.practicaexamendeint.data.db.model.Persona;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by carlos on 11/12/2017.
 */

public class PersonasRepository {
    private ArrayList<Persona> personas;
    private static PersonasRepository personasRepository;

    static {
        personasRepository = new PersonasRepository();
    }

    private PersonasRepository() {
        personas = new ArrayList<>();
        inicializar();
    }

    public void addPersona(Persona persona) {
        personas.add(persona);
    }

    private void inicializar() {
        addPersona(new Persona("Carlos", "Cruz", 20, "España", "680805232"));
        addPersona(new Persona("Pepe", "Pérez", 18, "España", "645566454"));
        addPersona(new Persona("Antonio", "Cáñamo", 25, "España", "678345643"));
        addPersona(new Persona("Maria", "Roto", 34, "España", "656121312"));
        addPersona(new Persona("Oscar", "Laville", 22, "España", "667887564"));
    }

    public static PersonasRepository getInstance() {
        return personasRepository;
    }

    public ArrayList<Persona> getPersonas() {
        Collections.sort(personas);
        return personas;
    }
}

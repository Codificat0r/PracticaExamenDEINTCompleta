package com.example.practicaexamendeint.ui.utils.comparator;

import com.example.practicaexamendeint.data.db.model.Persona;

import java.util.Comparator;

public class ComparatorOrdenarApellido implements Comparator<Persona> {
    @Override
    public int compare(Persona persona, Persona t1) {
        return persona.getApellido().compareTo(t1.getApellido());
    }
}

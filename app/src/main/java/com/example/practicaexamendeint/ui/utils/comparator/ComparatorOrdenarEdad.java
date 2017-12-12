package com.example.practicaexamendeint.ui.utils.comparator;

import com.example.practicaexamendeint.data.db.model.Persona;

import java.util.Comparator;

/**
 * Created by carlos on 12/12/2017.
 */

public class ComparatorOrdenarEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona persona, Persona t1) {
        if (persona.getEdad() > t1.getEdad())
            return 1;
        else if (persona.getEdad() == t1.getEdad())
            return 0;
        else
            return -1;
    }
}

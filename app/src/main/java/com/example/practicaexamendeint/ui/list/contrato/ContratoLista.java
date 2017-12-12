package com.example.practicaexamendeint.ui.list.contrato;

import android.content.Context;

import com.example.practicaexamendeint.adapter.PersonasAdapter;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.utils.comparator.ComparatorOrdenarApellido;
import com.example.practicaexamendeint.ui.utils.comparator.ComparatorOrdenarEdad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/12/2017.
 */

public interface ContratoLista {
    interface Vista {
        void cargarPersonas(List<Persona> personas);
        void mostrarLista(boolean mostrarLista);
    }

    interface Presentador {
        void pedirPersonas();
        void ordenarPorEdad(PersonasAdapter adapter);
        void ordenarPorApellido(PersonasAdapter adapter);
        void pedirPreferenciaMostrarLista(Context contexto);
        void pedirBorrarPersona(Persona persona);
    }
}

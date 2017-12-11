package com.example.practicaexamendeint.ui.list.contrato;

import com.example.practicaexamendeint.data.db.model.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/12/2017.
 */

public interface ContratoLista {
    interface Vista {
        void cargarPersonas(List<Persona> personas);
    }

    interface Presentador {
        void pedirPersonas();
    }
}

package com.example.practicaexamendeint.ui.list.interactor;

import android.content.Context;

import com.example.practicaexamendeint.data.db.model.Persona;

/**
 * Created by carlos on 11/12/2017.
 */

public interface ListaInteractor {
    void obtenerPersonas();
    void obtenerPreferenciaMostrarLista(Context contexto);
    void borrarPersona(Persona persona);
}

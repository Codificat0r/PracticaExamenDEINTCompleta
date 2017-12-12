package com.example.practicaexamendeint.ui.list.interactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.data.db.repository.PersonasRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/12/2017.
 */

public class ListaInteractorImpl implements ListaInteractor {
    OnPeticionesFinalizadasListener listener;

    public ListaInteractorImpl(OnPeticionesFinalizadasListener listener) {
        this.listener = listener;
    }

    public interface OnPeticionesFinalizadasListener {
        void onExitoObtenerPersonas(List<Persona> personas);
        void onExitoObtenerPreferenciaMostrarLista(boolean mostrarLista);
        void onExitoBorrarPersona(List<Persona> personas);
    }

    @Override
    public void obtenerPersonas() {
        List<Persona> personas = PersonasRepository.getInstance().getPersonas();
        listener.onExitoObtenerPersonas(personas);
    }

    @Override
    public void obtenerPreferenciaMostrarLista(Context contexto) {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(contexto);
        listener.onExitoObtenerPreferenciaMostrarLista(preferencias.getBoolean("mostrar_lista", true));
    }

    @Override
    public void borrarPersona(Persona persona) {
        List<Persona> personas = PersonasRepository.getInstance().getPersonas();
        personas.remove(persona);
        listener.onExitoBorrarPersona(personas);
    }
}

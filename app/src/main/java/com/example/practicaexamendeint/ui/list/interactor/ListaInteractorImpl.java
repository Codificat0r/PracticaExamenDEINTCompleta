package com.example.practicaexamendeint.ui.list.interactor;

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
    }

    @Override
    public void obtenerPersonas() {
        List<Persona> personas = PersonasRepository.getInstance().getPersonas();
        listener.onExitoObtenerPersonas(personas);
    }
}

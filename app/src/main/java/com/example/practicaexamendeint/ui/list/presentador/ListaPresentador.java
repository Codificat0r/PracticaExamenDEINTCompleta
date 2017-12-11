package com.example.practicaexamendeint.ui.list.presentador;

import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoLista;
import com.example.practicaexamendeint.ui.list.interactor.ListaInteractor;
import com.example.practicaexamendeint.ui.list.interactor.ListaInteractorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/12/2017.
 */

public class ListaPresentador implements ContratoLista.Presentador, ListaInteractorImpl.OnPeticionesFinalizadasListener {
    ContratoLista.Vista vista;
    ListaInteractor interactor;

    public ListaPresentador(ContratoLista.Vista vista) {
        this.vista = vista;
        interactor = new ListaInteractorImpl(this);
    }

    @Override
    public void pedirPersonas() {
        interactor.obtenerPersonas();
    }

    @Override
    public void onExitoObtenerPersonas(List<Persona> personas) {
        vista.cargarPersonas(personas);
    }
}

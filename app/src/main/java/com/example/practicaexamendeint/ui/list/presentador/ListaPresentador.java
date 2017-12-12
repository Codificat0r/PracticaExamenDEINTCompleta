package com.example.practicaexamendeint.ui.list.presentador;

import android.content.Context;

import com.example.practicaexamendeint.adapter.PersonasAdapter;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoLista;
import com.example.practicaexamendeint.ui.list.interactor.ListaInteractor;
import com.example.practicaexamendeint.ui.list.interactor.ListaInteractorImpl;
import com.example.practicaexamendeint.ui.utils.comparator.ComparatorOrdenarApellido;
import com.example.practicaexamendeint.ui.utils.comparator.ComparatorOrdenarEdad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 11/12/2017.
 */

public class ListaPresentador implements ContratoLista.Presentador, ListaInteractorImpl.OnPeticionesFinalizadasListener {
    private ContratoLista.Vista vista;
    private ListaInteractor interactor;
    private ComparatorOrdenarApellido comparatorOrdenarApellido;
    private ComparatorOrdenarEdad comparatorOrdenarEdad;

    public ListaPresentador(ContratoLista.Vista vista) {
        this.vista = vista;
        interactor = new ListaInteractorImpl(this);
        comparatorOrdenarApellido = new ComparatorOrdenarApellido();
        comparatorOrdenarEdad = new ComparatorOrdenarEdad();
    }

    @Override
    public void pedirPersonas() {
        interactor.obtenerPersonas();
    }

    @Override
    public void ordenarPorEdad(PersonasAdapter adapter) {
        adapter.sort(comparatorOrdenarEdad);
    }

    @Override
    public void ordenarPorApellido(PersonasAdapter adapter) {
        adapter.sort(comparatorOrdenarApellido);
    }

    @Override
    public void onExitoObtenerPersonas(List<Persona> personas) {
        vista.cargarPersonas(personas);
    }

    @Override
    public void pedirPreferenciaMostrarLista(Context contexto) {
        interactor.obtenerPreferenciaMostrarLista(contexto);
    }

    @Override
    public void onExitoObtenerPreferenciaMostrarLista(boolean mostrarLista) {
        vista.mostrarLista(mostrarLista);
    }

    @Override
    public void pedirBorrarPersona(Persona persona) {
        interactor.borrarPersona(persona);
    }

    @Override
    public void onExitoBorrarPersona(List<Persona> personas) {
        vista.cargarPersonas(personas);
    }

}

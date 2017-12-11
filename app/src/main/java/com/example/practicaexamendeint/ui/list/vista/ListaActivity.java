package com.example.practicaexamendeint.ui.list.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.practicaexamendeint.R;
import com.example.practicaexamendeint.adapter.PersonasAdapter;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoLista;
import com.example.practicaexamendeint.ui.list.presentador.ListaPresentador;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity implements ContratoLista.Vista {
    private ContratoLista.Presentador presentador;
    private FloatingActionButton fab;
    private ListView lstvPersonas;
    private Toolbar toolbar;
    private PersonasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        inicializar();

        setSupportActionBar(toolbar);
        lstvPersonas.setAdapter(adapter);

        presentador = new ListaPresentador(this);

        presentador.pedirPersonas();
    }

    private void inicializar() {
        adapter = new PersonasAdapter(this);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstvPersonas = (ListView) findViewById(R.id.lstvPersonas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void cargarPersonas(List<Persona> personas) {
        adapter.clear();
        adapter.addAll(personas);
    }
}

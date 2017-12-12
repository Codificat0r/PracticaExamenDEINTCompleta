package com.example.practicaexamendeint.ui.list.vista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practicaexamendeint.R;
import com.example.practicaexamendeint.adapter.PersonasAdapter;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoEditarAnadirPersona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoLista;
import com.example.practicaexamendeint.ui.list.presentador.ListaPresentador;
import com.example.practicaexamendeint.ui.prefs.PreferenciasActivity;

import java.util.List;

public class ListaActivity extends AppCompatActivity implements ContratoLista.Vista {
    private ContratoLista.Presentador presentador;
    private FloatingActionButton fab;
    private ListView lstvPersonas;
    private Toolbar toolbar;
    private PersonasAdapter adapter;
    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        inicializar();

        setSupportActionBar(toolbar);
        lstvPersonas.setAdapter(adapter);
        preferencias = PreferenceManager.getDefaultSharedPreferences(this);

        presentador = new ListaPresentador(this);

        presentador.pedirPersonas();

        presentador.pedirPreferenciaMostrarLista(this);
    }

    private void inicializar() {
        adapter = new PersonasAdapter(this);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstvPersonas = (ListView) findViewById(R.id.lstvPersonas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        registerForContextMenu(lstvPersonas);
        lstvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ListaActivity.this, EditarAnadirPersonaActivity.class);
                i.putExtra("persona", adapter.getItem(position));
                i.putExtra("accion", ContratoEditarAnadirPersona.EDITAR);
                startActivity(i);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaActivity.this, EditarAnadirPersonaActivity.class);
                i.putExtra("accion", ContratoEditarAnadirPersona.ANADIR);
                startActivity(i);
            }
        });
    }

    @Override
    public void cargarPersonas(List<Persona> personas) {
        adapter.clear();
        adapter.addAll(personas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmOrdenarPorEdad:
                presentador.ordenarPorEdad(adapter);
                break;
            case R.id.mitmOrdenarPorApellido:
                presentador.ordenarPorApellido(adapter);
                break;
            case R.id.mitmPreferencias:
                Intent i = new Intent(ListaActivity.this, PreferenciasActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presentador.pedirPreferenciaMostrarLista(this);
        //Recargamos por si se viene de una edición o de añadir
        presentador.pedirPersonas();
    }

    @Override
    public void mostrarLista(boolean mostrarLista) {
        if (mostrarLista)
            lstvPersonas.setVisibility(View.VISIBLE);
        else
            lstvPersonas.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Opciones de la persona");
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Persona persona = adapter.getItem(info.position);
        if (item.getItemId() == R.id.mitmBorrar) {
            presentador.pedirBorrarPersona(persona);
        }
        return super.onContextItemSelected(item);
    }


}

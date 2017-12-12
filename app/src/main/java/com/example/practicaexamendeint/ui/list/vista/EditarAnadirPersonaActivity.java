package com.example.practicaexamendeint.ui.list.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.practicaexamendeint.R;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoEditarAnadirPersona;
import com.example.practicaexamendeint.ui.list.presentador.EditarAnadirPersonaPresenter;

public class EditarAnadirPersonaActivity extends AppCompatActivity implements ContratoEditarAnadirPersona.Vista {

    private TextInputEditText edtNombre;
    private TextInputEditText edtApellido;
    private TextInputEditText edtPais;
    private TextInputEditText edtEdad;
    private TextInputEditText edtTelefono;
    private TextInputLayout tilNombre;
    private TextInputLayout tilApellido;
    private TextInputLayout tilPais;
    private TextInputLayout tilEdad;
    private TextInputLayout tilTelefono;
    private FloatingActionButton fab;
    private int accion;
    private Persona personaAEditar;
    private ContratoEditarAnadirPersona.Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        inicializar();

        if (accion == ContratoEditarAnadirPersona.EDITAR) {
            personaAEditar = (Persona) getIntent().getSerializableExtra("persona");
            edtNombre.setText(personaAEditar.getNombre());
            edtApellido.setText(personaAEditar.getApellido());
            edtPais.setText(personaAEditar.getPais());
            edtEdad.setText(Integer.toString(personaAEditar.getEdad()));
            edtTelefono.setText(personaAEditar.getTelefono());
        }
    }

    private void inicializar() {
        edtNombre = (TextInputEditText) findViewById(R.id.edtNombre);
        edtApellido = (TextInputEditText) findViewById(R.id.edtApellido);
        edtPais = (TextInputEditText) findViewById(R.id.edtPais);
        edtEdad = (TextInputEditText) findViewById(R.id.edtEdad);
        edtTelefono = (TextInputEditText) findViewById(R.id.edtTelefono);
        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        tilApellido = (TextInputLayout) findViewById(R.id.tilApellido);
        tilPais = (TextInputLayout) findViewById(R.id.tilPais);
        tilEdad = (TextInputLayout) findViewById(R.id.tilEdad);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        accion = getIntent().getIntExtra("accion", 0);
        presentador = new EditarAnadirPersonaPresenter(this);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accion == ContratoEditarAnadirPersona.ANADIR) {
                    presentador.pedirValidarDatosParaAnadir(edtNombre.getText().toString(), edtApellido.getText().toString(), edtPais.getText().toString(), edtEdad.getText().toString(), edtTelefono.getText().toString());
                }
                if (accion == ContratoEditarAnadirPersona.EDITAR) {
                    presentador.pedirValidarDatosParaEditar(personaAEditar, edtNombre.getText().toString(), edtApellido.getText().toString(), edtPais.getText().toString(), edtEdad.getText().toString(), edtTelefono.getText().toString());
                }
            }
        });
    }

    @Override
    public void onNombreError() {
        tilNombre.setError("El nombre no puede estar vacío");
        tilApellido.setError(null);
        tilTelefono.setError(null);
        tilEdad.setError(null);
        tilPais.setError(null);
    }

    @Override
    public void onApellidoError() {
        tilApellido.setError("El apellido no puede estar vacío");
        tilNombre.setError(null);
        tilTelefono.setError(null);
        tilEdad.setError(null);
        tilPais.setError(null);
    }

    @Override
    public void onPaisError() {
        tilPais.setError("El pais no puede estar vacío");
        tilNombre.setError(null);
        tilTelefono.setError(null);
        tilEdad.setError(null);
        tilApellido.setError(null);
    }

    @Override
    public void onEdadError() {
        tilEdad.setError("La edad no puede estar vacía y debe cumplir la restricción de longitud");
        tilNombre.setError(null);
        tilTelefono.setError(null);
        tilApellido.setError(null);
        tilPais.setError(null);
    }

    @Override
    public void onTelefonoError() {
        tilTelefono.setError("El telefono no puede estar vacío y debe cumplir la restricción de longitud");
        tilNombre.setError(null);
        tilApellido.setError(null);
        tilEdad.setError(null);
        tilPais.setError(null);
    }

    @Override
    public void onExito() {
        finish();
    }
}

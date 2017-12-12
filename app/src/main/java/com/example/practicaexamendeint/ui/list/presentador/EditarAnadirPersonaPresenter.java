package com.example.practicaexamendeint.ui.list.presentador;

import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.ui.list.contrato.ContratoEditarAnadirPersona;
import com.example.practicaexamendeint.ui.list.interactor.EditarAnadirPersonaInteractor;
import com.example.practicaexamendeint.ui.list.interactor.EditarAnadirPersonaInteractorImpl;

/**
 * Created by carlos on 12/12/2017.
 */

public class EditarAnadirPersonaPresenter implements ContratoEditarAnadirPersona.Presentador, EditarAnadirPersonaInteractorImpl.OnPeticionesFinalizadasListener {
    private ContratoEditarAnadirPersona.Vista vista;
    private EditarAnadirPersonaInteractor interactor;

    public EditarAnadirPersonaPresenter(ContratoEditarAnadirPersona.Vista vista) {
        this.vista = vista;
        interactor = new EditarAnadirPersonaInteractorImpl(this);
    }

    @Override
    public void pedirValidarDatosParaEditar(Persona personaAEditar, String nombre, String apellido, String pais, String edad, String telefono) {
        interactor.validarDatosParaEditar(personaAEditar, nombre, apellido, pais, edad, telefono);
    }

    @Override
    public void pedirValidarDatosParaAnadir(String nombre, String apellido, String pais, String edad, String telefono) {
        interactor.validarDatosParaAnadir(nombre, apellido, pais, edad, telefono);
    }

    @Override
    public void onExitoPeticion() {
        vista.onExito();
    }

    @Override
    public void onErrorEnNombre() {
        vista.onNombreError();
    }

    @Override
    public void onErrorEnApellido() {
        vista.onApellidoError();
    }

    @Override
    public void onErrorEnPais() {
        vista.onPaisError();
    }

    @Override
    public void onErrorEnEdad() {
        vista.onEdadError();
    }

    @Override
    public void onErrorEnTelefono() {
        vista.onTelefonoError();
    }
}

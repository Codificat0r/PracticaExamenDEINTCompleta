package com.example.practicaexamendeint.ui.list.interactor;

import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.data.db.repository.PersonasRepository;
import com.example.practicaexamendeint.ui.utils.CommonUtils;

import java.util.List;

/**
 * Created by carlos on 12/12/2017.
 */

public class EditarAnadirPersonaInteractorImpl implements EditarAnadirPersonaInteractor{
    private OnPeticionesFinalizadasListener listener;

    public EditarAnadirPersonaInteractorImpl(OnPeticionesFinalizadasListener listener) {
        this.listener = listener;
    }

    public interface OnPeticionesFinalizadasListener {
        void onExitoPeticion();
        void onErrorEnNombre();
        void onErrorEnApellido();
        void onErrorEnPais();
        void onErrorEnEdad();
        void onErrorEnTelefono();
    }

    @Override
    public void validarDatosParaAnadir(String nombre, String apellido, String pais, String edad, String telefono) {
        if (!CommonUtils.campoLleno(nombre)) {
            listener.onErrorEnNombre();
        } else if (!CommonUtils.campoLleno(apellido)) {
            listener.onErrorEnApellido();
        } else if (!CommonUtils.campoLleno(pais)) {
            listener.onErrorEnPais();
        } else if (!CommonUtils.campoLleno(edad) || !CommonUtils.longitudCorrecta(edad, 2)) {
            listener.onErrorEnEdad();
        } else if (!CommonUtils.campoLleno(telefono) || !CommonUtils.longitudCorrecta(telefono, 9)) {
            listener.onErrorEnTelefono();
        } else {
            List<Persona> personas = PersonasRepository.getInstance().getPersonas();
            personas.add(new Persona(nombre, apellido, Integer.parseInt(edad), pais, telefono));
            listener.onExitoPeticion();
        }
    }

    @Override
    public void validarDatosParaEditar(Persona personaAEditar, String nombre, String apellido, String pais, String edad, String telefono) {
        if (!CommonUtils.campoLleno(nombre)) {
            listener.onErrorEnNombre();
        } else if (!CommonUtils.campoLleno(apellido)) {
            listener.onErrorEnApellido();
        } else if (!CommonUtils.campoLleno(pais)) {
            listener.onErrorEnPais();
        } else if (!CommonUtils.campoLleno(edad) || !CommonUtils.longitudCorrecta(edad, 2)) {
            listener.onErrorEnEdad();
        } else if (!CommonUtils.campoLleno(telefono) || !CommonUtils.longitudCorrecta(telefono, 9)) {
            listener.onErrorEnTelefono();
        } else {
            List<Persona> personas = PersonasRepository.getInstance().getPersonas();
            Persona personaNueva = new Persona(nombre, apellido, Integer.parseInt(edad), pais, telefono);
            personas.remove(personaAEditar);
            personas.add(personaNueva);
            listener.onExitoPeticion();
        }
    }
}

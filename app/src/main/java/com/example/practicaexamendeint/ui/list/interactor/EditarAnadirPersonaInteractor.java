package com.example.practicaexamendeint.ui.list.interactor;

import com.example.practicaexamendeint.data.db.model.Persona;

/**
 * Created by carlos on 12/12/2017.
 */

public interface EditarAnadirPersonaInteractor {
    void validarDatosParaAnadir(String nombre, String apellido, String pais, String edad, String telefono);
    void validarDatosParaEditar(Persona personaAEditar, String nombre, String apellido, String pais, String edad, String telefono);
}

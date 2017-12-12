package com.example.practicaexamendeint.ui.list.contrato;

import com.example.practicaexamendeint.data.db.model.Persona;

/**
 * Created by carlos on 12/12/2017.
 */

public interface ContratoEditarAnadirPersona {
    int EDITAR = 0;
    int ANADIR = 1;

    interface Vista {
        void onNombreError();
        void onApellidoError();
        void onPaisError();
        void onEdadError();
        void onTelefonoError();
        void onExito();
    }

    interface Presentador {
        void pedirValidarDatosParaEditar(Persona personaAEditar, String nombre, String apellido, String pais, String edad, String telefono);
        void pedirValidarDatosParaAnadir(String nombre, String apellido, String pais, String edad, String telefono);
    }
}

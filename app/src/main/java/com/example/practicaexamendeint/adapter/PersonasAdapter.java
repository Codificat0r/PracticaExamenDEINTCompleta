package com.example.practicaexamendeint.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicaexamendeint.R;
import com.example.practicaexamendeint.data.db.model.Persona;
import com.example.practicaexamendeint.data.db.repository.PersonasRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 11/12/2017.
 */

public class PersonasAdapter extends ArrayAdapter<Persona>{


    public PersonasAdapter(@NonNull Context context) {
        //Tiene un ArrayList vacío a la espera de que el interactor le mande
        //los datos a la vista para que los cargue
        super(context, R.layout.item_persona, new ArrayList<Persona>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PersonaHolder personaHolder;
        View view = convertView;

        if (view == null) {
            //Obtengo el LayoutInflater del sistema.
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            personaHolder = new PersonaHolder();

            //Inflo la vista
            view = inflater.inflate(R.layout.item_persona, null);

            //Obtengo la referencia a memoria de los elementos de la vista inflada,
            //que es un item de la lista
            personaHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            personaHolder.txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);
            personaHolder.txvEdad = (TextView) view.findViewById(R.id.txvEdad);

            //Le pongo el tag de su PersonaHolder para poder obtener dicho
            //PersonaHolder cuando vayamos a reutilizar una de las vistas
            view.setTag(personaHolder);
        } else {
            //Si ya existia, lo podemos reutilizar. Para ello obtenermos
            //el PersonaHolder de su tag para poder establecer los textos
            //y el MaterialLetterIcon.
            personaHolder = (PersonaHolder) view.getTag();
        }
        //Guardo la persona por la que va actualmente
        Persona persona = getItem(position);

        //Relleno los elementos de la vista con los datos de la persona actual
        personaHolder.icon.setLetter(persona.getNombre().substring(0,1));
        personaHolder.txvNombreApellido.setText(persona.getNombre() + " " + persona.getApellido());
        //Aqui los integer y tipos deben ser convertidos explicitamente a String si no da un error muy raro
        //que lia mucho y hace perder mucho tiempo:
        personaHolder.txvEdad.setText(Integer.toString(persona.getEdad()));

        //Devuelvo la vista
        return view;
    }

    private class PersonaHolder {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        TextView txvEdad;
    }
}

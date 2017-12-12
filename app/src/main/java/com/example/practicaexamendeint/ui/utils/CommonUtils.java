package com.example.practicaexamendeint.ui.utils;

/**
 * Created by carlos on 12/12/2017.
 */

public class CommonUtils {
    public static boolean campoLleno(String texto) {
        if (texto.trim().isEmpty())
            return false;
        return true;
    }

    public static boolean longitudCorrecta(String texto, int longitudMaxima) {
        if (texto.length() <= longitudMaxima)
            return true;
        return false;
    }
}

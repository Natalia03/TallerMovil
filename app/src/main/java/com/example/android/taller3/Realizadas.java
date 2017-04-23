package com.example.android.taller3;

import java.util.ArrayList;

/**
 * Created by NATALIA MARTINEZ on 22/04/2017.
 */

public class Realizadas {
    private static ArrayList<Listado> ope= new ArrayList<>();

    public static void GuardarCambio(Listado opciones){

        ope.add(opciones);
    }

    public static ArrayList<Listado> getOperaciones(){
        return ope;

    }


}

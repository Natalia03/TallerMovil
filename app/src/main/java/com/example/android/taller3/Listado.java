package com.example.android.taller3;

/**
 * Created by NATALIA MARTINEZ on 22/04/2017.
 */

public class Listado {
    private String Resultados, Operaciones,Datos;

    public Listado(String resultados, String operaciones, String datos) {
        Resultados = resultados;
        Operaciones = operaciones;
        Datos = datos;
    }

    public String getResultados() {
        return Resultados;
    }

    public String getOperaciones() {
        return Operaciones;
    }

    public String getDatos() {
        return Datos;
    }

    public void setResultados(String resultados) {
        Resultados = resultados;
    }

    public void setOperaciones(String operaciones) {
        Operaciones = operaciones;
    }

    public void setDatos(String datos) {
        Datos = datos;
    }

    public void Guardar (){
        Realizadas.GuardarCambio(this);
    }

}

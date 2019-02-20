package com.androiddesdecero.referenciaametodos;

import android.util.Log;

/**
 * Created by albertopalomarrobledo on 18/2/19.
 */

public class User {

    private String nombre;

    public User(String nombre){
        this.nombre = nombre;
    }

    public static void referenciaAMetodoEstatico(){
        Log.d("TAG1", "probando referencia metodo estatico");
    }

    public void referenciaAMetodoObjetoParticular(){
        Log.d("TAG1", "probando referencia a Metodo Objeto Particular");
    }

    public void mostrarNombre(){
        Log.d("TAG1", nombre);
    }
}

package com.androiddesdecero.referenciaametodos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 18/2/19.
 */

public class MetodosReferencia {

    private List<String> lista = new ArrayList<>();

    public static void referenciaAMetodoEstatico(){
        Log.d("TAG1", "probando referencia metodo estatico");
    }

    public void referenciaAMetodoObjetoParticular(){
        Log.d("TAG1", "probando referencia metodo estatico");
    }

    public void referenciaAMetodoObjetoArbitrario(String palabra){
        palabra.toUpperCase();
        Log.d("TAG1", palabra);
    }

    private void setUpLista(){
        lista.clear();
        lista.add("java");
        lista.add("pytON");
        lista.add("pHp");
        lista.add("kotlin");
    }
}

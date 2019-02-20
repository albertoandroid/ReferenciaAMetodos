package com.androiddesdecero.referenciaametodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Transformation;

import java.util.ArrayList;
import java.util.List;
/*
        Referencias a Metodos
        :: Doble Colon Operator
        La Referencia del Método es una forma corta de una expresión lambda que contiene solo
        una llamada a un método.
        Es decir nos permite reducir aún más el código que una expresión lambda
        ¿Pero como es posible, si las LAMBDAs ya nos reducen el codigo?
        Normalmente usamos las expresiones lambda para crear métodos anómimos que devuelven
        el resutlado deseado en nuestra app.
        Pero en muchas ocasiones las expresiones lambda solo llamán a un método
        que ya existe y no hay nada más de codigo.
        Debido a que en este tipo de casos la expresión lambda llama a un método existente,
        la referencia a metodo puede usarse en lugar de la función lambda.
        Clase::metodo

        Tipos de metodos de Referencia
        Tipo                    Syntax                      Method Reference            Lambda expresion
        --------------------------------------------------------------------------------------------------
        Referencia a            Class::staticMethod        Math::abs                   n -> Math.abs(n)
        static method
        --------------------------------------------------------------------------------------------------
        Referencia a un         instancia::metodoInstancia  s:toString                  ()->"string".toString
        método de instancia
        de un objeto
        particular
        --------------------------------------------------------------------------------------------------
        Referencia a un         Class::metodoInstancia      String::toString            s -> s.toString()
        método de instancia
        de un objeto
        arbitrario de
        un tipo particular
        --------------------------------------------------------------------------------------------------
        Referencia a un         Class::new                  String::new                 ()->new String
        Constructor
         */

public class MainActivity extends AppCompatActivity {

    List<String> lista = new ArrayList();
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        A nivel global en lugar de usar
        UNA CLASE ANONIMA
        podemos usar
        LAMBDA EXPRESSION
        y si solo llamamos a un método, podemos usar
        REFERENCIAS A METODOS.
         */
        /*
        Ejemplo de Referencia a Método Estatico
         */
        Trabajo trabajo = new Trabajo() {
            @Override
            public void accion() {
                User.referenciaAMetodoEstatico();
            }
        };
        Trabajo trabajoL = () -> User.referenciaAMetodoEstatico();
        Trabajo trabajoMR = User::referenciaAMetodoEstatico;
        //Probando Referencia a Método Estatico
        trabajoMR.accion();

        /*
        Ejemplo de Referencia a Método de un Objeto Particular
         */
        User metodosReferenciaObjeto = new User("Alberto");

        Trabajo trabajoL1 = ()->metodosReferenciaObjeto.referenciaAMetodoObjetoParticular();
        Trabajo trabajoMR1 = metodosReferenciaObjeto::referenciaAMetodoObjetoParticular;
        trabajoMR1.accion();

        /*
        Ejemplo de Referencia a Método de Objeto Arbitrario
         */
        TrabajoString trabajoString = (palabra) -> palabra.toUpperCase();
        TrabajoString trabajoString1 = String::toUpperCase;
        Log.d("TAG1", trabajoString1.accion("ho"));

        setUpLista();
        users.forEach(nombre -> nombre.mostrarNombre());
        users.forEach(User::mostrarNombre);

        /*
        Ejemplo de Referencia a Un Constructor
         */
        IUser user = new IUser() {
            @Override
            public User crear(String nombre) {
                return new User(nombre);
            }
        };
        IUser user1 = (nombre -> new User(nombre));
        IUser user2 = User::new;
        user2.crear("Hola");


        lista.forEach(String::toUpperCase);
        lista.forEach(s -> s.toString());
        lista.stream().forEach(s -> s.toString());


    }

    private void setUpLista(){
        lista.clear();
        lista.add("java");
        lista.add("pytON");
        lista.add("pHp");
        lista.add("kotlin");


        users.clear();
        users.add(new User("Alberto"));
        users.add(new User("Maria"));
        users.add(new User("Marta"));
        users.add(new User("Paco"));

    }


}

package com.example.franprimo.mathdice2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements ListaFragment.ListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recojo los datos que he enviado con el intent que pasaba a esta activity y se los asigno
        //a dos variables.
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String edad = bundle.getString("edad");

        //Muestro en consola los datos recibidos con el intent
        Log.i("Nombre:", nombre);
        Log.i("Edad:", edad);

        //Coloco el fragment lista en su contenedor estatico
        ListaFragment lf = (ListaFragment) getFragmentManager().findFragmentById(R.id.listaFragment);

        //Añado el perfil fragment al container
        PerfilFragment pf = new PerfilFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, pf).commit();
    }

    //Tenemos que crear este metodo porque es el que implementa al ListFragmentListener
    public void onListSelected(int position){
        if(position == 0){
            PerfilFragment pf = new PerfilFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, pf);
            transaction.commit();
        }

        if(position == 1){
            DetalleFragment df = new DetalleFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, df);
            transaction.commit();
        }

        if(position == 2){
            Toast t;
            t = Toast.makeText(this, "Esto abrirá el fragment dinamico de instrucciones", Toast.LENGTH_LONG);
            t.show();
        }

        if(position == 3){
            Toast t;
            t = Toast.makeText(this, "Esto abrirá el fragment dinamico de información", Toast.LENGTH_LONG);
            t.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

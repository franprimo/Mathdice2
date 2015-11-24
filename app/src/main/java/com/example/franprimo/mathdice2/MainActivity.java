package com.example.franprimo.mathdice2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements ListaFragment.ListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaFragment lf = (ListaFragment) getFragmentManager().findFragmentById(R.id.listaFragment);
        //DetalleFragment df = (DetalleFragment) getFragmentManager().findFragmentById(R.id.detalleFragment);
        VacioFragment vf = new VacioFragment();

        getFragmentManager().beginTransaction().add(R.id.fragment_container, vf).commit();
    }

    //Tenemos que crear este metodo porque es el que implementa al ListFragmentListener
    public void onListSelected(int position){
        if(position == 0){
            Toast t;
            t = Toast.makeText(this, "Esto abrirá el fragment dinamico del perfil", Toast.LENGTH_LONG);
            t.show();
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

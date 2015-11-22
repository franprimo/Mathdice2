package com.example.franprimo.mathdice2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements ListaFragment.ListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaFragment lf = (ListaFragment) getFragmentManager().findFragmentById(R.id.listaFragment);
        DetalleFragment df = (DetalleFragment) getFragmentManager().findFragmentById(R.id.detalleFragment);


    }

    //Tenemos que crear este metodo porque es el que implementa al ListFragmentListener
    public void onListSelected(int position, String item){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String name = item.getTitle().toString();

        DetalleFragment detalleF = new DetalleFragment();
        Bundle arg = new Bundle();
        arg.putString("name", name);
        detalleF.setArguments(arg);

        //Intento colocar el fragment dinamico en su lugar
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.detalleFragment, detalleF);
        ft.commit();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

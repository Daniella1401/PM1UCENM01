package com.example.pm1ucenm01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pm1ucenm01.configuraciones.Personas;
import com.example.pm1ucenm01.configuraciones.SQLiteConexion;
import com.example.pm1ucenm01.configuraciones.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDB, null, 1);
        listapersonas = (ListView) findViewById(R.id.listapersonas);

        ObtenerInfo();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloLista);
        listapersonas.setAdapter(adp);


        listapersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String elementoseleccionado = (String) adapterView.getItemAtPosition(i);

                Toast.makeText(getApplicationContext(),elementoseleccionado, Toast.LENGTH_LONG ).show();
            }
        });

    }

    private void ObtenerInfo()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas persona = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectPersonas,null);

        while(cursor.moveToNext())
        {
            persona = new Personas();
            persona.setId(cursor.getInt(0));
            persona.setNombres(cursor.getString(1));
            persona.setApellidos(cursor.getString(2));
            persona.setCorreo(cursor.getString(3));
            persona.setTelefono(cursor.getString(4));

            lista.add(persona);
        }

        cursor.close();

        Filldata();

    }

    private void Filldata()
    {
        ArregloLista = new ArrayList<String>();

        for(int i = 0;  i < lista.size(); i++)
        {
            ArregloLista.add(lista.get(i).getNombres() + " | " +
                    lista.get(i).getApellidos()  + " | " +
                    lista.get(i).getCorreo());
        }

    }
}
package com.jdcasas.lab_7act2;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button btnCFInterno;
    Button btnCFExterno;
    Button btnLFInterno;
    Button btnLFExterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCFInterno = (Button) findViewById(R.id.Boton);
        btnCFInterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EFMinterna();
            }
        });
        btnLFInterno = (Button) findViewById(R.id.Boton2);
        btnLFInterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LFMinterna();
            }
        });
        btnCFExterno = (Button) findViewById(R.id.Boton3);
        btnCFExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearFMExterna();
            }
        });
        btnLFExterno = (Button) findViewById(R.id.Boton4);
        btnLFExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leeFMExterna();
            }
        });

    }

    public void EFMinterna(){
        try{
            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));
            fout.write("Texto de prueba.");
            fout.close();
            Toast.makeText(this, "Escribir en fichero de memoria interna", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){Log.e("Ficheros", "Error al escribir fichero a memoria interna");}
    }

    public void LFMinterna(){
        try
        {
            BufferedReader fin =new BufferedReader(new InputStreamReader(openFileInput("prueba_int.txt")));
            String texto = fin.readLine();
            Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
            fin.close();
            Toast.makeText(this, "Leer fichero de memoria interna", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){Log.e("Ficheros", "Error al leer desde memoria interna");}
    }

    public void crearFMExterna(){
        try
        {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
            fout.write("Texto de prueba externo.");
            fout.close();
            Toast.makeText(this,"Crear fichero de memoria externa ", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){Log.d("Ficheros", "Error al escribir fichero a tarjeta SD");}
    }

    public void leeFMExterna(){
        try{
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
            fin.close();
            Toast.makeText(this, "Leer fichero de memoria Externa ", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){Log.d("Ficheros", "Error al leer fichero desde tarjeta SD");}
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

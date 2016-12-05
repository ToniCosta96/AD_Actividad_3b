package com.example.a2dam.ad_actividad_3b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        final TextView editTextDatos= (TextView) findViewById(R.id.textViewDatos);
        final Intent intent= getIntent();
        final StringBuilder sb= new StringBuilder();
        sb.append("Nombre: ");
        sb.append(intent.getStringExtra("nom"));
        sb.append("\nDNI: ");
        sb.append(intent.getStringExtra("dni"));
        sb.append("\nFecha: ");
        sb.append(intent.getStringExtra("fecha"));
        sb.append("\nSexo: ");
        if(intent.getBooleanExtra("hombre",true)){
            sb.append("Hombre");
        }else{
            sb.append("Mujer");
        }
        editTextDatos.setText(sb.toString());
    }
}

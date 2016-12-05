package com.example.a2dam.ad_actividad_3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNom = (EditText) findViewById(R.id.editTextNom);
        final EditText editTextDNI = (EditText) findViewById(R.id.editTextDNI);
        final EditText editTextFecha = (EditText) findViewById(R.id.editTextFecha);
        final RadioButton radioButtonHombre= (RadioButton) findViewById(R.id.radioButtonHombre);
        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Creamos o recuperamos el objeto de preferencias compartidas
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                // Obtenemos un editor para modificar las preferencias
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                // Guardamos nuevos valores
                editor.putString("nom",editTextNom.getText().toString());
                editor.putString("dni",editTextDNI.getText().toString());
                editor.putString("fecha",editTextFecha.getText().toString());
                editor.putBoolean("hombre", radioButtonHombre.isChecked());

                // Guardamos los cambios
                editor.commit();
                Toast.makeText(getApplicationContext(),"Información guardada",Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Recuperamos el objeto de preferencias compartidas
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                Intent datosActivityIntent= new Intent(getApplicationContext(), DatosActivity.class);
                // Recuperamos los valores guardados
                datosActivityIntent.putExtra("nom",mySharedPreferences.getString("nom",""));
                datosActivityIntent.putExtra("dni",mySharedPreferences.getString("dni",""));
                datosActivityIntent.putExtra("fecha",mySharedPreferences.getString("fecha",""));
                datosActivityIntent.putExtra("hombre",mySharedPreferences.getBoolean("hombre",true));
                startActivity(datosActivityIntent);
            }
        });
    }
}

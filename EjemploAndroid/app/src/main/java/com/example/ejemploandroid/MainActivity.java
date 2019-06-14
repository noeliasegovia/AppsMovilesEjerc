package com.example.ejemploandroid;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Instancias para manejar los botones

    private Button btn_enviar;
    private RadioGroup rg_respuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Asocio las instancias a la interfaz
        btn_enviar= (Button)findViewById(R.id.btn_enviar);
        rg_respuestas= (RadioGroup)findViewById(R.id.rg_respuestas);

        //Registro un listener para el boton
        btn_enviar.setOnClickListener(enviarListener);
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

    //Listener para el boton enviar
    private View.OnClickListener enviarListener= new View.OnClickListener() {


        @Override
        public void onClick(View view) {
            //Recupero el valor del radiogroup
            int radioButtonID = rg_respuestas.getCheckedRadioButtonId();
            View RadioButton = rg_respuestas.findViewById(radioButtonID);
            //Indice del radiobtn seleccionado
            int idx= rg_respuestas.indexOfChild(RadioButton);

            //abro la otra activity
            Intent intent = new Intent(MainActivity.this, MensajeActivity.class);
            Bundle b = new Bundle();
            b.putInt("opcion",idx);
            intent.putExtras(b);
            startActivity(intent);
        }
    };
}

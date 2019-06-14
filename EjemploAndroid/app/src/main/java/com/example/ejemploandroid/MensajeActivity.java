package com.example.ejemploandroid;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MensajeActivity extends AppCompatActivity {
    private TextView txt_mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //OPCION SELECCIONADA EN A OTRA ACTIVITY
        int opcion;
        //Asocio la instancia con la UI
        txt_mensaje = (TextView) findViewById(R.id.txt_mensaje);
        //obtengo el parametro
        Bundle bundle =getIntent().getExtras();
        opcion=bundle.getInt("opcion");

        //Cambio el mensaje
        actualizarMensaje(opcion);
    }

    private void actualizarMensaje(int opcion){
        switch (opcion){
            case 0:
                txt_mensaje.setText(R.string.mensaje1);
                break;

            case 1:
                txt_mensaje.setText(R.string.mensaje2);
                break;

            case 2:
                txt_mensaje.setText(R.string.mensaje3);
                break;
            case 3:
                txt_mensaje.setText(R.string.mensaje4);
                break;
        }
    }
}

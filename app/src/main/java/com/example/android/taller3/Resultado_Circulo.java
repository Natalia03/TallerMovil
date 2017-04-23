package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado_Circulo extends AppCompatActivity {
    private TextView resultado;
    private double a;
    private String aux;
    private Intent i;
    private Bundle b;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__circulo);

        resultado = (TextView) findViewById(R.id.txtResultadoCirculo);
        b = getIntent().getExtras();
        a = b.getDouble("Area");
        aux = "" + a;
        resultado.setText(aux);


    }

    public void Volver (View v){
        i=new Intent(this, Circulo.class);
        startActivity(i);

    }



}

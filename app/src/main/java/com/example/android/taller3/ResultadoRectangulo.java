package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoRectangulo extends AppCompatActivity {
    private TextView resultado;
    private double a;
    private String aux;
    private Intent i;
    private Bundle b;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_rectangulo);

        resultado=(TextView)findViewById(R.id.txtResultadoRectangulo);
        b = getIntent().getExtras();
        a=b.getDouble("Area");
        aux=""+a;
        resultado.setText(aux);


    }

    public void Volver (View v){
        i=new Intent(this, Restangulo.class);
        startActivity(i);

    }

}

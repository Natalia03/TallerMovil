package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Esfera extends AppCompatActivity {

    private EditText radio;
    private Intent i;
    private Bundle b;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        res=this.getResources();
        i= new Intent(this,Resultado_Esfera.class);
        b= new Bundle();
        radio= (EditText)findViewById(R.id.txtRadio);
    }

    public void Calcular (View v){
        double n, resul;
        String opera="", datos="";
        String total;
        double pi;
        pi=3.1416;
        double nu;
        nu=(4/3);


        if(validar()) {
            n = Double.parseDouble(radio.getText().toString());
            resul =nu*pi*(n*n*n);
            total = "" + resul;

            datos = "" +getResources().getString(R.string.radio2) + radio.getText().toString();
            opera = "" +getResources().getString(R.string.volumendelaesfera);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }else{
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.erroresfera)).show();
        }


    }

    public boolean validar(){
        if(radio.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }


    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        radio.setText("");

    }
}

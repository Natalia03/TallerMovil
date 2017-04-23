package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.renderscript.Double2;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class Cuadrado extends AppCompatActivity {
    private EditText lado;
    private Intent i;
    private Bundle b;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        res=this.getResources();
        i= new Intent(this,resultadoCuadrado.class);
        b= new Bundle();
        lado= (EditText)findViewById(R.id.TxtCuadrado);
    }

    public void Calcular (View v){
        double n, resul;
        String opera="", datos="";
        String total;


        if(validar()) {
            n = Double.parseDouble(lado.getText().toString());
            resul = n * n;
             total = "" + resul;

            datos = "" +getResources().getString(R.string.Lado) + lado.getText().toString();
            opera = "" +getResources().getString(R.string.areadelcuadrado);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }else{
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorCuadrado)).show();
        }


    }

    public boolean validar(){
        if(lado.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    public void borrar (View v){ limpiar  ();}

        public void limpiar(){
            lado.setText("");
            lado.requestFocus();
    }
}

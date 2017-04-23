package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cilindro extends AppCompatActivity {
    private EditText cilindroA;
    private EditText cilindroR;
    private Intent i;
    private Bundle b;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        res=this.getResources();
        i= new Intent(this,Resultado_Cilindro.class);
        b= new Bundle();
        cilindroA= (EditText)findViewById(R.id.txtCilindroA);
        cilindroR= (EditText)findViewById(R.id.txtCilindroR);
    }

    public void Calcular (View v){
        double n,n2, resul;
        String opera="", datos="";
        String total;
        double pi;
        pi=3.1416;


        if(validar()) {
            n = Double.parseDouble(cilindroA.getText().toString());
            n2= Double.parseDouble(cilindroR.getText().toString());
            resul = n*pi*(n2*n2);
            total = "" + resul;

            datos = "" +getResources().getString(R.string.altura)  + cilindroA.getText().toString() + "  "+ getResources().getString(R.string.radio2) + cilindroR.getText().toString();
            opera = "" +getResources().getString(R.string.volumendelcilindro);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }
    }

    public boolean validar() {
        if (cilindroA.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorrectanguloaltura)).show();
            return false;
        }

        if (cilindroR.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errordelcirculo)).show();
            return false;
        }
        return true;
    }



    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        cilindroA.setText("");
        cilindroR.setText("");

    }
}

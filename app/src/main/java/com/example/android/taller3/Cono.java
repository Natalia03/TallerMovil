package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cono extends AppCompatActivity {
    private EditText altura;
    private EditText radio;
    private Intent i;
    private Bundle b;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        res=this.getResources();
        i= new Intent(this,Resultado_Cono.class);
        b= new Bundle();
        altura=(EditText)findViewById(R.id.txtAAlturaC);
        radio=(EditText)findViewById(R.id.txtRadioC);
    }

    public void Calcular (View v){
        double n,n2, resul;
        String opera="", datos="";
        String total;
        double pi;
        pi=3.1416;
        double nu;
        nu=(0.33);


        if(validar()) {
            n = Double.parseDouble(altura.getText().toString());
            n2= Double.parseDouble(radio.getText().toString());
            resul = nu*pi*(n2*n2)*n;
            total = "" + resul;

            datos = "" +getResources().getString(R.string.altura)  + altura.getText().toString() + "  "+ getResources().getString(R.string.radio2) + radio.getText().toString();
            opera = "" +getResources().getString(R.string.volumendelcono);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }
    }

    public boolean validar() {
        if (altura.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorrectanguloaltura)).show();
            return false;
        }

        if (radio.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errordelcirculo)).show();
            return false;
        }
        return true;
    }

    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        altura.setText("");
        radio.setText("");
    }
}

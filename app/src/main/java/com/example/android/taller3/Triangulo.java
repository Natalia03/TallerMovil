package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Triangulo extends AppCompatActivity {
    private EditText base;
    private EditText altura;
    private Intent i;
    private Bundle b;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        res=this.getResources();
        i= new Intent(this,Resultado_Triangulo.class);
        b= new Bundle();
        base=(EditText)findViewById(R.id.txtBase);
        altura=(EditText)findViewById(R.id.txtAltura);
    }

    public void Calcular (View v){
        double n,n2, resul;
        String opera="", datos="";
        String total;


        if(validar()) {
            n = Double.parseDouble(base.getText().toString());
            n2= Double.parseDouble(altura.getText().toString());
            resul = n * n2 /2;
            total = "" + resul;

            datos = "" +getResources().getString(R.string.base)  + base.getText().toString() + "  "+ getResources().getString(R.string.altura) + altura.getText().toString();
            opera = "" +getResources().getString(R.string.areadeltriangulo);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }
    }

    public boolean validar() {
        if (base.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorrectangulobase)).show();
            return false;
        }

        if (altura.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorrectanguloaltura)).show();
            return false;
        }
        return true;
    }

    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        base.setText("");
        altura.setText("");

    }
}

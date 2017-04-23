package com.example.android.taller3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cubo extends AppCompatActivity {
    private EditText area;
    private Intent i;
    private Bundle b;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        res=this.getResources();
        i= new Intent(this,Resultado_Cubo.class);
        b= new Bundle();
        area=(EditText)findViewById(R.id.txtArea);

    }

    public void Calcular (View v){
        double n, resul;
        String opera="", datos="";
        String total;


        if(validar()) {
            n = Double.parseDouble(area.getText().toString());
            resul = n * n *n;
            total = "" + resul;

            datos = "" +getResources().getString(R.string.area) + area.getText().toString();
            opera = "" +getResources().getString(R.string.volumendelcubo);
            b.putDouble("Area", resul);
            i.putExtras(b);
            Listado op = new Listado(total, opera, datos);
            op.Guardar();
            startActivity(i);
        }else{
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorcubo)).show();
        }


    }

    public boolean validar(){
        if(area.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        area.setText("");


    }
}

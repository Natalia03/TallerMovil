package com.example.android.taller3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Operaciones_Realizadas extends AppCompatActivity {

    private TableLayout t;
    private ArrayList<Listado> Operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones__realizadas);

        t=(TableLayout)findViewById(R.id.tblListado);
        Operaciones = Realizadas.getOperaciones();

        for (int i = 0; i < Operaciones.size(); i++) {
            TableRow fila= new TableRow(this);
            TextView c1= new TextView(this);
            TextView c2=new TextView(this);
            TextView c3=new TextView(this);
            TextView c4=new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(Operaciones.get(i).getOperaciones());
            c3.setText(Operaciones.get(i).getDatos());
            c4.setText(Operaciones.get(i).getResultados());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            t.addView(fila);

        }

    }
}

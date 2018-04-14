package com.example.app.demo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NotasAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_alumno);
        CargarProfesores();
    }

    public void CalcularNotas(View v)
    {
        Double PromPractica ,
               PromParcial,
               Promedio;
        EditText oedtNombres=(EditText)findViewById(R.id.edtNombres);
        Spinner oprofesor=(Spinner) findViewById(R.id.spnProfesor);
        Spinner oCurso=(Spinner) findViewById(R.id.spnCurso);
        EditText oedtPromPractica=(EditText)findViewById(R.id.edtPromPractica);
        EditText oedtPromParcial=(EditText)findViewById(R.id.edtPromParcial);

        if (oedtPromPractica.getText().toString().isEmpty())
        {
            Toast.makeText(getBaseContext(),
                    "Debes ingresar el promedio de practica",
                    Toast.LENGTH_LONG).show();
            return ;
        }
        if (oedtPromParcial.getText().toString().isEmpty())
        {
            Toast.makeText(getBaseContext(),
                    "Debes ingresar el promedio parcial",
                    Toast.LENGTH_LONG).show();
            return ;
        }
        PromPractica=Double.parseDouble(oedtPromPractica.getText().toString());
        PromParcial=Double.parseDouble(oedtPromParcial.getText().toString());
        if (PromPractica ==0 && PromParcial==0)
        {
            Toast.makeText(getBaseContext(),
                    "Debes ingresar valor mayores a cero",
                    Toast.LENGTH_LONG).show();
            return ;
        }
        Promedio = (PromPractica + PromParcial)/2;
        TextView oTvPromedio=(TextView)findViewById(R.id.tvPromedio);
        oTvPromedio.setText(String.valueOf(Promedio));
    }

    public void CargarProfesores()
    {
        Spinner oprofesor=(Spinner) findViewById(R.id.spnProfesor);
        List<String> ListaCursos=new ArrayList<>();
        ListaCursos.add("Santiago Solis");
        ListaCursos.add("Juan Palermo");
        ArrayAdapter<String> oAdaptador=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                ListaCursos
                );
        oAdaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        oprofesor.setAdapter(oAdaptador);
    }
}

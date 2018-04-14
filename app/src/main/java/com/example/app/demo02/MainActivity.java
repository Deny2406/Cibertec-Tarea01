package com.example.app.demo02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button obtnNotasAlumno=(Button) findViewById(R.id.BtnNotasAlumno);
        Button menucartaBtn = findViewById(R.id.btnMenuCarta);
        obtnNotasAlumno.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       //Incio Código del evento click
                       Intent oIntento2 =new Intent(
                               getBaseContext(),
                               NotasAlumno.class
                       );
                       startActivity(oIntento2) ;
                       //Fin del código evento click
                   }
               }
        );
        menucartaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MenuCarta.class));
            }
        });
    }

    public void MenuDatosPersonales(View v)
    {
        Intent oIntent=new Intent( getBaseContext(),
                DatosPersonales.class
        );
       startActivity(oIntent);
    }
}

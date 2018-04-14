package com.example.app.demo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosPersonales extends AppCompatActivity {

    EditText nameEdit,lastnameEdit,cellphoneEdit;
    Button cancelBtn,saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        nameEdit = findViewById(R.id.name_edit);
        lastnameEdit = findViewById(R.id.last_name_edit);
        cellphoneEdit = findViewById(R.id.cellphone_edit);
        saveBtn = findViewById(R.id.save_btn);
        cancelBtn=findViewById(R.id.cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameEdit.getText().toString().isEmpty() ||
                        lastnameEdit.getText().toString().isEmpty() ||
                        cellphoneEdit.getText().toString().isEmpty()) {
                    Toast.makeText(DatosPersonales.this, getString(R.string.message_validation), Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(DatosPersonales.this,getString(R.string.message_accept),Toast.LENGTH_LONG).show();
                    nameEdit.getText().clear();
                    lastnameEdit.getText().clear();
                    cellphoneEdit.getText().clear();
                }
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}

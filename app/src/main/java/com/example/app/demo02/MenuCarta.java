package com.example.app.demo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuCarta extends AppCompatActivity {

    EditText  orderdetailEdit , costEdit,cantidaEdit,totalEdit, descuentoEdit,totalpagarEdita;
    Button calcularBtn,ImprimirBtn;
    CheckBox deliveryCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carta);
        getSupportActionBar().setTitle("Menu Carta");

        orderdetailEdit = findViewById(R.id.detallepedido_edit);
        costEdit = findViewById(R.id.costo_edit);
        cantidaEdit = findViewById(R.id.cantidad_edit);
        totalEdit = findViewById(R.id.total_edit);
        descuentoEdit = findViewById(R.id.descuento_edit);
        totalpagarEdita = findViewById(R.id.total_pagar_edit);
        deliveryCheck = findViewById(R.id.servicio_delivery_check);
        calcularBtn=findViewById(R.id.calcular_btn);

        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(costEdit.getText().toString().isEmpty() && cantidaEdit.getText().toString().isEmpty()){
                    Toast.makeText(MenuCarta.this, getString(R.string.message_validation),Toast.LENGTH_LONG).show();
                }else{
                    double descuento;
                    double total = Double.parseDouble(costEdit.getText().toString()) * Double.parseDouble(cantidaEdit.getText().toString());
                    totalEdit.setText(total+"");
                        descuentoEdit.setText(0+"");
                        descuento = total*0.1;
                        if(total > 300){
                            total = total - descuento;
                            descuentoEdit.setText(descuento+"");
                        }if (deliveryCheck.isChecked()){
                            total = total+20;
                        }

                        totalpagarEdita.setText(total+"");

                }

            }
        });
    }
}

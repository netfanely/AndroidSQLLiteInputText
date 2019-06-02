package com.example.datosmobiles;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextInputLayout mtiMovimiento, mtiMonto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtiMovimiento = findViewById(R.id.tiMovimiento);
        mtiMonto = findViewById(R.id.tiMonto);
    }

    public void Guardar(View view){
        String movimiento = mtiMovimiento.getEditText().getText().toString();
        String monto = mtiMonto.getEditText().getText().toString();
    }
}

package com.example.datosmobiles;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MovimientoActivity extends AppCompatActivity {

    ListView mlvMovimientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento);
        mlvMovimientos = findViewById(R.id.lvMovimientos);
        Datos datos = new Datos (this);
        SQLiteDatabase sqLiteDatabase = datos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from movimientos", null
        );
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    String fecha = cursor.getString(cursor.getColumnIndex("fecha"));
                    String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                    float monto = cursor.getFloat(cursor.getColumnIndex("monto"));
                    HashMap<String,String> map = new HashMap<>();
                    map.put("fecha",fecha);
                    map.put("descripcion",descripcion);
                    map.put("monto",String.valueOf(monto));
                    arrayList.add(map);
                }while (cursor.moveToNext());

                ListAdapter listAdapter = new SimpleAdapter(
                        this, arrayList, R.layout.item_movimientos,
                        new String[]{"fecha","descripcion","monto"},
                        new int[]{R.id.tvFecha,R.id.tvDescripcion,R.id.tvMonto}
                );
                mlvMovimientos.setAdapter(listAdapter);
            }
        }
    }
}

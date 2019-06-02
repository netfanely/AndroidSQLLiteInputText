package com.example.datosmobiles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datos extends SQLiteOpenHelper {
    public Datos(Context context) {
        super(context, "banquito", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table movimientos " +
                        "(idmovimiento INTERGER PRIMARY KEY AUTOINCREMENT, " +
                        "fecha DATETIME DEFAULT CURRENT_TIMESTAMP,"+
                        "description text, monto float, tipomovimiento int)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void registrarMovimiento(Datos datos, String description, float monto, int tipomovimiento){
        SQLiteDatabase sqLiteDatabase = datos.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO movimientos (descripcion,monto,tipomovimiento) values('" +
                description + "',"+ monto + ","+ tipomovimiento + ")");
    }
}

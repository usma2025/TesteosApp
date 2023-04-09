package com.example.parcial_testeos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial_testeos.db.DbHelper;

public class Registros extends AppCompatActivity {
    EditText nombreEdit, edadEdit, ciudadEdit;
    Button btn_guardar;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        nombreEdit = findViewById(R.id.nombreEdit);
        edadEdit = findViewById(R.id.edadEdit);
        ciudadEdit = findViewById(R.id.ciudadEdit);
        btn_guardar = findViewById(R.id.btn_guardar);

        dbHelper = new DbHelper(this);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEdit.getText().toString();
                int edad = Integer.parseInt(edadEdit.getText().toString());
                String ciudad = ciudadEdit.getText().toString();

                int factorial = calcularFactorial(edad);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DbHelper.nombre, nombre);
                values.put(DbHelper.edad, edad);
                values.put(DbHelper.ciudad, ciudad);

                long result = db.insert(DbHelper.TABLE_REGISTROS, null, values);
                Log.d("MiApp", "Resultado de la inserción: " + result);
                if (result != -1) {

                    Toast.makeText(Registros.this, "Contacto guardado exitosamente. El factorial de la edad es: " + factorial, Toast.LENGTH_LONG).show();
                    nombreEdit.setText("");
                    edadEdit.setText("");
                    ciudadEdit.setText("");
                } else {
                    Toast.makeText(Registros.this, "Error al guardar el contacto", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public static int calcularFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calcularFactorial(number - 1);
        }
    }
}
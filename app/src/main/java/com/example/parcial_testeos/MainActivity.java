package com.example.parcial_testeos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuarioEdit, passwordEdit;
    Button btn_ingresar;
    private static final String user = "usma202528";
    private static final String password = "181019";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEdit = findViewById(R.id.nombreEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usuarioEdit.getText().toString();
                String password1 = passwordEdit.getText().toString();

                if (username.equals(user) && password1.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, Registros.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
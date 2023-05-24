package com.example.programa02_2023a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView etResultado;
    private ImageButton btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etResultado=(TextView) findViewById(R.id.etResultado);
        btnRegresar=(ImageButton) findViewById(R.id.btnRegresar);

        String conversion = getIntent().getStringExtra("valor");
        String opcion = getIntent().getStringExtra("opcion");
        etResultado.setText(conversion + " " + opcion);
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        onBackPressed();
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}
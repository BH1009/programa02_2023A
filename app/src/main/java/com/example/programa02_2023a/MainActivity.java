
package com.example.programa02_2023a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private ImageButton btnResultado;
    private Spinner convertirDe, convertirA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValor=(EditText) findViewById(R.id.etValor);
        btnResultado=(ImageButton) findViewById(R.id.btnResultado);
        convertirDe=(Spinner) findViewById(R.id.convetirDe);
        convertirA=(Spinner) findViewById(R.id.convertirA);

        String opciones[] = {"metros", "kilometros", "millas", "nudos"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        convertirDe.setAdapter(adapter1);
        convertirA.setAdapter(adapter2);
    }

    public void enviarResultado(View view, String dato, String opcion){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("valor", dato);
        intent.putExtra("opcion", opcion);
        startActivity(intent);
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    public void convertir(View view){
        String opcion1 = convertirDe.getSelectedItem().toString();
        String opcion2 = convertirA.getSelectedItem().toString();

        String res = etValor.getText().toString();
        double conversion;

        try{
            Float valor = Float.parseFloat(res);
            if(opcion1.equals(opcion2)){
                Toast.makeText(this, "No se puede realizar la operación", Toast.LENGTH_LONG).show();
            }
            else {
                if (opcion1.equals("metros")) {
                    if (opcion2.equals("kilometros")) {
                        conversion = valor * 0.001;
                    } else if (opcion2.equals("millas")) {
                        conversion = valor * 0.00062137;
                    } else {
                        conversion = valor * 1.9438;
                    }

                } else if (opcion1.equals("kilometros")) {
                    if (opcion2.equals("metros")) {
                        conversion = valor * 1000;
                    } else if (opcion2.equals("millas")) {
                        conversion = valor * 0.621371;
                    } else {
                        conversion = valor * 1943.85;
                    }

                } else if (opcion1.equals("millas")) {
                    if (opcion2.equals("metros")) {
                        conversion = valor * 1609.34;
                    } else if (opcion2.equals("kilometros")) {
                        conversion = valor * 1.6093;
                    } else {
                        conversion = valor * 3128.32 ;
                    }

                } else {
                    if (opcion2.equals("metros")) {
                        conversion = valor * 0.514444;
                    } else if (opcion2.equals("kilometros")) {
                        conversion = valor * 0.00051444;
                    } else {
                        conversion = valor * 0.00031966;
                    }
                }
                String dato = String.valueOf(conversion);
                enviarResultado(view, dato, opcion2);
                onBackPressed();
            }
        }catch(NumberFormatException e){
            Toast.makeText(this, "El campo valor esta vacio", Toast.LENGTH_LONG).show();
        }
    }

    //https://convertlive.com/

}
package es.ieslavereda.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equals;
    private Button clear;
    private TextView display;
    private Double operando;
    private Operacion operacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equals = findViewById(R.id.equals);
        clear = findViewById(R.id.clear);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        display = findViewById(R.id.display);
        clear.setOnClickListener(view -> display.setText("0"));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando = Double.parseDouble(display.getText().toString());
                operacion = Operacion.SUMA;
                display.setText("0");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando = Double.parseDouble(display.getText().toString());
                operacion = Operacion.RESTA;
                display.setText("0");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando = Double.parseDouble(display.getText().toString());
                operacion = Operacion.MULTIPLICACION;
                display.setText("0");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando = Double.parseDouble(display.getText().toString());
                operacion = Operacion.DIVISION;
                display.setText("0");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion==Operacion.SUMA) {
                    Double resultado = operando + Double.parseDouble(display.getText().toString());
                    if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
                } else if (operacion==Operacion.RESTA) {
                    Double resultado = operando - Double.parseDouble(display.getText().toString());
                    if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
                } else if (operacion==Operacion.MULTIPLICACION) {
                    Double resultado = operando * Double.parseDouble(display.getText().toString());
                    if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
                } else if (operacion==Operacion.DIVISION) {
                    Double resultado = operando / Double.parseDouble(display.getText().toString());
                    if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (display.getText().toString().equals("0")) {
            display.setText(((Button) view).getText());
        } else {
            display.setText(String.valueOf(display.getText())+((Button)view).getText());
        }
    }

}
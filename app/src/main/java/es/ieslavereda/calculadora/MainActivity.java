package es.ieslavereda.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equals;
    private Button backspace;
    private Button clear;
    private TextView display;
    private Double operating;
    private Operacion operation;
    private CheckBox optionsButton;
    private RadioGroup options;
    private RadioButton optionSum;
    private RadioButton optionSubtract;
    private RadioButton optionMultiply;
    private RadioButton optionDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equals = findViewById(R.id.equals);
        backspace = findViewById(R.id.backspace);
        clear = findViewById(R.id.clear);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        display = findViewById(R.id.display);
        optionsButton = findViewById(R.id.optionsButton);
        options = findViewById(R.id.options);
        optionSum = findViewById(R.id.opcionSuma);
        optionSubtract = findViewById(R.id.opcionResta);
        optionMultiply = findViewById(R.id.opcionMultiplicacion);
        optionDivide = findViewById(R.id.opcionDivision);

        clear.setOnClickListener(view -> display.setText("0"));
        backspace.setOnClickListener(v -> {
            if (!display.getText().toString().isEmpty()) {
                if (display.getText().toString().length()==1) {
                    display.setText("0");
                } else {
                    display.setText(display.getText().toString().substring(0,display.getText().toString().length()-1));
                }
            }

        });
        plus.setOnClickListener(view -> {
            operating = Double.parseDouble(display.getText().toString());
            operation = Operacion.SUMA;
            display.setText("0");
        });
        minus.setOnClickListener(view -> {
            operating = Double.parseDouble(display.getText().toString());
            operation = Operacion.RESTA;
            display.setText("0");
        });
        multiply.setOnClickListener(view -> {
            operating = Double.parseDouble(display.getText().toString());
            operation = Operacion.MULTIPLICACION;
            display.setText("0");
        });
        divide.setOnClickListener(view -> {
            operating = Double.parseDouble(display.getText().toString());
            operation = Operacion.DIVISION;
            display.setText("0");
        });

        equals.setOnClickListener(view -> {
            if (operation ==Operacion.SUMA) {
                Double resultado = operating + Double.parseDouble(display.getText().toString());
                if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
            } else if (operation ==Operacion.RESTA) {
                Double resultado = operating - Double.parseDouble(display.getText().toString());
                if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
            } else if (operation ==Operacion.MULTIPLICACION) {
                Double resultado = operating * Double.parseDouble(display.getText().toString());
                if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
            } else if (operation ==Operacion.DIVISION) {
                Double resultado = operating / Double.parseDouble(display.getText().toString());
                if (resultado == resultado.intValue()) { display.setText(String.valueOf(resultado.intValue())); } else { display.setText(resultado.toString()); }
            }
        });
        optionsButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                options.setVisibility(View.INVISIBLE);
            } else {
                options.setVisibility(View.VISIBLE);
            }
        });
        optionsButton.setChecked(true);

        optionSum.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                plus.setVisibility(View.INVISIBLE);
            } else {
                plus.setVisibility(View.VISIBLE);
            }
        });
        optionSubtract.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                minus.setVisibility(View.INVISIBLE);
            } else {
                minus.setVisibility(View.VISIBLE);
            }
        });
        optionMultiply.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                multiply.setVisibility(View.INVISIBLE);
            } else {
                multiply.setVisibility(View.VISIBLE);
            }
        });
        optionDivide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                divide.setVisibility(View.INVISIBLE);
            } else {
                divide.setVisibility(View.VISIBLE);
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
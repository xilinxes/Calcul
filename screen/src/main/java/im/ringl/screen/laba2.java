package im.ringl.screen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class laba2 extends Activity implements View.OnTouchListener {
    EditText number;
    TextView otvet;
    Switch sw2;
    int firstPos=0, secondPos=6;
    String[] data = {"миллиметр", "сантиметр", "метр", "километр", "фут", "ярд", "миля"};
    String[] data2 = {"миллиметр", "сантиметр", "метр", "километр", "фут", "ярд", "миля"};
    Double[] velichini = {1.0, 10.0, 1000.0, 1000000.0, 304.8, 914.4, 1609344.0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba2);
        number = (EditText) findViewById(R.id.Vvod);
        sw2 = (Switch) findViewById(R.id.switch2);
        otvet = (TextView) findViewById(R.id.Vivod);
        otvet.setOnTouchListener(this);

        View.OnClickListener lab2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.switch2: {
                        if (!sw2.isChecked()) {
                            Intent main = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(main);
                        }
                        break;
                    }
                }

            }
        };
        sw2.setOnClickListener(lab2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner);
        spin1.setAdapter(adapter);
        spin1.setPrompt("Перевести из");
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        spin2.setAdapter(adapter2);
        spin2.setPrompt("Перевести в");
        spin1.setSelection(0, true);
        spin2.setSelection(6, true);


        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), data[position], Toast.LENGTH_SHORT).show();
                firstPos = position;
                schet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), data[position], Toast.LENGTH_SHORT).show();
                secondPos = position;
                schet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP: {
                schet();
            }
        }
        return true;
    }

    public void schet() {
        try {
            double result = Double.parseDouble(String.valueOf(number.getText()));
            result = result * velichini[firstPos] / velichini[secondPos];
            otvet.setText(String.valueOf(result));
        } catch (Exception e) {

        }
    }
}







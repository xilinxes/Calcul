package im.ringl.screen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView screen;
    Button c, delit, ymnoj, delete, nine, eight, seven, six, five, forth, three, two, one, ravno, plus, minus, zero, point;
    Switch sw;
    Intent lab2 = new Intent(this, laba2.class);


    @Override
    protected void onCreate(final Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);
        c = (Button) findViewById(R.id.C);
        delete = (Button) findViewById(R.id.delete);
        delit = (Button) findViewById(R.id.delit);
        ymnoj = (Button) findViewById(R.id.ymnoj);
        nine = (Button) findViewById(R.id.nine);
        eight = (Button) findViewById(R.id.eight);
        seven = (Button) findViewById(R.id.seven);
        six = (Button) findViewById(R.id.six);
        five = (Button) findViewById(R.id.five);
        forth = (Button) findViewById(R.id.forth);
        three = (Button) findViewById(R.id.three);
        two = (Button) findViewById(R.id.two);
        one = (Button) findViewById(R.id.one);
        ravno = (Button) findViewById(R.id.ravno);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        zero = (Button) findViewById(R.id.zero);
        point = (Button) findViewById(R.id.point);
        sw=(Switch) findViewById(R.id.switch1);



        View.OnClickListener onclk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setTextColor(Color.rgb(0, 0, 0));
                if ((String.valueOf(screen.getText())).equals("Error"))
                    screen.setText("");


                switch (v.getId()) {
                    case R.id.switch1:{
                        if(sw.isChecked()){
                            sw.setText("Включён перевод длинн");
                            startActivity(lab2);
                        }
                        else
                            sw.setText("Включён калькулятор");
                        break;
                    }
                    case R.id.C:
                        screen.setText("");
                        break;
                    case R.id.delit:
                        screen.append("/");
                        break;
                    case R.id.ymnoj:
                        screen.append("*");
                        break;
                    case R.id.delete: {
                        String a = String.valueOf(screen.getText());
                        if (a.equals(""))
                            break;
                        a = a.substring(0, a.length() - 1);
                        screen.setText(a);
                    }
                    break;
                    case R.id.nine:
                        screen.append("9");
                        break;
                    case R.id.eight:
                        screen.append("8");
                        break;
                    case R.id.seven:
                        screen.append("7");
                        break;
                    case R.id.six:
                        screen.append("6");
                        break;
                    case R.id.five:
                        screen.append("5");
                        break;
                    case R.id.forth:
                        screen.append("4");
                        break;
                    case R.id.three:
                        screen.append("3");
                        break;
                    case R.id.two:
                        screen.append("2");
                        break;
                    case R.id.one:
                        screen.append("1");
                        break;
                    case R.id.plus:
                        screen.append("+");
                        break;
                    case R.id.minus:
                        screen.append("-");
                        break;
                    case R.id.zero:
                        screen.append("0");
                        break;
                    case R.id.point:
                        screen.append(".");
                        break;

                    case R.id.ravno:
                        try {
                            screen.append("/");
                            vichislenia();
                            break;
                        } catch (Exception e) {
                            Log.d("ERR", "error");
                            screen.setText((String.valueOf(screen.getText()).substring(0, screen.getText().length() - 1)));
                            screen.setTextColor(Color.rgb(255, 0, 0));
                            screen.append("\nError");

                        }

                }
            }
        };

        sw.setOnClickListener(onclk);
        c.setOnClickListener(onclk);
        ymnoj.setOnClickListener(onclk);
        delete.setOnClickListener(onclk);
        delit.setOnClickListener(onclk);
        nine.setOnClickListener(onclk);
        eight.setOnClickListener(onclk);
        seven.setOnClickListener(onclk);
        six.setOnClickListener(onclk);
        five.setOnClickListener(onclk);
        forth.setOnClickListener(onclk);
        three.setOnClickListener(onclk);
        two.setOnClickListener(onclk);
        one.setOnClickListener(onclk);
        ravno.setOnClickListener(onclk);
        plus.setOnClickListener(onclk);
        minus.setOnClickListener(onclk);
        zero.setOnClickListener(onclk);
        point.setOnClickListener(onclk);

    }

    public void vichislenia() {
        char znak = ' ';
        double otvet = 0;
        int index = 0;
        String text;
        text = String.valueOf(screen.getText());
        for (int j = 0; j < text.length(); j++) {
            if (text.charAt(j) == '/' || text.charAt(j) == '*' || text.charAt(j) == '+' || (text.charAt(j) == '-' && j > 0)) {
                znak = text.charAt(j);
                String str;
                str = text.substring(index, j);
                otvet = Double.parseDouble(str);
                index = j + 1;
                break;
            }
        }
        for (int i = index; i < text.length(); i++) {
            if (text.charAt(i) == '/' || text.charAt(i) == '*' || text.charAt(i) == '+' || text.charAt(i) == '-') {
                String str;
                str = text.substring(index, i);
                double a = Double.parseDouble(str);
                switch (znak) {
                    case '/':
                        otvet /= a;
                        break;
                    case '*':
                        otvet = otvet * a;
                        break;
                    case '+':
                        otvet += a;
                        break;
                    case '-':
                        otvet -= a;
                        break;


                }

                znak = text.charAt(i);
                index = i + 1;


            }


        }
        try {

            //hello
            if (otvet == Double.POSITIVE_INFINITY ||
                    otvet == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException();
            screen.setText(String.valueOf(otvet));
        } catch (ArithmeticException e) {
            screen.setTextColor(Color.rgb(255, 30, 30));
            screen.setText("Error");
        }
    }
}






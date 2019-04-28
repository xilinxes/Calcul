package im.ringl.screen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView screen;
    Button c, delit, ymnoj, delete, nine, eight, seven, six, five, forth, three, two, one, ravno;

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

        View.OnClickListener onclk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
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
                    case R.id.ravno:
                        vichislenia();


                }
            }
        };
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

    }

    public void vichislenia() {
        double otvet = 0;
        int index = 0;
        String text;
        text = String.valueOf(screen.getText());
        for (int j = 0; j < text.length(); j++) {
            if (text.charAt(j) == '/' || text.charAt(j) == '*') {
                char znak = text.charAt(j);
                otvet = Double.parseDouble(text.substring(index, j - 1));
                index = j + 1;
            }
        }
        for (int i = index; i < text.length(); i++) {
            if (text.charAt(i) == '/' || text.charAt(i) == '*') {
                char znak = text.charAt(i);
                double a = Double.parseDouble(text.substring(index, i - 1));
                index = i + 1;

                switch (znak) {
                    case '/':
                        otvet = otvet / a;
                        break;

                }
            }


        }
        screen.setText((int) otvet);
    }
}






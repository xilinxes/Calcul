package im.ringl.web;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btnWeb)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent br = new Intent(getApplicationContext(),browser.class);
                br.setData(Uri.parse("http://www.google.com"));
                startActivity(br);
            }
        });
        findViewById(R.id.Yandex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent br = new Intent(getApplicationContext(),browser.class);
                br.setData(Uri.parse("http://www.ya.ru"));
                startActivity(br);
            }
        });
    }
}

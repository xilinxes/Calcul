package im.ringl.web;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.ArrayList;

public class browser extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> listforward = new ArrayList<String>();
    Button back,forward,restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add("a");
        list.add("a");
        //Log.d("AAAAA", String.valueOf(list.size()));
        // Log.d("AAAA", String.valueOf(list.get(1)));
        setContentView(R.layout.activity_browser);
        back = (Button) findViewById(R.id.back);
        forward = (Button) findViewById(R.id.forward);
        restart = (Button) findViewById(R.id.restart);
        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Uri data = getIntent().getData();
        webView.loadUrl(data.toString());
        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.back:{
                        listforward.add(webView.getUrl());
                        webView.loadUrl(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                        break;
                    }
                    case R.id.forward:{
                        try {
                            list.add(webView.getUrl());
                            webView.loadUrl(listforward.get(listforward.size() - 1));
                            listforward.remove(listforward.size() - 1);
                            break;
                        }
                        catch (Exception e){

                        }
                    }
                    case R.id.restart:{
                        try {
                            webView.loadUrl(webView.getUrl());
                            break;
                        }
                        catch (Exception e){

                        }
                    }
                }
            }
        };
        restart.setOnClickListener(btn);
        forward.setOnClickListener(btn);
        back.setOnClickListener(btn);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        if (!(list.get(list.size() - 1)).endsWith(webView.getUrl()) ) {
                            list.add(webView.getUrl());
                            Log.e("fgd", list.toString() );
                        }
                    }
                }
                return false;
            }
        });
    }
}

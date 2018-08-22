package com.yueyue.jsnativedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.wv);
        setWebView();

    }
    private void setWebView(){
        //允许JavaScript执行
        webView.getSettings().setJavaScriptEnabled(true);
        //第二个参数其实就是形成一个ID,等着HTML通过ID调用window.toastandroid.show();
        webView.addJavascriptInterface(new ShowToast(),"toastandroid");
        webView.loadUrl("file:///android_asset/index.html");
//        webView.loadUrl("http://192.168.253.1:8000/");
    }
     public final class ShowToast {
        //Html调用此方法传递数据
        @JavascriptInterface
        public void show() {
            Toast.makeText(MainActivity.this,"调用",Toast.LENGTH_LONG).show();
        }
    }
}

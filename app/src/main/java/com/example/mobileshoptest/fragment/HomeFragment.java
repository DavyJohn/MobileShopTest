package com.example.mobileshoptest.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mobileshoptest.R;
import com.example.mobileshoptest.common.MyWebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    @BindView(R.id.webview)
    MyWebView webView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frament_layout,container,false);
        ButterKnife.bind(this,view);
        initWebView(view);

        webView.loadUrl("Http://www.baidu.com");
        setmSwipe();
        return view;
    }
    private void setmSwipe(){
        mSwipe.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_dark,android.R.color.holo_orange_dark);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                if (mSwipe.isRefreshing()){
                    mSwipe.setEnabled(false);
                }
            }
        });
    }
    @SuppressLint("JavascriptInterface")
    private void initWebView(View view){
        webView.addJavascriptInterface(this,"app");
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);

        webView.setOnCustomScrollChange(new MyWebView.IWebViewScroll() {
            @Override
            public void onTop() {
                mSwipe.setEnabled(true);
            }

            @Override
            public void onDown() {
                mSwipe.setEnabled(false);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

}

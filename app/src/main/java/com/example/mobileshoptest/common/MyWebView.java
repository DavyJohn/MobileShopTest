package com.example.mobileshoptest.common;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private IWebViewScroll iWebViewScroll;
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (iWebViewScroll != null && t == 0){
            iWebViewScroll.onTop();
        }else {
            iWebViewScroll.onDown();
        }
    }

    public void setOnCustomScrollChange(IWebViewScroll listener){
        this.iWebViewScroll = listener;
    }
    public interface IWebViewScroll{
        void onTop();
        void onDown();
    }
}

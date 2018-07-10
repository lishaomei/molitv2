package com.cloudmedia.tv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.VideoView;

import  com.cloudmedia.videoplayer.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    WebView webView;
    WebSettings webSettings;

    List<String> list=new ArrayList<>();
    int Index=0;

    VideoView videoView;

    protected void onCreate(Bundle paramBundle) {
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(paramBundle);


        list.add("http://live.fengshows.com/live/PIN_500k/index.m3u8?ts=1526841084049&token=d754aa8774f70c578ffe9ed09aba6e41");
        list.add("http://live.fengshows.com/live/PCC_500k/index.m3u8?ts=1526841084049&token=d754aa8774f70c578ffe9ed09aba6e41");
        list.add("http://live.fengshows.com/live/PHK_500k/index.m3u8?ts=1526841084049&token=d754aa8774f70c578ffe9ed09aba6e41");
        list.add("http://stream.mastvnet.com/MASTV/sd/live.m3u8");
        //
        list.add("http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv2/playlist.m3u8");
        //list.add("rtmp://wv4.tp33.net/sat/tv571");

        //list.add("http://1-fss24-s0.streamhoster.com/lv_uchannel/_definst_/broadcast1/chunklist.m3u8");



       setContentView(R.layout.webviewlayout);
       //webView=this.findViewById(R.id.mywebview);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏



        //String url="http://live.fengshows.com/live/PCC_500k/index.m3u8?ts=1526841084049&token=d754aa8774f70c578ffe9ed09aba6e41";
        //url="http://cctv5.v.wscdns.com/cache/6011_/seg0/index.m3u8";
        //url="http://117.169.120.209:8080/live/cctv-5/.m3u8";
        //url="http://223.110.243.155:80/PLTV/3/224/3221227166/1.m3u8";
        //url="http://hbmc.chinashadt.com:2739/live/dzdy.stream_360p/chunklist_w278857237.m3u8";


        videoView=findViewById(R.id.mVideoView);
        View content=findViewById(android.R.id.content);
        content.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(taxWindow!=null&&taxWindow.isShowing())
                {
                    taxWindow.dismiss();
                }
                else {
                    MainActivity.this.showTaxDetail(videoView);
                }
            }
        });
        LoadIndex();


    }

    public  void  LoadIndex()
    {
        String url="";
        if (Index+1>list.size())
        {
            Index=0;
        }

        if(Index<0)
        {
            Index=list.size()-1;
        }
        url=list.get(Index);
        videoView.refreshDrawableState();
        videoView.resume();

        videoView.setVideoPath(url);
        videoView.requestFocus();
        videoView.start();

    }

    PopupWindow  taxWindow;
    private void showTaxDetail(View view){
        LayoutInflater inflater=LayoutInflater.from(this);
        // 加载弹出框的布局
        View contentView=inflater.inflate(R.layout.playerui_layout, null);
        contentView.measure(0,0);
        taxWindow=new PopupWindow(contentView,contentView.getMeasuredWidth(),contentView.getMeasuredHeight(),true);
        taxWindow.setFocusable(false);
        // 得到按钮控件的坐标，便于定位弹出框位置
        taxWindow.showAtLocation(videoView, Gravity.NO_GRAVITY,0,200);
    }



    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient=new WebViewClient(){
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            //progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
            //progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //Log.i("ansen","拦截url:"+url);
            if(url.equals("http://www.google.com/")){
                Toast.makeText(MainActivity.this,"国内不能访问google,拦截该url",Toast.LENGTH_LONG).show();
                return true;//表示我已经处理过了
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

    };

    private long mExitTime;
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        boolean bool = true;
        switch (paramInt) {
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this,"你点击了菜单键",Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                //Toast.makeText(this,"你点击了确定键",Toast.LENGTH_SHORT).show();
                if(taxWindow!=null&&taxWindow.isShowing())
                {
                    taxWindow.dismiss();
                }
                else {
                    MainActivity.this.showTaxDetail(videoView);
                }
                break;
            case KeyEvent.KEYCODE_BACK:    //返回键
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    //大于2000ms则认为是误操作，使用Toast进行提示
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    // 并记录下本次点击“返回键”的时刻，以便下次进行判断
                    mExitTime = System.currentTimeMillis();
                    return  true;
                }
                else { //小于2000ms则认为是用户确实希望退出程序-调用进行退出
                        this.finish();
                    }
                break;
            case KeyEvent.KEYCODE_SETTINGS: //设置键
                Toast.makeText(this,"你点击了设置键",Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键
                Toast.makeText(this,"你点击了向下键",Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                Toast.makeText(this,"你点击了向上键",Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
                Toast.makeText(this,"你点击了向左键",Toast.LENGTH_SHORT).show();
                Index--;
                LoadIndex();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                Toast.makeText(this,"你点击了向右键",Toast.LENGTH_SHORT).show();
                Index++;
                LoadIndex();
                break;
            default:
                break;
        }

        return super.onKeyDown(paramInt, paramKeyEvent);
    }


    void  init()
    {
        //webView.loadUrl("http://m.shiting5.com/tv/fenghuangweishi.html");
        //webView.loadUrl("https://m.taobao.com");




        webSettings = webView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        // 禁用浏览器记住密码和表单数据
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(true);// support zoom

        webSettings.setUseWideViewPort(true);// 关键点
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);

        webView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    try {
                        Field defaultScale = WebView.class
                                .getDeclaredField("mDefaultScale");
                        defaultScale.setAccessible(true);
                        // WebViewSettingUtil.getInitScaleValue(VideoNavigationActivity.this,
                        // false )/100.0f 是我的程序的一个方法，可以用float 的scale替代
                        defaultScale.setFloat(webView, 1);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                        try {
                            Field zoomManager;
                            zoomManager = WebView.class
                                    .getDeclaredField("mZoomManager");
                            zoomManager.setAccessible(true);
                            Object zoomValue = zoomManager.get(webView);
                            Field defaultScale = zoomManager.getType()
                                    .getDeclaredField("mDefaultScale");
                            defaultScale.setAccessible(true);
                            // float sv = defaultScale.getFloat(zoomValue);
                            defaultScale.setFloat(zoomValue, 0.7f);
                        } catch (SecurityException e1) {
                            e1.printStackTrace();
                        } catch (IllegalArgumentException e1) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e1) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e1) {
                            e1.printStackTrace();
                            try {
                                Field mProviderField = WebView.class
                                        .getDeclaredField("mProvider");
                                mProviderField.setAccessible(true);
                                // mProviderField.getClass()
                                Object webviewclassic = mProviderField
                                        .get(webView);
                                Field zoomManager = webviewclassic.getClass()
                                        .getDeclaredField("mZoomManager");
                                zoomManager.setAccessible(true);
                                Object zoomValue = zoomManager
                                        .get(webviewclassic);
                                Field defaultScale = zoomManager.getType()
                                        .getDeclaredField("mDefaultScale");
                                defaultScale.setAccessible(true);
                                // sv = defaultScale.getFloat(zoomValue);
                                defaultScale.setFloat(zoomValue, 0.7f);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        });



        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(webViewClient);
    }

    //WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
    private WebChromeClient webChromeClient=new WebChromeClient(){
        //不支持js的alert弹窗，需要自己监听然后通过dialog弹窗
        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("确定",null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();

            //注意:
            //必须要这一句代码:result.confirm()表示:
            //处理结果为确定状态同时唤醒WebCore线程
            //否则不能继续点击按钮
            result.confirm();
            return true;
        }

        //获取网页标题
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            //Log.i("ansen","网页标题:"+title);
        }

        //加载进度回调
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //progressBar.setProgress(newProgress);
        }
    };

}

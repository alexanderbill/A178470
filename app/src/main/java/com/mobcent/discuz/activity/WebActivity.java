package com.mobcent.discuz.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.litesuits.common.assist.Toastor;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.ui.TopicOptPopup;
import com.mobcent.discuz.ui.WebOptPopup;

import org.apache.http.client.utils.URLEncodedUtils;
import org.w3c.dom.Text;

import java.nio.charset.Charset;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import static com.mobcent.discuz.base.constant.BaseIntentConstant.BUNDLE_WEB_TITLE;
import static com.mobcent.discuz.base.constant.BaseIntentConstant.BUNDLE_WEB_VIEW_URL;


@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends Activity implements View.OnClickListener {
    private static final String APP_CACHE_DIRNAME = "/webcache"; // web缓存目录

    private WebView mWebView;
    private View mToggleButton;
    private TextView mTitleTv;

    private boolean mUseTextAutoSize = true;
    private String mUrl;
    private String mTitle;
    private View mPlaceHolderView;

    public static void start(Context context, String url, String title) {
        Intent starter = new Intent(context, WebActivity.class);
        starter.putExtra(BUNDLE_WEB_VIEW_URL, url);
        starter.putExtra(BUNDLE_WEB_TITLE, title);
        context.startActivity(starter);
    }

    public static void startActivityForResult(Context context, String url, String title) {
        Intent starter = new Intent(context, WebActivity.class);
        starter.putExtra(BUNDLE_WEB_VIEW_URL, url);
        starter.putExtra(BUNDLE_WEB_TITLE, title);
        ((Activity)context).startActivityForResult(starter, LoginActivity.QQ_LOGIN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrl = getIntent().getStringExtra(BUNDLE_WEB_VIEW_URL);
        mTitle = getIntent().getStringExtra(BUNDLE_WEB_TITLE);
        setContentView(R.layout.activity_h5);

        findViewById(R.id.nav_btn_back).setVisibility(View.VISIBLE);
        mPlaceHolderView = findViewById(R.id.error_layout);
        mWebView = (WebView) findViewById(R.id.mc_forum_webview_browser);
        mTitleTv = (TextView) findViewById(R.id.nav_title);
        if (!TextUtils.isEmpty(mTitle)) {
            mTitleTv.setText(mTitle);
        }
        mToggleButton =  findViewById(R.id.nav_btn_more);
        mToggleButton.setVisibility(View.VISIBLE);
        // Apply the click listener
        mToggleButton.setOnClickListener(this);

        // Apply defaults including useWideViewport which us required
        // to make the text auto size to work
        setUpWebViewDefaults(mWebView);

        // Ensure we are using the default TextAutoSize
        setUseTextAutoSize(mUseTextAutoSize);

        // User-Agent
        setUpUserAgent(mWebView);

        // Cookies
        setUpCookie();

        // Make the WebView handle all loaded URLs
        mWebView.setWebViewClient(new MyWebViewClient());

        // setupDownload
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finish();
            }
        });
        mWebView.loadUrl(mUrl);
    }

    private void setUpCookie() {
        CookieJar cookieJar = DiscuzRequest.OK_HTTP_CLIENT.cookieJar();
        HttpUrl httpUrl = HttpUrl.parse(mUrl);
        List<Cookie> cookies = cookieJar.loadForRequest(httpUrl);
//        StringBuilder sb = new StringBuilder();
        for (Cookie cookie : cookies) {
//            sb.append(cookie.toString());
//            sb.append(";");
//                Log.d("COOKIE", cookie.getName() + "=" + cookie.getValue() + ",path=" + cookie.getPath() + ",domain=" + cookie.getDomain());
            CookieManager.getInstance().setCookie(cookie.domain(), cookie.name() + "=" + cookie.value() + "; domain=" + cookie.domain() + "; path=" + cookie.path());
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
//        CookieManager.getInstance().setCookie(mUrl, sb.toString());
    }

    public void setUpUserAgent(WebView web) {
        String ua = web.getSettings().getUserAgentString();
        web.getSettings().setUserAgentString(ua + " Appbyme");
    }

    /**
     * 用于控制页面导航
     *
     * @author wwj_748
     *
     */
    private class MyWebViewClient extends WebViewClient {
        /**
         * 当用于点击链接，系统调用这个方法
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Uri uri = Uri.parse(url);
            if (!TextUtils.isEmpty(uri.getQuery()) && uri.getQuery().indexOf("openid=") != -1) {

                String query = uri.getQuery();
                String[] params = query.split("&");
                String openid = "";
                String oauth_token = "";
                for (String param : params) {
                    String[] values = param.split("=");
                    if (values[0].equals("openid")) {
                        openid = values[1];
                    }
                    if (values[0].equals("oauth_token")) {
                        oauth_token = values[1];
                    }
                }
                if (!TextUtils.isEmpty(oauth_token) && !TextUtils.isEmpty(openid)) {
                    Intent intent = new Intent();
                    intent.putExtra("oauth_token", oauth_token);
                    intent.putExtra("openid", openid);
                    WebActivity.this.setResult(RESULT_OK, intent);
                    finish();
                    return true;
                }
            }
            return false;
//            if (Uri.parse(url).getHost().equals("www.baidu.com")) {
//                // 这个是我的网页，所以不要覆盖，让我的WebView来加载页面
//                return false;
//            }
//            // 否则，这个链接不是我的网站页面，因此启用浏览器来处理urls
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            WebActivity.this.setWebTitle(view.getTitle());
            mPlaceHolderView.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(getBaseContext(), "error:" + error.toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            Toast.makeText(getBaseContext(), "error:" + errorResponse.toString(), Toast.LENGTH_LONG).show();

        }
    }

    private void setWebTitle(String title) {
        mTitleTv.setText(title);
    }


    /**
     *  顶部的返回箭头 调用 此方法
     */

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 检查是否为返回事件，如果有网页历史记录
//        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
//            mWebView.goBack();
//            return true;
//        }
//        // 如果不是返回键或没有网页浏览历史，保持默认
//        // 系统行为（可能会退出该活动）
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.nav_btn_more:
                // show spinner
                // 顶部Header更多操作
                showHeaderOptMenu(v);
                break;
        }
    }

    /**
     * 显示操作popup - 收藏，浏览器打开，复制链接
     * @param anchor
     */
    private void showHeaderOptMenu(View anchor) {
        WebOptPopup webOptPopup = new WebOptPopup(this, mUrl);
        webOptPopup.showAtLocation(anchor.getRootView(), Gravity.BOTTOM, 0, 0);
    }

    /**
     * Convenience method to set some generic defaults for a
     * given WebView
     *
     * @param webView
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setUpWebViewDefaults(WebView webView) {
        WebSettings settings = webView.getSettings();

        // Enable Javascript
        settings.setJavaScriptEnabled(true);
        // Use WideViewport and Zoom out if there is no viewport defined
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        // Enable pinch to zoom without the zoom buttons
        settings.setBuiltInZoomControls(true);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            // Hide the zoom controls for HONEYCOMB+
            settings.setDisplayZoomControls(false);
        }

        // Enable remote debugging via chrome://inspect
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        setUpCacheCtrol();
    }

    private void setUpCacheCtrol() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK

        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        // 开启DOM storage API 功能
        mWebView.getSettings().setDomStorageEnabled(true);
        // 开启database storage API功能
        mWebView.getSettings().setDatabaseEnabled(true);
        String cacheDirPath = getFilesDir().getAbsolutePath()
                + APP_CACHE_DIRNAME;
        Log.i("cachePath", cacheDirPath);
        // 设置数据库缓存路径
        mWebView.getSettings().setDatabasePath(cacheDirPath); // API 19 deprecated
        // 设置Application caches缓存目录
        mWebView.getSettings().setAppCachePath(cacheDirPath);
        // 开启Application Cache功能
        mWebView.getSettings().setAppCacheEnabled(true);

    }
    // Change the layout algorithm used in the WebView
    private void setUseTextAutoSize(boolean useAlgorithm) {
        WebSettings settings = mWebView.getSettings();

        WebSettings.LayoutAlgorithm layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL;
        if(useAlgorithm) {
//            layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
        }

        settings.setLayoutAlgorithm(layoutAlgorithm);
    }
}
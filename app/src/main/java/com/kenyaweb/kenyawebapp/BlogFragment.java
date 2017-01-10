package com.kenyaweb.kenyawebapp;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {

//    public WebView blogWebView;


//    public BlogFragment() {
//        // Required empty public constructor
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);

        final WebView webView = (WebView) rootView.findViewById(R.id.blog_webview);
        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "Please wait, Loading Page...", true);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {}

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url){
                dialog.dismiss();
                String webUrl = webView.getUrl();
            }
        });

        webView.loadUrl("http://kenyaweb.com/Blog/");

        return rootView;


//        blogWebView = (WebView) v.findViewById(R.id.blog_webview);
//        blogWebView.loadUrl("http://kenyaweb.com/Blog/");
//
//        // Enable Javascript
//        WebSettings webSettings = blogWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);



////         Force links and redirects to open in the WebView instead of in a browser
//        blogWebView.setWebViewClient(new WebViewClient());

//        blogWebView.setWebViewClient(new WebViewClient() {
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//                super.onPageStarted(view, url, favicon);
//                view.findViewById(R.id.progress1).setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                view.findViewById(R.id.progress1).setVisibility(View.GONE);
//            }
//        });


//        return v;


//        blogWebView = (WebVieblogWebView.loadUrl("http://kenyaweb.com/Blog/");w) blogWebView.findViewById(R.id.blog_webview);
//        blogWebView.loadUrl("http://kenyaweb.com/Blog/");
//
//        // Enable Javascript
//        WebSettings webSettings = blogWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        // Force links and redirects to open in the WebView instead of in a browser
//        blogWebView.setWebViewClient(new WebViewClient());
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blog, container, false);
    }

}

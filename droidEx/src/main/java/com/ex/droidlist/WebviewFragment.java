package com.ex.droidlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

/**
 * Created by jitesh on 14/3/17.
 */

public class WebviewFragment extends Fragment {

    private String postUrl = "http://www.google.com";
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imgHeader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_view, container, false);

        webView = (WebView) view.findViewById(R.id.webView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        imgHeader = (ImageView) view.findViewById(R.id.backdrop);

        // initializing toolbar
        initCollapsingToolbar(view);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(postUrl);
        webView.setHorizontalScrollBarEnabled(false);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
//                if (!loadingFinished) {
//                    redirect = true;
//                }
//
//                loadingFinished = false;
                webView.loadUrl(urlNewString);
                Log.e("shouldOver", "1");
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                if(!redirect){
//                    loadingFinished = true;
//                }
//
//                if(loadingFinished && !redirect){
//                    //HIDE LOADING IT HAS FINISHED
//                } else{
//                    redirect = false;

//                }
                Log.e("onPageFinished", "3");
            }
        });

//        webView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return false;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//
//                if (url.contains("/allow")){
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Intent intent = new Intent();
//                            intent.putExtra("token", token);
//                            setResult(11, intent);
//                            finish();
//                        }
//                    }, 1000);
//
//                }
//            }
//        });

        return view;
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar txtPostTitle on scroll
     */
    private void initCollapsingToolbar(View view) {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the txtPostTitle when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Web View");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

        // loading toolbar header image
        Glide.with(getActivity().getApplicationContext()).load("http://api.androidhive.info/webview/nougat.jpg")
                .thumbnail(0.5f)
                .into(imgHeader);
    }

}

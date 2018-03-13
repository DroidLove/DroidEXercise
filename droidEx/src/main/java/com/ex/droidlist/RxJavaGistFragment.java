package com.ex.droidlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.droidlist.databinding.FragmentRxJavaGistBinding;
import com.ex.droidlist.helper.Gist;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by itrs-203 on 11/6/17.
 */

public class RxJavaGistFragment extends Fragment {

    private static final String TAG = "RxJavaGistFragment";
    FragmentRxJavaGistBinding fragmentRxJavaGistBinding;
//    private Subscription subscriber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentRxJavaGistBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_rx_java_gist, container, false);

//        subscriber = getGistRepoObserable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Gist>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        Log.e(TAG, "onError: " + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Gist gist) {
//
//                        StringBuilder sb = new StringBuilder();
//
//                        for (Map.Entry<String, GistRepo> entry : gist.stringGistRepoMap.entrySet()) {
//
//                            sb.append(entry.getKey());
//                            sb.append("_");
//                            sb.append("Length of the file");
//                            sb.append(entry.getValue().content.length());
//                        }
//
//                        fragmentRxJavaGistBinding.textviewResponse.setText(sb.toString());
//
//                    }
//                });

        return fragmentRxJavaGistBinding.getRoot();
    }

//    private Observable<Gist> getGistRepoObserable() {
//
//        return Observable.defer(new Func0<Observable<Gist>>() {
//            @Override
//            public Observable<Gist> call() {
//
//                try {
//
//                    return Observable.just(getGist());
//                } catch (IOException e) {
//                    return null;
//                }
//            }
//        });
//
//    }

    @Nullable
    public Gist getGist() throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.github.com/gists/9c9fb7bd0264354f00e5768bac06d794").build();

        Response response = okHttpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            Gist gist = new Gson().fromJson(response.body().charStream(), Gist.class);
            return gist;
        }

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (subscriber != null && subscriber.isUnsubscribed()) {
//            subscriber.unsubscribe();
//        }
    }
}

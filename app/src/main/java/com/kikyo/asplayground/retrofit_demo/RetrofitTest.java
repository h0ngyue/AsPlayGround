package com.kikyo.asplayground.retrofit_demo;

import okio.ByteString;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by shuailongcheng on 13/02/2017.
 */

public class RetrofitTest {

    public static void test() {

        ByteString bs;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpbinService httpbinService = retrofit.create(HttpbinService.class);
        httpbinService.testGet();

        Timber.d("httpbinService:%s", httpbinService.getClass().toString());

        Api2 api2 = retrofit.create(Api2.class);
        api2.testGet();

        Timber.d("api2:%s", api2.getClass().toString());

    }
}

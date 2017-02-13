package com.kikyo.asplayground.retrofit_demo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shuailongcheng on 13/02/2017.
 */

public interface Api2 {
    @GET("/get?arg1=hello")
    Call<HttpbinRequest> testGet();
}
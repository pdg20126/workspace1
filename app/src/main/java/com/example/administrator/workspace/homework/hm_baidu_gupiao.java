package com.example.administrator.workspace.homework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface hm_baidu_gupiao {
    @GET("/apistore/mobilenumber/mobilenumber")
    Call<hm_baidu_gupiao_bean> getgupiaoInfo(@Header("apikey") String apikey, @Query("stockid") String gupiaoNum,@Query("list") String listNum);
}

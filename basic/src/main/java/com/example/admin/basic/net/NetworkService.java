package com.example.admin.basic.net;

import com.example.admin.basic.bean.IndexList;
import com.example.admin.basic.bean.OneList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by admin on 2017/10/31.
 */

public interface NetworkService {

    @GET("api/onelist/idlist/")
    Observable<IndexList> getIndexList(@Query("channel")String channel,@Query("version")String version,@Query("uuid")String uuid,@Query("platform")String platform);

    @GET("api/onelist/{data}/0")
    Observable<OneList> getOneList(@Path("data") String data, @Query("channel")String channel, @Query("uuid")String uuid, @Query("platform")String platform);
}

package com.example.ibrahim.testworldcup.network;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by ibrahim on 19/01/18.
 */

public interface BaseApiService {

  //  @Headers ({"content-type: application/json"})

    //for log in  user url
    @FormUrlEncoded
    @POST ("getMatches.php")
    Call<ResponseBody> GetMatches (    @Field ("finished") String finished);


}

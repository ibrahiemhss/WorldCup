package com.example.ibrahim.testworldcup.data.network.connection;


import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;



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

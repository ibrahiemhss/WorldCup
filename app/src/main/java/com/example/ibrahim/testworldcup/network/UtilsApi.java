package com.example.ibrahim.testworldcup.network;

import com.example.ibrahim.testworldcup.network.BaseApiService;
import com.example.ibrahim.testworldcup.network.RetroConnect;

import static com.example.ibrahim.testworldcup.data.Contract.AUTHORITY;

/**
 * Created by ibrahim on 19/01/18.
 */

public class UtilsApi {
    public static BaseApiService getAPIService(){
        return RetroConnect.getClient(AUTHORITY).create(BaseApiService.class);
    }    }
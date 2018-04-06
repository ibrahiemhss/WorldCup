package com.example.ibrahim.testworldcup.data.network.connection;

import static com.example.ibrahim.testworldcup.data.contract.AUTHORITY;

/**
 * Created by ibrahim on 19/01/18.
 */

public class UtilsApi {
    public static BaseApiService getAPIService(){
        return RetroConnect.getClient(AUTHORITY).create(BaseApiService.class);
    }    }
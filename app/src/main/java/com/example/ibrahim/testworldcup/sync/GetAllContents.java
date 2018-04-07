package com.example.ibrahim.testworldcup.sync;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.network.BaseApiService;
import com.example.ibrahim.testworldcup.network.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.ibrahim.testworldcup.data.Contract.URL_SYNC;

/**
 * Created by ibrahim on 26/12/17.
 */
public class GetAllContents {
    private static final String TAG = GetAllContents.class.getSimpleName ();

    private RequestQueue requestQueue;
    DBHelber mDbHelber;
    BaseApiService mApiService;
    Context context;
    public GetAllContents(Context context) {
        this.context = context;
        mDbHelber = new DBHelber( context );
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

    }

 /*   public void getMatches(Context context) {

        mApiService.GetMatches ("yes")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        if (response.isSuccessful()){

                            try {
                                String remoteResponse=response.body().string();

                                Log.d("JSONDR", remoteResponse);

                                JSONObject jsonRESULTS = new JSONObject(remoteResponse);
                                if (jsonRESULTS.getString("error").equals("false")){
                                String TeamA = jsonRESULTS.getString("TeamA");
                                  String TeamB = jsonRESULTS.getString("TeamB");
                          //          JSONObject user = jsonRESULTS.getJSONObject("matches");
                                  //  String TeamA = user.getString("TeamA");
                                  //  String TeamB = user.getString("TeamB");

                          //  String TeamA = jsonRESULTS.getJSONObject("matches").getString("TeamA");
                             //  String TeamB = jsonRESULTS.getJSONObject("matches").getString("TeamB");
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    mDbHelber.addMathesList ( TeamA, TeamB);

                                    Log.i("TeamssValue", "["+ TeamA+"]");
                                   // Log.e("debuguser", name);
                                  //  Log.v("TeamssValue", "TeamA> "+TeamA );

                                    Log.v("TeamssValue", "TeamA > "+TeamA );

                                    Log.e("debug", "succeess: ERROR > "+error_message );
                                } else {
                                    // Jika login gagal
                                    Log.e("debug", "onFailure: ERROR > " );
                                    String error_message = jsonRESULTS.getString("error_msg");

                                    Log.e("debug", "noAcount: ERROR > "+error_message );

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });

    }
*/


    public void getMatches(Context context) {

        StringRequest stringRequest = new StringRequest( Request.Method.POST, URL_SYNC ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //       JSONObject jObj = new JSONObject(response);

                            JSONArray jsonArray = new JSONArray( response );

                            PARSE_STATES( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String> ();
                params.put("finished", "yes");

                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_STATES(JSONArray array) {
        for (int i = 0; i < array.length (); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject (i);

                String TeamA = json.getString ("TeamA");
                String TeamB = json.getString ("TeamB");

                mDbHelber.addMathesList (TeamA, TeamB);

                Log.d (TAG, "value from face server : \n TeamA" + TeamA + "\n TeamB :" + TeamB);

            } catch (JSONException e) {
                e.printStackTrace ();
                Log.d (TAG, "JSONException bbbb" + e.getMessage ());

            }
        }
    }
}

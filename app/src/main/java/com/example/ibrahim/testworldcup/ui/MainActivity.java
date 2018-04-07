package com.example.ibrahim.testworldcup.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.network.BaseApiService;
import com.example.ibrahim.testworldcup.sync.GetAllContents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.ibrahim.testworldcup.data.Contract.URL_SYNC;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName ();


    GetAllContents getAllContents;
    DBHelber mDbHelber;
    RequestQueue requestQueue;
    BaseApiService mApiService;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    //  getAllContents=new GetAllContents (this);
     //getAllContents.getMatches (this);
        mDbHelber = new DBHelber( this );
        getMatches(this);
        findViewById (R.id.BtnGoMatches).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (MainActivity.this, MatchesActiviy.class);
                startActivity (intent);
            }
        });
    }
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
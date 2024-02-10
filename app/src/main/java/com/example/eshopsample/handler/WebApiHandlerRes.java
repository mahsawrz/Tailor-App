package com.example.eshopsample.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.eshopsample.interfaces.IData;
import com.example.eshopsample.utils.WebApiTypes;
import com.example.eshopsample.activities.server.ResponseActivity;
import com.example.eshopsample.model.Response;
import com.example.eshopsample.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WebApiHandlerRes {
//--------------------*Define global variables*-----------------------------------------------------------------------------------
    Context context;
    String apiLink = "";
    ArrayList<Response> responseArrayList = new ArrayList<>();

//--------------------*WebApiHandlerRes constructor*-----------------------------------------------------------------------------------
    public WebApiHandlerRes(Context context) {
        this.context = context;
    }

//--------------------*API requests*-----------------------------------------------------------------------------------

 //This function  is responsible for making API requests using the Volley library
    public void apiConnect(WebApiTypes type) {//Taking a parameter  that is used to determine the type of API request to be made.
        switch (type) {
            case GetProducts: {
                apiLink = Config.getProductWebApi;
                break;
            }
            case GetRequest: {
                apiLink = Config.getRequestWebApi;
                break;
            }
            case SendResponse: {
                apiLink = Config.getResponseWebApi;
                break;
            }

        }

        /*
        *Creating a progress dialog to show the user that the request is being processed.
        *Setting up a request object with the appropriate URL and response/error listeners.
        *Adding the request to a request queue for execution.
         */

        ProgressDialog progressDialog = ProgressDialog.show(context, "connecting", "please wait"
                , false, false);
        StringRequest request = new StringRequest(Request.Method.POST
                , apiLink, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJson(response);
                progressDialog.dismiss();

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

//--------------------*Parsing a JSON response*-----------------------------------------------------------------------------------

//This function is responsible for parsing a JSON response from an API and populating a list of `Product` objects.
    private void showJson(String response) {
        responseArrayList.clear();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String CR_ID = jsonObject1.getString("CR_ID");
                String CR_RegisterDate = jsonObject1.getString("CR_RegisterDate");
                String CR_RegisterTime = jsonObject1.getString("CR_RegisterTime");
                String CR_ResponseDate = jsonObject1.getString("CR_ResponseDate");
                String CR_ResponseTime = jsonObject1.getString("CR_ResponseTime");
                String U_ID_fk = jsonObject1.getString("U_ID_fk");
                String CR_ResponseDescription = jsonObject1.getString("CR_ResponseDescription");
                String CR_RegisterDescription = jsonObject1.getString("CR_RegisterDescription");
                String CR_Image = jsonObject1.getString("CR_Image");
                Response res = new Response(CR_ID, CR_RegisterDate, CR_RegisterTime, CR_ResponseDate, CR_ResponseTime, U_ID_fk
                        , CR_ResponseDescription, CR_RegisterDescription, CR_Image);

                responseArrayList.add(res);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Updating the list in the response activity.
        ResponseActivity.resArrayList = responseArrayList;

        //The `context` is cast to the `IData` interface
        IData iData = (IData) context;

        //Using to notify the context that the data has been updated.
        iData.sendData();
    }


}


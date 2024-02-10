package com.example.eshopsample.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.eshopsample.interfaces.IData;
import com.example.eshopsample.utils.WebApiTypes;
import com.example.eshopsample.activities.MainActivity;
import com.example.eshopsample.model.Product;
import com.example.eshopsample.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WebApiHandler {
//--------------------*Define global variables*-----------------------------------------------------------------------------------
    Context context;
    String apiLink = "";
    ArrayList<Product> productArrayList = new ArrayList<>();

//--------------------*WebApiHandler constructor*-----------------------------------------------------------------------------------
    public WebApiHandler(Context context) {
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
                , apiLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJson(response);
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
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
        productArrayList.clear();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String id = jsonObject1.getString("id");
                String name = jsonObject1.getString("name");
                String fname = jsonObject1.getString("fname");
                String ename = jsonObject1.getString("ename");
                String description = jsonObject1.getString("description");
                String price = jsonObject1.getString("price");
                String photo = jsonObject1.getString("photo");
                Product p = new Product(id, name, fname, ename, description, price, photo);

                productArrayList.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Updating the list in the main activity.
        MainActivity.productArrayList = productArrayList;

        //The `context` is cast to the `IData` interface
        IData iData = (IData) context;

        //Using to notify the context that the data has been updated.
        iData.sendData();
    }

}


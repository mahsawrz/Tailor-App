package com.example.eshopsample.activities.server;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.eshopsample.R;
import com.example.eshopsample.utils.Config;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class SubmitResponseActivity extends AppCompatActivity {

//--------------------*Define global variables*-----------------------------------------------------------------------------------
    EditText edTxt_id, edTxt_date, edTxt_time, edTxt_dec;
    Button save_btn, back_btn;
    public static String sId;
//--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_response);

//--------------------*Identification of variables*-----------------------------------------------------------------------------------
        edTxt_id = findViewById(R.id.cus_id);
        edTxt_date = findViewById(R.id.cus_date);
        edTxt_time = findViewById(R.id.cus_time);
        edTxt_dec = findViewById(R.id.ad_des);
        save_btn = findViewById(R.id.bsave);
        back_btn = findViewById(R.id.bback);

        edTxt_id.setText(sId);
//--------------------*Actionable Buttons events*-----------------------------------------------------------------------------------
        //By clicking on the save button, the response information will be sent to  server side.
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    save();
                } catch (Exception ignored) {
                    ignored.getMessage();
                }
            }
        });

        //Back to before & Cancel response information saving
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });

    }

//--------------------*Request to a web API*-----------------------------------------------------------------------------------

    /*
    *Volley  schedules all network requests.
    * Connect to the server with Volley
    * */
    private void save() throws IOException {   //POST request to a web API to save data.
        //Showing the progress dialog: This indicates to the user that some operation is in progress.
        final ProgressDialog loading = ProgressDialog.show(this, "Uploading...", "Please wait...", false, false);

       //Creating and Sending Request: StringRequest object for making a POST request to the specified web API
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GetResponseWebApi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) { //Handling the successful response from the server.
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast message of the response
                        Toast.makeText(SubmitResponseActivity.this, s, Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {//Handling any error response from the server
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(SubmitResponseActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            /*
             * getParams() retrieves data from EditText fields (`edTxt_date`, `edTxt_time`, and `edTxt_dec`)
             *  and sets them as parameters for the request.
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {//Setting Request Parameters

                String date = edTxt_date.getText().toString().trim();
                String time = edTxt_time.getText().toString().trim();
                String dec = edTxt_dec.getText().toString().trim();

                //Creating parameters
                Map<String, String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put("CR_ResponseDate", date);
                params.put("CR_ResponseTime", time);
                params.put("CR_ResponseDescription", dec);
                params.put("CR_ID", sId);

                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue:  creates a RequestQueue using Volley to handle network requests.
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue: sending the POST request to the web API with the specified parameters.
        requestQueue.add(stringRequest);
    }
}
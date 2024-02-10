package com.example.eshopsample.activities.server;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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


import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class ReserveActivity extends AppCompatActivity {
//--------------------*Define global variables*-----------------------------------------------------------------------------------
    EditText edName, edFamily, edDec;
    ImageView imgModel;
    Button btnSave, btnBack;
    Bitmap bitmap;
//--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

//--------------------*Identification of variables*-----------------------------------------------------------------------------------
        edName = findViewById(R.id.edName);
        edFamily = findViewById(R.id.edFamily);
        edDec = findViewById(R.id.edDec);
        imgModel = findViewById(R.id.imgModel);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);

//--------------------*Actionable Buttons events*-----------------------------------------------------------------------------------
        //By clicking on the save button, the image will be sent to  server side.
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    uploadImage(bitmap);
                } catch (Exception ignored) {

                }

            }
        });

        //Back to before & Cancel response information saving
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });

        //By clicking on the image location, can choose image from gallery
        imgModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
    }

 //--------------------*Handle the result of an activity*-----------------------------------------------------------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //Handling the result properly

        //Checking the Request Code and Result Code
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Retrieving the URI of the selected image from the `data` Intent object.
            Uri uri = data.getData();
            try {
                //Obtaining a `Bitmap` object from the image URI
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgModel.setImageBitmap(bitmap);//The selected image is converted into a `Bitmap` object.
            } catch (IOException ignored) {
                ignored.getMessage();
            }

        }
    }

 //--------------------*Convert image to string*-----------------------------------------------------------------------------------

    //Converting Bitmap to Base64 String => sending images to a server through a web API
    public String getStringImage(Bitmap bmp) {

        //Creating a ByteArrayOutputStream: Writing image data  into a byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        /*
        * compresses the Bitmap `bmp` into a PNG format with maximum quality (100)
        *  and writes the compressed data into the ByteArrayOutputStream `baos`.
        */
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);

        //Converting to Byte Array
        byte[] imageBytes = baos.toByteArray();

        //Encoding the byte array `imageBytes` into a Base64 encoded string
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

 //--------------------*Upload an image to server*-----------------------------------------------------------------------------------

    /*
     *Volley  schedules all network requests.
     * Connect to the server with Volley
     * */
    private void uploadImage(Bitmap bitmap) throws IOException { //POST request to a web API to upload image.
        //Showing the progress dialog: This indicates to the user that some operation is in progress.
        final ProgressDialog loading = ProgressDialog.show(this, "Uploading...", "Please wait...", false, false);

        //Creating and Sending Request: StringRequest object for making a POST request to the specified web API
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.getRequestWebApi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {//Handling the successful response from the server.
                        //Disimissing the progress dialog
                        loading.dismiss();

                        //Showing toast message of the response
                        Toast.makeText(ReserveActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {//Handling any error response from the server
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(ReserveActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }) {

            /*
             * getParams() retrieves data from EditText fields (`edName`, `edFamily`, and `edDec`) & converts the Bitmap image to a Base64 encoded string
             *  and sets them as parameters for the request.
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //Setting Request Parameters

                String image = getStringImage(bitmap);//Converting Bitmap to String
                String name = edName.getText().toString().trim();
                String fname = edFamily.getText().toString().trim();
                String dec = edDec.getText().toString().trim();

                //Creating parameters
                Map<String, String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put("img", image);
                params.put("name", name);
                params.put("family", fname);
                params.put("dec", dec);
                params.put("U_ID_fk", "1");

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
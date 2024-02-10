package com.example.eshopsample.activities.server;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.eshopsample.adapters.AdapterResponse;
import com.example.eshopsample.adapters.AdapterUser;
import com.example.eshopsample.interfaces.IData;
import com.example.eshopsample.R;
import com.example.eshopsample.handler.WebApiHandlerRes;
import com.example.eshopsample.utils.RecyclerTouchListener;
import com.example.eshopsample.utils.WebApiTypes;
import com.example.eshopsample.model.Response;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity implements IData {
 //--------------------*Define global variables*-----------------------------------------------------------------------------------
    WebApiHandlerRes webApiHandler;
    RecyclerView rcMain;
    public static ArrayList<Response> resArrayList = new ArrayList<>();
    static Response response;
//--------------------------------------------------------------------------------------------------------------------------------------

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

//--------------------*Identification of variables*-----------------------------------------------------------------------------------
        rcMain=findViewById(R.id.rcMainRes);

//--------------------*Set up  listener for  RecyclerView*-----------------------------------------------------------------------------------
        /*
        *Show user responses in RecyclerView:
        *send the date and time of the visit and the  description from the server
         */

        webApiHandler = new WebApiHandlerRes(this);//WebApiHandler object is created  for handling web API requests
        webApiHandler.apiConnect(WebApiTypes.SendResponse);//Connect the SendResponse(server PHP file)
        rcMain.addOnItemTouchListener(new RecyclerTouchListener(this, rcMain, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ResponseActivity.response = resArrayList.get(position);
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));

    }

 //--------------------*Fill up  RecyclerView*---------------------------------------------------------------------------------------
    @Override
    public void sendData() {
        //Client side
        AdapterUser adapter = new AdapterUser(this,resArrayList);

        rcMain.setLayoutManager(new LinearLayoutManager(this));
        rcMain.setItemAnimator(new DefaultItemAnimator());
        rcMain.setAdapter(adapter);

    }

}
package com.example.eshopsample.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopsample.utils.Config;
import com.example.eshopsample.R;
import com.example.eshopsample.model.Response;
import com.example.eshopsample.activities.server.SubmitResponseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterResponse extends RecyclerView.Adapter<AdapterResponse.MyHolder> {

 //--------------------*Define global variables*-----------------------------------------------------------------------------------
    private ArrayList<Response> ProductList;
    private Context c;
    static Intent i;

 //--------------------*AdapterResponse constructor*-----------------------------------------------------------------------------------
    public AdapterResponse(Context c, ArrayList<Response> productArrayList) {
        this.ProductList = productArrayList;
        this.c = c;
    }

    /*
    INITIALIZE VIEWHOLDER
     */

// These  functions are part of an adapter class that is used to display a list of products in a RecyclerView
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {//Creates a new ViewHolder by loading a layout file
        View v = LayoutInflater.from(c).inflate(R.layout.row_request, parent, false);
        return new MyHolder(v);
    }

    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {//Binds the data to the views in the ViewHolder
        Response s = ProductList.get(position);

        //Setting the text of `txt_regDate` in the ViewHolder to the value received from Register Date of user.
        holder.txt_regDate.setText(s.getCR_RegisterDate());

        //Setting the text of `txt_regTime` in the ViewHolder to the value received from Register Time of user.
        holder.txt_regTime.setText(s.getCR_RegisterTime());

//--------------------*Actionable events*-------------------------------------------------------------------------------------
        //This Button is used for admin to respond users
        holder.answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitResponseActivity.sId = s.getCR_ID();
                i = new Intent(c.getApplicationContext(), SubmitResponseActivity.class);//Directing the admin to submit the response to the user
                c.startActivity(i);

            }
        });

        //Setting the text of `txt_regDesc` in the ViewHolder to the value received from Register Description of user.
        holder.txt_regDesc.setText(s.getCR_RegisterDescription());

        //Loading an image models that users had uploaded
        Picasso.with(c).load(Config.Ip_Value+"/requests/"+s.getCR_Image()).into(holder.cusImg_model);

    }

    /*
    TOTAL SPACECRAFTS NUM
     */
    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    //-----------------------------------*MyHolder*-------------------------------------------------------------------
    /*
    VIEW HOLDER CLASS
    This  static nested class  extends `RecyclerView.ViewHolder`.
     It is used to hold the views that make up each item in the RecyclerView.
     */

    static class MyHolder extends RecyclerView.ViewHolder {
 //--------------------*Define global variables in static class*-----------------------------------------------------------------------------------
        TextView txt_regDate, txt_regTime, txt_regDesc;
        ImageView cusImg_model;
        Button answerBtn;

        /*
         * calls the constructor of the superclass `RecyclerView.ViewHolder`
         *  with the provided `itemView`, which is the layout for an individual
         *  item in the RecyclerView.
         */
        public MyHolder(View itemView) {
            super(itemView);


            txt_regDate = itemView.findViewById(R.id.customerReq_date);
            txt_regTime = itemView.findViewById(R.id.customerReq_time);
            txt_regDesc = itemView.findViewById(R.id.customerReq_dec);
            cusImg_model = itemView.findViewById(R.id.cusImg_model);
            answerBtn = itemView.findViewById(R.id.answerCus);
        }
    }
}

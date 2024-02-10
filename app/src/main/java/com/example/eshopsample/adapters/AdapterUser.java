package com.example.eshopsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopsample.utils.Config;
import com.example.eshopsample.R;
import com.example.eshopsample.model.Response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyHolder> {

//--------------------*Define global variables*-----------------------------------------------------------------------------------
    private ArrayList<Response> ProductList;
    private Context c;

 //--------------------*AdapterUser constructor*-----------------------------------------------------------------------------------
    public AdapterUser(Context c, ArrayList<Response> productArrayList) {
        this.ProductList = productArrayList;
        this.c = c;
    }

    /*
    INITIALIZE VIEWHOLDER
     */
// These  functions are part of an adapter class that is used to display a list of products in a RecyclerView
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {//Creates a new ViewHolder by loading a layout file
        View v = LayoutInflater.from(c).inflate(R.layout.row_user, parent, false);
        return new MyHolder(v);
    }

    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {//Binds the data to the views in the ViewHolder
        Response s = ProductList.get(position);

        //Setting the text of `txt_resDate` in the ViewHolder to the value received from Response Date of user.
        holder.txt_resDate.setText(s.getCR_ResponseDate());

        //Setting the text of `txt_resTime` in the ViewHolder to the value received from ResponseTime of user.
        holder.txt_resTime.setText(s.getCR_ResponseTime());

        //Setting the text of `txt_resDesc` in the ViewHolder to the value received from Response Description of user.
        holder.txt_resDesc.setText(s.getCR_ResponseDescription());

        //Loading an image models that users had uploaded
        Picasso.with(c).load(Config.Ip_Value + "/requests/" + s.getCR_Image()).into(holder.cusImg_model);


    }


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
        TextView txt_resDate, txt_resTime, txt_resDesc;
        ImageView cusImg_model;

        /*
         * calls the constructor of the superclass `RecyclerView.ViewHolder`
         *  with the provided `itemView`, which is the layout for an individual
         *  item in the RecyclerView.
         */
        public MyHolder(View itemView) {
            super(itemView);


            txt_resDate = itemView.findViewById(R.id.customerReq_date);
            txt_resTime = itemView.findViewById(R.id.customerReq_time);
            txt_resDesc = itemView.findViewById(R.id.customerReq_dec);
            cusImg_model = itemView.findViewById(R.id.cusImg_model);

        }
    }
}

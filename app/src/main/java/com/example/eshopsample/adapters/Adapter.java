package com.example.eshopsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopsample.utils.Config;
import com.example.eshopsample.model.Product;
import com.example.eshopsample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

 //--------------------*Define global variables*-----------------------------------------------------------------------------------
    private final ArrayList<Product> ProductList;
    private Context c;

 //--------------------*Adapter constructor*-----------------------------------------------------------------------------------
    public Adapter(Context c, ArrayList<Product> productArrayList) {
        this.ProductList = productArrayList;
        this.c = c;
    }
//--------------------------------------------------------------------------------------------------------------------------------------
    /*
    INITIALIZE VIEW HOLDER
     */
// These  functions are part of an adapter class that is used to display a list of products in a RecyclerView

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {//Creates a new ViewHolder by loading a layout file

        //Getting the LayoutInflater instance in order  to load the view
        View v = LayoutInflater.from(c).inflate(R.layout.row_layout, parent, false);
        return new MyHolder(v);
    }


    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {//Binds the data to the views in the ViewHolder
        Product s = ProductList.get(position);

        //Setting the text of `txtName1` in the ViewHolder to the value received from persian name of the product.
        holder.txtName1.setText(s.getcFaname());

        //Setting the text of `txtName2` in the ViewHolder to the value received from english name of the product.
        holder.txtName2.setText(s.getcEnname());

        //Loading an image from Loads URL constructed
        Picasso.with(c).load(Config.Ip_Value + "/clothimg/" + s.getPhoto()).into(holder.imgv);

//--------------------*Actionable events*-------------------------------------------------------------------------------------
        holder.imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(c, android
                        .R.anim.slide_in_left)); //Display the image with special animation
            }
        });

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
        TextView txtName1, txtName2;
        ImageView imgv;

        /*
        * calls the constructor of the superclass `RecyclerView.ViewHolder`
        *  with the provided `itemView`, which is the layout for an individual
        *  item in the RecyclerView.
         */

        public MyHolder(View itemView) {
            super(itemView);

  //--------------------*Identification of variables*-----------------------------------------------------------------------------------
            txtName1 = itemView.findViewById(R.id.rowTxtProductFaName);
            txtName2 = itemView.findViewById(R.id.rowTxtProductEngName);
            imgv = itemView.findViewById(R.id.rowImgProduct);
        }
    }
}

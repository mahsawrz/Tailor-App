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

public class Adapterhorizontal extends RecyclerView.Adapter<Adapterhorizontal.MyHolder> {
 //--------------------*Define global variables*-----------------------------------------------------------------------------------
    private ArrayList<Product> ProductList;
    private Context c;

 //--------------------*Adapter horizontal constructor*-----------------------------------------------------------------------------------
    public Adapterhorizontal(Context c, ArrayList<Product> productArrayList) {
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
        View v = LayoutInflater.from(c).inflate(R.layout.row_layout_grid, parent, false);
        return new MyHolder(v);
    }

    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {//Binds the data to the views in the ViewHolder
        Product s = ProductList.get(position);

        //Setting the text of `txtName` in the ViewHolder to the value received from  name of the product.
        holder.txtName.setText(s.getName());

        //Setting the text of `txtPrice` in the ViewHolder to the value received from  price of the product.
        holder.txtPrice.setText(s.getPrice() + " تومان ");

        //Loading an image from Loads URL constructed
        Picasso.with(c).load(Config.Ip_Value + "/images/" + s.getPhoto()).into(holder.imgv);

//--------------------*Actionable events*-------------------------------------------------------------------------------------
        holder.imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(c, android
                        .R.anim.slide_in_left));//Display the image with special animation
            }
        });
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
     */
    class MyHolder extends RecyclerView.ViewHolder {
//--------------------*Define global variables in static class*-----------------------------------------------------------------------------------
        TextView txtName;
        TextView txtPrice;
        ImageView imgv;

    /*
     * calls the constructor of the superclass `RecyclerView.ViewHolder`
     *  with the provided `itemView`, which is the layout for an individual
     *  item in the RecyclerView.
     */

        public MyHolder(View itemView) {
            super(itemView);

//--------------------*Identification of variables*-----------------------------------------------------------------------------------
            txtName = itemView.findViewById(R.id.rowTxtProductName);
            txtPrice = itemView.findViewById(R.id.rowTxtPrice);
            imgv = itemView.findViewById(R.id.rowImgProduct);
        }
    }
}

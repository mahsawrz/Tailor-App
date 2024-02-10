package com.example.eshopsample.activities.server;


import android.os.Bundle;
import com.example.eshopsample.R;
import com.example.eshopsample.model.Product;
import com.example.eshopsample.utils.Config;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

 //--------------------*Define global variables*-----------------------------------------------------------------------------------
    TextView txtName, txtDesc;
    public static Product product;
    ImageView imageView;

//--------------------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

//--------------------*Identification of variables*-----------------------------------------------------------------------------------

        txtName = findViewById(R.id.txtfName);
        txtDesc = findViewById(R.id.txtDesc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout toolBarLayout =  findViewById(R.id.toolbar_layout);
        imageView = toolBarLayout.findViewById(R.id.imgTitle);


//--------------------*Product data recovery*-----------------------------------------------------------------------------------

        setSupportActionBar(toolbar);
        toolBarLayout.setTitle(product.getcFaname());
        String text = String.valueOf((product.getDescription()));
        txtName.setText(product.getcFaname());
        txtDesc.setText(text);
        Picasso.with(this).load(Config.Ip_Value + "clothimg/" + product.getPhoto()).into(imageView);

    }
}
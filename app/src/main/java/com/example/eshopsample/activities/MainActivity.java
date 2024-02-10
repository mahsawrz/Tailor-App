package com.example.eshopsample.activities;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.viewbinding.ViewBinding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;


import com.example.eshopsample.activities.server.ProductActivity;
import com.example.eshopsample.activities.server.ReserveActivity;
import com.example.eshopsample.activities.server.ResponseActivity;
import com.example.eshopsample.activities.slider.ColorStyleActivity;
import com.example.eshopsample.activities.slider.DifferentStyleActivity;
import com.example.eshopsample.activities.slider.ManStyleActivity;
import com.example.eshopsample.activities.slider.WomanStyleActivity;
import com.example.eshopsample.interfaces.IData;
import com.example.eshopsample.R;
import com.example.eshopsample.handler.WebApiHandler;
import com.example.eshopsample.utils.RecyclerTouchListener;
import com.example.eshopsample.utils.WebApiTypes;
import com.example.eshopsample.adapters.Adapter;
import com.example.eshopsample.adapters.Adapterhorizontal;
import com.example.eshopsample.model.Product;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IData {
 //--------------------*Define global variables*-----------------------------------------------------------------------------------
 public WebApiHandler webApiHandler;
    RecyclerView rcMain;
    public static ArrayList<Product> productArrayList = new ArrayList<>();
    List<CarouselItem> sliderList;
    public boolean doubleBackToExitPressedOnce = false;
    public Button btnObserv;
    public Button btnReq;

   // private FirebaseAnalytics mFirebaseAnalytics;
//--------------------------------------------------------------------------------------------------------------------------------------

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//--------------------*Identification of variables*-----------------------------------------------------------------------------------
        rcMain = findViewById(R.id.rcMain);
        ImageCarousel carousel = findViewById(R.id.carousel);
        btnObserv = findViewById(R.id.btn);
        btnReq = findViewById(R.id.btnReq);

 //--------------------*Actionable events*-------------------------------------------------------------------------------------

        //Order registration
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ResponseActivity.class);
                startActivity(intent);



            }
        });

        //View request
        btnObserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ReserveActivity.class);
                startActivity(intent);

            }
        });

//--------------------*Creation image slider*-----------------------------------------------------------------------------------

        carousel.setShowCaption(true);
        carousel.setCaptionMargin(Utils.dpToPx(0, this)); // px value of dp
        carousel.setCaptionTextSize(Utils.spToPx(20, this)); // px value of sp
        carousel.setShowIndicator(true);

        // Register lifecycle For activity
        carousel.registerLifecycle(getLifecycle());
        sliderList = new ArrayList<>();

        // Image URL with caption
        sliderList.add(
                new CarouselItem(
                        R.drawable.uu,
                        "معرفی استایل های زنانه"

                )
        );
        sliderList.add(
                new CarouselItem(
                        R.drawable.sec,
                        "معرفی استایل های مردانه"
                )
        );
        sliderList.add(
                new CarouselItem(
                        R.drawable.cc,
                        "تاثیر رنگ ها در استایل"
                )
        );
        sliderList.add(
                new CarouselItem(
                        R.drawable.nn,
                        "استایل مناسب افراد مختلف"
                )
        );
        carousel.setData(sliderList);

        //Implementation of carousel methods
        carousel.setCarouselListener(new CarouselListener() {
            @Override
            public void onLongClick(int i, @NonNull CarouselItem carouselItem) {

            }

            @Nullable
            @Override
            public ViewBinding onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
                return null;
            }

  //--------------------*Click on image slider*-----------------------------------------------------------------------------------
            @Override
            public void onClick(int i, @NonNull CarouselItem carouselItem) {
                switch (i) {
                    case 0:

                        startActivity(new Intent(MainActivity.this, WomanStyleActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ManStyleActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ColorStyleActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, DifferentStyleActivity.class));
                        break;
                }
            }

            @Override
            public void onBindViewHolder(@NonNull ViewBinding viewBinding, @NonNull CarouselItem carouselItem, int i) {

            }
        });

//--------------------*Set up  listener for  RecyclerView*-----------------------------------------------------------------------------------

        webApiHandler = new WebApiHandler(this);//WebApiHandler object is created  for handling web API requests
        webApiHandler.apiConnect(WebApiTypes.GetProducts);//Connect the GetProducts(server PHP file), for  getting required information from
        rcMain.addOnItemTouchListener(new RecyclerTouchListener(this, rcMain, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) { //Click on each row of recycler view
                view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
                ProductActivity.product = productArrayList.get(position);
                startActivity(new Intent(MainActivity.this, ProductActivity.class));//Show product detail of each row

                FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());

                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "button_click");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

  //--------------------*Fill up  RecyclerViews*-----------------------------------------------------------------------------------

    //display of two different sets of data in a vertical and horizontal layout
    @Override
    public void sendData() {
        // Linear Recycler View : cloth types
        Adapter adapter = new Adapter(this, productArrayList);
        rcMain.setLayoutManager(new LinearLayoutManager(this));
        rcMain.setItemAnimator(new DefaultItemAnimator());
        rcMain.setAdapter(adapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Horizontal Recycler View : work samples
        Adapterhorizontal adapterhorizontal = new Adapterhorizontal(this, productArrayList);
        RecyclerView myList = findViewById(R.id.rcMainh);
        myList.setLayoutManager(layoutManager);
        myList.setAdapter(adapterhorizontal);

    }

    //--------------------*Exit from program*-----------------------------------------------------------------------------------
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;

        Toast.makeText(this, "برای خروج دوباره بر روی دکمه بازگشت بزنید", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;

            }
        }, 2000);

    }


}
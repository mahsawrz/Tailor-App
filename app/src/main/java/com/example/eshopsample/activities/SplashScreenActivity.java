package com.example.eshopsample.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.eshopsample.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//--------------------*Introducing a delay*-----------------------------------------------------------------------------------

        /*
        * Scheduling a delay of 2 seconds using a `Handler`, and then starts the new activity.
        * This delay can be useful in scenarios where you want to show a splash screen
        *  or introduce a delay before transitioning to a new activity.
        * */

        //Creating a new `Handler` object and uses its `postDelayed` method to schedule a task to be executed after a specified delay
        new Handler().postDelayed(new Runnable() { //Containing the code that will be executed after the specified delay.
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);//The delay is set to 2000 milliseconds (or 2 seconds).

    }
}


package com.example.eshopsample.activities.slider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eshopsample.R;
import com.example.eshopsample.model.CustomListAdapter;
import com.example.eshopsample.model.WStyle;

import java.util.ArrayList;
import java.util.List;

public class ColorStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_style);


        List<WStyle> image_details = getListData();
        final ListView listView1 = findViewById(R.id.lstcolor);
        listView1.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {
                    case 0:
                        View v_app = getLayoutInflater().inflate(R.layout.activity_c1, null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder.setView(v_app);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        break;
                    case 1:
                        View v_app1 = getLayoutInflater().inflate(R.layout.c2, null);
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder1.setView(v_app1);
                        AlertDialog alertDialog1 = builder1.create();
                        alertDialog1.show();
                        break;
                    case 2:
                        View v_app2 = getLayoutInflater().inflate(R.layout.c3, null);
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder2.setView(v_app2);
                        AlertDialog alertDialog2 = builder2.create();
                        alertDialog2.show();
                        break;
                    case 3:
                        View v_app3 = getLayoutInflater().inflate(R.layout.c4, null);
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder3.setView(v_app3);
                        AlertDialog alertDialog3 = builder3.create();
                        alertDialog3.show();
                        break;
                    case 4:
                        View v_app4 = getLayoutInflater().inflate(R.layout.c5, null);
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder4.setView(v_app4);
                        AlertDialog alertDialog4 = builder4.create();
                        alertDialog4.show();
                        break;
                    case 5:
                        View v_app5 = getLayoutInflater().inflate(R.layout.c6, null);
                        AlertDialog.Builder builder5 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder5.setView(v_app5);
                        AlertDialog alertDialog5 = builder5.create();
                        alertDialog5.show();
                        break;
                    case 6:
                        View v_app6 = getLayoutInflater().inflate(R.layout.c7, null);
                        AlertDialog.Builder builder6 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder6.setView(v_app6);
                        AlertDialog alertDialog6 = builder6.create();
                        alertDialog6.show();
                        break;
                    case 7:
                        View v_app7 = getLayoutInflater().inflate(R.layout.c8, null);
                        AlertDialog.Builder builder7 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder7.setView(v_app7);
                        AlertDialog alertDialog7 = builder7.create();
                        alertDialog7.show();
                        break;
                    case 8:
                        View v_app8 = getLayoutInflater().inflate(R.layout.c9, null);
                        AlertDialog.Builder builder8 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder8.setView(v_app8);
                        AlertDialog alertDialog8 = builder8.create();
                        alertDialog8.show();
                        break;
                    case 9:
                        View v_app9 = getLayoutInflater().inflate(R.layout.c10, null);
                        AlertDialog.Builder builder9 = new AlertDialog.Builder(ColorStyleActivity.this);
                        builder9.setView(v_app9);
                        AlertDialog alertDialog9 = builder9.create();
                        alertDialog9.show();
                        break;
                }
            }
        });
    }


    //This function creates a list of "WStyle" type objects, fills it with ten different colors
    private List<WStyle> getListData() {
        List<WStyle> list = new ArrayList<WStyle>();
        WStyle i1 = new WStyle("green", "green", "سبز");
        WStyle i2 = new WStyle("blue", "blue", "آبی");
        WStyle i3 = new WStyle("brown", "brown", "قهوه ای");
        WStyle i4 = new WStyle("black", "black", "مشکی");
        WStyle i5 = new WStyle("yellow", "yellow", "زرد");
        WStyle i6 = new WStyle("gray", "gray", "خاکستری");
        WStyle i7 = new WStyle("red", "red", "قرمز");
        WStyle i8 = new WStyle("orange", "orange", "نارنجی");
        WStyle i9 = new WStyle("white", "white", "سفید");
        WStyle i10 = new WStyle("purple", "purple", "بنفش");

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);
        list.add(i6);
        list.add(i7);
        list.add(i8);
        list.add(i9);
        list.add(i10);

        return list;
    }

}
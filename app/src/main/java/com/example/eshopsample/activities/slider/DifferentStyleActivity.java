package com.example.eshopsample.activities.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eshopsample.R;
import com.example.eshopsample.model.CustomListAdapter;
import com.example.eshopsample.model.WStyle;

import java.util.ArrayList;
import java.util.List;

public class DifferentStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_style);


        List<WStyle> image_details = getListData();
        final ListView listView1 = findViewById(R.id.lstDiff);
        listView1.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(DifferentStyleActivity.this, ShortActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DifferentStyleActivity.this, TallActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(DifferentStyleActivity.this, FatActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(DifferentStyleActivity.this, ThinActivity.class));
                        break;
                }
            }
        });
    }

    //This function creates a list of `WStyle` objects. Each `WStyle` object represents a specific styling option for different body types.
    private List<WStyle> getListData() {
        List<WStyle> list = new ArrayList<WStyle>();
        WStyle i1 = new WStyle("استایل مناسب افراد قد کوتاه چه آیتم هایی دارد؟", "sht", "");
        WStyle i2 = new WStyle("استایل مناسب افراد قد بلند چه آیتم هایی دارد؟", "tall", "");
        WStyle i3 = new WStyle("اصول استایلینگ برای افراد چاق", "fat", "");
        WStyle i4 = new WStyle("لباس مناسب برای افراد لاغر", "thin", "");

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);

        return list;
    }

}
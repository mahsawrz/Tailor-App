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

public class WomanStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_style);


        List<WStyle> image_details = getListData();
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WomanStyleActivity.this, W1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WomanStyleActivity.this, W2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(WomanStyleActivity.this, W3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(WomanStyleActivity.this, W4Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(WomanStyleActivity.this, W5Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(WomanStyleActivity.this, W6Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(WomanStyleActivity.this, W7Activity.class));
                        break;
                    case 7:
                        startActivity(new Intent(WomanStyleActivity.this, W8Activity.class));
                        break;
                }
            }
        });
    }


    //
    private List<WStyle> getListData() {
        List<WStyle> list = new ArrayList<WStyle>();
        WStyle i1 = new WStyle("Maximal", "maximal", "ماکسیمال");
        WStyle i2 = new WStyle("Minimal", "minimal", "مینیمال");
        WStyle i3 = new WStyle("Vintage", "vintage", "وینتیج");
        WStyle i4 = new WStyle("Modern", "modern", "مدرن");
        WStyle i5 = new WStyle("Casual", "casual", "کژوآل");
        WStyle i6 = new WStyle("Retro", "retro", "رترو");
        WStyle i7 = new WStyle("Formal", "formalw", "رسمی");
        WStyle i8 = new WStyle("Street", "street", "خیابانی");

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);
        list.add(i6);
        list.add(i7);
        list.add(i8);

        return list;
    }

}
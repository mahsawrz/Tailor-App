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

public class ManStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_style);


        List<WStyle> image_details = getListData();
        final ListView listView1 = findViewById(R.id.lstman);
        listView1.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(ManStyleActivity.this, M1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ManStyleActivity.this, M2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ManStyleActivity.this, M3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(ManStyleActivity.this, M4Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ManStyleActivity.this, M5Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(ManStyleActivity.this, M6Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(ManStyleActivity.this, M7Activity.class));
                        break;
                    case 7:
                        startActivity(new Intent(ManStyleActivity.this, M8Activity.class));
                        break;
                }
            }
        });
    }

    //This function creates a list of `WStyle` objects, each representing a specific clothing style.
    private List<WStyle> getListData() {
        List<WStyle> list = new ArrayList<WStyle>();
        WStyle i1 = new WStyle("Semi-formal", "semiformal", "نیمه رسمی");
        WStyle i2 = new WStyle("Formal", "formal", "رسمی");
        WStyle i3 = new WStyle("Cocktail", "cocktail", "کوکتل");
        WStyle i4 = new WStyle("Classic", "classic", "کلاسیک");
        WStyle i5 = new WStyle("European", "european", "اروپایی");
        WStyle i6 = new WStyle("Business casual", "businessca", "کژوآل بیزینسی");
        WStyle i7 = new WStyle("Artistic", "artistic", "هنری");
        WStyle i8 = new WStyle("Norm Core", "normcore", "نرم کر");

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
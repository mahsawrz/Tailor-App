package com.example.eshopsample.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eshopsample.R;
import com.example.eshopsample.model.WStyle;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

//--------------------*Define global variables*-----------------------------------------------------------------------------------
    private List<WStyle> listData;
    private LayoutInflater layoutInflater;
    private Context context;

 //--------------------*CustomListAdapter constructor*-----------------------------------------------------------------------------------
    public CustomListAdapter(Context aContext, List<WStyle> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

 //--------------------*Fill up ListView*-----------------------------------------------------------------------------------

    /*
    * This function is a method from a custom adapter class used
    *  in Android to populate a ListView or GridView with data.
    *  It is called for each item in the list to create and configure the view for that item.
    **/

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder; //Hold references to the views in the list item layout.
        if (convertView == null) {//There is no recycled view available
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);//New view is inflated from the `list_item_layout` layout file.
            holder = new ViewHolder();

            //Identification of variables from convertView
            holder.flagView =  convertView.findViewById(R.id.imageView_flag);
            holder.engName =  convertView.findViewById(R.id.txtEnName);
            holder.faName =  convertView.findViewById(R.id.txtFaName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();//the `ViewHolder` object is retrieved from the tag
        }

        //The `WStyle` object at the specified `position` is retrieved from the `listData` list.
        WStyle wStyle = this.listData.get(position);
        holder.engName.setText(wStyle.getStyleName());
        holder.faName.setText(wStyle.getFaStyleName());

        //Getting the resource ID of the flag image.
        int imageId = this.getMipmapResIdByName(wStyle.getFlagName());

        //Setting the image resource
        holder.flagView.setImageResource(imageId);

        return convertView;
    }

 //-----------------------------------*Find image id*-------------------------------------------------------------------

 // Retrieving the resource ID of a mipmap resource based on its name
    public int getMipmapResIdByName(String resName) {

        //The package name of the application is obtained  to  identify the resource within the app's package.
        String pkgName = context.getPackageName();

        /*
        * getResources().getIdentifier() => Retrieve the resource ID of the mipmap resource:
        * It takes three parameters: the `resName` (name of the resource)
        * , the resource type (`"mipmap"` in this case),
        * and the package name.
        * */
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

//-----------------------------------*ViewHolder Class*-------------------------------------------------------------------

   //It is used to hold the views that make up each item in the ListView.
    static class ViewHolder {
        ImageView flagView;
        TextView engName;
        TextView faName;
    }

}
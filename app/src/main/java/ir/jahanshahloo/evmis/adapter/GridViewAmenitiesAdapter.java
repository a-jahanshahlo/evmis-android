package ir.jahanshahloo.evmis.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.model.AmenitieModel;
import ir.jahanshahloo.evmis.model.BaseModel;
import ir.jahanshahloo.evmis.model.ImageItem;

/**
 * Created by Ali on 10/29/16.
 */
public class GridViewAmenitiesAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private List<AmenitieModel> amenitieList;

    private Context mContext;

    public GridViewAmenitiesAdapter(Context context, int layoutResourceId, List<AmenitieModel> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.amenitieList = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
             holder.chkAmenitie = (AppCompatCheckBox) row.findViewById(R.id.chk_amenitie);

     //       holder.image = (ImageView) row.findViewById(R.id.image_new_house_gallery_item);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        AmenitieModel
                item = (AmenitieModel) amenitieList.get(position);
        holder.chkAmenitie.setText(item.getTitleFa());
        holder.chkAmenitie.setTag(R.string.grid_view_item_amenitie_id,item.getId());
    //    holder.image.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder {
        AppCompatCheckBox chkAmenitie;

    }


}

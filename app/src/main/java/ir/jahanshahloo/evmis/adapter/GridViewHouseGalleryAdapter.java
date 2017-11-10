package ir.jahanshahloo.evmis.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.di.modules.BaseDataModule;
import ir.jahanshahloo.evmis.model.BaseModel;
import ir.jahanshahloo.evmis.model.HouseForRent;
import ir.jahanshahloo.evmis.model.ImageItem;

/**
 * Created by Adminstrator on 9/11/2016.
 */
public class GridViewHouseGalleryAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public GridViewHouseGalleryAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = (AppCompatImageView) row.findViewById(R.id.imageButton_new_house_gallery_item);

            holder.image = (ImageView) row.findViewById(R.id.image_new_house_gallery_item);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = (ImageItem) data.get(position);
        // holder.imageButton.setText(item.getTitle());
        holder.image.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder {
        AppCompatImageView imageView;
        ImageView image;
    }

}

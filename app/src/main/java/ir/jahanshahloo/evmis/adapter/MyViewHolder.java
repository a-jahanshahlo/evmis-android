package ir.jahanshahloo.evmis.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.model.Landscape;

/**
 * Created by Alireza on 6/27/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    ImageView imgDel,imgSel,imgThumb;
    int position;
    Landscape current;
    public MyViewHolder(View itemView) {
        super(itemView);
        this.title=(TextView)itemView.findViewById(R.id.txtTitle);
        this.imgThumb=(ImageView) itemView.findViewById(R.id.imgDelRow);
        this.imgDel=(ImageView)itemView.findViewById(R.id.imgDelRow);
        this.imgSel=(ImageView)itemView.findViewById(R.id.imgDelsel);

    }

    public void setData(Landscape item, int position) {
        this.title.setText(item.getTitle());
        this.imgThumb.setImageResource(item.getImageId());
        this.position=position;
        this.current=item;
    }
}

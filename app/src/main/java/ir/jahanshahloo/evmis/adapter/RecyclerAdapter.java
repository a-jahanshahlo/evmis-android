package ir.jahanshahloo.evmis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.model.Landscape;

/**
 * Created by Alireza on 6/27/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Landscape> mData;
    private LayoutInflater minflater;

    public RecyclerAdapter(Context context, List<Landscape> list) {
        mData = list;
        minflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape item = mData.get(position);
        holder.setData(item, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

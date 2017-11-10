package ir.jahanshahloo.evmis.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.AnimUtils;
import ir.jahanshahloo.evmis.model.HouseModel;

/**
 * Created by Adminstrator on 7/11/2016.
 */
public class HouseRecyclerAdapter extends RecyclerView.Adapter<HouseRecyclerAdapter.ViewHolder> {

    private ArrayList<HouseModel> houseModelList;

private Context mContext;
    public HouseRecyclerAdapter(ArrayList<HouseModel> list, Context mContext) {

        this.houseModelList = list;

        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HouseModel houseModel = houseModelList.get(position);
        Log.i("ali", houseModel.getCityTitle() + " get city");


        TextView addressTitleTextView = holder.addressTitleTextView;
        TextView cityTitleTextView = holder.cityTitleTextView;
        TextView countLikeTextView = holder.countLikeTextView;
        TextView floorTitleTextView = holder.floorTitleTextView;
        TextView houseTypeTitleTextView = holder.houseTypeTitleTextView;
        TextView provinceTitleTextView = holder.provinceTitleTextView;
        AppCompatImageButton button_more = holder.button_more;
        String current = DateFormat.getDateTimeInstance().format(new Date());

        addressTitleTextView.setText(houseModel.getAddressTitle());
        cityTitleTextView.setText(houseModel.getCityTitle());
        countLikeTextView.setText(houseModel.getId().toString() + " " + current);
        floorTitleTextView.setText(houseModel.getFloorTitle());
        houseTypeTitleTextView.setText(houseModel.getHouseTypeTitle());
        provinceTitleTextView.setText(houseModel.getProvinceTitle());

        button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.btn_report:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;

                default:
            }
            return false;
        }
    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_list_item, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    @Override
    public int getItemCount() {
        String s = houseModelList == null ? "true" : "false";
        Log.i("ali", "housemodel is null? " + s);
        return houseModelList == null ? 0 : houseModelList.size();
    }

    //House view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        boolean toggleExpand = false;
        public TextView houseTypeTitleTextView;
        public TextView addressTitleTextView;
        public TextView floorTitleTextView;
        public TextView provinceTitleTextView;
        public TextView cityTitleTextView;
        public TextView countLikeTextView;
        public LinearLayoutCompat linearLayoutCompat_expandable;
        public ImageButton button_expand_house;
        public AppCompatImageButton button_more;
        //Animations
        Animation button_expand;
        Animation button_collapse;
        public Button messageButton;

        public ViewHolder(View itemView) {
            super(itemView);

            houseTypeTitleTextView = (TextView) itemView.findViewById(R.id.house_Type_Title);
            addressTitleTextView = (TextView) itemView.findViewById(R.id.address_Title);
            floorTitleTextView = (TextView) itemView.findViewById(R.id.floor_Title);
            provinceTitleTextView = (TextView) itemView.findViewById(R.id.province_Title);
            cityTitleTextView = (TextView) itemView.findViewById(R.id.city_Title);
            countLikeTextView = (TextView) itemView.findViewById(R.id.count_Like);
            button_expand_house = (ImageButton) itemView.findViewById(R.id.img_button_expand_house);
            linearLayoutCompat_expandable = (LinearLayoutCompat) itemView.findViewById(R.id.linearLayout_house_expand);
            button_expand = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.button_expand);
            button_collapse = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.button_collapse);
            button_more = (AppCompatImageButton) itemView.findViewById(R.id.ic_house_more);
            button_expand_house.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {


                    if (toggleExpand == false) {

                        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams) v.getLayoutParams();

                        v.setLayoutParams(layoutParams);
                        v.startAnimation(button_expand);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                AnimUtils.expand(linearLayoutCompat_expandable);

                            }
                        }, 500);

                        toggleExpand = true;
                    } else {

                        TableRow.LayoutParams layoutParams = (TableRow.LayoutParams) v.getLayoutParams();

                        v.setLayoutParams(layoutParams);
                        v.startAnimation(button_collapse);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                AnimUtils.collapse(linearLayoutCompat_expandable);

                            }
                        }, 500);
                        toggleExpand = false;
                    }
                }
            });
            itemView.setOnCreateContextMenuListener(this);
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //      menu.add(Menu.NONE,v.getId(),1,"T1");
        }
    }
}

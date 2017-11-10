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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.AnimUtils;
import ir.jahanshahloo.evmis.model.HouseForRent;

/**
 * Created by Adminstrator on 7/11/2016.
 */
public class HouseForRentRecyclerAdapter extends RecyclerView.Adapter<HouseForRentRecyclerAdapter.ViewHolder> {

    private ArrayList<HouseForRent> houseForRentModelsList;

    private Context mContext;

    public HouseForRentRecyclerAdapter(ArrayList<HouseForRent> list, Context mContext) {

        this.houseForRentModelsList = list;

        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_for_rent_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HouseForRent houseModel = houseForRentModelsList.get(position);
        //Log.i("ali", houseModel.getCityTitle() + " get city");


        TextView addressTitleTextView = holder.addressTitleTextView;
        TextView roomTextView = holder.roomTextView;
        TextView priceTextView = holder.priceTextView;
        TextView cityTitleTextView = holder.cityTitleTextView;
        TextView countLikeTextView = holder.countLikeTextView;
        TextView floorTitleTextView = holder.floorTitleTextView;
        TextView houseTypeTitleTextView = holder.houseTypeTitleTextView;
        TextView provinceTitleTextView = holder.provinceTitleTextView;
        AppCompatImageButton button_more = holder.button_more;
        String current = DateFormat.getDateTimeInstance().format(new Date());

       // addressTitleTextView.setText(houseModel.get());
        priceTextView.setText(houseModel.getPrice().toString()+" / "+houseModel.getTimeUnit());
        roomTextView.setText(houseModel.getHouse().getRoom().toString());
        cityTitleTextView.setText(houseModel.getHouse().getAddress().getCity().getTitle());
        countLikeTextView.setText(houseModel.getId().toString() + " " + current);
        floorTitleTextView.setText(houseModel.getHouse().getFloor().getTitle());
        houseTypeTitleTextView.setText(houseModel.getHouse().getHouseType().getTitle());
        provinceTitleTextView.setText(houseModel.getHouse().getAddress().getCity().getProvince().getTitle());

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
        String s = houseForRentModelsList == null ? "true" : "false";
        Log.i("ali", "housemodel is null? " + s);
        return houseForRentModelsList.size();
    }

    //House view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        boolean toggleExpand = false;
        public TextView houseTypeTitleTextView;
        public TextView roomTextView;
        public TextView priceTextView;

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
            priceTextView = (TextView) itemView.findViewById(R.id.hfr_price);
            roomTextView = (TextView) itemView.findViewById(R.id.hfr_room);

            houseTypeTitleTextView = (TextView) itemView.findViewById(R.id.hfr_house_Type);
            addressTitleTextView = (TextView) itemView.findViewById(R.id.hfr_address_Title);
            floorTitleTextView = (TextView) itemView.findViewById(R.id.hfr_floor_Title);
            provinceTitleTextView = (TextView) itemView.findViewById(R.id.hfr_province_Title);
            cityTitleTextView = (TextView) itemView.findViewById(R.id.hfr_city_Title);
            countLikeTextView = (TextView) itemView.findViewById(R.id.hfr_count_Like);
            button_expand_house = (ImageButton) itemView.findViewById(R.id.hfr_img_button_expand_house);
            linearLayoutCompat_expandable = (LinearLayoutCompat) itemView.findViewById(R.id.hfr_linearLayout_house_expand);
            button_expand = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.button_expand);
            button_collapse = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.button_collapse);
            button_more = (AppCompatImageButton) itemView.findViewById(R.id.hfr_house_more);
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
                        }, 1);

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
                        }, 1);
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

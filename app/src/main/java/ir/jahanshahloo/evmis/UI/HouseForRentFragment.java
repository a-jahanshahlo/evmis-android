package ir.jahanshahloo.evmis.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Service.Contract.IHouseForRentService;
import ir.jahanshahloo.evmis.Service.Contract.IHouseService;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.adapter.EndlessRecyclerViewScrollListener;
import ir.jahanshahloo.evmis.adapter.HouseForRentRecyclerAdapter;
import ir.jahanshahloo.evmis.adapter.HouseRecyclerAdapter;
import ir.jahanshahloo.evmis.model.HouseForRent;
import ir.jahanshahloo.evmis.model.HouseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class HouseForRentFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private OnTouchForRentListListener mOnTouchForRentListListener;

    @Inject
    IHouseForRentService iHouseForRentService;
    private RecyclerView recyclerView;
    private ArrayList<HouseForRent> data;
    private HouseForRentRecyclerAdapter adapter;
    View view;
    SwipeRefreshLayout mainswl;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HouseForRentFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HouseForRentFragment newInstance(int columnCount) {
        HouseForRentFragment fragment = new HouseForRentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_house_for_rent_item_list, container, false);

        // Set the adapter
        ((App) inflater.getContext().getApplicationContext()).getHouseForRentComponent().inject(this);

        mainswl = (SwipeRefreshLayout) view.findViewById(R.id.main_hfr_srl);
        mainswl.setOnRefreshListener(this);

        data = new ArrayList<>();
        adapter = new HouseForRentRecyclerAdapter(data, inflater.getContext());

        setRecyclerView();


        return view;
    }

    private void setRecyclerView() {


        recyclerView = (RecyclerView) view.findViewById(R.id.hfr_recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list

                Log.i("ali", " page = " + page + "total = " + totalItemsCount);
                Log.i("ali", " skip = " + totalItemsCount);

                //  loadJSON(totalItemsCount, 10);
            }
        });
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mOnTouchForRentListListener.onTouchRentHouse(v, event);
                return false;
            }
        });
        recyclerView.setAdapter(adapter);
        loadJSON(0, 10);
    }

    private void loadJSON(int page, int total) {

        Call<List<HouseForRent>> call = iHouseForRentService.getRent(page, total);
        call.enqueue(new Callback<List<HouseForRent>>() {
            @Override
            public void onResponse(Call<List<HouseForRent>> call, Response<List<HouseForRent>> response) {
                if (response.isSuccessful()) {
                    List<HouseForRent> list = response.body();
                    ArrayList<HouseForRent> data2 = (ArrayList<HouseForRent>) list;
                    Log.i("ali", " data2 = " + data2.size());
                    Log.i("ali", " data = " + data.size());

                    data.addAll(data2);
                    // adapter = new HouseRecyclerAdapter(data);
                    Log.i("ali", " data = " + data.size());

                    //    recyclerView.setAdapter(adapter);
                    // recyclerView.notifyAll();
                    //  adapter.notifyItemRangeInserted(adapter.getItemCount(), data2.size());
                    Log.i("ali", "notifyItemRangeInserted");

                    adapter.notifyDataSetChanged();
                    Log.i("ali", "notifyDataSetChanged");

                }
            }

            @Override
            public void onFailure(Call<List<HouseForRent>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        //  ((App) getApplication()).getNetComponent().
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else if (context instanceof OnTouchForRentListListener) {
            mOnTouchForRentListListener = (OnTouchForRentListListener) context;

        } else {
          /*  throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRefresh() {
        int skipLength = data.size();

        loadJSON(0, 10);
        Toast.makeText(view.getContext(), "this is good " + skipLength, Toast.LENGTH_SHORT).show();
        mainswl.setRefreshing(false);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(HouseForRent item);
    }

    public interface OnTouchForRentListListener {
        // TODO: Update argument type and name
        void onTouchRentHouse(View v, MotionEvent event);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}

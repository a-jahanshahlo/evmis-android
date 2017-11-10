package ir.jahanshahloo.evmis.UI;


import android.content.Intent;
import android.os.Bundle;
import com.github.clans.fab.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.AppUrls;


public class MainActivity extends AppCompatActivity implements HouseFragment.OnTouchListListener, HouseForRentFragment.OnTouchForRentListListener {


    /**/
    private FloatingActionButton fab_sales;
    private FloatingActionButton fab_rent;
private FloatingActionMenu fab_menu_main;
    Toolbar toolbar;
    Picasso picasso;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    AccountHeader headerResult;
    Drawer result;
    IProfile activeProfile;
    HouseForRentDialogFragment rentDialogFragment;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_menu_main=(FloatingActionMenu)findViewById(R.id.main_fab_menu);
        fab_menu_main.setClosedOnTouchOutside(true);
        fab_rent = (FloatingActionButton) findViewById(R.id.fab_rent);
        fab_sales = (FloatingActionButton) findViewById(R.id.fab_sales);
        rentDialogFragment = new HouseForRentDialogFragment();

/*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (FAB_Status == false) {
                    //Display FAB menu
                    expandFAB();
                    FAB_Status = true;
                } else {
                    //Close FAB menu
                    hideFAB();
                    FAB_Status = false;
                }
            }
        });*/


        picasso = ((App) getApplication()).getNetComponent().getPicasso();

        //initialize tabLayout
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        //initialize viewpager
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Test");
        // getSupportActionBar().setSubtitle("subtitle");
        toolbar.setSubtitle("subtitle");


        setUpDrawer();
    /*   if (AndroidUtility.isConnectToInternet(getBaseContext())) {

        }
        */

        setupViewPager(viewPager);

        //link tabs with view pager
        tabLayout.setupWithViewPager(viewPager);

        setTabs();
        fab_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  i=new Intent(MainActivity.this,)
            }
        });
        fab_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, NewHouseForRentActivity.class);
                startActivity(i);

            }
        });
    }

    private void refreshProfileImage() {
        if (headerResult != null) {
            if (activeProfile != null) {
                headerResult.updateProfile(activeProfile);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshProfileImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_search:
                Toast.makeText(getBaseContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    public void onFilterClick(MenuItem menuItem) {
        rentDialogFragment.show(getFragmentManager(), "dasdsd");
    }

    public void setUpDrawer() {

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.backgroung_evmis_profile)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("علیرضا")
                                .withEmail("جهانشاهلو")
                                .withIcon(AppUrls.PROFILE_IMAGE)
                                .withSelectedColorRes(R.color.iconsTint_dark)

                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        activeProfile = headerResult.getActiveProfile();

        result = new DrawerBuilder()
                .withAccountHeader(headerResult)
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.pref_mobile_number).withIcon(FontAwesome.Icon.faw_mobile).withIdentifier(1).withDescription("9307185332"),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withIdentifier(2).withName("تنظیمات").withIcon(FontAwesome.Icon.faw_gear).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                             /*   Intent i =new Intent(Intent.ACTION_PICK);
                                i.setType("image/*");
                                startActivityForResult(i, 1);*/
                                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                                startActivity(i);
                                return false;
                            }
                        }),
                        new SecondaryDrawerItem().withIdentifier(3).withName("dddd"),
                        new SecondaryDrawerItem().withIdentifier(4).withName("wwwww")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return false;
                    }
                })
                .withDrawerGravity(Gravity.END)
                .build();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        HouseFragment houseFragment = new HouseFragment();
        HouseForRentFragment houseForRentFragment = new HouseForRentFragment();
        // create three fragments for three tabs and set them
        adapter.addFragment(houseForRentFragment, getResources().getString(R.string.House_Salse));
        adapter.addFragment(new HouseFragment(), getResources().getString(R.string.House_Rent));
        adapter.addFragment(new HouseFragment(), getResources().getString(R.string.service));
        adapter.addFragment(new HouseFragment(), getResources().getString(R.string.consultant));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onTouch(View v, MotionEvent event) {


    }

    @Override
    public void onTouchRentHouse(View v, MotionEvent event) {
        Log.i("ali","List tuched");

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void setTabs() {
        // add names and icons to tabs or can attach a custom layout
        //  can identify tabs attach with fragments using id
        tabLayout.getTabAt(0).setText(getResources().getString(R.string.House_Salse));//.setIcon(R.drawable.first_tab_icon);
        tabLayout.getTabAt(1).setText(getResources().getString(R.string.House_Rent));//.setIcon(R.drawable.first_tab_icon);

        tabLayout.getTabAt(2).setText(getResources().getString(R.string.service));//.setIcon(R.drawable.second_tab_icon);
        tabLayout.getTabAt(3).setText(getResources().getString(R.string.consultant));//.setIcon(R.drawable.third_tab_icon);

    }

}

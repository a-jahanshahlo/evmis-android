package ir.jahanshahloo.evmis.UI;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.github.brunodles.compressor.BitmapCompressor;
import com.github.brunodles.pic_picker.PicPicker;
import com.github.brunodles.pic_picker.impl.WritePermissionAsker;
import com.github.brunodles.pic_picker.listener.CantFindCameraAppErrorListener;
import com.github.brunodles.pic_picker.listener.ErrorCreatingTempFileForCameraListener;
import com.github.brunodles.pic_picker.listener.PicResultListener;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Service.Contract.IBaseDataService;
import ir.jahanshahloo.evmis.Service.Handler.Handlers;
import ir.jahanshahloo.evmis.Util.AndroidUtility;
import ir.jahanshahloo.evmis.Util.AnimUtils;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.Date.ChangeDate;
import ir.jahanshahloo.evmis.Util.RegisterUtil;
import ir.jahanshahloo.evmis.adapter.GridViewAmenitiesAdapter;
import ir.jahanshahloo.evmis.adapter.GridViewHouseGalleryAdapter;
import ir.jahanshahloo.evmis.databinding.ActivityNewHouseForRentBinding;
import ir.jahanshahloo.evmis.model.AmenitieModel;
import ir.jahanshahloo.evmis.model.BaseModel;
import ir.jahanshahloo.evmis.model.ImageItem;
import ir.jahanshahloo.evmis.model.NewHouseForRent;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RuntimePermissions
public class NewHouseForRentActivity extends AppCompatActivity implements OptionMenuRevealFragment.OnOptionMenuRevealListener {

    ActivityNewHouseForRentBinding binding;
    NewHouseForRent houseForRent;
    boolean toggleExpand = false;


    private PicPicker picPicker;
    private WritePermissionAsker writePermissionAsker;
    private static final String TAG = "NewHouseForRentActivity";
    private static final int RC_WRITE_EXTERNAL_STORAGE = 42;


    AppCompatButton _okButton;

    AppCompatButton _attachButton;

    @Inject
    IBaseDataService iBaseDataService;


    private OptionMenuRevealFragment menuRevealFragment;


    private GridViewHouseGalleryAdapter _gridViewHouseGalleryAdapter;
    private GridViewAmenitiesAdapter _gridViewAmenitiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_new_house_for_rent);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_house_for_rent);
        //  ActivityNewHouseForRentBinding.inflate(getLayoutInflater());
        // ActivityRentForHouseNewBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_new_house_for_rent);

        binding.inclideHouseForRent.setHandler(new Handlers());
        menuRevealFragment = new OptionMenuRevealFragment();
        // toolbar_new_hfr = (Toolbar) findViewById(R.id.toolbar_new_hfr);
        setSupportActionBar(binding.toolbarNewHfr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Test2");
        binding.toolbarNewHfr.setSubtitle("ghjghj");
        houseForRent = new NewHouseForRent();

        setContentView(binding.getRoot());
        binding.setNewHouseForRent(houseForRent);

/*Camera*/

        writePermissionAsker = new WritePermissionAsker(this, RC_WRITE_EXTERNAL_STORAGE,
                R.string.dialog_filter_advertise);

        picPicker = new PicPicker(this, picResultListener)
                .setFileForCameraListener(fileForCameraListener)
                // this will be called when we got a error from the camera app,
                // sometimes it even doesn't exists.
                .setCameraAppErrorListener(cameraAppErrorListener)
                // this will be called when we need a permission, for android 6+
                .setPermissionErrorListener(writePermissionAsker);


/*Image Gallery container*/
        binding.inclideHouseForRent.gridViewHouseImage.setEmptyView(findViewById(R.id.empty_view));
        _gridViewHouseGalleryAdapter = new GridViewHouseGalleryAdapter(this, R.layout.grid_house_gallery_item_layout, getData());
        binding.inclideHouseForRent.gridViewHouseImage.setAdapter(_gridViewHouseGalleryAdapter);

/*End Image Gallery*/


        _attachButton = (AppCompatButton) findViewById(R.id.action_new_house_attach);

        _okButton = (AppCompatButton) findViewById(R.id.action_new_house_ok);


        binding.inclideHouseForRent.spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BaseModel province = (BaseModel) parent.getSelectedItem();
                Toast.makeText(view.getContext(), "province ID: " + province.getId() + ",  province Name : " + province.getTitle(), Toast.LENGTH_SHORT).show();
                bindCity(view.getContext(), province.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        _attachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menuRevealFragment.OnClickToggleReveal(true, null);
            }
        });

        _okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.inclideHouseForRent.houseForRentAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String year = ChangeDate.decreaseCurrentYear(progress).replace("/", "").replace("\\/", "");
                Log.i(TAG, "onProgressChanged: " + year);
                houseForRent.getHouse().setDateHouseCreated(Integer.parseInt(year));
                Calendar c = Calendar.getInstance();
                c.add(Calendar.YEAR, -progress);
                Log.i(TAG, "onProgressChanged: " + c.getTime());

                houseForRent.getHouse().setDateHouseCreatedEn(c.getTime());
                binding.inclideHouseForRent.houseForRentAgeTextview.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AnimUtils.setRotationAnim(this, binding.inclideHouseForRent.btnExpandHouseNewFuture, binding.inclideHouseForRent.lnHouseNewFuture);


        binding.inclideHouseForRent.gridViewHouseImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //   String item = (String) parent.getItemAtPosition(position);
                _gridViewHouseGalleryAdapter.remove(_gridViewHouseGalleryAdapter.getItem(position));
                _gridViewHouseGalleryAdapter.notifyDataSetChanged();
                AndroidUtility.refreshGridViewHeight(binding.inclideHouseForRent.gridViewHouseImage, 114);

                Log.i("ali", String.valueOf(position));
            }
        });
        binding.inclideHouseForRent.newHouseMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewHouseForRentActivityPermissionsDispatcher.callMapWithCheck(NewHouseForRentActivity.this);
            }
        });
        ScrollView layout = (ScrollView) findViewById(R.id.sv_new_house);


        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().addToBackStack("OptionMenuRevealFragment").replace(R.id.text_fragment, menuRevealFragment, "CURRENT_OptionMenuRevealFragment_TAG").commit();
        }


        ((App) getApplicationContext()).getBaseDataComponent().inject(this);
        setupSpinner(getBaseContext());


    }

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
     /*   TypedArray imgs  = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }*/
        return imageItems;
    }

    private void setupSpinner(Context context) {
        bindGridViewModel(this, binding.inclideHouseForRent.gridViewAmenitie, iBaseDataService.getAmenitie());
        bindModel(context, binding.inclideHouseForRent.spinnerProvince, iBaseDataService.getProvince());
        bindModel(context, binding.inclideHouseForRent.spinnerFloor, iBaseDataService.getFloor());

        bindModel(context, binding.inclideHouseForRent.spinnerRentadvertisetype, iBaseDataService.getRentAdvertiseType());
        bindModel(context, binding.inclideHouseForRent.spinnerHousetype, iBaseDataService.getHouseType());
        bindModel(context, binding.inclideHouseForRent.spinnerRentType, iBaseDataService.getRentType());
        bindModel(context, binding.inclideHouseForRent.spinnerTimeUnit, iBaseDataService.getTimeUnit());

        bindModel(context, binding.inclideHouseForRent.spinnerCabinet, iBaseDataService.getCabinet());
        bindModel(context, binding.inclideHouseForRent.spinnerHouseGeoView, iBaseDataService.getHouseGeoView());
        bindModel(context, binding.inclideHouseForRent.spinnerHouseView, iBaseDataService.getHouseView());
        bindModel(context, binding.inclideHouseForRent.spinnerFloorCoverings, iBaseDataService.getFloorCovering());
        bindModel(context, binding.inclideHouseForRent.spinnerProofOwnership, iBaseDataService.getProofOwnership());
        bindModel(context, binding.inclideHouseForRent.spinnerLivingState, iBaseDataService.getLivingState());
    }


    private void bindCity(final Context context, int province) {
        Log.i("ali", "bind city");

        Call<List<BaseModel>> city = iBaseDataService.getCity(province);
        city.enqueue(new Callback<List<BaseModel>>() {
            @Override
            public void onResponse(Call<List<BaseModel>> call, Response<List<BaseModel>> response) {
                Log.i("ali", "load city");
                if (response.isSuccessful()) {
                    Log.i("ali", "load city successfully");

                    List<BaseModel> cityList = response.body();

                    ArrayAdapter<BaseModel> adapter = new ArrayAdapter<BaseModel>(context, R.layout.custom_spinner_textview, cityList);
                    binding.inclideHouseForRent.spinnerCity.setAdapter(adapter);
                } else {
                    Log.i("ali", "load city error");

                }
            }

            @Override
            public void onFailure(Call<List<BaseModel>> call, Throwable t) {
                Log.e("ali", t.getMessage());

            }
        });
    }

    private void bindModel(final Context context, final AppCompatSpinner _spinner, Call<List<BaseModel>> call) {
        Log.i("ali", "bind RentAdvertiseType");

        call.enqueue(new Callback<List<BaseModel>>() {
            @Override
            public void onResponse(Call<List<BaseModel>> call, Response<List<BaseModel>> response) {
                Log.i("ali", "load RentAdvertiseType");
                if (response.isSuccessful()) {
                    Log.i("ali", "load RentAdvertiseType successfully");

                    List<BaseModel> list = response.body();

                    ArrayAdapter<BaseModel> adapter = new ArrayAdapter<BaseModel>(context, R.layout.custom_spinner_textview, list);
                    _spinner.setAdapter(adapter);
                } else {
                    Log.i("ali", "load RentAdvertiseType error");

                }
            }

            @Override
            public void onFailure(Call<List<BaseModel>> call, Throwable t) {
                Log.e("ali", t.getMessage());

            }
        });
    }

    private void bindGridViewModel(final Context context, final GridView _gridView, Call<List<AmenitieModel>> call) {

        call.enqueue(new Callback<List<AmenitieModel>>() {
            @Override
            public void onResponse(Call<List<AmenitieModel>> call, Response<List<AmenitieModel>> response) {
                Log.i("ali", "load RentAdvertiseType");
                if (response.isSuccessful()) {
                    Log.i("ali", "load RentAdvertiseType successfully");

                    List<AmenitieModel> list = response.body();
                    _gridViewAmenitiesAdapter = new GridViewAmenitiesAdapter(context, R.layout.grid_view_amenitie, list);
                    _gridView.setAdapter(_gridViewAmenitiesAdapter);
                } else {
                    Log.i("ali", "load RentAdvertiseType error");

                }
            }

            @Override
            public void onFailure(Call<List<AmenitieModel>> call, Throwable t) {
                Log.e("ali", t.getMessage());

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
   /*     int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getBaseContext(), "sdsds", Toast.LENGTH_SHORT).show();
                break;
            default: }*/
        Intent i = new Intent(NewHouseForRentActivity.this, MainActivity.class);
        startActivity(i);
        finishAffinity();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (menuRevealFragment.getToggleState()) {
            menuRevealFragment.OnClickToggleReveal(false, null);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("ali requestCode:", String.valueOf(requestCode));

        //    startActivityForResult(result,requestCode);
        if (picPicker.onActivityResult(requestCode, resultCode, data)) {
            Log.i("ali", "valid picPicker");

        } else if (requestCode == UCrop.REQUEST_CROP) {
            Log.i("ali", "valid Crop");

            handleCrop(resultCode, data);
        } else {
            Log.i("ali", "invalid code");
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == RegisterUtil.READ_MAP && resultCode == RESULT_OK && data != null) {
            Log.i(TAG, "READ_MAP");

            double lng = data.getDoubleExtra(RegisterUtil.LNG, -1d);
            double lnt = data.getDoubleExtra(RegisterUtil.LNT, -1d);
            if (lng != -1d) {
                Log.i(TAG, "onActivityResult: " + lng);
                houseForRent.getHouse().setGeoLatitude(lnt);
                houseForRent.getHouse().setGeoLongitude(lng);

                binding.inclideHouseForRent.lng.setText(String.valueOf(lng));
                binding.inclideHouseForRent.lnt.setText(String.valueOf(lnt));
            }
        }
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {

            final Uri uri = UCrop.getOutput(result);


            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                ImageItem imageItem = new ImageItem(bitmap, "");
                Log.i("ali", "insert to gallery");

                _gridViewHouseGalleryAdapter.add(imageItem);
                _gridViewHouseGalleryAdapter.notifyDataSetChanged();
                AndroidUtility.refreshGridViewHeight(binding.inclideHouseForRent.gridViewHouseImage, 114);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (resultCode == UCrop.RESULT_ERROR) {
            Toast.makeText(this, UCrop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(this.getCacheDir(), "cropped"));
        UCrop.of(source, destination).withAspectRatio(1, 1).start(this);

    }

    private PicResultListener picResultListener = new PicResultListener() {
        @Override
        public void onPictureResult(final Bitmap bitmap) {
            Log.i(TAG, "onPictureResult: ");
            new BitmapCompressor(400) {
                @Override
                protected void onPostExecute(Bitmap[] bitmaps) {
                    // Here we get the response from the bitmapCompressor
                    Log.i(TAG, "bitmapCompressor.onPostExecute: ");
                    String path = MediaStore.Images.Media.insertImage(getBaseContext().getContentResolver(), bitmaps[0], "Title", null);
                    Log.i(TAG, path);
                    Uri uri = Uri.parse(path);
                    beginCrop(uri);
                    //     image.setImageBitmap(bitmaps[0]); // sets the compressed bitmap on the ImageView
                }
            }.execute(bitmap); // Here we pass the bitmap
        }
    };

    private CantFindCameraAppErrorListener cameraAppErrorListener = new CantFindCameraAppErrorListener() {
        @Override
        public void cantFindCameraApp() {
            Log.e(TAG, "cantFindCameraApp: ");
            Toast.makeText(getBaseContext(), "Can't find the camera app", Toast.LENGTH_SHORT).show();
        }
    };
    private ErrorCreatingTempFileForCameraListener fileForCameraListener = new ErrorCreatingTempFileForCameraListener() {
        @Override
        public void errorCreatingTempFileForCamera() {
            Log.e(TAG, "errorCreatingTempFileForCamera: ");
            Toast.makeText(getBaseContext(), "Error starting camera", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClickMenuItem(int code) {

        switch (code) {
            case 1:

                NewHouseForRentActivityPermissionsDispatcher.callCameraWithCheck(this);
                break;
            case 2:
                NewHouseForRentActivityPermissionsDispatcher.callGalleryWithCheck(this);
                break;
        }
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    void callCamera() {
        picPicker.camera();
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void onCameraDenied() {
        Toast.makeText(this, R.string.permission_camera_denied, Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void callGallery() {
        picPicker.gallery();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void onCameraNeverAskAgain() {
        Toast.makeText(this, R.string.permission_camera_never_askagain, Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void showRationaleForCamera(PermissionRequest request) {
        // NOTE: Show a rationale to explain why the permission is needed, e.g. with a dialog.
        // Call proceed() or cancel() on the provided PermissionRequest to continue or abort
        AndroidUtility.showRationaleDialog(R.string.permission_camera_rationale, request, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method

        NewHouseForRentActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    void onLocationDenied() {
        Toast.makeText(this, R.string.permission_location_denied, Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    void onLocationNeverAskAgain() {
        Toast.makeText(this, R.string.permission_never_askagain, Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void showRationaleForLocation(PermissionRequest request) {
        AndroidUtility.showRationaleDialog(R.string.permission_location_rationale, request, this);
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_COARSE_LOCATION)
    void onCoarseLocationDenied() {
        Toast.makeText(this, R.string.permission_coarse_denied, Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_COARSE_LOCATION)
    void onCoarseLocationNeverAskAgain() {
        Toast.makeText(this, R.string.permission_never_askagain, Toast.LENGTH_SHORT).show();
    }


    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void callMap() {
        Intent i = new Intent(NewHouseForRentActivity.this, HouseMapsActivity.class);
        startActivityForResult(i, RegisterUtil.READ_MAP);
    }

}

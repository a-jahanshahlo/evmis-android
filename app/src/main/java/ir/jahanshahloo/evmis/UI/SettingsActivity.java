package ir.jahanshahloo.evmis.UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Service.Contract.IUploadService;
import ir.jahanshahloo.evmis.Service.Provider.PicassoBuilder;
import ir.jahanshahloo.evmis.Util.App;
import ir.jahanshahloo.evmis.Util.AppUrls;
import ir.jahanshahloo.evmis.Util.UploadUtil;
import ir.jahanshahloo.evmis.config.ClientConfigs;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsActivity extends AppCompatActivity {
    String[] photoStrings;
    Toolbar toolbar_settings;
    @Inject
    IUploadService iUploadService;

    Picasso picasso;
    CollapsingToolbarLayout collapsingToolbarLayout;
    UploadUtil uploadUtil;
    AppCompatImageView profileImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        uploadUtil = new UploadUtil();
        ((App) getApplication()).getUploadComponent().inject(this);
        profileImageview = (AppCompatImageView) findViewById(R.id.profile_setting_background);

        picasso = ((App) getApplication()).getNetComponent().getPicasso();

        picasso.load(AppUrls.PROFILE_IMAGE)
                  .placeholder(R.drawable.logo)
                  .error(R.drawable.logo)
                .into(profileImageview);

        photoStrings = getResources().getStringArray(R.array.pref_get_photo);

     /*  */
        toolbar_settings = (Toolbar) findViewById(R.id.toolbar_settings);
        setSupportActionBar(toolbar_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Test2");
        toolbar_settings.setSubtitle("ghjghj");
        toolbar_settings.setLogo(R.drawable.ic_photo_camera_white_24dp);
        getSupportActionBar().setSubtitle("Test2");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_settings);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     /*   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i =new Intent(Intent.ACTION_PICK);
                                i.setType("image/*");
                                startActivityForResult(i, 1);*/

                takePhoto();
            }
        });
    }

    private void takePhoto() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("take photo");
        builder.setItems(photoStrings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (photoStrings[0] == photoStrings[which]) {
                    Log.i("ali", photoStrings[which]);
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));

                    startActivityForResult(intent, 1);
                } else if (photoStrings[1] == photoStrings[which])

                {
                    Log.i("ali", photoStrings[which]);
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(intent, 2);


                }
            }
        }).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File file = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : file.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {

                        Call<ResponseBody> call = uploadUtil.UploadProfilePhoto(getBaseContext(), temp, iUploadService);
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()) {
                                    Log.i("ali", "success");
                                    //  Picasso picasso = PicassoBuilder.getImageLoader(getBaseContext());
                                    picasso.load(AppUrls.PROFILE_IMAGE).memoryPolicy(MemoryPolicy.NO_CACHE)
                                            //  .placeholder(R.drawable.user_placeholder)
                                            //  .error(R.drawable.user_placeholder_error)
                                            .into(profileImageview);
                                } else {
                                    ResponseBody errorBody = response.errorBody();
                                    try {
                                        String string = errorBody.string();


                                        Log.i("ali_notresponse", response.message());
                                        Log.i("ali_notresponse", string);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.i("ali", t.getMessage());
                            }
                        });

                        break;
                    }
                }

            } else if (requestCode == 2) {
                Uri uri = data.getData();
                Call<ResponseBody> call = uploadUtil.UploadProfilePhoto(getBaseContext(), uri, iUploadService);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.i("ali", "success");

                        } else {
                            ResponseBody errorBody = response.errorBody();
                            try {
                                String string = errorBody.string();


                                Log.i("ali_notresponse", response.message());
                                Log.i("ali_notresponse", string);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.i("ali", t.getMessage());
                    }
                });

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getBaseContext(), "sdsds", Toast.LENGTH_SHORT).show();
                break;
            default:
                Intent i = new Intent(SettingsActivity.this, MainActivity.class);

                startActivity(i);
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

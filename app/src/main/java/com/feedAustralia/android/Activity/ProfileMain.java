package com.feedAustralia.android.Activity;
import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feedAustralia.android.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asd on 01-02-2019.
 */

public class ProfileMain extends BaseActivity implements View.OnClickListener{
    RelativeLayout HeaderLayout;
    CircleImageView profile_image;
    private static final int SELECT_FILE = 1;
    private static final int REQUEST_CAMERA = 0;
    Bitmap bm = null;
    RelativeLayout NextLayout;
    RelativeLayout ViewLayout;
    TextView Logout;
    CircleImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);
        init();
        Listener();
        checkRunTimePermission();
    }
    public void init(){
        HeaderLayout = findViewById(R.id.HeaderLayout);
        profile_image = findViewById(R.id.profile_image);

        TextView userName =(TextView) findViewById(R.id.textProfileName);
        userName.setText(SessionManager.user_name(this));
        imageView = (CircleImageView) findViewById(R.id.profile_image);


        String gender = SessionManager.gender(this);

        if(gender.equals("M"))
        {
            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);

        }
        else if(gender.equals("F"))
        {
            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.female)).into(imageView);

        }
        else {

            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);

        }
        NextLayout = findViewById(R.id.NextLayout);
        ViewLayout = findViewById(R.id.ViewLayout);
        Logout = findViewById(R.id.Logout);
    }
    public void Listener(){
        HeaderLayout.setOnClickListener(this);
        profile_image.setOnClickListener(this);
        NextLayout.setOnClickListener(this);
        ViewLayout.setOnClickListener(this);
        Logout.setOnClickListener(this);
    }
    public void checkRunTimePermission(){
        String[] permissionArrays = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, 11111);
        } else {

        }
    }
    @Override
    public void onRestart() {
        super.onRestart();

        String gender = SessionManager.gender(this);

        if(gender.equals("M"))
        {
            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);

        }
        else if(gender.equals("F"))
        {
            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.female)).into(imageView);

        }
        else {

            Glide.with(this)
                    .load(SessionManager.userAvtar(this)).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);

        }

        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.HeaderLayout:

                break;
            case R.id.profile_image:
//                camera_gallery();
                break;
            case R.id.NextLayout:
                Intent intent = new Intent(ProfileMain.this,EditProfile.class);
                startActivity(intent);
                break;
            case R.id.ViewLayout:
                finish();
                break;
            case R.id.Logout:
                Intent intent1 = new Intent(ProfileMain.this,Login.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
    public void camera_gallery(){
        final Dialog dialog_ = new Dialog(this);
        dialog_.requestWindowFeature(Window.FEATURE_NO_TITLE);
            try {
                dialog_.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Window window = dialog_.getWindow();
                window.setGravity(Gravity.BOTTOM);
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                dialog_.getWindow().getAttributes().windowAnimations = R.style.AlertDialogAnimation;
            } catch (Exception exc) {

            }
            LayoutInflater li = LayoutInflater.from(this);
            View myView = li.inflate(R.layout.alertbox_box, null);
            dialog_.setContentView(myView);
            TextView TakePhoto = dialog_.findViewById(R.id.TakePhoto);
            TextView ChoosePhoto = dialog_.findViewById(R.id.ChoosePhoto);
            TextView Cancel = dialog_.findViewById(R.id.Cancel);
            TextView Remove = dialog_.findViewById(R.id.Remove);
            Remove.setVisibility(View.GONE);
            dialog_.setCancelable(true);
            dialog_.setCanceledOnTouchOutside(true);
            TakePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);//zero can be replaced with any action code
                    dialog_.dismiss();
                }
            });
            ChoosePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);
                    dialog_.dismiss();
                }
            });
            Cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_.dismiss();
                }
            });
        dialog_.show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }
    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profile_image.setImageBitmap(bm);
    }
    private void onCaptureImageResult(Intent data) {
        bm = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile_image.setImageBitmap(bm);
    }
}

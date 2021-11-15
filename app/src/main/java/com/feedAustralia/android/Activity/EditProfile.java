package com.feedAustralia.android.Activity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.feedAustralia.android.pojo.profilePakage.health.ChildHealth;
import com.feedAustralia.android.pojo.profilePakage.health.Food;
import com.feedAustralia.android.pojo.profilePakage.identity.ProfilePicture;
import com.feedAustralia.android.pojo.profilePakage.parent.ParentIdentity;
import com.suke.widget.SwitchButton;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 07-02-2019.
 */

public class EditProfile extends BaseActivity implements View.OnClickListener{
    CircleImageView profile_Picture;
    private static final int SELECT_FILE = 1;
    private static final int REQUEST_CAMERA = 0;
    Bitmap bm = null;
    FamilyDatum selectedMember;
    Bitmap profile_pic;
    String selectedServiceId,selectedSchemeId,memberId,memberType;
    List<FamilyDatum> familyData;
    Map<String, Object> healthParam = new ArrayMap<>();
    EditText textDOB,Comment;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
//    ToggleButton Others,Wheat,Soy,Seeds,Nuts,Milk,Honey,Fruit,Fish,Eggs,Chocolate;
    ImageView Back;
    RecyclerView profileRecycler,ChildRecycler;
    ProfileDapter profileDapter;
    GifTextView Loading;
    int selectedProficPosition = 0;
    TextView textprofile,textSave,textFoodAllergy;
    EditText textfirstName,textmiddleName,textlastName,textMobile,textEmail;
    TextView lblPhone,lblEmail;
    NestedScrollView scrollView;
    childItemAdapter childAdapter;
    LinearLayout layoutChild;
    ParentIdentity parentIdentity;
    EditText foodAllergyOtherComment;
    View borderView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.edit_profile);
        textFoodAllergy = findViewById(R.id.textFoodAllergy);
        layoutChild = findViewById(R.id.layoutChild); // layout for Hide When Parents Data Appears
        scrollView = findViewById(R.id.scrollView);
        ChildRecycler = findViewById(R.id.ChildRecycler); // RecyclerView for All Child Allergy
        ChildRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        ChildRecycler.setLayoutManager(layoutManager1);
        borderView = findViewById(R.id.borderView);
        borderView.setVisibility(View.GONE);
        profileRecycler = findViewById(R.id.profileRecycler); // RecyclerView for  multiple Child Images
        profileRecycler.setNestedScrollingEnabled(false);
        Loading = findViewById(R.id.Loading);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        profileRecycler.setLayoutManager(layoutManager);

        init();
        Listener();
        layoutChild.setVisibility(View.GONE);
        getfamilymember();
    }
    public void init(){
        profile_Picture = findViewById(R.id.profile_Picture);
        textDOB = findViewById(R.id.textDOB);
        Back = findViewById(R.id.Back);
        textSave = findViewById(R.id.textSave);
        textprofile = findViewById(R.id.textprofile);
        textfirstName = findViewById(R.id.textfirstName);
        textmiddleName = findViewById(R.id.textmiddleName);
        textlastName = findViewById(R.id.textlastName);
        textMobile = findViewById(R.id.textMobile);
        textEmail = findViewById(R.id.textEmail);
        lblPhone = findViewById(R.id.lblPhone);
        lblEmail = findViewById(R.id.lblEmail);


    }
    public void Listener(){
        profile_Picture.setOnClickListener(this);
        textprofile.setOnClickListener(this);
        textDOB.setOnClickListener(this);
        myCalendar = Calendar.getInstance();
        Back.setOnClickListener(this);
        textSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_Picture:
                camera_gallery();
                break;
            case R.id.textprofile:
                camera_gallery();
                break;
            case R.id.textDOB:
//                new DatePickerDialog(EditProfile.this, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;

            case R.id.Back:
                finish();
                break;
            case R.id.textSave:
                updateProfileData();
                break;
        }
    }
    public void getfamilymember(){
        Loading.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<FamilyDatum>> Service = apiInterface.familylist();
        Service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                familyData = response.body();
                try {
                    if (familyData !=null && familyData.size()>0) {

                        profileDapter = new ProfileDapter(EditProfile.this,familyData);
                        profileRecycler.setAdapter(profileDapter);
                        for (FamilyDatum child : familyData) {
                            if (child.getType().equals("parent")) {
                                getparents(child,child.getType());

                                break;
                            }
                            else if(child.getType().equals("child")) {
                                getparents(child,child.getType());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
                    Loading.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                Loading.setVisibility(View.GONE);
                Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getparents(FamilyDatum parent,String type){
        String auth_token =SessionManager.getAuth_token(EditProfile.this);
        String schemeId = "";
        String service_id = "";
        String parentId = "";
        if(parent.getServices().size()>0) {

            if (parent.getServices().get(0).getSchemeId() != null)
                schemeId = parent.getServices().get(0).getSchemeId().toString();
            else
                schemeId = null;


            if (parent.getServices().get(0).getServiceId() != null)
                service_id = parent.getServices().get(0).getServiceId().toString();
            else
                service_id = null;

            Integer parent_id = 0;
            if (parent.getId() != null)
                parent_id = parent.getId();
            parentId = new Integer(parent_id).toString();

        }

        String parent_id = "";
        String child_id = "";
        String user_type = "";

        if(type.equals("child")) {
            child_id = parentId;
            parent_id = null;
            user_type = "children";
            memberId =child_id;
            memberType = user_type;

        }
        else if(type.equals("parent"))
        {
            parent_id = parentId;
            child_id  = null;
            user_type = "users";
            memberId =parent_id;
            memberType = user_type;



        }
        selectedServiceId = service_id;
        selectedSchemeId  = schemeId;
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<ParentIdentity> call = apiInterface.getParentidentity(user_type,parentId,schemeId,service_id,"true",auth_token,parent_id,child_id,"1");
        call.enqueue(new Callback<ParentIdentity>() {
            @Override
            public void onResponse(Call<ParentIdentity> call, Response<ParentIdentity> response) {
                parentIdentity = response.body();
                if (parentIdentity != null){

                    if(type.equals("parent")) {


                        setParentData(parentIdentity,parent,type);
                        Loading.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);
                    }


                    else if(type.equals("child"))
                    {
                        setParentData(parentIdentity,parent,type);
                        getHealth(parent);
                    }

                }else{
                    Loading.setVisibility(View.GONE);
                    Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ParentIdentity> call, Throwable t) {
                Loading.setVisibility(View.GONE);
                Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getHealth(FamilyDatum child){

        String auth_token =SessionManager.getAuth_token(EditProfile.this);
        String schemeId = "";
        String service_id = "";
        String parentId = "";
        if(child.getServices().size()>0) {

            if (child.getServices().get(0).getSchemeId() != null)
                schemeId = child.getServices().get(0).getSchemeId().toString();
            else
                schemeId = null;


            if (child.getServices().get(0).getServiceId() != null)
                service_id = child.getServices().get(0).getServiceId().toString();
            else
                service_id = null;

            Integer parent_id = 0;
            if (child.getId() != null)
                parent_id = child.getId();
            parentId = new Integer(parent_id).toString();

        }
        String child_id = parentId;
        String parent_id = null;
        String user_type = "children";


        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<ChildHealth> call = apiInterface.getChildHealth(user_type,parentId,schemeId,service_id,"true",auth_token,parent_id,child_id,"3");
        call.enqueue(new Callback<ChildHealth>() {
            @Override
            public void onResponse(Call<ChildHealth> call, Response<ChildHealth> response) {
                ChildHealth healthData = response.body();
                try{
                    if (healthData != null){

                       List<Food> food =  healthData.getMedicalConditionsDetails().getAllergies().getFood();
                        Loading.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);
                        childAdapter = new childItemAdapter(EditProfile.this,food);
                        ChildRecycler.setAdapter(childAdapter);

                        layoutChild.setVisibility(View.VISIBLE);

                    }
                    else{
                        Loading.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);

//                        Toast.makeText(EditProfile.this, "healthData Null", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Loading.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
//                    Toast.makeText(EditProfile.this, "App Crash", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ChildHealth> call, Throwable t) {
//                Toast.makeText(EditProfile.this, "UnSuccess"+t, Toast.LENGTH_SHORT).show();
                Loading.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void updateProfileData() {


        try {
            String auth_token = SessionManager.getAuth_token(EditProfile.this);
            String user_type = memberType;
            Loading.setVisibility(View.VISIBLE);

            Map<String, Object> jsonParams = new ArrayMap<>();
            if (selectedServiceId != null)
                jsonParams.put("service_id", selectedServiceId);

            if (selectedSchemeId != null)
                jsonParams.put("scheme_id", selectedServiceId);

            jsonParams.put("hh_child_id", memberId);
            jsonParams.put("section", "3");
            healthParam.put("allergies", "yes");
            jsonParams.put("child", healthParam);


            if (healthParam.get("food_allergy_other") != null) {
                if (foodAllergyOtherComment != null && healthParam.get("food_allergy_other").equals("yes")) {
                    if (foodAllergyOtherComment.getText() != null) {
                        Map<String, Object> comment = new ArrayMap<>();
                        comment.put("text", foodAllergyOtherComment.getText());

                        ArrayList<Map> list = new ArrayList<>();
                        list.add(comment);
                        healthParam.put("food_allergy_other_comments", list);
                    }
                }
            }


            for (Map.Entry<String, Object> entry : healthParam.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }


            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
            ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
            Call<ProfilePicture> call = apiInterface.updateProfileData(user_type, memberId, body);
            call.enqueue(new Callback<ProfilePicture>() {
                @Override
                public void onResponse(Call<ProfilePicture> call, Response<ProfilePicture> response) {
                    ProfilePicture pictureData = response.body();
                    try {
                        Loading.setVisibility(View.GONE);
                    } catch (Exception e) {
                        Loading.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<ProfilePicture> call, Throwable t) {
                    Loading.setVisibility(View.GONE);
                }
            });

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    private Bitmap getScaledBitmap(Bitmap b, int reqWidth, int reqHeight)
    {
        int bWidth = b.getWidth();
        int bHeight = b.getHeight();

        int nWidth = bWidth;
        int nHeight = bHeight;

        if(nWidth > reqWidth)
        {
            int ratio = bWidth / reqWidth;
            if(ratio > 0)
            {
                nWidth = reqWidth;
                nHeight = bHeight / ratio;
            }
        }

        if(nHeight > reqHeight)
        {
            int ratio = bHeight / reqHeight;
            if(ratio > 0)
            {
                nHeight = reqHeight;
                nWidth = bWidth / ratio;
            }
        }

        return Bitmap.createScaledBitmap(b, nWidth, nHeight, true);
    }

    public void removeProfilePicture()
    {

        try {

            String auth_token = SessionManager.getAuth_token(EditProfile.this);
            String user_type = memberType;


            Map<String, Object> jsonParams = new ArrayMap<>();
            jsonParams.put("service_id", selectedServiceId);
            jsonParams.put("id", memberId);
            if (memberType.equals("users")) {
                jsonParams.put("type", "parent");
                jsonParams.put("hh_parent_id", memberId);
            } else {
                jsonParams.put("type", memberType);
                jsonParams.put("hh_child_id", memberId);
            }
            jsonParams.put("_delete_picture", true);


            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
            ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
            Call<ProfilePicture> call = apiInterface.updateProfile(user_type, memberId, body);
            call.enqueue(new Callback<ProfilePicture>() {
                @Override
                public void onResponse(Call<ProfilePicture> call, Response<ProfilePicture> response) {
                    ProfilePicture pictureData = response.body();
                    try {
                        if(memberType.equals("users")) {
                            SessionManager.update(getBaseContext(), pictureData.getAvatar());
                        }
                        profile_Picture.setImageDrawable(null);
                        profile_Picture.setImageResource(R.drawable.male);
                        updatefamilymember();

                    } catch (Exception e) {
                        Loading.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<ProfilePicture> call, Throwable t) {
                    Loading.setVisibility(View.GONE);
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateProfile()
    {

        try{
        Loading.setVisibility(View.VISIBLE);
        String auth_token =SessionManager.getAuth_token(EditProfile.this);
        String user_type = memberType;

        Bitmap scaledbitmap = getScaledBitmap(bm,250,250);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        scaledbitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.NO_WRAP);
        String base64Pic = "data:image/jpeg;base64,"+encoded;

        Map<String, Object> jsonParams = new ArrayMap<>();
        jsonParams.put("picture", base64Pic);
        jsonParams.put("picture_name", "909090.jpg");
        jsonParams.put("service_id", selectedServiceId);
        jsonParams.put("id", memberId);
        if(memberType.equals("users")) {
            jsonParams.put("type", "parent");
            jsonParams.put("hh_parent_id", memberId);
        }
        else {
            jsonParams.put("type", memberType);
            jsonParams.put("hh_child_id", memberId);
        }

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<ProfilePicture> call = apiInterface.updateProfile(user_type,memberId,body);
        call.enqueue(new Callback<ProfilePicture>() {
            @Override
            public void onResponse(Call<ProfilePicture> call, Response<ProfilePicture> response) {
                ProfilePicture pictureData = response.body();
                try{
                    if (pictureData != null && pictureData.getAvatar()!=null){

                        if(memberType.equals("users")) {
                            SessionManager.update(getBaseContext(), pictureData.getAvatar());
                        }
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.male);
                        requestOptions.error(R.drawable.male);
                        Glide.with(EditProfile.this)
                                .load(pictureData.getAvatar()).apply(requestOptions).into(profile_Picture);
                        updatefamilymember();
                    }
                    else{
                    }
                }catch (Exception e){
                    Loading.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<ProfilePicture> call, Throwable t) {
                Loading.setVisibility(View.GONE);
            }
        });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updatefamilymember(){

        try{
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<FamilyDatum>> Service = apiInterface.familylist();
        Service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                familyData = response.body();
                try {
                    if (familyData !=null && familyData.size()>0) {

                        profileDapter = new ProfileDapter(EditProfile.this,familyData);
                        profileRecycler.setAdapter(profileDapter);
                        Loading.setVisibility(View.GONE);

                    }
                } catch (Exception e) {
                    Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
                    Loading.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                Loading.setVisibility(View.GONE);
                Toast.makeText(EditProfile.this, "An Error has been occured!", Toast.LENGTH_SHORT).show();
            }
        });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public  void setParentData(ParentIdentity data,FamilyDatum family,String type)
    {

        try {
            borderView.setVisibility(View.VISIBLE);
            if(data.getFirstName() instanceof ArrayList) {
                ArrayList<String> first = (ArrayList)data.getFirstName();
                if (first.size()>0) {
                    textfirstName.setText(first.get(0));
                }
            }
            if(data.getMiddleNames() instanceof ArrayList)
            {
                ArrayList<String> middleNames = (ArrayList)data.getMiddleNames();

                if (middleNames.size() > 0) {
                    String middle_name = "";
                    for (String middle : middleNames) {
                        middle_name = middle_name + " " + middle;
                    }
                    textmiddleName.setText(middle_name + " ");
                }
            }

            if(data.getLastName() instanceof ArrayList)
            {
                ArrayList<String> lastname = (ArrayList)data.getLastName();

                if (lastname.size() > 0) {
                    textlastName.setText(lastname.get(0));
                }
            }


            if(data.getBirthday() instanceof ArrayList)
            {
                ArrayList<String> dob = (ArrayList)data.getBirthday();


                if (dob.size() > 0) {

                    String myFormat = "yyyy-MM-dd"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
                    Date new_date = sdf.parse(dob.get(0));
                    sdf = new SimpleDateFormat("dd/MM/yyyy");
                    textDOB.setText(sdf.format(new_date));
                }

            }
            if(type.equals("parent"))
            {
                if (data.getContactEmails() != null) {
                    if (data.getContactEmails().size() > 0) {
                        textEmail.setText(data.getContactEmails().get(0).getType());
                    }
                }
                if (data.getContactMobilePhones() != null) {
                    if (data.getContactMobilePhones().size() > 0) {
                        textMobile.setText(data.getContactMobilePhones().get(0).getNumber());
                    }
                }
                textEmail.setVisibility(View.VISIBLE);
                textMobile.setVisibility(View.VISIBLE);
                lblEmail.setVisibility(View.VISIBLE);
                lblPhone.setVisibility(View.VISIBLE);
                layoutChild.setVisibility(View.GONE);


                textfirstName.setEnabled(false);
                textmiddleName.setEnabled(false);
                textlastName.setEnabled(false);
                textDOB.setEnabled(false);

                textEmail.setEnabled(false);
                textMobile.setEnabled(false);

                textSave.setVisibility(View.GONE);


            }
            else
            {
                textEmail.setVisibility(View.GONE);
                textMobile.setVisibility(View.GONE);
                lblEmail.setVisibility(View.GONE);
                lblPhone.setVisibility(View.GONE);
                textSave.setVisibility(View.VISIBLE);
                textfirstName.setEnabled(false);
                textmiddleName.setEnabled(false);
                textlastName.setEnabled(false);
                textDOB.setEnabled(false);


            }


            if(family.getAvatar()!=null) {

                if (data.getGender() != null) {
                    if (data.getGender().equals("M")) {
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.male);
                        requestOptions.error(R.drawable.male);
                        Glide.with(this)
                                .load(family.getAvatar()).apply(requestOptions).into(profile_Picture);
                    } else {
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.female);
                        requestOptions.error(R.drawable.female);
                        Glide.with(this)
                                .load(family.getAvatar()).apply(requestOptions).into(profile_Picture);
                    }
                }
                else {
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.male);
                    requestOptions.error(R.drawable.male);
                    Glide.with(this)
                            .load(family.getAvatar()).apply(requestOptions).into(profile_Picture);
                }
            }
            else{
                if (data.getGender() != null) {
                    if (data.getGender().equals("M")) {
                        profile_Picture.setImageResource(R.drawable.male);

                    } else {
                        profile_Picture.setImageResource(R.drawable.female);

                    }
                }
                else
                    profile_Picture.setImageResource(R.drawable.male);

            }















        }
        catch (Exception e)
        {
            e.printStackTrace();
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
        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeProfilePicture();

                dialog_.dismiss();
            }
        });
        dialog_.show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
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
        profile_pic = bm;
        profile_Picture.setImageBitmap(bm);
        updateProfile();
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
        profile_pic = bm;
        profile_Picture.setImageBitmap(bm);
        updateProfile();

    }


    public class ProfileDapter extends RecyclerView.Adapter<ProfileDapter.ViewHolder> {

        Activity activity;
        List<FamilyDatum> familyData;
        private int lastSelectedPosition = 0;

        public ProfileDapter(Activity activity,List<FamilyDatum> familyData) {
            this.activity =activity;
            this.familyData = familyData;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.profile_items, parent,false);
            return  new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            FamilyDatum data = familyData.get(position);
            holder.textChild.setText(data.getFirstName());
            if(selectedProficPosition == position) {
                holder.frame.setBackground(holder.itemView.getResources().getDrawable(R.drawable.circle_background));
            }
            else {
                holder.frame.setBackground(null);
            }
            holder.frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Loading.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    healthParam.clear();
                    if(familyData.get(position).getType().equals("parent"))
                    {
                        getparents(familyData.get(position),"parent");
                    }
                    else if(familyData.get(position).getType().equals("child"))
                    {
                        getparents(familyData.get(position),"child");

                    }
                    selectedProficPosition = position;
                    notifyDataSetChanged();
                }
            });

            if(data.getAvatar()!=null) {

                if (data.getGender() != null) {
                    if (data.getGender().equals("M")) {
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.male);
                        requestOptions.error(R.drawable.male);
                        Glide.with(activity)
                                .load(data.getAvatar()).apply(requestOptions).into(holder.profile_image);
                    } else {
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.female);
                        requestOptions.error(R.drawable.female);
                        Glide.with(activity)
                                .load(data.getAvatar()).apply(requestOptions).into(holder.profile_image);
                    }
                }
                else {
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.male);
                    requestOptions.error(R.drawable.male);
                    Glide.with(activity)
                            .load(data.getAvatar()).apply(requestOptions).into(holder.profile_image);
                }
            }
            else{
                if (data.getGender() != null) {
                    if (data.getGender().equals("M")) {
                        holder.profile_image.setImageResource(R.drawable.male);

                    } else {
                        holder.profile_image.setImageResource(R.drawable.female);

                    }
                }
                else{
                    holder.profile_image.setImageResource(R.drawable.male);

                }
            }



//            if(data.getGender()!= null)
//            {
//                if(data.getGender().equals("M"))
//                {
//                    Glide.with(activity)
//                            .load(data.getAvatar()).apply(RequestOptions.placeholderOf(R.drawable.male)).into(holder.profile_image);
//
//                }
//                else {
//
//                    Glide.with(activity)
//                            .load(data.getAvatar()).apply(RequestOptions.placeholderOf(R.drawable.female)).into(holder.profile_image);
//
//                }
//
//            }


//            Glide.with(activity)
//                    .load(data.getAvatar()).apply(RequestOptions.placeholderOf(R.drawable.avtar)).into(holder.profile_image);

        }
        @Override
        public int getItemCount() {
            return familyData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            CircleImageView profile_image;
            TextView textChild;
            FrameLayout frame;
            public ViewHolder(View itemView) {
                super(itemView);
                profile_image = itemView.findViewById(R.id.profile_image);
                textChild = itemView.findViewById(R.id.textChild);
                frame = itemView.findViewById(R.id.profileFrame);

            }
        }
    }


    public class childItemAdapter extends RecyclerView.Adapter<childItemAdapter.ViewHolder> {
        Activity activity;
        int getPostion = 9;
        List<Food> food;
        public childItemAdapter(Activity activity,List<Food> food) {
            this.activity =activity;
            this.food = food;

        }
        @NonNull
        @Override
        public childItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.child_items, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull childItemAdapter.ViewHolder holder, final int position) {


            // Put Food allergies label
            if(food.get(position).getLabel()!=null){
                holder.textAllergy.setText(food.get(position).getLabel());
                String[] arrOfStr = food.get(position).getLabel().split("\\(", 5);
                if(arrOfStr.length>0) {
                    holder.textAllergy.setText(arrOfStr[0]);
                }
                else {
                    holder.textAllergy.setText(food.get(position).getLabel());
                }
            }

            // Handle Food Other Allergies  Yes/No and show other food allergies comment
            if(food.get(position).getLabel()!=null) {
                if(food.get(position).getLabel().equals("Other")) {
                    if(food.get(position).getStatus().equals("yes")) {
                        holder.textComment.setVisibility(View.VISIBLE);
                        foodAllergyOtherComment = holder.textComment;

                        String finallabel = "";
                        String[] split = food.get(position).getLabel().split(" ");
                        String editedlabel = "";
                        if(split[0].contains(","))
                            editedlabel = split[0].replace(",","");
                        else
                            editedlabel = split[0];

                        if(split.length>0) {
                            finallabel = "food_allergy_"+editedlabel.toLowerCase();
                        }
                        else
                            finallabel = "food_allergy_"+food.get(position).getLabel().toLowerCase();

                        healthParam.put(finallabel,"yes");


                        if(food.get(position).getComments()!=null) {
                            if(food.get(position).getComments().size()>0) {

                                try{
                                    JSONObject rootObject = new JSONObject(food.get(position).getComments().get(0).toString());
                                    holder.textComment.setText(rootObject.getString("text"));
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }



                            }
                            holder.border.setVisibility(View.INVISIBLE);
                        }
                    }
                    else {
                        holder.textComment.setVisibility(View.GONE);
                        holder.border.setVisibility(View.VISIBLE);
                        holder.textComment.setText("");
                    }
                }
            }


            //Put Food allergies status yes/no
            if(food.get(position).getStatus()!=null) {
                if(!food.get(position).getStatus().equals("")) {

                    String finallabel = "";
                    String[] split = food.get(position).getLabel().split(" ");
                    String editedlabel = "";
                    if(split[0].contains(","))
                        editedlabel = split[0].replace(",","");
                    else
                        editedlabel = split[0];

                    if(split.length>0) {
                        finallabel = "food_allergy_"+editedlabel.toLowerCase();
                    }
                    else
                        finallabel = "food_allergy_"+food.get(position).getLabel().toLowerCase();

                    if(food.get(position).getStatus().equals("yes")) {
                        holder.switchAllergy.setChecked(true);
                        healthParam.put(finallabel,"yes");
                    }
                    else if(food.get(position).getStatus().equals("no")) {
                        holder.switchAllergy.setChecked(false);
                    }
                }
                else
                    holder.switchAllergy.setChecked(false);
            }
            else
                holder.switchAllergy.setChecked(false);




            //Switch Click Listener and create update data
            holder.switchAllergy.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                        String label = food.get(position).getLabel();
                        String finallabel = "";
                        String[] split = label.split(" ");
                        String editedlabel = "";
                        if(split[0].contains(","))
                            editedlabel = split[0].replace(",","");
                        else
                            editedlabel = split[0];

                        if(split.length>0) {
                            finallabel = "food_allergy_"+editedlabel.toLowerCase();
                        }
                        else
                            finallabel = "food_allergy_"+label.toLowerCase();

                        if(isChecked) {
                            healthParam.put(finallabel, "yes");
                        }
                        else {
                            healthParam.put(finallabel, "no");
                        }

                    if(food.get(position).getLabel().equals("Other")) {


                        if(isChecked) {
                            holder.textComment.setVisibility(View.VISIBLE);
                            foodAllergyOtherComment = holder.textComment;
                        }
                        else
                        {
                            holder.textComment.setVisibility(View.GONE);
                        }
                    }

                }
            });

        }
        @Override
        public int getItemCount() {
            return food.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            RelativeLayout layoutEvent;
            TextView textAllergy;
            SwitchButton switchAllergy;
            EditText textComment;
            View border;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                layoutEvent = itemView.findViewById(R.id.layoutEvent);
                textAllergy = itemView.findViewById(R.id.textAllergy);
                switchAllergy = itemView.findViewById(R.id.switchAllergy);
                textComment = itemView.findViewById(R.id.textComment);
                border = itemView.findViewById(R.id.viewborder);

            }
        }
    }

}







































package com.feedAustralia.android.Activity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.feedAustralia.android.pojo.Family.Service;
import com.feedAustralia.android.pojo.FeedAuIsActive;
import com.feedAustralia.android.pojo.LoginData;
import com.feedAustralia.android.pojo.Privileges;
import com.feedAustralia.android.pojo.Service_;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 30-01-2019.
 */

public class Login extends AppCompatActivity implements View.OnClickListener{
    EditText Email,Password;
    TextView ForgetPassword;
    ScrollView scrollView;
    Button LoginText;
    GifTextView Loading;
    String Auth_token,Type;
    int ChildId,scheme_id;
    int checkedValue;
    String child,Scheme;

    RelativeLayout rememberme;
    ImageView checked;


    String type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.login_activity);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setEnabled(true);

        rememberme = findViewById(R.id.remeberme);
        checked  = findViewById(R.id.checked);

        init();

        SharedPreferences pref=getApplicationContext().getSharedPreferences("firstTime", Context.MODE_PRIVATE);
        String checkedV =  pref.getString("firstTime","");

        String userName =  pref.getString("username","");
        String passWord =  pref.getString("password","");


        if(checkedV.equals("") || checkedV.equals("0"))
        {
            checked.setImageResource(R.drawable.unchecked);
            checkedValue = 0;

        }
        else {

            checked.setImageResource(R.drawable.checked);
            checkedValue = 1;
            Email.setText(userName);
            Password.setText(passWord);

        }

        rememberme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(checkedValue ==1 ) {
                    checked.setImageResource(R.drawable.unchecked);
                    checkedValue = 0;
                }
                else {
                    checked.setImageResource(R.drawable.checked);
                    checkedValue = 1;
                }


            }
        });

        Listener();
    }
    public void init(){
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);






//        Email.setText("savannha_hart");
//        Password.setText("BQVgw7AjYa");
//
//        Email.setText("rosalind_baker6");
//        Password.setText("rosalind_baker6");
//
//        Email.setText("bonnie_hall36");
//        Password.setText("2v9pQQP0KF");
//
//
//        Email.setText("chris_burrett");
//        Password.setText("yISqDYciRJ");
//
//
//        Email.setText("tyrone_wilmen");
//        Password.setText("W5gNA31DLK");
//
//
//
//
//        Email.setText("rosalind_baker6");
//        Password.setText("rosalind_baker6");
//
//        Email.setText("seema_bhatt");
//        Password.setText("seema_bhatt");


        LoginText = findViewById(R.id.LoginText);
        ForgetPassword = findViewById(R.id.ForgetPassword);
        Loading = findViewById(R.id.Loading);
    }
    public void Listener(){
        ForgetPassword.setOnClickListener(this);
        LoginText.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LoginText:
                Api();
                break;
            case R.id.ForgetPassword:
                Intent intent =   new Intent(Login.this,ForgetActivity.class);
                startActivity(intent);
                break;
        }
    }
    public void AlertBox(String program,String legal_type,String legal_label){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.AlertDialogAnimationLogin;
        } catch (Exception exc) {
        }
        LayoutInflater li = LayoutInflater.from(this);
        View myView = li.inflate(R.layout.alertbox, null);
        dialog.setContentView(myView);
        RelativeLayout Animatelayout =dialog.findViewById(R.id.Animatelayout);
        TextView textAccept=dialog.findViewById(R.id.textAccept);
        TextView FirstText = dialog.findViewById(R.id.FirstText);
        CheckBox checkSelected = dialog.findViewById(R.id.checkSelected);
        TextView textSecond = dialog.findViewById(R.id.SecondText);
        textSecond.setText(legal_label);


//        TextView FourthText = dialog.findViewById(R.id.FourthText);
        Animatelayout.getLayoutParams().width=getScreenWidth(this);
        dialog. setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();


        textSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(legal_type.equals("TOU"))
                {
                    Intent Terms = new Intent(Login.this,TermsOfService.class);
                    Terms.putExtra("program",program);
                    Terms.putExtra("type",legal_type);
                    Login.this.startActivity(Terms);
                }
                else if(legal_type.equals("PRIVACY"))
                {
                    Intent Terms = new Intent(Login.this,TermsOfService.class);
                    Terms.putExtra("program",program);
                    Terms.putExtra("type",legal_type);
                    Login.this.startActivity(Terms);
                }
            }
        });

        checkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {

                    dialog.dismiss();
                    Loading.setVisibility(View.VISIBLE);
                    updateTOU(legal_type,program);

                }
            }
        });
    }

    public void updateTOU(String legal_type,String program){

        Loading.setVisibility(View.VISIBLE);
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<LoginData> service = apiInterface.updateTOU(email,password,legal_type,program,"true");
        service.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                LoginData loginData = response.body();
                try{
                    Api();
                }catch (Exception e){
                    Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                Log.d("Failure", "onFailure: "+t);
            }
        });
    }



    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        return (int) (point.x*0.9);
    }
    public void Api(){


        if(checkedValue ==1 )
        {
            SharedPreferences pref=getApplicationContext().getSharedPreferences("firstTime", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            editor.putString("firstTime", "1");
            editor.putString("username",Email.getText().toString());
            editor.putString("password",Password.getText().toString());
            editor.apply();

        }
        else {
            SharedPreferences pref=getApplicationContext().getSharedPreferences("firstTime", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            editor.putString("firstTime", "0");
            editor.putString("username","");
            editor.putString("password","");
            editor.apply();

        }

        //Save Remember Me Username and password


        Loading.setVisibility(View.VISIBLE);
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<LoginData> service = apiInterface.login(email,password,"true");
        service.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                LoginData loginData = response.body();
                try{
                    if(response.code()==403)
                    {
                        ResponseBody errorbody = response.errorBody();
                        if (response != null && response.errorBody() != null) {
                            JSONObject jsonObject = new JSONObject(response.errorBody().string());
                            String error =  jsonObject.getString("error");
                            String legal_label =  jsonObject.getString("legal_label");
                            String legal_type =  jsonObject.getString("legal_type");
                            String program =  jsonObject.getString("program");
                            Loading.setVisibility(View.GONE);
                            AlertBox(program,legal_type,legal_label);
                        }
                    }
                    else {
                        if(loginData != null)
                        {
                            Auth_token = loginData.getAuthToken();
                            Privileges pre = loginData.getPrivileges();
                            if(pre.getHubhelloFeedauAccess()) {
                                ApiCall(loginData);
                            }
                            else {
                                ErrorAlert.alertDialog(Login.this,"Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                                Loading.setVisibility(View.GONE);
                            }
                        } else {
                            Loading.setVisibility(View.GONE);
                            ErrorAlert.alertDialog(Login.this,"The login or password you entered is incorrect. Please try again.");
                        }

                    }

                }catch (Exception e){
                    showError("");
                }

            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                Log.d("Failure", "onFailure: "+t);
                showError("");

            }
        });
    }
    public void ApiCall(LoginData loginData){
        Auth_token = loginData.getAuthToken();
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call <List<FamilyDatum>> service = apiInterface.familylist();
        service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                List<FamilyDatum> familyData = response.body();
                try{
                    if (familyData !=null && familyData.size()>0){
                        String schemeId = "";
                        String service_id  = "";
                        String childType = "";
                        String childId = "";
                        String user_avtar = "";
                        String service_name = "";
                        String gender = "";


                        int check = 0;
                        for(FamilyDatum child : familyData) {
                            if(child.getType().equals("child")) {
                                if(child.getServices().size()>0) {
                                    if(child.getServices().get(0).getSchemeId()!=null)
                                        schemeId = child.getServices().get(0).getSchemeId().toString();

                                    if(child.getServices().get(0).getServiceId()!=null)
                                        service_id = child.getServices().get(0).getServiceId().toString();

                                    if(loginData.getUserAvatar()!=null)
                                    {
                                        user_avtar = loginData.getUserAvatar().toString();
                                    }
                                    if(loginData.getGender()!= null)
                                        gender = loginData.getGender();
                                    check = 1;
                                    childType = child.getType();
                                    childId = child.getId().toString();
                                    service_name = child.getServices().get(0).getGroupName();
                                    break;
                                }
                            }
                            else if(child.getType().equals("parent"))
                            {

                            }
                        }
                        int feedau_access = 0;
                        List<FeedAuIsActive> active = loginData.getFeedAuIsActive();
                        for(FeedAuIsActive feed:active)
                        {
                            for(Service_ service:feed.getServices())
                            {
                                if(service.getServiceId()!=null){
                                    if(service_id.equals(service.getServiceId().toString()))
                                    {
                                        feedau_access=1;
                                    }
                                }

                                if(service.getSchemeId()!=null){
                                    if(schemeId.equals(service.getSchemeId().toString()))
                                    {
                                        feedau_access=1;
                                    }
                                }
                            }
                        }
                        if(check==0) {
                            showError("");
                        }
//                        else if(feedau_access==0)
//                        {
//                            showError("feedAustralia program is not available yet. Please check later.");
//                        }
                        else {
                            SessionManager.shared(Login.this, Auth_token,childType,childId,schemeId,service_id,user_avtar,loginData.getUserName(),service_name,gender);
                            Intent intent = new Intent(Login.this,Home.class);
                            startActivity(intent);
                            finish();
                            Loading.setVisibility(View.GONE);

                        }





                    }else{
                        showError("");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    showError("");
                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                showError("");

            }
        });

    }

    public void showError(String error)
    {
        Loading.setVisibility(View.GONE);
        if(error.equals("")) {
            ErrorAlert.alertDialog(Login.this,"We’re sorry! An Error has occurred, please try again.");
        }
        else {
            ErrorAlert.alertDialog(Login.this,error);
        }
    }

}


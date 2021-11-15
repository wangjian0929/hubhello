package com.feedAustralia.android.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import okhttp3.RequestBody;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 30-01-2019.
 */

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Email;
    TextView EmailText;
    ScrollView scrollView;
    int value = 0;
    Button ResetPassword;
    GifTextView Loading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.forget_password);
        scrollView = findViewById(R.id.scrollView);
        Loading = findViewById(R.id.Loading);
        scrollView.setEnabled(true);
        init();
        Listener();
    }
    public void init(){
        Email = findViewById(R.id.Email);
        ResetPassword = findViewById(R.id.ResetPassword);
        EmailText = findViewById(R.id.EmailText);
    }
    public void Listener(){
        ResetPassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ResetPassword:
                Api();
                break;
        }
    }

    public void showError(String error)
    {
        Loading.setVisibility(View.GONE);
        if(error.equals("")) {
            ErrorAlert.alertDialog(ForgetActivity.this,"We could not send an email with instructions on how to reset your password.");
        }
        else {
            ErrorAlert.alertDialog(ForgetActivity.this,error);
        }
    }

    public void Api(){
        Loading.setVisibility(View.VISIBLE);
        String username = Email.getText().toString();
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<RequestBody> Service = apiInterface.forgetData(username);
        Service.enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                if (response.isSuccessful()){
                    if (response.code()== 204){
                        if (value == 0){
                            Email.setVisibility(View.INVISIBLE);
                            EmailText.setText("Please Check your email for your password.");
                            ResetPassword.setText("Back to Login");
                            value =1;
                            Loading.setVisibility(View.GONE);
                        }else if (value == 1){
                            Intent intent = new Intent(ForgetActivity.this,Login.class);
                            startActivity(intent);
                            finish();
                            value =0;
                        }
                    }
                    else{
                        Log.d("Error", "onResponse: "+response);
                    }
                }
                else {

                    showError("");

                }
            }
            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                Log.d("UnSuccess", "onFailure: "+t);
            }
        });
    }
}

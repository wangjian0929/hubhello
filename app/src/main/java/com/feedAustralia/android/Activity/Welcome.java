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
import android.text.Html;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.feedAustralia.android.LanguageFont.FontTextView_Bold;
import com.feedAustralia.android.LanguageFont.FontTextView_SemiBold;
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

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    FontTextView_SemiBold staticText;
    FontTextView_Bold login;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        login = findViewById(R.id.loginView);

        SharedPreferences pref=getApplicationContext().getSharedPreferences("welcome", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("welcome", "1");
        editor.apply();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this,Login.class);
                startActivity(intent);
                finish();


            }
        });
        staticText = findViewById(R.id.staticText);

//        staticText.setText("The feedAustralia app is for parents who have children attending a service using the free feedAustralia program.\n" +
//                "\n" +
//                "If you would like to gain access you can advise your service to sign up for feedAustralia here:\n" +
//                "http://feedaustralia.org.au\n" +
//                "\n" +
//                "If they are using the program already make sure they have added your child and your email address into feedAustralia which will automatically send you your login details.");


        staticText.setLinksClickable(true);
        staticText.setLinkTextColor(getResources().getColor(R.color.white));
        staticText.setText(Html.fromHtml("The feedAustralia app is for parents who have children attending a service using the free feedAustralia program.<br>" +
                "<br>" +
                "If you would like to gain access you can advise your service to sign up for feedAustralia here:<br>" +
                "<u>http://feedaustralia.org.au</u><br>" +
                "<br>" +
                "If they are using the program already make sure they have added your child and your email address into feedAustralia which will automatically send you your login details."));

        Linkify.addLinks(staticText, Linkify.WEB_URLS);


//        scrollView = findViewById(R.id.scrollView);
//        scrollView.setEnabled(true);
    }
    @Override
    public void onClick(View v) {

    }






}


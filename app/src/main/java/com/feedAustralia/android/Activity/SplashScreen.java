package com.feedAustralia.android.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.feedAustralia.android.R;
import pl.droidsonroids.gif.GifTextView;


public class SplashScreen extends AppCompatActivity {
    GifTextView SplashPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        SplashPicture = findViewById(R.id.SplashPicture);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences pref=getApplicationContext().getSharedPreferences("welcome", Context.MODE_PRIVATE);
                String welcome =  pref.getString("welcome","");

                if(welcome.equals(""))
                {
                    Intent intent = new Intent(SplashScreen.this,Welcome.class);
                    startActivity(intent);
                    finish();


                }
                else {
                    Intent intent = new Intent(SplashScreen.this,Login.class);
                    startActivity(intent);
                    finish();

                }

            }
        },3000);
    }
}

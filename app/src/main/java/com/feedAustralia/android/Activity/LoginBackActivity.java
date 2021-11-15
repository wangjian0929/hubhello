package com.feedAustralia.android.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.feedAustralia.android.R;

/**
 * Created by asd on 30-01-2019.
 */

public class LoginBackActivity extends AppCompatActivity implements View.OnClickListener{
    TextView BackLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.login_back);
        init();
        Listener();
    }
    public void init(){
        BackLogin = findViewById(R.id.BackLogin);
    }
    public void Listener(){
        BackLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BackLogin:
                Intent intent = new Intent(LoginBackActivity.this,Login.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

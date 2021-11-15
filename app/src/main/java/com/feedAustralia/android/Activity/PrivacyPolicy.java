package com.feedAustralia.android.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Privacy.PrivacyData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrivacyPolicy extends BaseActivity implements View.OnClickListener{
    TextView DateId,DescriptionText,SignIn,TitleText,Revision;
    String Title,Content,UpdateDate;
    GifTextView Loading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy);
        DateId = findViewById(R.id.DateId);
        DescriptionText = findViewById(R.id.DescriptionText);
        SignIn = findViewById(R.id.SignIn);
        TitleText = findViewById(R.id.TitleText);
        Revision = findViewById(R.id.Revision);
        Loading = findViewById(R.id.Loading);
        Listener();
        Api();
    }
    public void Api(){
        Loading.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<PrivacyData> Service = apiInterface.privacy("All","PRIVACY");
        Service.enqueue(new Callback<PrivacyData>() {
            @Override
            public void onResponse(Call<PrivacyData> call, Response<PrivacyData> response) {
                PrivacyData GetData = response.body();
                if (response.isSuccessful()){
                    Title = GetData.getDocumentTitle();
                    TitleText.setText(Title);
                    Content = GetData.getContent();
                    DescriptionText.setText(Html.fromHtml(Content));
                    UpdateDate = GetData.getUpdatedDate();
                    DateId.setText(convertTime(UpdateDate));
                    Revision.setVisibility(View.VISIBLE);
                    Loading.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<PrivacyData> call, Throwable t) {
                Log.d("Failure", "onFailure: "+t);
            }
        });
    }
    private String convertTime(String updateDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd, yyyy");
        java.util.Date date = null;
        try {
            date = format.parse(updateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convertedDate = format1.format(date);
        return convertedDate;
    }
    public void Listener(){
        SignIn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignIn:
                Intent intent = new Intent(PrivacyPolicy.this,Login.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

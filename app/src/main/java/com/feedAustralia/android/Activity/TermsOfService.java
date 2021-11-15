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
import com.feedAustralia.android.pojo.Terms.TermsData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 06-02-2019.
 */

public class TermsOfService extends BaseActivity implements View.OnClickListener {
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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String program = getIntent().getStringExtra("program");
            String legal_type = getIntent().getStringExtra("type");
            Api(program, legal_type);

        }
        else {
            Api("feedAustralia", "TOU");
        }

    }
    public void Api(String program,String legal_type){
        Loading.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<TermsData> Service = apiInterface.terms(program,legal_type);
        Service.enqueue(new Callback<TermsData>() {
            @Override
            public void onResponse(Call<TermsData> call, Response<TermsData> response) {
                TermsData GetData = response.body();
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
            public void onFailure(Call<TermsData> call, Throwable t) {
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
                finish();
                break;
        }
    }
}

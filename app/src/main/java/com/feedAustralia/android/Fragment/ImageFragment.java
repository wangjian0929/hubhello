package com.feedAustralia.android.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.feedAustralia.android.R;

/**
 * Created by asd on 11-02-2019.
 */

public class ImageFragment extends DialogFragment {
    ImageView Image;
    public static ImageFragment newInstance() {
        ImageFragment f = new ImageFragment();
        return f;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, container, false);
        Image = view.findViewById(R.id.Image);
//        Bundle bundle = this.getArguments();
//        String myValue = bundle.getSerializable("message",meal.getThumbnailUrl());
//        Glide.with(getActivity()).load(meal.getThumbnailUrl()).apply(RequestOptions.placeholderOf(R.drawable.burger)).into(Image);Image
        return view;
    }
    @SuppressLint("MissingSuperCall")
    public void onStart(){
        super.onStart();
//        Dialog dialog = getDialog();
//        if (dialog != null)
//        {
//            int width = ViewGroup.LayoutParams.MATCH_PARENT;
//            int height = ViewGroup.LayoutParams.MATCH_PARENT;
//            dialog.getWindow().setLayout(width, height);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
    }
}
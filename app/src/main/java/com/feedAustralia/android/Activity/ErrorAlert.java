package com.feedAustralia.android.Activity;

import android.app.Activity;
import com.feedAustralia.android.R;

import android.app.Dialog;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ErrorAlert {
    public static void alertDialog(Activity context, String msg_) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.AlertDialogAnimationLogin;
        } catch (Exception exc) {
        }
        LayoutInflater li = LayoutInflater.from(context);
        View myView = li.inflate(R.layout.erroralert, null);
        dialog.setContentView(myView);
        RelativeLayout Animatelayout =dialog.findViewById(R.id.Animatelayout);
        RelativeLayout btnOkay=dialog.findViewById(R.id.btnOkay);
        TextView message=dialog.findViewById(R.id.message);
        message.setText(msg_);
        Animatelayout.getLayoutParams().width=getScreenWidth(context);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        return (int) (point.x*0.8);

    }
}

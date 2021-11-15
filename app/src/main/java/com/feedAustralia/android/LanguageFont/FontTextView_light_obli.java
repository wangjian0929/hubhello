package com.feedAustralia.android.LanguageFont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by asd on 05-02-2019.
 */

public class FontTextView_light_obli extends android.support.v7.widget.AppCompatTextView {
    public FontTextView_light_obli(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "AvenirLTStd-LightOblique.ttf");
        this.setTypeface(face);
    }
    public FontTextView_light_obli(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "AvenirLTStd-LightOblique.ttf");
        this.setTypeface(face);
    }
    public FontTextView_light_obli(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "AvenirLTStd-LightOblique.ttf");
        this.setTypeface(face);
    }
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }

}

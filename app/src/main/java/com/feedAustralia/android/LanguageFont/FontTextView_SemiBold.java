package com.feedAustralia.android.LanguageFont;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class FontTextView_SemiBold extends android.support.v7.widget.AppCompatTextView {
    public FontTextView_SemiBold(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "avenirltstd_book.ttf");
        this.setTypeface(face);
    }
    public FontTextView_SemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(),"avenirltstd_book.ttf");
        this.setTypeface(face);

    }
    public FontTextView_SemiBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "avenirltstd_book.ttf");
        this.setTypeface(face);
    }
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }

}
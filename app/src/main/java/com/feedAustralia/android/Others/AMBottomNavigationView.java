package com.feedAustralia.android.Others;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.feedAustralia.android.R;
import java.util.ArrayList;

/**
 * Created by asd on 04-02-2019.
 */

public class AMBottomNavigationView extends FrameLayout {
    Context context;
    private int items=4;
    private int currentItem = 0;
    int[] icons_ = {R.drawable.unmenutab,R.drawable.unselectedmenuideas,R.drawable.uneatinghabits
                ,R.drawable.unanalytics};
    int[] iconss_ = {R.drawable.menutab,R.drawable.menuideas,R.drawable.eatinghabit
            ,R.drawable.analyticstab};

        private ArrayList<View> views = new ArrayList<>();
        private AMBottomNavigationView.OnNavigationItemSelectedListener mSelectedListener;
        String [] footerdata = {"Menu","Recipes","Eating Habits","Analytics"};
    public AMBottomNavigationView(Context context) {
        this(context, null);
    }
    public AMBottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public AMBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        int layoutHeight = (int) getResources().getDimension(R.dimen.bottom_navigation_height);
        LinearLayout linearLayoutContainer = new LinearLayout(context);
        linearLayoutContainer.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutContainer.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, layoutHeight);
        addView(linearLayoutContainer, layoutParams);
        createClassicItems(linearLayoutContainer);
        post(new Runnable() {
            @Override
            public void run() {
                requestLayout();
            }
        });
    }
    private void createClassicItems(LinearLayout linearLayout) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        float height = getResources().getDimension(R.dimen.bottom_navigation_height);
        for (int i = 0; i < items; i++) {
            final boolean current = currentItem == i;
            final int itemIndex = i;
            View view = inflater.inflate(R.layout.bottom_navigation_view, this, false);
            ImageView icon =view.findViewById(R.id.bottom_navigation_item_icon);

           if(i==1) {

                int layoutHeight = (int) getResources().getDimension(R.dimen._20sdp);
                int layoutWidth = (int) getResources().getDimension(R.dimen._22sdp);


                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(layoutWidth,layoutHeight);
                parms.gravity = Gravity.CENTER;
                parms.topMargin = (int) getResources().getDimension(R.dimen._minus5sdp);
                icon.setLayoutParams(parms);


            }
            else if(i==2) {
                int layoutHeight = (int) getResources().getDimension(R.dimen._20sdp);
                int layoutWidth = (int) getResources().getDimension(R.dimen._25sdp);

                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(layoutWidth,layoutHeight);
               parms.gravity = Gravity.CENTER;
               parms.topMargin = (int) getResources().getDimension(R.dimen._minus5sdp);
                icon.setLayoutParams(parms);
                icon.setLayoutParams(parms);

            }



            icon.setImageResource(icons_[i]);
            TextView footer = view.findViewById(R.id.bottom_navigation_item_text);
            footer.setText(footerdata[i]);
            view.setBackgroundColor(getResources().getColor(R.color.white));
            if (i==currentItem)
            {
                icon.setImageResource(R.drawable.menutab);
                footer.setTextColor(Color.parseColor("#91ce0c"));
//                icon.setColorFilter(ContextCompat.getColor(context, R.color.button_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            else
            {
//                icon.setColorFilter(ContextCompat.getColor(context, R.color.button_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            FrameLayout container = view.findViewById(R.id.bottom_navigation_container);
            container.setPadding(0, container.getPaddingTop(), 0, container.getPaddingBottom());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateItems(itemIndex, true);
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, (int) height,1f);
            linearLayout.addView(view, params);
            views.add(view);
        }
    }
    public void updateItems(final int itemIndex, boolean useCallback) {
        if (currentItem == itemIndex) {
            if (mSelectedListener != null && useCallback) {
                mSelectedListener.onNavigationItemSelected(itemIndex, true);
            }
            return;
        }
        if (mSelectedListener != null && useCallback) {
            boolean selectionAllowed = mSelectedListener.onNavigationItemSelected(itemIndex, false);
            if (!selectionAllowed) return;
        }
        for (int i = 0; i < views.size(); i++) {
            View view=views.get(i);
            ImageView icon =view.findViewById(R.id.bottom_navigation_item_icon);
            icon.setImageResource(icons_[i]);
            TextView footer = view.findViewById(R.id.bottom_navigation_item_text);
            footer.setText(footerdata[i]);
            if (i==itemIndex)
            {
                icon.setImageResource(iconss_[i]);
                footer.setTextColor(Color.parseColor("#91ce0c"));
//                icon.setColorFilter(ContextCompat.getColor(context, R.color.button_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            else
            {
                footer.setTextColor(Color.parseColor("#666666"));
                 view.setBackgroundColor(getResources().getColor(R.color.white));
//                icon.setColorFilter(ContextCompat.getColor(context, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        }
        currentItem = itemIndex;
    }
    public void setOnNavigationItemSelectedListener(
            @Nullable AMBottomNavigationView.OnNavigationItemSelectedListener listener) {
        mSelectedListener = listener;
    }
    public void addItemsCount(int i) {
        this.items=i;
    }
    public void Update() {
        updateItems(0,true);
    }
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(int position, boolean b);
    }
}




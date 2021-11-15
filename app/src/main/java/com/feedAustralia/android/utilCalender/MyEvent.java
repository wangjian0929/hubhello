package com.feedAustralia.android.utilCalender;

public class MyEvent extends CalendarEvent {

    private String mTitle;
    private String mDetail;

    public MyEvent(String title,String detail, long startTimeInMillis, int indicatorColor) {
        super(startTimeInMillis, indicatorColor);
        mTitle = title;
        mDetail = detail;
    }

    public String getTitle() {
        return mTitle;
    }
    public String getDetail() {
        return  mDetail;
    }

}

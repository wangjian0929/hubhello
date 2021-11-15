package com.feedAustralia.android.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.events.calendar.views.EventsCalendar;
import com.feedAustralia.android.Activity.EditProfile;
import com.feedAustralia.android.Activity.MenuDescription;
import com.feedAustralia.android.Activity.ProfileMain;
import com.feedAustralia.android.Activity.SessionManager;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.feedAustralia.android.pojo.Menu.Group__;
import com.feedAustralia.android.pojo.Menu.MenuData;
import com.feedAustralia.android.pojo.MenuOne.Group;
import com.feedAustralia.android.pojo.MenuOne.Meal;
import com.feedAustralia.android.pojo.MenuOne.MealsDataList;
import com.feedAustralia.android.pojo.MenuOne.MealsDatum;
import com.feedAustralia.android.pojo.MenuOne.Nutrition_;
import com.feedAustralia.android.pojo.Service;
import com.feedAustralia.android.pojo.habit.MenuSet;
import com.feedAustralia.android.utilCalender.CalendarEvent;
import com.feedAustralia.android.utilCalender.CalendarMonthNameFormatter;
import com.feedAustralia.android.utilCalender.CalendarView;
import com.feedAustralia.android.utilCalender.MonthPager;
import com.feedAustralia.android.utilCalender.MyEvent;
import com.feedAustralia.android.utilCalender.OnDateSelectedListener;
import com.feedAustralia.android.utilCalender.OnLoadEventsListener;
import com.feedAustralia.android.utilCalender.OnMonthChangedListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MenuFragment extends Fragment  implements OnMonthChangedListener, OnLoadEventsListener, OnDateSelectedListener {
    RecyclerView recyclerView,recyclerview1,recyclerView4;
    WeekAdapter weekAdapter;
    MultiChildAdapter multiChildAdapter;
    private CalendarMonthNameFormatter mFormatter = new CalendarMonthNameFormatter(true);
    MenusAdapter menusAdapter;
    List<MyEvent>  events = new ArrayList<>();
    OnLoadEventsListener loadEventsListener;
    OnMonthChangedListener monthChangedListener;
    OnDateSelectedListener dateSelectedListener;
    View view=null;
    String menuSetId = "";
    int weekClicked = 0;
    String selectedDate = "";
    NestedScrollView scrollView;
    RatingBar ratingBar;
    TextView PacifDate;
    int weekvalue=1;
    LinearLayoutManager layoutManager1,layoutManagerchild,layoutManagerService;
    CircleImageView profile_image;
    ImageView settings;
    RelativeLayout imagecalanderweek,HeaderCalnder;
    private PopupWindow mDropdown = null;
    private PopupWindow monthCalendar = null;

    int currentMonth ;
    int currentYear;
    int selectedYear = currentYear;
    LayoutInflater mInflater;
    Calendar calendar;
    TextView monthname;
    ArrayList<String> date;

    String selectedChild,selectedService,selectedScheme,selectedServiceName;

    LinearLayout layoutCalander;
    String Auth_token;
    String GetDate,SetDAte;
    List <MenuData> myRetroClas;
    String MeatStr,VegetablesStr,BreadStr,FruitStr,DairyStr;
    TextView meatquantity,Dairyquantity,Breadquantity,Fruitquantity,Vegetablesquantity;
    com.feedAustralia.android.pojo.Menu.Group meal_group;
    TextView GetView;
    int currentYea;
    ArrayList<String> sorteddate;
    int color;
    ImageView monthcalendaricon;
    TextView errornodata,nodatamonthtext;
    TextView energyPerChild,proteinPerChild,fatTotalPerChild,carbohydrateTotalPerChild,carbohydrateSugarPerChild,sodiumPerChild;
    TextView energy100g,protein100g,fat100g,carbohydrate100g,carbohydrateSugar100g,sodium100g,allergyquantity;
    GifTextView loading;
    LinearLayout mainLayout,secondLayout;
    RelativeLayout RatingLayout;
    View Viewed;
    int value = 0;
    ImageView Checkedone,Checkedtwo;
    RelativeLayout custommonthview;
    LinearLayout monthView;
    ImageView monthbackward,monthforward;
    TextView textmonth;
    CalendarView calendarView;
    ImageView backButton;
//    Button btnjan,btnfeb,btnmar,btnapr,btnmay,btnjun,btnjul,btnaug,btnsept,btnoct,btnnov,btndec;
    int month =0;
    int year = 0;
    CircleImageView imageView;
    LinearLayout allergyLayout;
    DateRangeCalendarView weekCalendar;
    RecyclerView viewRecylerMultipleChild,multiServiceRecyclerView;
    RelativeLayout childLayout,multiserviceview,multiservicelayout;
    TextView multiserviceText;
    RelativeLayout weekCalendarView;
    String startDate, endDate;

    ImageView logofA;

//    View layout_someneeded;

    @Override
    public void onResume() {
        super.onResume();
        // Check should we need to refresh the fragment
        imageView = (CircleImageView) view.findViewById(R.id.profile_image);
        String gender = SessionManager.gender(getActivity());

        if(gender.equals("M")) {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);
        }
        else if(gender.equals("F"))
        {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.female)).into(imageView);
        }
        else {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);
        }


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        calendar = Calendar.getInstance();
        monthView =  view.findViewById(R.id.support_layout);
        logofA = view.findViewById(R.id.Logo);

        weekCalendar = view.findViewById(R.id.weekCalendar);
        weekCalendarView = view.findViewById(R.id.weekCalendarView);
        HeaderCalnder = view.findViewById(R.id.HeaderCalnder);
        errornodata = view.findViewById(R.id.errornodata);
        nodatamonthtext = view.findViewById(R.id.nodatamonthtext);
        currentYea   = calendar.get(Calendar.YEAR);
        meatquantity =view.findViewById(R.id.meatquantity);
        Dairyquantity =view.findViewById(R.id.Dairyquantity);
        Breadquantity =view.findViewById(R.id.Breadquantity);
        Fruitquantity =view.findViewById(R.id.Fruitquantity);
        Vegetablesquantity =view.findViewById(R.id.Vegetablesquantity);
        layoutCalander = view.findViewById(R.id.layoutCalander);
        monthname = view.findViewById(R.id.monthname);
        loading = view.findViewById(R.id.loading);
        mainLayout = view.findViewById(R.id.mainLayout);
        secondLayout = view.findViewById(R.id.secondLayout);
        RatingLayout = view.findViewById(R.id.RatingLayout);
        Viewed = view.findViewById(R.id.Viewed);
        imagecalanderweek = view.findViewById(R.id.calendarIcon);
        monthcalendaricon =  view.findViewById(R.id.imagecalanderweek);
        monthbackward = view.findViewById(R.id.monthbackward);
        monthforward = view.findViewById(R.id.monthforward);
        imageView =  view.findViewById(R.id.profile_image);
        allergyLayout = view.findViewById(R.id.allergyLayout);

        // Current Date selected for Week menu
        Date current = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        selectedDate = format.format(current);

        //Multichild
        viewRecylerMultipleChild = view.findViewById(R.id.viewRecylerMultipleChild);
        layoutManagerchild = new LinearLayoutManager(getActivity());
        viewRecylerMultipleChild.setLayoutManager(layoutManagerchild);

        // Multi Services View
        multiServiceRecyclerView = view.findViewById(R.id.multiServiceRecyclerView);
        layoutManagerService = new LinearLayoutManager(getActivity());
        multiServiceRecyclerView.setLayoutManager(layoutManagerService);

        multiserviceview = view.findViewById(R.id.multiserviceview);
        multiserviceText = view.findViewById(R.id.serviceName);
        multiservicelayout = view.findViewById(R.id.multiservicelayout);

        weekCalendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weekCalendarView.getVisibility() == View.VISIBLE)
                {
                    weekCalendarView.setVisibility(View.GONE);

                }
            }
        });
        multiserviceview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(multiservicelayout.getVisibility() == View.VISIBLE)
                {
                    multiservicelayout.setVisibility(View.GONE);

                }
                else{
                    multiservicelayout.setVisibility(View.VISIBLE);

                }
            }
        });

        backButton = view.findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                childLayout.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.GONE);
                settings.setVisibility(View.GONE);

            }
        });

        logofA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                childLayout.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.GONE);
                settings.setVisibility(View.GONE);

            }
        });



        weekCalendar.setWeekOffset(1);
        Typeface typeface=Typeface.createFromAsset(getContext().getAssets(), "avenirltstd_book.ttf");
        weekCalendar.setFonts(typeface);
        weekCalendar.setCalendarListener(new DateRangeCalendarView.CalendarListener() {
            @Override
            public void onFirstDateSelected(Calendar startDate) {


                Date selected = new Date();
                selected = startDate.getTime();
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                String sel = fmt.format(selected);
                Api(sel);
                weekCalendarView.setVisibility(View.GONE);
                weekCalendar.resetAllSelectedViews();

            }

            @Override
            public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
            }
        });

        childLayout = view.findViewById(R.id.childLayout);
        String gender = SessionManager.gender(getActivity());
        if(gender.equals("M")) {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);
        }
        else if(gender.equals("F")) {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.female)).into(imageView);
        }
        else {
            Glide.with(this)
                    .load(SessionManager.userAvtar(getActivity())).apply(RequestOptions.placeholderOf(R.drawable.male)).into(imageView);
        }


        imagecalanderweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weekvalue==1)
                {

                    if(weekCalendarView.getVisibility() == View.VISIBLE) {
                        weekCalendarView.setVisibility(View.GONE);
                    }
                    else {
                        weekCalendarView.setVisibility(View.VISIBLE);
                        try {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date myDate = null;
                        Date endDat = null;
                            myDate = dateFormat.parse(startDate);
                            endDat = dateFormat.parse(endDate);

                            Calendar startSelectionDate = Calendar.getInstance();
                            startSelectionDate.setTime(myDate);
                            Calendar endSelectionDate = Calendar.getInstance();
                            endSelectionDate.setTime(myDate);
                            endSelectionDate.add(Calendar.DATE, 6); // 10 is the days you want to add or subtract
//                            endSelectionDate.setTime(endDat);
                            weekCalendar.setSelectedDateRange(startSelectionDate, endSelectionDate);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if(weekvalue==0)
                {
                    if (value ==0){
                        showMonthCalendar();
                        value =1;
                    }else if (value ==1){
                        Log.e("1",Integer.toString(value));
                        value =0;
                        try {
                            calendarView.setVisibility(View.VISIBLE);
                            scrollView.setNestedScrollingEnabled(true);
                            scrollView.setEnabled(true);
                            monthView.setVisibility(View.GONE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        allergyquantity = view.findViewById(R.id.allergyquantity);
        energyPerChild = view.findViewById(R.id.energyPerChild);
        proteinPerChild = view.findViewById(R.id.proteinPerChild);
        fatTotalPerChild = view.findViewById(R.id.fatTotalPerChild);
        carbohydrateTotalPerChild = view.findViewById(R.id.carbohydrateTotalPerChild);
        carbohydrateSugarPerChild = view.findViewById(R.id.carbohydrateSugarPerChild);
        sodiumPerChild = view.findViewById(R.id.SodiumPerChild);

        energy100g = view.findViewById(R.id.energy100g);
        protein100g = view.findViewById(R.id.protein100g);
        fat100g = view.findViewById(R.id.fat100g);
        carbohydrate100g = view.findViewById(R.id.carbohydrate100g);
        carbohydrateSugar100g = view.findViewById(R.id.carbohydrateSugar100g);
        sodium100g = view.findViewById(R.id.sodium100g);

        myRetroClas = new ArrayList<>();
        GetView = view.findViewById(R.id.GetView);
        PacifDate = view.findViewById(R.id.PacifDate);
        profile_image = view.findViewById(R.id.profile_image);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileMain.class);
                startActivity(intent);

            }
        });
        settings = view.findViewById(R.id.settings);
        settings.setVisibility(View.GONE);

        view.findViewById(R.id.profileImageLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDropdown!=null) {
                    mDropdown.dismiss();
                    mDropdown = null;
                }
                else
                    initiatePopupWindow();
            }
        });
        scrollView = view.findViewById(R.id.scrollView);
        ratingBar = view.findViewById(R.id.ratingBar);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerview1  = view.findViewById(R.id.recyclerview1);
        recyclerview1.setNestedScrollingEnabled(false);
        layoutManager1 = new LinearLayoutManager(recyclerview1.getContext());
        recyclerview1.setLayoutManager(layoutManager1);
        calendarView = view.findViewById(R.id.calendarView);

        loadEventsListener=this;
        monthChangedListener=this;
        dateSelectedListener=this;
        calendar=Calendar.getInstance();
        calendarView.setMinimumDate(calendar.getTimeInMillis());
        calendarView.setOnLoadEventsListener(loadEventsListener);
//        calendarView.setFirstDayOfWeek(1);
        // Get Menu Sets

        getfamilymember();
        return view;
    }

    public boolean onBackPressed() {

        if(backButton.getVisibility() == View.VISIBLE)
        {
            viewRecylerMultipleChild.setVisibility(View.VISIBLE);
            childLayout.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.GONE);
            settings.setVisibility(View.GONE);

            return true;
        }
        else
            return false;


    }

    @Override
    public void onDateSelected(Calendar dayCalendar, @Nullable List<CalendarEvent> events) {
    }
    @Override
    public void onDateSelected_day(Calendar dayCalendar, int eventsOfDay, int month, int day, List<CalendarEvent> events)
    {
        loading.setVisibility(View.VISIBLE);
        recyclerview1.setVisibility(View.GONE);
        secondLayout.setVisibility(View.GONE);
        RatingLayout.setVisibility(View.GONE);
        Viewed.setVisibility(View.GONE);
       String selected = day + "-"+ (month+1)+"-"+eventsOfDay;
       ApiClient(selected);

    }
    @Override
    public void onMonthChanged(Calendar monthCalendar) {
        monthname.setText(mFormatter.format(monthCalendar));
    }
    @Override
    public List<? extends CalendarEvent> onLoadEvents(int year, int month) {
        return events;
    }

    public Date date_to_calender_(String date_)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(date_);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return myDate;
    }

    public void getfamilymember(){
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<FamilyDatum>> Service = apiInterface.familylist();
        Service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                List<FamilyDatum> familyData = response.body();
                List<FamilyDatum> childs =  new ArrayList<>();
                try {
                    if (familyData !=null && familyData.size()>0) {

                        for (FamilyDatum child : familyData) {
                            if (child.getType().equals("parent")) {
                            }
                            else if(child.getType().equals("child")) {
                                childs.add(child);
                            }
                        }

                        if(childs.size()>1) {
                            childLayout.setVisibility(View.VISIBLE);
                            viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                            multiChildAdapter = new MultiChildAdapter(getActivity(),childs);
                            viewRecylerMultipleChild.setAdapter(multiChildAdapter);
                        }
                        else {
                            settings.setVisibility(View.VISIBLE);
                            FamilyDatum child = childs.get(0);
                            String schemeId = "";
                            String serviceId = "";
                            if(child.getServices().size()>0) {

                                if(child.getServices().get(0).getSchemeId()!=null)
                                    schemeId = child.getServices().get(0).getSchemeId().toString();

                                if(child.getServices().get(0).getServiceId()!=null)
                                    serviceId = child.getServices().get(0).getServiceId().toString();
                                selectedServiceName = child.getServices().get(0).getGroupName();

                            }

                            if(child.getServices().size()>1) {
                                multiserviceview.setVisibility(View.VISIBLE);
                                multiserviceText.setText(child.getServices().get(0).getGroupName());
                                List<com.feedAustralia.android.pojo.Family.Service> services= child.getServices();
                                multiServiceRecyclerView.setAdapter(new MultiServiceAdapter(getActivity(),services));
                            }
                            else {
                                multiserviceview.setVisibility(View.GONE);
                            }
                            childLayout.setVisibility(View.GONE);
                            backButton.setVisibility(View.GONE);
                            selectedChild = child.getId().toString();
                            selectedScheme  =schemeId;
                            selectedService = serviceId;
                            getMenuSet();
                        }

                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "An Error has been occured!", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                Toast.makeText(getActivity(), "An Error has been occured!", Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);

            }
        });
    }


    public void setWeekRange(String startDate,String endDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        Date endDat = null;
        try {
            myDate = dateFormat.parse(startDate);
            endDat = dateFormat.parse(endDate);
            SimpleDateFormat newFormat = new SimpleDateFormat("MMM dd");
            SimpleDateFormat newFormatYear = new SimpleDateFormat("yyyy");
            monthname.setText(newFormat.format(myDate)+" - "+newFormat.format(endDat)+" " +newFormatYear.format(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void getMenuSet(){
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;

        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MenuSet>> service = apiInterface.menuset(childId,schemeId,serviceId,auth_token);
        service.enqueue(new Callback<List<MenuSet>>() {
            @Override
            public void onResponse(Call<List<MenuSet>> call, Response<List<MenuSet>> response) {
                List<MenuSet> menuSetList = response.body();
                try{
                    if (menuSetList != null && menuSetList.size()>0){

                        HeaderCalnder.setVisibility(View.VISIBLE);
                        settings.setVisibility(View.VISIBLE);
                        MenuSet menuSet = menuSetList.get(0);
                        menuSetId  = menuSet.getId().toString();
                        Date current = calendar.getTime();
                        currentYear = calendar.get(Calendar.YEAR);
                        currentMonth = calendar.get(Calendar.MONTH)+1;
                        selectedYear = currentYear;

                        if(weekvalue==0) {
                            ApiMonth(new Date());
                            monthname.setText(mFormatter.format(calendar));
                        }
                        else
                            Api(selectedDate);
                    }else{

                        HeaderCalnder.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                        settings.setVisibility(View.GONE);
                        errornodata.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);
                        scrollView.setVisibility(View.GONE);



                        if(weekvalue==0)
                        {
                            nodatamonthtext.setVisibility(View.GONE);
                            HeaderCalnder.setVisibility(View.GONE);
                            recyclerview1.setVisibility(View.GONE);
                            secondLayout.setVisibility(View.GONE);
                            RatingLayout.setVisibility(View.GONE);
                            Viewed.setVisibility(View.GONE);
                            layoutCalander.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.GONE);
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "MenuSet failed", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }

            }
            @Override
            public void onFailure(Call<List<MenuSet>> call, Throwable t) {
                Log.d("unSuccess", "onFailure: "+t);
                loading.setVisibility(View.GONE);


            }
        });
    }
    public void Api(String selected){
        loading.setVisibility(View.VISIBLE);
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        ApiInterface apiClent = ApiInterface.retrofit.create(ApiInterface.class);
        selectedDate = selected;

        Call<List<MenuData>> Service = apiClent.menulist(childId,schemeId,serviceId,menuSetId,
                selectedDate,"week","true",auth_token);
        Service.enqueue(new Callback<List<MenuData>>() {
            @Override
            public void onResponse(Call<List<MenuData>> call, Response<List<MenuData>> response) {
                List <MenuData>  myRetroClas = response.body();
                try{
                    if (myRetroClas !=null){
                        List<com.feedAustralia.android.pojo.Menu.Meal> meals = new ArrayList<>();
                        for(MenuData mealData : myRetroClas) {
                            List<com.feedAustralia.android.pojo.Menu.MealsDatum> mealsDatum =  mealData.getMealsData();
                            for (int i = 0; i <mealsDatum.size() ; i++) {
                                com.feedAustralia.android.pojo.Menu.MealsDatum meal_group =   mealsDatum.get(i);
                                List<com.feedAustralia.android.pojo.Menu.Meal> meal = meal_group.getMeals();
                                for(com.feedAustralia.android.pojo.Menu.Meal mea : meal) {
                                    String meal_time =  meal_group.getMealsTime().getName();
                                    mea.setMealTime(meal_time);
                                    meals.add(mea);
                                }
                            }
                        }
                        if(meals.size()>0) {
                            startDate = myRetroClas.get(0).getDate();
                            endDate = myRetroClas.get(myRetroClas.size()-1).getDate();
                            setWeekRange(startDate,endDate);
                            scrollView.setVisibility(View.VISIBLE);
                            weekAdapter = new WeekAdapter(getActivity(), myRetroClas);
                            recyclerView.setAdapter(weekAdapter);
                            recyclerView.setVisibility(View.VISIBLE);
                            HeaderCalnder.setVisibility(View.VISIBLE);
                            ApiClient(selectedDate);
                        }
                        else {
                            startDate = myRetroClas.get(0).getDate();
                            endDate = myRetroClas.get(myRetroClas.size()-1).getDate();
                            setWeekRange(startDate,endDate);
                            HeaderCalnder.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.GONE);
                            scrollView.setVisibility(View.GONE);
                            errornodata.setText(selectedServiceName +" has not published a menu for this week.");
                            errornodata.setVisibility(View.VISIBLE);
                            loading.setVisibility(View.GONE);
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "An error has been occured! Please try again.", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);

                    }


                }catch (Exception e){
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }
            }
            @Override
            public void onFailure(Call<List<MenuData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failure"+t, Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);

            }
        });
    }
    public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.ViewHolder>{
        Activity activity;
        int  row_index = -1;
        List<MenuData> RetroClas;
        public WeekAdapter(FragmentActivity activity, List<MenuData> myRetroClas) {
            this.activity=activity;
            this.RetroClas =  myRetroClas;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.week_item,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {


            if(position == RetroClas.size()-1)
                holder.sepertor1.setVisibility(View.VISIBLE);


           if(position==0)
           {
               holder.seperator.setVisibility(View.GONE);
           }
           else
               holder.seperator.setVisibility(View.VISIBLE);

            holder.DateText.setText(ConvertTime(RetroClas.get(position).getDate()));
            holder.DayText.setText(RetroClas.get(position).getWeekday());
            List<com.feedAustralia.android.pojo.Menu.MealsDatum> meals = RetroClas.get(position).getMealsData();

            Collections.sort(
                    meals,
                    (player1, player2) -> player1.getMealsTime().getPosition()
                            - player2.getMealsTime().getPosition());


            String mealstr = "";
            for (int i = 0; i <meals.size() ; i++) {
                com.feedAustralia.android.pojo.Menu.MealsDatum meal_group =   meals.get(i);

                List<com.feedAustralia.android.pojo.Menu.Meal> meal = meal_group.getMeals();
                for(int j=0; j<meal.size(); j++)
                {
                    com.feedAustralia.android.pojo.Menu.Meal mea = meal.get(j);
                    if(mealstr.equals("") || j==0)
                        mealstr = mealstr +""+ mea.getName();
                    else
                        mealstr = mealstr + ", "+ mea.getName();
                }
                if(meal.size()>0 && i!= meals.size()-1)
                mealstr  = mealstr +"\n";
            }
            float spc = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6,getResources().getDisplayMetrics());
            holder.FoodItemOne.setLineSpacing(spc, 1.2f);
            holder.FoodItemOne.setText(mealstr);
            holder.groupLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loading.setVisibility(View.VISIBLE);
                    row_index=position;
                    weekClicked = 1;
                    notifyDataSetChanged();
                    selectedDate = RetroClas.get(position).getDate();
                    ApiClient(selectedDate);
                    recyclerview1.setVisibility(View.GONE);
                    secondLayout.setVisibility(View.GONE);
                    RatingLayout.setVisibility(View.GONE);
                    Viewed.setVisibility(View.GONE);

                }
            });
            if(selectedDate.equals(RetroClas.get(position).getDate())) {
                holder.groupLayout.setBackgroundColor(Color.parseColor("#0a90ce0b"));
            }
            else {
                holder.groupLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
        private String convertTime(String GetDate) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format1 = new SimpleDateFormat("MMM, dd, yyyy");
            java.util.Date date = null;
            try {
                date = format.parse(GetDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String convertedDate = format1.format(date);
            return convertedDate;
        }
        private String ConvertTime(String updateDate) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format1 = new SimpleDateFormat("d");
            java.util.Date date = null;
            try {
                date = format.parse(updateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String convertedDate = format1.format(date);
            return convertedDate;
        }
        @Override
        public int getItemCount() {
            return RetroClas.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            LinearLayout groupLayout;
            TextView DateText, DayText, FoodItemOne;
            View seperator,sepertor1;
            public ViewHolder(View itemView) {
                super(itemView);
                groupLayout = itemView.findViewById(R.id.groupLayout);
                DateText = itemView.findViewById(R.id.DateText);
                DayText = itemView.findViewById(R.id.DayText);
                FoodItemOne = itemView.findViewById(R.id.FoodItemOne);
                seperator = itemView.findViewById(R.id.View);
                sepertor1 = itemView.findViewById(R.id.View2);


            }
        }
    }

    public static void scrollToView(final NestedScrollView scrollView, final View view) {
        // View needs a focus
        view.requestFocus();
        // Determine if scroll needs to happen
        final Rect scrollBounds = new Rect();
        scrollView.getHitRect(scrollBounds);
        if (!view.getLocalVisibleRect(scrollBounds)) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    scrollView.smoothScrollTo(0, view.getTop());
                }
            });
        }
    }
    public void ApiMonth(final Date current){
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;

//        Date current = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        selectedDate = format.format(current);

        ApiInterface apiClent = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MenuData>> Service = apiClent.menulist(childId,schemeId,serviceId,menuSetId,
                selectedDate,"month","true",auth_token);
        Service.enqueue(new Callback<List<MenuData>>() {
            @Override
            public void onResponse(Call<List<MenuData>> call, Response<List<MenuData>> response) {
                List <MenuData>  myRetroClas = response.body();
                try{
                    events.clear();
                    if (myRetroClas != null){
                        for (int i = 0; i <myRetroClas.size() ; i++) {
                            try{
                                int menuPresent = 0;
                                List<com.feedAustralia.android.pojo.Menu.MealsDatum> mealData = myRetroClas.get(i).getMealsData();
                                for(com.feedAustralia.android.pojo.Menu.MealsDatum mea : mealData) {
                                    for(com.feedAustralia.android.pojo.Menu.Meal meal:mea.getMeals()) {
                                        menuPresent++;
                                    }
                                }
                                if(menuPresent>0) {
                                    String menu_date  = myRetroClas.get(i).getDate();
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    Date dateMenu = format.parse(menu_date);

                                    SimpleDateFormat format1 = new SimpleDateFormat("dd");
                                    Calendar cal = Calendar.getInstance();
                                    String day = format1.format(dateMenu);
                                    cal.add(Calendar.DAY_OF_MONTH,Integer.valueOf(day));
                                    MyEvent event = new MyEvent("Example event","hello its detail", dateMenu.getTime(),getResources().getColor(R.color.sick_green));
                                    events.add(event);
                                }
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                            Calendar selectedCalendar = Calendar.getInstance();
                            selectedCalendar.setTime(current);
                            calendarView.invalidate();
                            calendarView = view.findViewById(R.id.calendarView);
                            calendarView.setMinimumDate(current.getTime());
                            calendarView.selectedCalendar  = selectedCalendar;
                            calendarView.mMonthPager = new MonthPager(2,selectedCalendar);
                            calendarView.dispatchOnMonthChanged(selectedCalendar);
                        HeaderCalnder.setVisibility(View.VISIBLE);
                        calendarView.setVisibility(View.VISIBLE);

                        calendarView.updateEvents();
                        calendarView.setOnLoadEventsListener(loadEventsListener);
                        layoutCalander.setVisibility(View.VISIBLE);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        ApiClient(format.format(current));
                    }
                    else{
                        HeaderCalnder.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                        errornodata.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }
            }
            @Override
            public void onFailure(Call<List<MenuData>> call, Throwable t) {
                Log.d("Failed", "onFailure: "+t);
                loading.setVisibility(View.GONE);

            }
        });
     }
    class StringDateComparator implements Comparator<String>
    {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        public int compare(String lhs, String rhs)
        {
            try {
                return dateFormat.parse(lhs).compareTo(dateFormat.parse(rhs));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
    private String convertTime(String setDAte) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("MMM, dd, yyyy");
        java.util.Date date = null;
        try {
            date = format.parse(setDAte);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convertedDate = format1.format(date);
        return convertedDate;
    }

    public  void applyRating(int rating)
    {
        if (rating ==1){
            ratingBar.setRating(rating);
        }
        else if (rating ==2){
            ratingBar.setRating(rating);
        }
        else if (rating ==3){
            ratingBar.setRating(rating);
        }
        else if (rating ==4){
            ratingBar.setRating(rating);
        }
        else if (rating ==5){
            ratingBar.setRating(rating);
        }
    }

    public  void ApiClient(String selected){
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MealsDataList>> Service = apiInterface.menulistone(childId,schemeId,serviceId,menuSetId,
                selected,"day","true","true","true","true","true","true","true","true","true",auth_token);
        Service.enqueue(new Callback<List<MealsDataList>>() {
            @Override
            public void onResponse(Call<List<MealsDataList>> call, Response<List<MealsDataList>> response) {
                List <MealsDataList>  myRetroClas = response.body();
                try{
                    if (myRetroClas != null && myRetroClas.size()>0){
                        // Set Selected Date in Recylcer View
                        //Set Data Day Wise
                        MealsDataList menuData = myRetroClas.get(0);
                        List<MealsDatum> mealsDatum =  menuData.getMealsData();
                        Collections.sort(
                                mealsDatum,
                                (player1, player2) -> player1.getMealsTime().getPosition()
                                        - player2.getMealsTime().getPosition());

                        List<Meal> meals = new ArrayList<>();
                        for (int i = 0; i <mealsDatum.size() ; i++) {
                            MealsDatum meal_group =   mealsDatum.get(i);
                            List<Meal> meal = meal_group.getMeals();
                            for(Meal mea : meal)
                            {
                                String meal_time =  meal_group.getMealsTime().getName();
                                mea.setMealTime(meal_time);
                                meals.add(mea);
                            }
                        }

                        if(meals.size()<=0)
                        {
                            loading.setVisibility(View.GONE);

                            if(weekvalue==0)
                            {
                                nodatamonthtext.setText(selectedServiceName +" has not published a menu for selected date.");
                                nodatamonthtext.setVisibility(View.VISIBLE);
                                recyclerview1.setVisibility(View.GONE);
                                calendarView.setVisibility(View.VISIBLE);
                                mainLayout.setVisibility(View.VISIBLE);
                                layoutCalander.setVisibility(View.VISIBLE);
                                Viewed.setVisibility(View.VISIBLE);
                                secondLayout.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                                RatingLayout.setVisibility(View.GONE);

                            }
                            else if(weekvalue==1)
                            {
                                recyclerview1.setVisibility(View.GONE);
//                                scrollView.setVisibility(View.GONE);
                                RatingLayout.setVisibility(View.GONE);
                                secondLayout.setVisibility(View.GONE);


                            }
                        }
                        else {

                            errornodata.setVisibility(View.GONE);
                            nodatamonthtext.setVisibility(View.GONE);
                            SetDAte = myRetroClas.get(0).getDate();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            try {
                                Date selected = format.parse(SetDAte);
                                SimpleDateFormat newformat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
                                PacifDate.setText(newformat.format(selected));
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            // Apply Rating
                            int rating   = myRetroClas.get(0).getNutritionalRating();
                            applyRating(rating);

                            menusAdapter = new MenusAdapter(getActivity(),meals);
                            recyclerview1.setAdapter(menusAdapter);

                            if(weekvalue==1 && weekClicked==1) {
                                scrollToView(scrollView, RatingLayout);
                                weekClicked = 0;
                            }
                            menusAdapter.notifyDataSetChanged();
                            //Set Day Wise Groups Data
                            List<Group__> daygroups = menuData.getGroups();
                            for (int i = 0; i <daygroups.size() ; i++) {
                                Group__ meal_group = daygroups.get(i);
                                try{
                                    if(meal_group.getCode().equals("meat") && meal_group.getIsActive())
                                    {
                                        meatquantity.setText(String.valueOf(new Double(meal_group.getAmount())));
                                    }
                                    else if(meal_group.getCode().equals("dairy") && meal_group.getIsActive() )
                                    {
                                        Dairyquantity.setText(String.valueOf(new Double(meal_group.getAmount())));

                                    }
                                    else if(meal_group.getCode().equals("cereal") && meal_group.getIsActive())
                                    {
                                        Breadquantity.setText(String.valueOf(new Double(meal_group.getAmount())));

                                    }
                                    else if(meal_group.getCode().equals("fruit") && meal_group.getIsActive())
                                    {
                                        Fruitquantity.setText(String.valueOf(new Double(meal_group.getAmount())));
                                    }
                                    else if(meal_group.getCode().equals("vegetables") && meal_group.getIsActive())
                                    {
                                        Vegetablesquantity.setText(String.valueOf(new Double(meal_group.getAmount())));
                                    }
                                }catch (Exception e){

                                }
                            }
                            //Set Allergies Count
                            List<Object> allergies =  menuData.getChildrenWithAllergies();
                            if(allergies !=null)
                            {
                                allergyquantity.setText(String.valueOf(allergies.size()));
                            }
                            else {
                                allergyquantity.setText("0");
                                allergyquantity.setTextColor(Color.GREEN);
                            }

                            //Set Nutrition Values in Menu
                            Nutrition_ nutrition = menuData.getNutrition();
                            if (nutrition != null){
                                energyPerChild.setText(String.format("%.1f kJ", nutrition.getEnergy()));
                                proteinPerChild.setText(String.format("%.1f g", nutrition.getProtein()));
                                fatTotalPerChild.setText(String.format("%.1f g", nutrition.getFatTotal()));
                                carbohydrateTotalPerChild.setText(String.format("%.1f g", nutrition.getAvailableCarbohydrate()));
                                carbohydrateSugarPerChild.setText(String.format("%.1f g", nutrition.getTotalSugars()));
                                sodiumPerChild.setText(String.format("%.1f mg", nutrition.getSodium()));
                                energy100g.setText(String.format("%.1f kJ", nutrition.getEnergy100g()));
                                protein100g.setText(String.format("%.1f g", nutrition.getProtein100g()));
                                fat100g.setText(String.format("%.1f g", nutrition.getFatTotal100g()));
                                carbohydrate100g.setText(String.format("%.1f g", nutrition.getAvailableCarbohydrate100g()));
                                carbohydrateSugar100g.setText(String.format("%.1f g", nutrition.getTotalSugars100g()));
                                sodium100g.setText(String.format("%.1f mg", nutrition.getSodium100g()));
                            }

                            loading.setVisibility(View.GONE);
                            mainLayout.setVisibility(View.VISIBLE);
                            recyclerview1.setVisibility(View.VISIBLE);
                            scrollView.setVisibility(View.VISIBLE);

                            if(layoutCalander.getVisibility() == View.VISIBLE)
                                recyclerView.setVisibility(View.GONE);
                            else
                                recyclerView.setVisibility(View.VISIBLE);

                            HeaderCalnder.setVisibility(View.VISIBLE);
                            secondLayout.setVisibility(View.VISIBLE);
                            RatingLayout.setVisibility(View.VISIBLE);
                            Viewed.setVisibility(View.VISIBLE);
                            allergyLayout.setVisibility(View.GONE);
                        }

                    }
                    else{
                        Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);

                    }

                }catch (Exception e){
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }

            }
            @Override
            public void onFailure(Call<List<MealsDataList>> call, Throwable t) {
                Log.d("Failure", "onFailure: "+t);
                loading.setVisibility(View.GONE);

            }
        });
    }


    public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.ViewHolder>{
        Activity activity;
        List<Meal> myRetroClas;
        public MenusAdapter(FragmentActivity activity, List<Meal> myRetroClas) {
            this.activity=activity;
            this.myRetroClas=myRetroClas;
        }
        @NonNull
        @Override
        public MenusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.menu_item,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final MenusAdapter.ViewHolder holder, final int position) {
            holder.MenuName.setText(myRetroClas.get(position).getMealTime());
            holder.menuItemName.setText(myRetroClas.get(position).getName());
            Glide.with(activity)
                    .load(myRetroClas.get(position).getImageUrl()).apply(RequestOptions.placeholderOf(R.drawable.mealplaceholder)).into(holder.roundedImageView);
            List<Group> group = myRetroClas.get(position).getGroups();
            for (int i = 0; i < group.size(); i++) {
                Group meal_group = group.get(i);
                if(meal_group.getCode().equals("meat") && meal_group.getIsActive())
                {
                    holder.Meat.setText(meal_group.getName());
                    MeatStr = String.valueOf(new Double(meal_group.getAmount()));
                    holder.MeatValue.setText(MeatStr+" "+"serves");
                    holder.Forth.setVisibility(View.VISIBLE);
                }
                else if(meal_group.getCode().equals("dairy") && meal_group.getIsActive() )
                {
                    holder.Dairy.setText(meal_group.getName());
                    DairyStr = String.valueOf(new Double(meal_group.getAmount()));
                    holder.DairyValue.setText(DairyStr+" "+"serves");
                    holder.Second.setVisibility(View.VISIBLE);
                }
                else if(meal_group.getCode().equals("cereal") && meal_group.getIsActive())
                {
                    holder.Bread.setText(meal_group.getName());
                    BreadStr = String.valueOf(new Double(meal_group.getAmount()));
                    holder.BreadValue.setText(BreadStr+" "+"serves");
                    holder.Third.setVisibility(View.VISIBLE);
                }
                else if(meal_group.getCode().equals("fruit") && meal_group.getIsActive())
                {
                    holder.Fruit.setText(meal_group.getName());
                    FruitStr = String.valueOf(new Double(meal_group.getAmount()));
                    holder.FruitValue.setText(FruitStr+" "+"serves");
                    holder.First.setVisibility(View.VISIBLE);
                }
                else if(meal_group.getCode().equals("vegetables") && meal_group.getIsActive())
                {
                    holder.Vegetables.setText(meal_group.getName());
                    VegetablesStr = String.valueOf(new Double(meal_group.getAmount()));
                    holder.VegetablesValue.setText(VegetablesStr+" "+"serves");
                    holder.Fifth.setVisibility(View.VISIBLE);
                }
            }
            holder.ParseData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, MenuDescription.class);
                    intent.putExtra("meal",myRetroClas.get(position));
                    startActivity(intent);
                }
            });
        }
        @Override
        public int getItemCount() {
            return myRetroClas.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView MenuName,menuItemName,Fruit,FruitValue,Dairy,DairyValue,Bread,BreadValue,Meat,MeatValue,Vegetables,VegetablesValue;
            RelativeLayout ParseData;
            ImageView roundedImageView;
            RelativeLayout First,Second,Third,Forth,Fifth;
            public ViewHolder(View itemView) {
                super(itemView);
                MenuName = itemView.findViewById(R.id.MenuName);
                ParseData = itemView.findViewById(R.id.ParseData);
                roundedImageView = itemView.findViewById(R.id.roundedImageView);
                menuItemName = itemView.findViewById(R.id.menuItemName);
                Fruit = itemView.findViewById(R.id.Fruit);
                FruitValue = itemView.findViewById(R.id.FruitValue);
                Fruit = itemView.findViewById(R.id.Fruit);
                FruitValue = itemView.findViewById(R.id.FruitValue);
                Dairy = itemView.findViewById(R.id.Dairy);
                DairyValue = itemView.findViewById(R.id.DairyValue);
                Bread = itemView.findViewById(R.id.Bread);
                BreadValue = itemView.findViewById(R.id.BreadValue);
                Meat = itemView.findViewById(R.id.Meat);
                MeatValue = itemView.findViewById(R.id.MeatValue);
                Vegetables = itemView.findViewById(R.id.Vegetables);
                VegetablesValue = itemView.findViewById(R.id.VegetablesValue);
                First =  itemView.findViewById(R.id.First);
                Second =  itemView.findViewById(R.id.Second);
                Third =  itemView.findViewById(R.id.Third);
                Forth =  itemView.findViewById(R.id.Forth);
                Fifth =  itemView.findViewById(R.id.Fifth);
            }
        }
    }

    public PopupWindow initiatePopupWindow(){
        try {
            mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = mInflater.inflate(R.layout.popup_layout, null);
            final LinearLayout Week = layout.findViewById(R.id.Week);
            final LinearLayout Month = layout.findViewById(R.id.Month);
            Checkedone = layout.findViewById(R.id.Checkedone);
            Checkedtwo = layout.findViewById(R.id.Checkedtwo);
            final RelativeLayout HideLayout = layout.findViewById(R.id.HideLayout);
            final RelativeLayout popuplayout = layout.findViewById(R.id.popuplayout);
            final RelativeLayout dropdown = layout.findViewById(R.id.dropdown);

            layout.measure(View.MeasureSpec.UNSPECIFIED,
                    View.MeasureSpec.UNSPECIFIED);
            mDropdown = new PopupWindow(layout, FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT, true);
            mDropdown.showAsDropDown(settings, 0, 5);
            mDropdown.setFocusable(false);
            mDropdown.setTouchable(true);
            mDropdown.setBackgroundDrawable(new BitmapDrawable());
            popuplayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDropdown.dismiss();
                    mDropdown = null;
                }
            });
            dropdown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDropdown.dismiss();
                    mDropdown = null;
                }
            });
            if(weekvalue == 1)
            {
                Checkedone.setVisibility(View.VISIBLE);
                Checkedtwo.setVisibility(View.INVISIBLE);
            }
            else {
                Checkedtwo.setVisibility(View.VISIBLE);
                Checkedone.setVisibility(View.INVISIBLE);
            }
            Week.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    errornodata.setVisibility(View.GONE);
                    nodatamonthtext.setVisibility(View.GONE);
                    mDropdown.dismiss();
                    weekvalue  = 1;
                    GetView.setText("Week's Menu");
                    loading.setVisibility(View.VISIBLE);
                    HideLayout.setVisibility(View.GONE);
                    popuplayout.setVisibility(View.GONE);
                    HeaderCalnder.setVisibility(View.GONE);
                    recyclerview1.setVisibility(View.GONE);
                    secondLayout.setVisibility(View.GONE);
                    RatingLayout.setVisibility(View.GONE);
                    Viewed.setVisibility(View.GONE);
                    layoutCalander.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);

                    Api(selectedDate);
                    scrollView.smoothScrollTo(0,0);
                    }
            });
            Month.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    errornodata.setVisibility(View.GONE);
                    nodatamonthtext.setVisibility(View.GONE);

                    GetView.setText("Month Menu");
                    //Set Current Month and Yeat
                    Date current = calendar.getTime();
                    currentYear = calendar.get(Calendar.YEAR);
                    currentMonth = calendar.get(Calendar.MONTH)+1;
                    selectedYear = currentYear;
                    monthname.setText(mFormatter.format(calendar));
                    calendarView.setOnMonthChangedListener(monthChangedListener);
                    calendarView.setOnDateSelectedListener(dateSelectedListener);
                    weekvalue  = 0;
                    mDropdown.dismiss();
                    HeaderCalnder.setVisibility(View.GONE);
                    HideLayout.setVisibility(View.GONE);
                    popuplayout.setVisibility(View.GONE);
                    loading.setVisibility(View.VISIBLE);
                    recyclerview1.setVisibility(View.GONE);
                    secondLayout.setVisibility(View.GONE);
                    RatingLayout.setVisibility(View.GONE);
                    Viewed.setVisibility(View.GONE);
                    loading.setVisibility(View.VISIBLE);
                    layoutCalander.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    scrollView.smoothScrollTo(0,0);
                    ApiMonth(new Date());

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDropdown;
    }

    public void changeMonth(int month)
    {
        try{
            //Show Loader
            loading.setVisibility(View.VISIBLE);
            //View Invisible while loading
            scrollView.setNestedScrollingEnabled(true);
            scrollView.setEnabled(true);
            monthView.setVisibility(View.GONE);
            recyclerview1.setVisibility(View.GONE);
            secondLayout.setVisibility(View.GONE);
            RatingLayout.setVisibility(View.GONE);
            Viewed.setVisibility(View.GONE);
            layoutCalander.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            scrollView.smoothScrollTo(0,0);


            //Update Month in calendar View
            currentMonth = month;
            currentYear = selectedYear;
            String selected = currentYear + "-"+currentMonth+"-1";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date selectedDate = formatter.parse(selected);
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.setTime(selectedDate);
            monthname.setText(mFormatter.format(selectedCalendar));
            //Call Api for selected month
            ApiMonth(selectedDate);


        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void showMonthCalendar(){
        try {

            final String[] monthnames = {"January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"};
            selectedYear = currentYear;
            calendarView.setVisibility(View.INVISIBLE);
            scrollView.setNestedScrollingEnabled(false);
            scrollView.setEnabled(false);

            monthView.invalidate();
            monthView  =  view.findViewById(R.id.support_layout);
            RelativeLayout monthview =  monthView.findViewById(R.id.monthview);
            RelativeLayout monthincludedview = monthview.findViewById(R.id.monthcalendar);

            View includeView = (View)monthview.findViewById(R.id.monthcalendar);
            final TextView month = (TextView) monthview.findViewById(R.id.textmonth);
            month.setText(monthnames[currentMonth-1] + " "+selectedYear);

            monthView.setVisibility(View.VISIBLE);
            final Button jan  =  includeView.findViewById(R.id.btnjan);
            final Button feb  =  includeView.findViewById(R.id.btnfeb);
            final Button mar  =  includeView.findViewById(R.id.btnmar);
            final Button apr  =  includeView.findViewById(R.id.btnapr);
            final Button may  =  includeView.findViewById(R.id.btnmay);
            final Button june =  includeView.findViewById(R.id.btnjun);
            final Button jul  =  includeView.findViewById(R.id.btnjul);
            final Button aug  =  includeView.findViewById(R.id.btnaug);
            final Button sept =  includeView.findViewById(R.id.btnsept);
            final Button oct  =  includeView.findViewById(R.id.btnoct);
            final Button nov  =  includeView.findViewById(R.id.btnnov);
            final Button dec  =  includeView.findViewById(R.id.btndec);


            jan.setBackgroundColor(getResources().getColor(R.color.white));
            feb.setBackgroundColor(getResources().getColor(R.color.white));
            mar.setBackgroundColor(getResources().getColor(R.color.white));
            apr.setBackgroundColor(getResources().getColor(R.color.white));
            may.setBackgroundColor(getResources().getColor(R.color.white));
            june.setBackgroundColor(getResources().getColor(R.color.white));
            jul.setBackgroundColor(getResources().getColor(R.color.white));
            aug.setBackgroundColor(getResources().getColor(R.color.white));
            sept.setBackgroundColor(getResources().getColor(R.color.white));
            oct.setBackgroundColor(getResources().getColor(R.color.white));
            nov.setBackgroundColor(getResources().getColor(R.color.white));
            dec.setBackgroundColor(getResources().getColor(R.color.white));

            switch (currentMonth)
            {
                case 1:
                    jan.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 2:
                    feb.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 3:
                    mar.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 4:
                    apr.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 5:
                    may.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 6:
                    june.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 7:
                    jul.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 8:
                    aug.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 9:
                    sept.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 10:
                    oct.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 11:
                    nov.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;
                case 12:
                    dec.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    break;

            }
            jan.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    jan.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(1);
                }
            });
            feb.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    feb.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(2);

                }
            });
            mar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    mar.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(3);

                }
            });
            apr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    apr.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(4);

                }
            });
            may.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    may.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(5);

                }
            });
            june.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    june.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(6);

                }
            });
            jul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    jul.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(7);

                }
            });
            aug.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    aug.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(8);

                }
            });
            sept.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    sept.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(9);

                }
            });
            oct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    oct.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(10);

                }
            });
            nov.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    nov.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(11);

                }
            });
            dec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //code whatever you want to do here
                    dec.setBackgroundColor(getResources().getColor(R.color.month_selection));
                    changeMonth(12);

                }
            });

            monthview.findViewById(R.id.monthforward).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("2","2");
                    selectedYear = selectedYear+1;
                    month.setText(monthnames[currentMonth-1] + " "+(selectedYear));
                }

            });
            monthview.findViewById(R.id.monthbackward).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("2","2");
                    selectedYear = selectedYear-1;
                    month.setText(monthnames[currentMonth-1] + " "+selectedYear);
                }

            });
            monthincludedview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.e("2","2");
                    calendarView.setVisibility(View.VISIBLE);
                    scrollView.setNestedScrollingEnabled(true);
                    scrollView.setEnabled(true);
                    monthView.setVisibility(View.GONE);

                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MultiChildAdapter extends RecyclerView.Adapter<MultiChildAdapter.ViewHolder> {
        Activity activity;
        List<FamilyDatum> child;
        public MultiChildAdapter(Activity activit,List<FamilyDatum> child) {
            this.activity=activity;
            this.child = child;

        }
        @NonNull
        @Override
        public MultiChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.child_itemscount,parent,false);

            return new MultiChildAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull MultiChildAdapter.ViewHolder holder, final int position) {

            holder.textChild.setText(child.get(position).getName());

            holder.layoutChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    settings.setVisibility(View.VISIBLE);

                    loading.setVisibility(View.VISIBLE);
                    errornodata.setVisibility(View.GONE);
                    String schemeId = "";
                    String serviceId = "";
                    if(child.get(position).getServices().size()>0) {
                        if(child.get(position).getServices().get(0).getSchemeId()!=null)
                            schemeId = child.get(position).getServices().get(0).getSchemeId().toString();

                        if(child.get(position).getServices().get(0).getServiceId()!=null)
                            serviceId = child.get(position).getServices().get(0).getServiceId().toString();

                        selectedServiceName = child.get(position).getServices().get(0).getGroupName();
                    }

                    if(child.get(position).getServices().size()>1) {
                        multiserviceview.setVisibility(View.VISIBLE);
                        multiserviceText.setText(child.get(position).getServices().get(0).getGroupName());
                        List<com.feedAustralia.android.pojo.Family.Service> services= child.get(position).getServices();
                        multiServiceRecyclerView.setAdapter(new MultiServiceAdapter(getActivity(),services));

                    }
                    else
                    {
                        multiserviceview.setVisibility(View.GONE);
                    }

                    selectedChild = child.get(position).getId().toString();
                    selectedScheme = schemeId;
                    selectedService = serviceId;
                    getMenuSet();
                    childLayout.setVisibility(View.GONE);
                    backButton.setVisibility(View.VISIBLE);
                }
            });
        }
        @Override
        public int getItemCount() {
            return child.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView textChild;
            ImageView imageChild;
            RelativeLayout layoutChild;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textChild = itemView.findViewById(R.id.textChild);
                imageChild = itemView.findViewById(R.id.imageChild);
                layoutChild = itemView.findViewById(R.id.layoutChild);

            }
        }
    }


    public class MultiServiceAdapter extends RecyclerView.Adapter<MultiServiceAdapter.ViewHolder> {
        Activity activity;
        List<com.feedAustralia.android.pojo.Family.Service> services;
        public MultiServiceAdapter(Activity activit,List<com.feedAustralia.android.pojo.Family.Service> services) {
            this.activity=activity;
            this.services = services;

        }
        @NonNull
        @Override
        public MultiServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.multiservicelayout,parent,false);

            return new MultiServiceAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull MultiServiceAdapter.ViewHolder holder, final int position) {

            holder.textService.setText(services.get(position).getGroupName());
            holder.layoutService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loading.setVisibility(View.VISIBLE);
                    errornodata.setVisibility(View.GONE);
                    String serviceId  = "";
                    String schemeId = "";
                    if(services.get(position).getServiceId()!=null)
                    serviceId = services.get(position).getServiceId().toString();

                    if(services.get(position).getSchemeId()!=null)
                        schemeId = services.get(position).getSchemeId().toString();

                    selectedServiceName= services.get(position).getGroupName();
                    multiserviceText.setText(selectedServiceName);

                    selectedScheme = schemeId;
                    selectedService = serviceId;
                    multiservicelayout.setVisibility(View.GONE);
                   getMenuSet();

                }
            });
        }
        @Override
        public int getItemCount() {
            return services.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView textService;
            RelativeLayout layoutService;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textService = itemView.findViewById(R.id.textService);
                layoutService = itemView.findViewById(R.id.layoutService);

            }
        }
    }

}
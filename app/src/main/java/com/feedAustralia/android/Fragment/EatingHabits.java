package com.feedAustralia.android.Fragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.feedAustralia.android.Activity.SessionManager;
import com.feedAustralia.android.AdpatersPagers.EatingAdapter;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.feedAustralia.android.pojo.habit.EatingHabit;
import com.feedAustralia.android.pojo.habit.FilterEatingHabit;
import com.feedAustralia.android.pojo.habit.MenuEatingHabit;
import com.feedAustralia.android.pojo.habit.MenuMealTime;
import com.feedAustralia.android.pojo.habit.MenuSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 04-02-2019.
 */

public class EatingHabits extends Fragment implements View.OnClickListener{
    RecyclerView recyclerview;
    RelativeLayout serveView;
    EatingAdapter eatingAdapter;
    GifTextView loading;
    View view=null;
    Calendar calendar;
    CalendarView calendarView;
    ImageView CalenderOpen;
    TextView errornodata;
    LayoutInflater mInflater;
    private PopupWindow mDropdown = null;
    public static EatingHabits newInstance() {
        return new EatingHabits();
    }
    RelativeLayout childLayout;
    RecyclerView viewRecylerMultipleChild;
    LinearLayoutManager layoutManager,layoutManagerchild,layoutManagerService;

    RecyclerView multiServiceRecyclerView;
    RelativeLayout multiserviceview,multiservicelayout;
    TextView multiserviceText;
    String selectedChild,selectedService,selectedScheme,selectedServiceName;
    ImageView backButton,logofA;


    MultiChildAdapter multiChildAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.eating_habits, container, false);
        loading = view.findViewById(R.id.loading);
        errornodata = view.findViewById(R.id.errortexthabit);
        recyclerview = view.findViewById(R.id.recyclerview);
        serveView = view.findViewById(R.id.serveView);
//        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
//        calendar.set(Calendar.DAY_OF_MONTH, 9);
//        calendar.set(Calendar.YEAR, 2012);
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        calendar.add(Calendar.YEAR, 1);
//        calendarView = view.findViewById(R.id.calendarView);
//        CalenderOpen.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        childLayout = view.findViewById(R.id.childLayout);
        viewRecylerMultipleChild = view.findViewById(R.id.viewRecylerMultipleChild);
        layoutManagerchild = new  LinearLayoutManager(getActivity());
        viewRecylerMultipleChild.setLayoutManager(layoutManagerchild);


        // Multi Services

        // Multi Services View
        multiServiceRecyclerView = view.findViewById(R.id.multiServiceRecyclerView);
        layoutManagerService = new LinearLayoutManager(getActivity());
        multiServiceRecyclerView.setLayoutManager(layoutManagerService);


        multiserviceview = view.findViewById(R.id.multiserviceview);
        multiserviceText = view.findViewById(R.id.serviceName);
        multiservicelayout = view.findViewById(R.id.multiservicelayout);
        multiserviceview.setVisibility(View.GONE);

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
        serveView.setVisibility(View.GONE);



        backButton = view.findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                childLayout.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.GONE);
                errornodata.setVisibility(View.GONE);

            }
        });

        logofA = view.findViewById(R.id.Logo);

        logofA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                childLayout.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.GONE);
                errornodata.setVisibility(View.GONE);


            }
        });


        return view;
    }

    public boolean onBackPressed() {

        if(backButton.getVisibility() == View.VISIBLE)
        {
            viewRecylerMultipleChild.setVisibility(View.VISIBLE);
            childLayout.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.GONE);
            errornodata.setVisibility(View.GONE);
            return true;
        }
        else
            return false;


    }

    public void getfamilymember(){
        loading.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<FamilyDatum>> Service = apiInterface.familylist();
        Service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                List<FamilyDatum> familyData = response.body();
                List<FamilyDatum> childs =  new ArrayList<>();
                try {
                    loading.setVisibility(View.GONE);

                    if (familyData !=null && familyData.size()>0) {

                        for (FamilyDatum child : familyData) {
                            if (child.getType().equals("parent")) {
                            }
                            else if(child.getType().equals("child")) {
                                childs.add(child);
                            }
                        }

                        if(childs.size()>1)
                        {
                            childLayout.setVisibility(View.VISIBLE);
                            viewRecylerMultipleChild.setVisibility(View.VISIBLE);
                            multiChildAdapter = new EatingHabits.MultiChildAdapter(getActivity(),childs);
                            viewRecylerMultipleChild.setAdapter(multiChildAdapter);


                        }
                        else {



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
                                multiServiceRecyclerView.setAdapter(new EatingHabits.MultiServiceAdapter(getActivity(),services));
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
                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                Toast.makeText(getActivity(), "An Error has been occured!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void getMenuSet(){
        loading.setVisibility(View.VISIBLE);
        String auth_token =SessionManager.getAuth_token(getActivity());

        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;

        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;

//        String childId = SessionManager.child(getActivity());
//        String schemeId = SessionManager.Schemeid(getActivity());
//        String serviceId = SessionManager.serviceId(getActivity());

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MenuSet>> service = apiInterface.menuset(childId,schemeId,serviceId,auth_token);
        service.enqueue(new Callback<List<MenuSet>>() {
            @Override
            public void onResponse(Call<List<MenuSet>> call, Response<List<MenuSet>> response) {
                List<MenuSet> menuSetList = response.body();
                try{
                    if (menuSetList != null && menuSetList.size()>0){
                        MenuSet menuSet = menuSetList.get(0);
                        String menuSetId  = menuSet.getId().toString();
                        getMealTime(menuSetId);
                    }else{
                        serveView.setVisibility(View.GONE);
                        recyclerview.setVisibility(View.GONE);
                        errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                        errornodata.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);




                    }
                }catch (Exception e){
                    serveView.setVisibility(View.GONE);
                    errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                    errornodata.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<MenuSet>> call, Throwable t) {
                Log.d("unSuccess", "onFailure: "+t);
                serveView.setVisibility(View.GONE);
                errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                errornodata.setVisibility(View.VISIBLE);
                loading.setVisibility(View.GONE);
            }
        });
    }

    public void getMealTime(final String menuSetId){
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;




        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MenuMealTime>> Service = apiInterface.menumealtime(childId,schemeId,serviceId,menuSetId,auth_token);
        Service.enqueue(new Callback<List<MenuMealTime>>() {
            @Override
            public void onResponse(Call<List<MenuMealTime>> call, Response<List<MenuMealTime>> response) {
                List<MenuMealTime> menuMealTimes = response.body();
                try{
                    if (menuMealTimes != null && menuMealTimes.size()>0){
                        getEatingHabit(menuSetId);
                    }else{

                        serveView.setVisibility(View.GONE);
                        recyclerview.setVisibility(View.GONE);

                        errornodata.setVisibility(View.VISIBLE);
                        errornodata.setText("Eating habits data not available for current week.");
                        loading.setVisibility(View.GONE);

//                        Toast.makeText(getActivity(), "Meal Null Data", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){

                    errornodata.setVisibility(View.VISIBLE);
                    errornodata.setText("Eating habits data not available for current week.");
                    loading.setVisibility(View.GONE);

//                    Toast.makeText(getActivity(), "MealTime Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<MenuMealTime>> call, Throwable t) {
                Log.d("unSuccess", "onFailure: "+t);
                loading.setVisibility(View.GONE);

            }
        });
    }


    public void getEatingHabit(String menuSetId){
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = selectedChild;
        String serviceId = selectedService;
        String schemeId = selectedScheme;
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        Date current = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDate = format.format(current);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MenuEatingHabit>> Service = apiInterface.menumealhabit(childId,schemeId,serviceId,menuSetId,selectedDate,auth_token);
        Service.enqueue(new Callback<List<MenuEatingHabit>>() {
            @Override
            public void onResponse(Call<List<MenuEatingHabit>> call, Response<List<MenuEatingHabit>> response) {
                List<MenuEatingHabit> eatingHabitList = response.body();
                try{
                    if (eatingHabitList !=null && eatingHabitList.size()>0){

                        List<EatingHabit> eatingHabits = eatingHabitList.get(0).getEatingHabits();
                        ArrayList<String> list = new ArrayList<>();
                        for(EatingHabit habit:eatingHabits)
                        {
                            list.add(habit.getEffectiveDate());
                        }
                        ArrayList<String> myList = new ArrayList<>();
                        for (String aString: list)
                        {
                            if (!myList.contains( aString ))
                            {
                                myList.add(aString);
                            }
                        }
                        final ArrayList<FilterEatingHabit> data = new ArrayList<>();

                        for(final String date :myList)
                        {
                            FilterEatingHabit habit = new FilterEatingHabit();
                            habit.setEatingDate(date);
                            habit.setRoomId(0);
                            List<EatingHabit> result = new ArrayList<EatingHabit>();
                            for (EatingHabit habits : eatingHabits) {
                                if (habits.getEffectiveDate().equals(date)) {
                                    result.add(habits);
                                }
                            }
                            Collections.sort(
                                    result,
                                    (player1, player2) -> player1.getMealsTime().getPosition()
                                            - player2.getMealsTime().getPosition());

                            habit.setEatingHabits(result);
                            data.add(habit);
                        }
                        serveView.setVisibility(View.VISIBLE);
                        eatingAdapter = new EatingAdapter(getActivity(),data);
                        recyclerview.setVisibility(View.VISIBLE);
                        recyclerview.setAdapter(eatingAdapter);
                        loading.setVisibility(View.GONE);
                    }
                    else{
//                        loading.setVisibility(View.GONE);
//                        errornodata.setVisibility(View.VISIBLE);

                        errornodata.setVisibility(View.VISIBLE);
                        errornodata.setText("Eating habits data not available for current week.");
                        loading.setVisibility(View.GONE);
                        recyclerview.setVisibility(View.GONE);
                        serveView.setVisibility(View.GONE);



//                        Toast.makeText(getActivity(), "Habits null Data", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){

                    loading.setVisibility(View.GONE);
                    errornodata.setVisibility(View.VISIBLE);
                    errornodata.setText("Eating habits data not available for current week.");
                    recyclerview.setVisibility(View.GONE);
                    serveView.setVisibility(View.GONE);

//                    Toast.makeText(getActivity(), "Habits Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<MenuEatingHabit>> call, Throwable t) {
                Log.d("unSuccess", "onFailure: "+t);
                loading.setVisibility(View.GONE);

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. CalenderOpen:
                CalnderShow();
                break;
        }
    }


    private PopupWindow CalnderShow() {
        try {
            mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = mInflater.inflate(R.layout.calnder_layout, null);
            final CalendarView calendarView = layout.findViewById(R.id.calendarView);
            layout.measure(View.MeasureSpec.UNSPECIFIED,
                    View.MeasureSpec.UNSPECIFIED);
            mDropdown = new PopupWindow(layout, FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT,true);
            mDropdown.showAsDropDown(CalenderOpen, 5, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDropdown;
    }


    public class MultiChildAdapter extends RecyclerView.Adapter<EatingHabits.MultiChildAdapter.ViewHolder> {
        Activity activity;
        List<FamilyDatum> child;
        public MultiChildAdapter(Activity activit,List<FamilyDatum> child) {
            this.activity=activity;
            this.child = child;

        }
        @NonNull
        @Override
        public EatingHabits.MultiChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.child_itemscount,parent,false);

            return new EatingHabits.MultiChildAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull EatingHabits.MultiChildAdapter.ViewHolder holder, final int position) {

            holder.textChild.setText(child.get(position).getName());

            holder.layoutChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                        multiServiceRecyclerView.setAdapter(new EatingHabits.MultiServiceAdapter(getActivity(),services));

                    }
                    else
                    {
                        multiserviceview.setVisibility(View.GONE);
                    }


                    recyclerview.setVisibility(View.GONE);
                    serveView.setVisibility(View.GONE);

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


    public class MultiServiceAdapter extends RecyclerView.Adapter<EatingHabits.MultiServiceAdapter.ViewHolder> {
        Activity activity;
        List<com.feedAustralia.android.pojo.Family.Service> services;
        public MultiServiceAdapter(Activity activit,List<com.feedAustralia.android.pojo.Family.Service> services) {
            this.activity=activity;
            this.services = services;

        }
        @NonNull
        @Override
        public EatingHabits.MultiServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.multiservicelayout,parent,false);

            return new EatingHabits.MultiServiceAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull EatingHabits.MultiServiceAdapter.ViewHolder holder, final int position) {

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

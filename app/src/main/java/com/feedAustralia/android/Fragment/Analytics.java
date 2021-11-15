package com.feedAustralia.android.Fragment;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.feedAustralia.android.Activity.SessionManager;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Menu.Group;
import com.feedAustralia.android.pojo.Menu.Meal;
import com.feedAustralia.android.pojo.Menu.MealsDatum;
import com.feedAustralia.android.pojo.Menu.MenuData;
import com.feedAustralia.android.pojo.habit.MenuSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 04-02-2019.
 */

public class Analytics extends Fragment {
    View view=null;
    public static Analytics newInstance() {
        return new Analytics();
    }
    private static String TAG = "Analytics";
    private float[] yData;
    private String[] xData = {"veg_color","meat_color" ,"dairy_color","vegetable_color", "Fruit"};
    PieChart pieChart;
    ScrollView scrollView;
    TextView textmenu,textDate,textVeg,textMeat,textDairy,textVegetables,textFruit,nodataerror;
    CircleImageView imageVeg,imageMeat,imageDairy,imageVegetables,imageFruit;
    GifTextView loading;
    RelativeLayout childLayout;
    RecyclerView viewRecylerMultipleChild;
    LinearLayoutManager layoutManagerchild,layoutManagerService;
    MultiChildAdapter multiChildAdapter;
    TextView errornodata;

    RecyclerView multiServiceRecyclerView;
    RelativeLayout multiserviceview,multiservicelayout;
    TextView multiserviceText;
    String selectedChild,selectedService,selectedScheme,selectedServiceName;
    ImageView backButton,logofA;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_analytics, container, false);
        loading = view.findViewById(R.id.loading);
        nodataerror = view.findViewById(R.id.nodataerror);
        pieChart = view.findViewById(R.id.idPieChart);
        textmenu = view.findViewById(R.id.textmenu);
        errornodata = view.findViewById(R.id.errortexthabit);
        textDate = view.findViewById(R.id.textDate);
        imageVeg = view.findViewById(R.id.imageVeg);
        imageMeat = view.findViewById(R.id.imageMeat);
        imageDairy = view.findViewById(R.id.imageDairy);
        imageVegetables = view.findViewById(R.id.imageVegetables);
        imageFruit = view.findViewById(R.id.imageFruit);
        textVeg = view.findViewById(R.id.textVeg);
        textMeat = view.findViewById(R.id.textMeat);
        textDairy = view.findViewById(R.id.textDairy);
        textVegetables = view.findViewById(R.id.textVegetables);
        textFruit = view.findViewById(R.id.textFruit);
        scrollView = view.findViewById(R.id.ScrollView);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setDescriptionColor(Color.parseColor("#ffffff"));
        pieChart.setVisibility(View.INVISIBLE);
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
            }
            @Override
            public void onNothingSelected() {
            }
        });
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
        scrollView.setVisibility(View.GONE);
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<FamilyDatum>> Service = apiInterface.familylist();
        Service.enqueue(new Callback<List<FamilyDatum>>() {
            @Override
            public void onResponse(Call<List<FamilyDatum>> call, Response<List<FamilyDatum>> response) {
                List<FamilyDatum> familyData = response.body();
                List<FamilyDatum> childs =  new ArrayList<>();
                loading.setVisibility(View.GONE);

                try {
                    if (familyData !=null && familyData.size()>0) {
                        nodataerror.setVisibility(View.GONE);


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
                            multiChildAdapter = new Analytics.MultiChildAdapter(getActivity(),childs);
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
                                multiServiceRecyclerView.setAdapter(new Analytics.MultiServiceAdapter(getActivity(),services));
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

                    loading.setVisibility(View.GONE);
                    nodataerror.setVisibility(View.VISIBLE);


//                    Toast.makeText(getActivity(), "An Error has been occured!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<FamilyDatum>> call, Throwable t) {
                loading.setVisibility(View.GONE);
                nodataerror.setVisibility(View.VISIBLE);
            }
        });
    }


    public class MultiChildAdapter extends RecyclerView.Adapter<Analytics.MultiChildAdapter.ViewHolder> {
        Activity activity;
        List<FamilyDatum> child;
        public MultiChildAdapter(Activity activit,List<FamilyDatum> child) {
            this.activity=activity;
            this.child = child;

        }
        @NonNull
        @Override
        public Analytics.MultiChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.child_itemscount,parent,false);

            return new Analytics.MultiChildAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull Analytics.MultiChildAdapter.ViewHolder holder, final int position) {

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
                        multiServiceRecyclerView.setAdapter(new Analytics.MultiServiceAdapter(getActivity(),services));

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


    public class MultiServiceAdapter extends RecyclerView.Adapter<Analytics.MultiServiceAdapter.ViewHolder> {
        Activity activity;
        List<com.feedAustralia.android.pojo.Family.Service> services;
        public MultiServiceAdapter(Activity activit,List<com.feedAustralia.android.pojo.Family.Service> services) {
            this.activity=activity;
            this.services = services;

        }
        @NonNull
        @Override
        public Analytics.MultiServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.multiservicelayout,parent,false);

            return new Analytics.MultiServiceAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull Analytics.MultiServiceAdapter.ViewHolder holder, final int position) {

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


    public void getMenuSet(){
        scrollView.setVisibility(View.INVISIBLE);
        loading.setVisibility(View.VISIBLE);
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
                        MenuSet menuSet = menuSetList.get(0);
                        String menuSetId  = menuSet.getId().toString();
                        getanalytics(menuSetId);
                    }else{

                        errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                        errornodata.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);


                    }
                }catch (Exception e){
                    errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                    errornodata.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);                }
            }
            @Override
            public void onFailure(Call<List<MenuSet>> call, Throwable t) {
                errornodata.setText("Your service is not currently using the feedAustralia program. Your service can visit http://feedAustralia.org.au to sign up and start using it today");
                errornodata.setVisibility(View.VISIBLE);
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
            textDate.setText(newFormat.format(myDate)+" - "+newFormat.format(endDat)+" " +newFormatYear.format(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void getanalytics(String menuSetId) {
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
        Call<List<MenuData>> Service = apiInterface.analyticsdata(childId,schemeId,serviceId,selectedDate,"week",
                "true",menuSetId,"true",auth_token);
        Service.enqueue(new Callback<List<MenuData>>() {
            @Override
            public void onResponse(Call<List<MenuData>> call, Response<List<MenuData>> response) {
                List<MenuData> analyticsData = response.body();
                try{
                    if (analyticsData !=null && analyticsData.size()>0){
                        nodataerror.setVisibility(View.GONE);
                        List<com.feedAustralia.android.pojo.Menu.Meal> meals = new ArrayList<>();
                        for(MenuData mealData : analyticsData) {
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

                            nodataerror.setVisibility(View.GONE);
                            String startDate = analyticsData.get(0).getDate();
                            String endDate = analyticsData.get(analyticsData.size()-1).getDate();
                            setWeekRange(startDate,endDate);

                            int veg = 0;
                            int fruit = 0;
                            int cereal = 0;
                            int meat = 0;
                            int dairy = 0;

                            for (int i = 0; i <analyticsData.size() ; i++) {
                                try {
                                    List<MealsDatum> mealData = analyticsData.get(i).getMealsData();
                                    for(MealsDatum mea : mealData) {
                                        for(Meal meal:mea.getMeals()) {
                                            List<Group> group =  meal.getGroups();
                                            for(Group gr:group)
                                            {
                                                if(gr.getIsActive())
                                                {
                                                    if(gr.getCode().equals("meat"))
                                                    {
                                                        meat++;
                                                    }
                                                    else if(gr.getCode().equals("dairy"))
                                                    {
                                                        dairy++;
                                                    }
                                                    else if(gr.getCode().equals("cereal"))
                                                    {
                                                        cereal++;
                                                    }
                                                    else if(gr.getCode().equals("fruit"))
                                                    {
                                                        fruit++;
                                                    }
                                                    else if(gr.getCode().equals("vegetables"))
                                                    {
                                                        veg++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }

                            }
                            ArrayList<Float> data = new ArrayList<>();
                            int total = veg+dairy+meat+cereal+fruit;
                            Float vege = (float)veg/total*100;
                            Float meats = (float)meat/total*100;
                            Float fruits = (float)fruit/total*100;
                            Float cereals = (float)cereal/total*100;
                            Float dairys = (float)dairy/total*100;


                            data.add((float)(Math.round(meats+0.3)));
                            data.add((float)(Math.round(fruits+0.3)));
                            data.add((float)(Math.round(dairys+0.3)));
                            data.add((float)(Math.round(cereals+0.3)));
                            data.add((float)(Math.round(vege+0.3)));

                            addDataSet(data);


                            textDairy.setText("Dairy Foods "+Math.round(dairys+0.3)+"%");
                            textVegetables.setText("Vegetables "+Math.round(vege+0.3)+"%");
                            textVeg.setText("Breads, Cereals, Rice and Pasta "+Math.round(cereals+0.3)+"%");
                            textMeat.setText("Meat and alternatives "+Math.round(meats+0.3)+"%");
                            textFruit.setText("Fruits "+Math.round(fruits+0.3)+"%");


                            pieChart.setVisibility(View.VISIBLE);
                            scrollView.setVisibility(View.VISIBLE);
                            loading.setVisibility(View.GONE);


                        }
                        else {

                            loading.setVisibility(View.GONE);
                            nodataerror.setVisibility(View.VISIBLE);

                        }






                    }else{
//                        Toast.makeText(getActivity(), "Analytics Null", Toast.LENGTH_SHORT).show();

                        loading.setVisibility(View.GONE);
                        nodataerror.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
//                    Toast.makeText(getActivity(), "Analytics Crash", Toast.LENGTH_SHORT).show();


                    loading.setVisibility(View.GONE);
                    nodataerror.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void onFailure(Call<List<MenuData>> call, Throwable t) {
                Log.d("", "onFailure: "+t);
                loading.setVisibility(View.GONE);
                nodataerror.setVisibility(View.VISIBLE);
            }
        });
    }

    private void addDataSet(ArrayList<Float> data) {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < data.size(); i++){
            yEntrys.add(new PieEntry(data.get(i) , i));
        }

        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "%");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextColor(Color.parseColor("#ffffff"));
//        pieDataSet.setValueLineColor(Color.parseColor("#ffffff"));
        pieDataSet.setValueTextSize(12);
        ArrayList<Integer> colors = new ArrayList<>();


        colors.add(Color.parseColor("#0073b6"));//meat_color
        colors.add(Color.parseColor("#8cbd50")); // fruit_Color
        colors.add(Color.parseColor("#75298c")); //dairy_color
        colors.add(Color.parseColor("#fa9b3d")); //cereal_color
        colors.add(Color.parseColor("#009c4c")); // vegetable_color


        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                if(value<5)
                    return " "+((int) value) +"" ;
                    else
                return ((int) value) + "%" ;
            }
        };
        pieDataSet.setValueFormatter(formatter);

        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    public class MutliChildAdapter extends RecyclerView.Adapter<MutliChildAdapter.ViewHolder>{
        Activity activity;
        public MutliChildAdapter(Activity activity) {
            this.activity= activity;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.child_itemscount,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.layoutChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    childLayout.setVisibility(View.GONE);
                }
            });
        }
        @Override
        public int getItemCount() {
            return 5;
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
}

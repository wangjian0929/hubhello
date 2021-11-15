//<<<<<<< HEAD:app/src/main/java/com/feedAustralia/android/pojo/ApiInterface.java
package com.feedAustralia.android.pojo;
import com.feedAustralia.android.pojo.mealpkg.MealGroup;
import com.feedAustralia.android.pojo.Family.FamilyDatum;
import com.feedAustralia.android.pojo.Meal.MealTime;
import com.feedAustralia.android.pojo.Menu.MenuData;
import com.feedAustralia.android.pojo.MenuOne.MealsDataList;
import com.feedAustralia.android.pojo.Privacy.PrivacyData;
import com.feedAustralia.android.pojo.Terms.TermsData;
import com.feedAustralia.android.pojo.habit.MenuEatingHabit;
import com.feedAustralia.android.pojo.habit.MenuMealTime;
import com.feedAustralia.android.pojo.habit.MenuSet;
import com.feedAustralia.android.pojo.profilePakage.health.ChildHealth;
import com.feedAustralia.android.pojo.profilePakage.identity.ProfilePicture;
import com.feedAustralia.android.pojo.recipe.RecipeDatum;
import com.feedAustralia.android.pojo.profilePakage.parent.ParentIdentity;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by asd on 30-01-2019.
 */


public interface ApiInterface {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


    CookieHandler cookieHandler = new CookieManager();
    OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor)
            .cookieJar(new JavaNetCookieJar(cookieHandler))
            .connectTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .build();


    //https://hubhello.com/hubhello/api/
    //https://staging.hubhello.com/hubhello/api/
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://hubhello.com/hubhello/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
    @FormUrlEncoded
    @POST("session")
    Call<LoginData> login(@Field("login") String email,
                          @Field("password") String password,
                          @Header("X-Is-Request-Token") String trueData

    );

    @FormUrlEncoded
    @POST("session")
    Call<LoginData> updateTOU(@Field("login") String email,
                          @Field("password") String password,
                              @Field("accepted_legal") String type,
                              @Field("program") String program,
                              @Header("X-Is-Request-Token") String trueData

    );


    @GET("family/members")
    Call<List<FamilyDatum>> familylist();

    @FormUrlEncoded
    @POST("users/passwords")
    Call<RequestBody> forgetData(@Field("username") String username);

    @FormUrlEncoded
    @POST("legals/document")
    Call<PrivacyData> privacy(@Field("program") String program,
                              @Field("legal_type") String legal_type);
    @FormUrlEncoded
    @POST("legals/document")
    Call<TermsData> terms(@Field("program") String program,
                          @Field("legal_type") String legal_type);

    @GET("menu/menus")
    Call<List<MenuData>> menulist(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("menu_set_id") String menu_set_id,
            @Query("date") String  date,
            @Query("mode") String  mode,
//            @Query("with_meals_groups") String  with_meals_groups,
//            @Query("with_meals_times_groups") String  with_meals_times_groups,
//            @Query("with_menus_groups") String  with_menus_groups,
            @Query("meals_times_from_8_hours_period_only") String hours_period,
            @Query("auth_token") String  auth_token);


    @GET("menu/menus")
    Call<List<MealsDataList>> menulistone(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("menu_set_id") String menu_set_id,
            @Query("date") String  date,
            @Query("mode") String  mode,
            @Query("with_meals_groups") String  with_meals_groups,
            @Query("with_meals_times_groups") String  with_meals_times_groups,
            @Query("with_menus_groups") String  with_menus_groups,
            @Query("with_menus_nutrition") String  with_menus_nutrition,
            @Query("with_menus_children_allergies") String  with_menus_children_allergies,
            @Query("with_meals_ingredients_data") String  with_meals_ingredients_data,
            @Query("with_meals_nutrition") String  with_meals_nutrition,
            @Query("fetch_total_menus") String  fetch_total_menus,
            @Query("meals_times_from_8_hours_period_only") String hours_period,
            @Query("auth_token") String  auth_token);

    @GET("menu/menu_ideas")
    Call<List<RecipeDatum>> recipelist(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("ideas_meals_time_id") Integer ideas_meals_time_id,
            @Query("auth_token") String  auth_token);


    @GET("menu/menu_ideas")
    Call<List<RecipeDatum>> recipelistCustomMeals(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("only_custom_meals") String custom_meals,
            @Query("auth_token") String  auth_token);


    @GET("menu/ideas_meals_times")
    Call<List<MealTime>> timelist(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("auth_token") String  auth_token);

    @GET("menu/meals_groups")
    Call<List<MealGroup>> mealgroup(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("auth_token") String  auth_token);

    @GET("menu/menu_sets")
    Call<List<MenuSet>> menuset(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("auth_token") String  auth_token);


    @GET("menu/meals_times")
    Call<List<MenuMealTime>> menumealtime(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("menu_set_id") String menu_set_id,
            @Query("auth_token") String  auth_token);

    @GET("menu/eating_habits")
    Call<List<MenuEatingHabit>> menumealhabit(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("menu_set_id") String menu_set_id,
            @Query("date") String date,
            @Query("auth_token") String  auth_token);

    @GET("menu/menus")
    Call<List<MenuData>> analyticsdata(
            @Query("hh_child_id") String hh_child_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("date") String date,
            @Query("mode") String  mode,
            @Query("with_meals_groups") String  with_meals_groups,
            @Query("menu_set_id") String menu_set_id,
            @Query("meals_times_from_8_hours_period_only") String meals_times_from_8_hours_period_only,
            @Query("auth_token") String  auth_token);




    // family Api Parents
    @GET("profile/{type}/{user_id}") //parent
    Call<ParentIdentity> getParentidentity(
            @Path("type") String type,
            @Path("user_id") String user_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("with_grouped_response") String with_grouped_response,
            @Query("auth_token") String  auth_token,
            @Query("hh_parent_id") String  hh_parent_id,
            @Query("hh_child_id") String  hh_child_id,
            @Query("section") String section); //1


    @GET("profile/{type}/{user_id}") //parent
    Call<ChildHealth> getChildHealth(
            @Path("type") String type,
            @Path("user_id") String user_id,
            @Query("scheme_id") String scheme_id,
            @Query("service_id") String service_id,
            @Query("with_grouped_response") String with_grouped_response,
            @Query("auth_token") String  auth_token,
            @Query("hh_parent_id") String  hh_parent_id,
            @Query("hh_child_id") String  hh_child_id,
            @Query("section") String section); //1


    @PUT("profile/{type}/{user_id}") //parent
    Call<ProfilePicture> updateProfile(
            @Path("type") String type,
            @Path("user_id") String user_id,
            @Body RequestBody body
          ); //1

    @PUT("profile/{type}/{user_id}") //parent
    Call<ProfilePicture> updateProfileData(
            @Path("type") String type,
            @Path("user_id") String user_id,
            @Body RequestBody body
    ); //1







//    // family Api Parents
//    @GET("profile/users/{user_id}") //parent //{user_id}  parameters scheme_id/service_id/with_grouped_response =true/auth_token/section =1;
//    Call<IdentityData> getidentityParent(
//            @Path(value = "user_id", encoded = true) String userId,
//            @Query("scheme_id") String scheme_id,
//            @Query("with_grouped_response") String with_grouped_response,
//            @Query("auth_token") String  auth_token,
//            @Query("hh_parent_id") String  hh_parent_id,
//            @Query("section") String section); //1

//    // family Api child
//    @GET("profile/children/parent") //child
//    Call<IdentityData> getidentityChild(
//          @Query("scheme_id") String scheme_id,
//           @Query("with_grouped_response") String with_grouped_response,
//           @Query("auth_token") String  auth_token,
//           @Query("hh_child_id") String hh_child_id,
//           @Query("section") String section);

    //HealthData Api Parents (Working Api)
//    @GET("profile/users/")
//    Call<HealthData> gethealth(
//            @Query("scheme_id") String scheme_id,
//            @Query("with_grouped_response") String with_grouped_response,
//            @Query("auth_token") String  auth_token,
//            @Query("hh_parent_id") String  hh_parent_id,
//            @Query("section") String section); //3

//    //HealthData Api Child
//    @GET("profile/children/parent") //child
//    Call<HealthData> gethealthChild(
//            @Query("scheme_id") String scheme_id,
//            @Query("with_grouped_response") String with_grouped_response,
//            @Query("auth_token") String  auth_token,
//            @Query("hh_child_id") String hh_child_id,
//            @Query("section") String section);
}




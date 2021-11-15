package com.feedAustralia.android.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asd on 14-02-2019.
 */

public class SessionManager  {
    public static  String auth_token="auth_token";
    public static  String login="login_";
    public static void shared(Context context, String auth_token, String type, String id, String scheme_id,String service_id,String user_avtar,String user_name,String service_name,String gender){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("auth_token", auth_token);
        editor.putString("type", type);
        editor.putString("id",id);
        editor.putString("scheme_id",scheme_id);
        editor.putString("service_id",service_id);
        editor.putString("user_avtar",user_avtar);
        editor.putString("user_name",user_name);
        editor.putString("service_name",service_name);
        editor.putString("gender",gender);

        editor.apply();
    }

    public static void update(Context context, String user_avtar){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("user_avtar",user_avtar);
        editor.apply();
    }

    public static String getServiceName(Context context)
    {
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("service_name","12");


    }

    public static String getAuth_token(Context context)
    {
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("auth_token","11");


    }
    public static String child (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("id","2");
    }

    public static String Schemeid (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("scheme_id","3");
    }

    public static String serviceId (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("service_id","5");
    }

    public static String userAvtar (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("user_avtar","6");
    }

    public static String user_name (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("user_name","7");
    }


    public static String gender (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("gender","7");
    }


    public static String Typed (Context context){
        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
        return pref.getString("type","4");
    }



//    public static void logout(Context context)
//    {
//        SharedPreferences pref=context.getSharedPreferences(login, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=pref.edit();
//        editor.clear().apply();
//    }
}

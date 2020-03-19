package com.example.hangin.utilities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferencesManger {

    private static SharedPreferences sharedPreferences = null;

    public static String USER_DATA = "USER_DATA";
    public static String USER_PASSWORD = "USER_PASSWORD";


    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences("Blood", activity.MODE_PRIVATE);
        }
    }

    public static void saveString(Activity activity, String data_Key, String data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

   public static void getString (Activity activity, String data_key,String DataValue){

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(activity);
        String myValue= sharedPreferences.getString(USER_DATA,"Not_Found");
        Log.v("myValue",myValue);

    }




}

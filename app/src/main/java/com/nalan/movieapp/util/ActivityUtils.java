package com.nalan.movieapp.util;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityUtils {


    public static void setRecyclerHorizontalLayoutManager(RecyclerView recyclerView,Activity activity){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearVertical =
                new LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearVertical);
    }
    public static void setRecyclerVerticalLayoutManager(RecyclerView recyclerView,Activity activity){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearVertical =
                new LinearLayoutManager(activity,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearVertical);
    }
    public static void setRecyclerGridLayoutManager(RecyclerView recyclerView,Activity activity){
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public static boolean checkInternetConnection(Activity context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Activity.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package com.example.android_components.FileDownloadComponent.VolleyImageLoadComponent;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class BitmapController extends Application {

    static BitmapController instanse;
    RequestQueue requestQueue;
    ImageLoader imageLoader;

    private static Context mContext;

    public BitmapController(){}

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getmContext(){
        return mContext;
    }

    public synchronized static BitmapController getInstance(){
        if(instanse == null){
            instanse = new BitmapController();
        }
        return instanse;
    }

    //request queue, image cache
    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(mContext);
        }
        return requestQueue;
    }

    public ImageLoader getimageLoader(){
        if(imageLoader == null){
            imageLoader = new ImageLoader(getRequestQueue(),new BitmapLRUCache());
        }
        return imageLoader;
    }
}

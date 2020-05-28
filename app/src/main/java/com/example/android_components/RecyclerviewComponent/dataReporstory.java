package com.example.android_components.RecyclerviewComponent;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android_components.OperationListerenComponent.Operation;
import com.example.android_components.OperationListerenComponent.OperationListerener;
import com.example.android_components.OperationListerenComponent.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class dataReporstory implements Operation {

    static dataReporstory dr;
    RequestQueue mRequestQueue;
    OperationListerener opl;

    private dataReporstory(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized dataReporstory getInstence(Context context){
        if(dr == null){
            dr = new dataReporstory(context);
            return dr;
        }
        return dr;
    }

    @Override
    public dataReporstory setOperationListerner(OperationListerener opl) {
        this.opl = opl;
        return this;
    }

    public void parseJson(){
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            List<RecyclerViewItem> recyclerViewItems = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String imageUrl = hit.getString("webformatURL");
                                String creatorName = hit.getString("user");
                                int like = hit.getInt("likes");

                                recyclerViewItems.add(new RecyclerViewItem(imageUrl,creatorName,like));
                            }

                            opl.onSuccess(new Result.Success<>(recyclerViewItems));
                        }catch (JSONException e){
                            e.printStackTrace();
                            opl.onError(new Result.Error(e));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                opl.onError(new Result.Error(error));
            }
        });

        mRequestQueue.add(request);
    }

}

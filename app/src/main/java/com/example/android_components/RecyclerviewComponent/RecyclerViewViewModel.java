package com.example.android_components.RecyclerviewComponent;

import android.content.Context;

import com.example.android_components.OperationListerenComponent.OperationListerener;
import com.example.android_components.OperationListerenComponent.Result;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RecyclerViewViewModel implements OperationListerener {

    MutableLiveData<List<RecyclerViewItem>> mutableLiveData = new MutableLiveData();
    Context mContext;

    public RecyclerViewViewModel(Context mContext){
        this.mContext = mContext;
        setMutableLiveData();
    }

    public LiveData<List<RecyclerViewItem>> getData(){
        return mutableLiveData;
    }

    public void setMutableLiveData(){
        dataReporstory.getInstence(mContext).setOperationListerner(this).parseJson();
    }


    @Override
    public void onSuccess(Result result) {
        mutableLiveData.setValue(((Result.Success<List<RecyclerViewItem>>) result).getData());
    }

    @Override
    public void onError(Result result) {

    }
}

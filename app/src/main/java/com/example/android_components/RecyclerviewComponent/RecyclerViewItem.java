package com.example.android_components.RecyclerviewComponent;

public class RecyclerViewItem {
    private String mImageUrl;
    private String mCreator;
    private int mLike;

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public int getmLike() {
        return mLike;
    }

    public void setmLike(int mLike) {
        this.mLike = mLike;
    }

    public RecyclerViewItem(String mImageUrl, String mCreator, int mLike) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLike = mLike;
    }



}

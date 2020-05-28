package com.example.android_components.FileDownloadComponent.VolleyImageLoadComponent;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;

public class BitmapLRUCache extends LruCache<String,Bitmap> implements ImageLoader.ImageCache {

    public static int getDefalutLruCacheSize(){
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory/8;
        return cacheSize;
    }

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public BitmapLRUCache(int maxSize) {
        super(maxSize);
    }

    public BitmapLRUCache(){
        this(getDefalutLruCacheSize());
    }

    @Override
    protected int sizeOf(@NonNull String key, @NonNull Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url,bitmap);
    }
}

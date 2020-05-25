package com.example.android_components;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SetWallPaperComponent extends AppCompatActivity {
    Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);

        try {
            wallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

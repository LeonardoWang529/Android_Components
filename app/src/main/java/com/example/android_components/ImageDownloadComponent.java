package com.example.android_components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDownloadComponent extends AppCompatActivity {

    URL url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new ImageDownloadTask().execute(setUrl("http://api.ins.com"));
    }

    public URL setUrl(String url){
        try{
            this.url = new URL(url);
            return this.url;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    class ImageDownloadTask extends AsyncTask<URL, Void, Bitmap>{


        @Override
        protected Bitmap doInBackground(URL... urls) {
            URL url = urls[0];
            HttpsURLConnection connection = null;

            try {
                connection = (HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                return BitmapFactory.decodeStream(bufferedInputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }
    }
}

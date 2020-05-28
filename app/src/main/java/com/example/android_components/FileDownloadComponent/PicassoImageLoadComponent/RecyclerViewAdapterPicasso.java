package com.example.android_components.FileDownloadComponent.PicassoImageLoadComponent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_components.R;
import com.example.android_components.RecyclerviewComponent.RecyclerViewItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterPicasso extends RecyclerView.Adapter<RecyclerViewAdapterPicasso.ImageViewHolder> {
    List<RecyclerViewItem> objectList = new ArrayList<>();
    Context mContext;
    public RecyclerViewAdapterPicasso(Context context){
        mContext = context;
    }

    public void setObjectList(List<RecyclerViewItem> objectList){
        this.objectList = objectList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.textView.setText(objectList.get(position).getmCreator());
        holder.likes.setText("Likes: " + objectList.get(position).getmLike());

        //https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library
        Picasso.get().load(objectList.get(position).getmImageUrl()).resize(200, 200)
                .centerCrop().into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView likes;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.image_title);
            this.imageView = itemView.findViewById(R.id.image);
            this.likes = itemView.findViewById(R.id.likes);
        }
    }

}

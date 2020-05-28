package com.example.android_components.FileDownloadComponent.VolleyImageLoadComponent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.android_components.R;
import com.example.android_components.RecyclerviewComponent.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterVolley extends RecyclerView.Adapter<RecyclerViewAdapterVolley.ImageViewHolder> {
    List<RecyclerViewItem> list = new ArrayList<>();
    ImageLoader imageLoader;

    public void setObjectList( List<RecyclerViewItem> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_volley, parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getmCreator());
        holder.textView.setText("Likes:" + list.get(position).getmLike());

        if(imageLoader == null){
            //request queue, image cache
            imageLoader = BitmapController.getInstance().getimageLoader();
        }

        holder.imageView.setImageUrl(list.get(position).getmImageUrl(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        NetworkImageView imageView;
        TextView likes;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.image_title);
            this.imageView = itemView.findViewById(R.id.image);
            this.likes = itemView.findViewById(R.id.likes);
        }
    }

}

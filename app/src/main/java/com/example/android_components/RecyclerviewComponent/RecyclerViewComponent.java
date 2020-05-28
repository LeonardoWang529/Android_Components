package com.example.android_components.RecyclerviewComponent;

import android.os.Bundle;

import com.example.android_components.FileDownloadComponent.PicassoImageLoadComponent.RecyclerViewAdapterPicasso;
import com.example.android_components.FileDownloadComponent.VolleyImageLoadComponent.RecyclerViewAdapterVolley;
import com.example.android_components.databinding.ActivityRecycleviewBinding;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewComponent extends AppCompatActivity {

    ActivityRecycleviewBinding binding;
    //RecyclerViewAdapterPicasso adapter;
    RecyclerViewAdapterVolley adapter;
    RecyclerViewViewModel viewViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerView = binding.rcview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adapter = new RecyclerViewAdapterPicasso(this);
        adapter = new RecyclerViewAdapterVolley();

        recyclerView.setAdapter(adapter);

        viewViewModel = new RecyclerViewViewModel(this);

        viewViewModel.mutableLiveData.observe(this, new Observer<List<RecyclerViewItem>>() {
            @Override
            public void onChanged(List<RecyclerViewItem> recyclerViewItems) {
                adapter.setObjectList(recyclerViewItems);
            }
        });

    }
}

package com.example.doanungdungdocbao;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanungdungdocbao.Adapter.BaiVietAdapter;
import com.example.doanungdungdocbao.Model.BaiViet;

public class TimKiemActivity extends AppCompatActivity {
    EditText mTim;
    LoaderManager loaderManager;
    RecyclerView recyclerView;
    BaiVietAdapter mAdapter;
    public void TimKiem(View view) {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiem);
        mTim = findViewById(R.id.edit_timkiem);
    }
}

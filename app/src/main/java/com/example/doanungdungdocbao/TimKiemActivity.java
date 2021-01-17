package com.example.doanungdungdocbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanungdungdocbao.Adapter.BaiVietAdapter;
import com.example.doanungdungdocbao.Model.BaiViet;

public class TimKiemActivity extends AppCompatActivity {
    EditText mTim;
    LoaderManager loaderManager;
    RecyclerView recyclerView;
    BaiVietAdapter mAdapter;
    private ImageButton imgHome;
    private Toolbar mToolbar;
    public void TimKiem(View view) {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiem);
        mTim = findViewById(R.id.edit_timkiem);
        someMethodThatUsesActivity(this);
        mToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    public void someMethodThatUsesActivity(Activity myActivityReference){
        myActivityReference.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

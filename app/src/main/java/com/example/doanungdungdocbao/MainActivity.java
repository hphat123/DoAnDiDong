package com.example.doanungdungdocbao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.doanungdungdocbao.Adapter.BottomNavPagerAdapter;
import com.example.doanungdungdocbao.Data.SaveState;
import com.example.doanungdungdocbao.FragmentView.FragMentFirst;
import com.example.doanungdungdocbao.FragmentView.FragMentSetting;
import com.example.doanungdungdocbao.FragmentView.FragMentThoiSu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  static Boolean mInNightMode=false;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private TextView txt_tile;
    private ImageButton imgBtnSetting;
    private ImageButton imgBtnSearch;
    private ImageButton imgBtnClose;
    SaveState saveState;
    public static Integer tindaxem;
    public static List<Integer> dsTinDaXem = new ArrayList<>();
    public static List<Integer> tinYeuThich = new ArrayList<>();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_trangchu:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_caidat:
                    viewPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveState =new SaveState(this);
        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        final BottomNavigationView navigation = findViewById(R.id.bot_nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        imgBtnClose = findViewById(R.id.img_close);
        imgBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClosePressed();
            }

        });
        NutTimKiem();
    }
        // Xử Lý Nút Thoát
    public void onClosePressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.ic_dialog).setTitle("Thông Báo")
                .setMessage("Bạn Có Muốn Thoát Hay Không?")
                .setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Không", null).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        BottomNavPagerAdapter adapter = new BottomNavPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new FragMentFirst());
        adapter.addFragment(new FragMentThoiSu());
        adapter.addFragment(new FragMentSetting());
        viewPager.setAdapter(adapter);
    }
    public void NutTimKiem(){
        imgBtnSearch = findViewById(R.id.img_search);
        imgBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimKiemActivity.class);
                    startActivity(intent);
            }
        });
    }



}
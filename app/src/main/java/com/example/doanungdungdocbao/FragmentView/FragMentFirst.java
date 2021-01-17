package com.example.doanungdungdocbao.FragmentView;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.doanungdungdocbao.Adapter.TabViewAdapter;
import com.example.doanungdungdocbao.Data.SaveState;
import com.example.doanungdungdocbao.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class FragMentFirst extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mFirstViewPager;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ImageButton mImgHome;
    private ImageButton mImgClose;
    SaveState saveState;

    public FragMentFirst() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saveState = new SaveState(getContext());
        if(saveState.getState()==true)
            ((AppCompatActivity)(getActivity())).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else
            ((AppCompatActivity)(getActivity())).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);


    }

    public void someMethodThatUsesActivity(Activity myActivityReference){
        myActivityReference.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        someMethodThatUsesActivity(getActivity());//ẨN THANH STATUS TRẠNG THÁI
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        mFirstViewPager = (ViewPager) rootView.findViewById(R.id.viewpage_content);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        //Drawer Toolbar
        mDrawerLayout = rootView.findViewById(R.id.drawer_layout);
        // NavLeft hiển thị các item trái
        mNavigationView = rootView.findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                switch (item.getItemId()){
                    case R.id.nav_left_thoisu:
                        mFirstViewPager.setCurrentItem(0);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_thegioi:
                        mFirstViewPager.setCurrentItem(1);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_thethao:
                        mFirstViewPager.setCurrentItem(2);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_congnghe:
                        mFirstViewPager.setCurrentItem(3);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_giaitri:
                        mFirstViewPager.setCurrentItem(4);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_khoahoc:
                        mFirstViewPager.setCurrentItem(5);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_dulich:
                        mFirstViewPager.setCurrentItem(6);
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_left_suckhoe:
                        mFirstViewPager.setCurrentItem(7);
                        mDrawerLayout.closeDrawers();
                        return true;
                }
                // close drawer when item is tapped
                return true;
                //Nếu Item được chạm , đoạn code này sẽ thiết lập lựa chon item và Drawer cũng được đóng bởi hàm closeDrawers().
            }
        });
        View hview = mNavigationView.getHeaderView(0);
        mImgHome = hview.findViewById(R.id.img_home);
       mImgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });
      /*  user_name=hview.findViewById(R.id.user_name);
        user_email=hview.findViewById(R.id.tindaxem);
        dangXuat=hview.findViewById(R.id.dangxuat);
        dangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USER_NAME="";
                USER_EMAIL="";
                dangXuat.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(),"Đăng xuất thành công",Toast.LENGTH_LONG).show();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000); // Set time LENGTH_LONG Toast
                            startActivity(new Intent(getContext(), DangNhap.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });
        if(!USER_NAME.equals("")) {
            Log.d("USERNAME",USER_NAME);
            user_name.setText(USER_NAME);
            user_email.setText(USER_EMAIL);
            dangXuat.setVisibility(View.VISIBLE);

        }*/
        mToolbar = rootView.findViewById(R.id.toolbar_drawer);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);//set toolbar như là 1 actionbar
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);//Thêm Icon ---
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START); //MỞ DRAWER KHI NG DÙNG CHỌN BUTTON
            }
        });

        mTabLayout.setupWithViewPager(mFirstViewPager);//set viewpager

        setupViewPager(mFirstViewPager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewAdapter adapter = new TabViewAdapter(getChildFragmentManager());
        adapter.addFragment(new FragMentThoiSu(), "Thời Sự");
        adapter.addFragment(new FragMentTheGioi(),"Thế Giới");
        adapter.addFragment(new FragMentTheThao(),"Thể Thao");
        adapter.addFragment(new FragMentCongNghe(),"Công Nghệ");
        adapter.addFragment(new FragMentGiaiTri(),"Giải Trí");
        adapter.addFragment(new FragMentKhoaHoc(),"Khoa Học");
        adapter.addFragment(new FragMentDuLich(),"Du Lịch");
        adapter.addFragment(new FragMentSucKhoe(),"Sức Khỏe");
        viewPager.setAdapter(adapter);
    }

}

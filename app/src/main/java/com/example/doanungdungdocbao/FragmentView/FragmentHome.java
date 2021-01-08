package com.example.doanungdungdocbao.FragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.doanungdungdocbao.Data.SaveState;
import com.example.doanungdungdocbao.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentHome extends Fragment {

    private TabLayout tabLayout;
    private ViewPager firstViewPager;
    SaveState saveState;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,null);

    }
}
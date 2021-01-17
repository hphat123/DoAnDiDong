package com.example.doanungdungdocbao.FragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.doanungdungdocbao.Adapter.BaiVietAdapter;
import com.example.doanungdungdocbao.AsysTaskLoader.BaiVietLoader;
import com.example.doanungdungdocbao.Model.BaiViet;
import com.example.doanungdungdocbao.R;

import java.util.ArrayList;
import java.util.List;


public class FragMentTheGioi extends Fragment implements LoaderManager.LoaderCallbacks<List<BaiViet>> {
    private RecyclerView recyclerView;
    private BaiVietAdapter mAdapter;
    LoaderManager loaderManager;
    public List<BaiViet>  listNews = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragMentTheGioi() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragMentTheGioi newInstance(String param1, String param2) {
        FragMentTheGioi fragment = new FragMentTheGioi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thegioi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerview_thegioi);
        mAdapter=new BaiVietAdapter(getContext(),listNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        loaderManager = LoaderManager.getInstance(this);
        Loader loader = loaderManager.getLoader(1000);
        if (loader == null) {
            loaderManager.initLoader(1000, null, this);
        } else {
            loaderManager.restartLoader(1000, null,this);
        }

    }

    @NonNull
    @Override
    public Loader<List<BaiViet>> onCreateLoader(int id, @Nullable Bundle args) {
        return new BaiVietLoader(getContext(),"2");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<BaiViet>> loader, List<BaiViet> data) {
        listNews.clear();
        if(data!=null) {
            listNews.addAll(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<BaiViet>> loader) {

    }
}
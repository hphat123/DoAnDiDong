package com.example.doanungdungdocbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.doanungdungdocbao.AsysTaskLoader.BaiVietLoader;
import com.example.doanungdungdocbao.AsysTaskLoader.TrangChiTietLoader;
import com.example.doanungdungdocbao.Data.SaveState;
import com.example.doanungdungdocbao.Model.BaiViet;
import com.squareup.picasso.Picasso;

public class TrangChiTietActivity extends AppCompatActivity {
    private TextView mNoiDung,mTieuDe,mTomTat;
    SaveState saveState;
    private ImageView mHinh;
    LoaderManager loaderManager;
    static String id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchitiet);
        mHinh = findViewById(R.id.imgChiTiet);
        mTieuDe = findViewById(R.id.txt_tieudechitiet);
        mNoiDung = findViewById(R.id.txt_noidung);
        mTomTat = findViewById(R.id.txt_tomtat);
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        loaderManager = LoaderManager.getInstance(this);
        Loader loader = loaderManager.getLoader(1111);
        if (loader == null) {
            loaderManager.initLoader(1111, null, new CallBack());
        } else {
            loaderManager.restartLoader(1111, null, new CallBack());
        }
        someMethodThatUsesActivity(this);
    }
    private class CallBack implements LoaderManager.LoaderCallbacks<BaiViet>{

        @NonNull
        @Override
        public Loader<BaiViet> onCreateLoader(int id, @Nullable Bundle args) {
            return new TrangChiTietLoader(getApplicationContext(),Integer.valueOf(id));
        }

        @Override
        public void onLoadFinished(@NonNull Loader<BaiViet> loader, BaiViet data) {
                mNoiDung.setText(data.getNoidung());
                mTieuDe.setText(data.getTieude());
                mTomTat.setText(data.getTomtat());
            Picasso.get()
                    .load("http://10.0.2.2:8000/storage/upload/tintuc/"+data.getHinh())
                    .into(mHinh);
        }

        @Override
        public void onLoaderReset(@NonNull Loader<BaiViet> loader) {

        }
    }
    //Ẩn thanh status
    public void someMethodThatUsesActivity(Activity myActivityReference){
        myActivityReference.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

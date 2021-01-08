package com.example.doanungdungdocbao.AsysTaskLoader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.doanungdungdocbao.Data.NetWorkUltis;
import com.example.doanungdungdocbao.Model.BaiViet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class BaiVietLoader extends AsyncTaskLoader<List<BaiViet>> {

    public String danhmuc;
    public BaiVietLoader(@NonNull Context context, String danhmuc) {
        super(context);
        this.danhmuc=danhmuc;
    }

    @Nullable
    @Override
    public List<BaiViet> loadInBackground() {
        List<BaiViet> listNewspaper= new ArrayList<>();
        try {
            String results= NetWorkUltis.getNewspaper(danhmuc);
            JSONObject jsonObject = new JSONObject(results);
            JSONArray newspaper = jsonObject.getJSONArray("baiViet");
            for (int i=0;i<newspaper.length();i++){
                JSONObject item = newspaper.getJSONObject(i);
                Integer id= item.getInt("id");
                String tieuDe = item.getString("TieuDe");
                String tieuDeKhongDau = item.getString("TieuDeKhongDau");
                String tomTat = item.getString("TomTat");
                String noiDung =item.getString("NoiDung");
                String hinh = item.getString("Hinh");
                Integer noiBat = item.getInt("NoiBat");
                Integer soLuotXem = item.getInt("SoLuotXem");
                BaiViet aBaiViet = new BaiViet(id,tieuDe,tieuDeKhongDau,tomTat,noiDung,hinh,noiBat,soLuotXem);
                listNewspaper.add(aBaiViet);
            }
            return listNewspaper;

        } catch (JSONException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

}

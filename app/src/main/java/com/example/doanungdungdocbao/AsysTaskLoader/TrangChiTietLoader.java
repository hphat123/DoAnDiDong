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

public class TrangChiTietLoader extends AsyncTaskLoader<BaiViet> {
    public int id;

    public TrangChiTietLoader(@NonNull Context context, int id) {
        super(context);
        this.id = id;
    }
        @Nullable
        @Override
        public BaiViet loadInBackground () {
            BaiViet baiViet;
            try {
                String results = NetWorkUltis.getChiTiet(id);
                JSONObject jsonObject = new JSONObject(results);
                JSONArray detail = jsonObject.getJSONArray("baiViet");
                for (int i = 0; i < detail.length(); i++) {
                    JSONObject item = detail.getJSONObject(i);
                    Integer id = item.getInt("id");
                    String tieuDe = item.getString("TieuDe");
                    String tieuDeKhongDau = item.getString("TieuDeKhongDau");
                    String tomTat = item.getString("TomTat");
                    String noiDung =item.getString("NoiDung");
                    String hinh = item.getString("Hinh");
                    Integer noiBat = item.getInt("NoiBat");
                    Integer soLuotXem = item.getInt("SoLuotXem");
                    BaiViet aBaiViet = new BaiViet(id,tieuDe,tieuDeKhongDau,tomTat,noiDung,hinh,noiBat,soLuotXem);
                    return aBaiViet;
                }

            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            return null;
        }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}


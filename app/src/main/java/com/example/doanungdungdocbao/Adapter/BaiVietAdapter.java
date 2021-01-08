package com.example.doanungdungdocbao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanungdungdocbao.Model.BaiViet;
import com.example.doanungdungdocbao.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BaiVietAdapter extends RecyclerView.Adapter<BaiVietAdapter.BaiVietViewHolder> {

    private final List<BaiViet> listNews;
    private LayoutInflater mInflater;
    private Context context;


    public BaiVietAdapter(Context context, List<BaiViet> newsList) {
        mInflater=LayoutInflater.from(context);
        this.listNews = newsList;
        this.context=context;
    }

    @NonNull
    @Override
    public BaiVietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item,parent,false);
        return new BaiVietViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiVietViewHolder holder, int position) {
        final BaiViet baiviet = listNews.get(position);
        Picasso.get()
                .load(baiviet.getHinh())
                .into(holder.mHinhAnh);
        holder.mTieuDe.setText(baiviet.getTieude().toString());
        holder.mTomTat.setText(baiviet.getTomtat().toString());
        holder.mNoiBat.setText(baiviet.getNoibat().toString());

    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class BaiVietViewHolder extends RecyclerView.ViewHolder{

        final ImageView mHinhAnh;
        final TextView mTieuDe;
        final TextView mTomTat;
        final TextView mNoiBat;
        final BaiVietAdapter mAdapter;
        public BaiVietViewHolder(@NonNull View itemView, BaiVietAdapter mAdapter) {
            super(itemView);
            mHinhAnh=itemView.findViewById(R.id.img_main);
            mTieuDe=itemView.findViewById(R.id.txt_tieude);
            mTomTat=itemView.findViewById(R.id.txt_mota);
            mNoiBat=itemView.findViewById(R.id.txt_noibat);
            this.mAdapter = mAdapter;

//            this.mMoTa.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(),TrangChiTiet.class);
//                    intent.putExtra("Title",mTieuDe.getText());
//                    intent.putExtra("Mota",mMoTa.getText());
//
//                }
//            });
//            this.mHinhAnh.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(),TrangChiTiet.class);
//                    intent.putExtra("Title",mTieuDe.getText());
//                    intent.putExtra("Mota",mMoTa.getText());
//
//                }
//            });
        }
    }

}

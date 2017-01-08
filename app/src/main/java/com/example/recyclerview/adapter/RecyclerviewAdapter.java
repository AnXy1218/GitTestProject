package com.example.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gittestproject.R;
import com.example.recyclerview.data.Info;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Leovo on 2016/12/23.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<Info> data;

    public RecyclerviewAdapter(Context context,List<Info> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_content_recyclerview,parent,false);
        return new InfoHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Info info = data.get(position);
        //holder.mTitleTextView.setText(info.getmTtitle());
        ((InfoHolder)holder).bindView(info,context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class InfoHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tv_title_item_recyclerview)
        TextView tvTitle;
        @Bind(R.id.tv_content_item_recyclerview)
        TextView tvContent;
        @Bind(R.id.iv_image_item_recyclerview)
        ImageView ivImage;

        private Info mInfo;
        public InfoHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindView(Info info,Context context){
            mInfo = info;
            tvTitle.setText(mInfo.getTitle());
            tvContent.setText(mInfo.getContent());
            Glide.with(context)
                    .load(mInfo.getImgUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivImage);
        }
    }
}

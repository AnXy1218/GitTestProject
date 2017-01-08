package com.example.gittestproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.recyclerview.adapter.RecyclerviewAdapter;
import com.example.recyclerview.data.Info;
import com.example.recyclerview.data.InfoFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerviewActivity extends AppCompatActivity {
    @Bind(R.id.rv_main_recoverview)
    RecyclerView rvMain;

    private List<Info> mList;

    private RecyclerviewAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ButterKnife.bind(this);

        mList = new ArrayList<>();
        for (int i = 0;i < 20;i++){
            Info info = InfoFactory.createInfo();
            info.setTitle("标题：" + i);
            info.setContent("内容" + i);
            info.setImgUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
            mList.add(info);
        }

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rAdapter = new RecyclerviewAdapter(this,mList);
        rvMain.setAdapter(rAdapter);

    }

}

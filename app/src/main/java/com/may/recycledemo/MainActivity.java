package com.may.recycledemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView mImg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //111
        //22222
        setContentView(R.layout.activity_main);
        mRecyclerView = (MyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        initDatas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GalleryAdapter.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this, holder.mTxt.getText().toString() + position, Toast.LENGTH_SHORT).show();
            }
        });

        mImg = (ImageView) findViewById(R.id.id_content);
        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener()
        {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }

        });
    }

    private void initDatas() {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.mm0,
                R.drawable.mm1, R.drawable.mm2, R.drawable.mm3, R.drawable.mm4,
                R.drawable.mm5, R.drawable.mm6, R.drawable.mm7, R.drawable.mm8, R.drawable.mm9));
    }
}

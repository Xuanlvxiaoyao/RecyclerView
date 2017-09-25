package com.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    int[] imgs={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    List<String> textList;
    RvAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initview();
        //初始化数据
        initdata();
    }

    private void initdata() {
        textList=new ArrayList<>();
        for(int i=0;i<20;i++){
            textList.add("item"+i);
        }
        initRvdata();
    }

    //初始化RecyclerView的数据
    private void initRvdata() {
        rvAdapter=new RvAdapter(this,imgs,textList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rvAdapter);
    }

    private void initview() {
        rv= (RecyclerView) findViewById(R.id.mRv);
    }
}

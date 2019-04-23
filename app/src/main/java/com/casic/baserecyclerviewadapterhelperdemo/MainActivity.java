package com.casic.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AnimationAdapter mAnimationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAnimationAdapter = new AnimationAdapter();
        mAnimationAdapter.openLoadAnimation();
        int mFirstPageItemCount = 3;
        mAnimationAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        mAnimationAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.img:
                        content = "img:" + status.getUserAvatar();
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetText:
                        content = "tweetText:" + status.getUserName();
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
                        // you have set clickspan .so there should not solve any click event ,just empty
                        break;
                    default:
                        break;

                }
            }
        });

        /*
        设置动画为左滑行（BaseQuickAdapter.SLIDEIN_LEFT）
        BaseQuickAdapter.ALPHAIN   透明渐变动画
        BaseQuickAdapter.SCALEIN   缩放动画
        BaseQuickAdapter.SLIDEIN_BOTTOM 从下到上
        BaseQuickAdapter.SLIDEIN_LEFT   从左到右
        BaseQuickAdapter.SLIDEIN_RIGHT  从右到左

         */
        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //如果为true，则在首次加载时显示anim；如果为false，则在每次加载数据时显示anim。
        mAnimationAdapter.isFirstOnly(false);

        mRecyclerView.setAdapter(mAnimationAdapter);
    }
}

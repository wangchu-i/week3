package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.Contract;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:16
 *@Description:${DESCRIPTION}
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.View {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutID()!=0){
            setContentView(layoutID());
            initView();
            initData();
            mPresenter=initPresenter();
            mPresenter.onAttch(this);
            startcomming();
        }
    }

    protected abstract void startcomming();

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.bawei.base;

import com.bawei.Contract;

import java.lang.ref.WeakReference;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:16
 *@Description:${DESCRIPTION}
 **/
public abstract class BasePresenter<V extends Contract.View> implements Contract.Presenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }
    protected abstract void initModel();
    protected void onAttch(V view){
        mWeak=new WeakReference<>(view);
    }
    protected void onDoAttch(){
        if (mWeak!=null){
            mWeak.clear();
            mWeak=null;
        }
    }
    protected V getView(){
        return mWeak.get();
    }
}

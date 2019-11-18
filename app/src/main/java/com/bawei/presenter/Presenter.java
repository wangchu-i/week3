package com.bawei.presenter;

import com.bawei.Contract;
import com.bawei.base.BasePresenter;
import com.bawei.model.Model;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:26
 *@Description:${DESCRIPTION}
 **/
public class Presenter extends BasePresenter {
    private Contract.Model model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void startPostRequest(String url, Map<String, String> map) {
        model.postInfo(url, map, new Contract.MyCallBack() {
            @Override
            public void onRuccess(String json) {
                getView().onRuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}

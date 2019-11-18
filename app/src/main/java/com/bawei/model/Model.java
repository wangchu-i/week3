package com.bawei.model;

import com.bawei.Contract;
import com.bawei.util.HttpUtil;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:25
 *@Description:${DESCRIPTION}
 **/
public class Model implements Contract.Model {
    @Override
    public void postInfo(String url, Map<String, String> map, final Contract.MyCallBack myCallBack) {
        HttpUtil.getInstance().postInfo(url, map, new HttpUtil.MyCallBack() {
            @Override
            public void onRuccess(String json) {
                myCallBack.onRuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}

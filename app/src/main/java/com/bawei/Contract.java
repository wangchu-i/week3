package com.bawei;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:12
 *@契约类
 **/
public interface Contract {
    interface MyCallBack{
        void onRuccess(String json);
        void onError(String error);
    }
    interface Model{
        void postInfo(String url, Map<String,String>map, MyCallBack myCallBack);
    }
    interface View{
        void onRuccess(String json);
        void onError(String error);
    }
    interface Presenter{
        void startPostRequest(String url,Map<String,String>map);
    }
}

package com.bawei.util;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.app.AppContext;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:04
 *@Description:${DESCRIPTION}
 **/
public class HttpUtil {

    private final RequestQueue requestQueue;

    private HttpUtil(){
        requestQueue = Volley.newRequestQueue(AppContext.context);
    }
    private static class NetHolder{
        private static final HttpUtil mNet = new HttpUtil();
    }
    public static HttpUtil getInstance(){
        return NetHolder.mNet;
    }
    public void postInfo(String url, final Map<String,String>map, final MyCallBack myCallBack){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.onRuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map!=null){
                    return map;
                }
                return super.getParams();
            }
        };
        requestQueue.add(request);
    }
    public interface MyCallBack{
        void onRuccess(String json);
        void onError(String error);
    }
}

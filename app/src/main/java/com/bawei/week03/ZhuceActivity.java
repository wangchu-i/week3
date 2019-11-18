package com.bawei.week03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.Contract;
import com.bawei.app.AppPostUrl;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.presenter.Presenter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ZhuceActivity extends BaseActivity implements View.OnClickListener {
    private EditText edit_mima;
    private EditText edit_zhanghao;
    private Button btn_zhuce;
    private String phone;
    private String pwd;
    private String isPhone = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private String isPwd = "^[a-zA-Z0-9]\\w{5,17}$";

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zhuce:
                phone=edit_zhanghao.getText().toString().trim();
                pwd=edit_mima.getText().toString().trim();
                if (phone.isEmpty()&&pwd.isEmpty()){
                    Toast.makeText(this, "账号或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                setInit();
                break;
        }
    }

    private void setInit() {
        boolean matches = Pattern.matches(isPhone, phone);
        boolean matches1 = Pattern.matches(isPwd, pwd);
        if (matches&&matches1){
            Map map = new HashMap();
            map.put("phone",phone);
            map.put("pwd",pwd);
            mPresenter.startPostRequest(AppPostUrl.ZHUCE_URL,map);
            Intent intent = getIntent();
            intent.putExtra("phone",phone);
            intent.putExtra("pwd",pwd);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void startcomming() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        edit_mima=findViewById(R.id.edit_mima);
        edit_zhanghao=findViewById(R.id.edit_zhanghao);
        btn_zhuce=findViewById(R.id.btn_zhuce);
        btn_zhuce.setOnClickListener(this);
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_zhuce;
    }

    @Override
    public void onRuccess(String json) {
        Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {

    }
}

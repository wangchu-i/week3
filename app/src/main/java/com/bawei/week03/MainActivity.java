package com.bawei.week03;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.app.AppPostUrl;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.presenter.Presenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private EditText edit_a,edit_b;
    private Button btn_a,btn_b;
    private String phone;
    private String pwd;

    @Override
    public void onClick(View v) {
        //
        switch (v.getId()){
            case R.id.btn_a:
                //跳转到注册页面
                Intent intent = new Intent(this,ZhuceActivity.class);
                startActivityForResult(intent,100);
                finish();
                break;
            case R.id.btn_b:
                phone=edit_a.getText().toString().trim();
                pwd=edit_b.getText().toString().trim();
                //判断账号不为空
                if (phone.isEmpty()){
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //判断密码不为空
                if (pwd.isEmpty()){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.equals(phone)&&pwd.equals(pwd)){
                    Map map = new HashMap();
                    map.put("phone",phone);
                    map.put("pwd",pwd);
                    mPresenter.startPostRequest(AppPostUrl.LOGIN_URL,map);
                    //跳转到view
                    Intent intent1 = new Intent(this,Main2Activity.class);
                    startActivity(intent1);
                    finish();
                }
                break;
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
        edit_a=findViewById(R.id.edit_a);
        edit_b=findViewById(R.id.edit_b);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_b.setOnClickListener(this);
        btn_a.setOnClickListener(this);
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onRuccess(String json) {
        Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {

    }
}

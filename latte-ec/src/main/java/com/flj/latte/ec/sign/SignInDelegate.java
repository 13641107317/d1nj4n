package com.flj.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.flj.latte.delegates.LatteDelegate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wp on 2018/5/18.
 * 登录
 */

public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_name)
    TextInputEditText mUserName;
    @BindView(R2.id.edit_sign_in_pass)
    TextInputEditText mPassWord;
    private ISignListener mListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mListener = (ISignListener) activity;
        }
    }

    //登录
    @OnClick(R2.id.bt_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            SignHandler.onSignIn(mListener);

        }

    }

    //跳转注册
    @OnClick(R2.id.tv_sign_up)
    void onClickStartSignUp() {
        start(new SignUpDelegate());
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWechat() {

    }

    private boolean checkForm() {
        final String userName = mUserName.getText().toString();
        final String password = mPassWord.getText().toString();
        boolean isPass = true;
        if (userName.isEmpty()) {
            mUserName.setError("请输入账号");
            isPass = false;
        } else {
            mUserName.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassWord.setError("密码错误");
            isPass = false;
        } else {
            mPassWord.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}

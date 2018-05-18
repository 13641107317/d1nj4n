package com.flj.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.flj.latte.delegates.LatteDelegate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wp on 2018/5/18.
 */

public class SignUpDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_sign_up_pw)
    TextInputEditText mPassWord;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone;
    @BindView(R2.id.edit_sign_up_pw1)
    TextInputEditText mRePassWord;
    @BindView(R2.id.tv_sign_in)
    AppCompatTextView mSignIn;
    @BindView(R2.id.bt_sign_up_reg)
    AppCompatButton mBtSign;
    @OnClick(R2.id.bt_sign_up_reg)
    void onClickSignUp(){
        if (checkForm()){
            Toast.makeText(getContext(),"注册成功",Toast.LENGTH_LONG).show();
        }
    }
    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassWord.getText().toString();
        final String repassword = mRePassWord.getText().toString();
        boolean isPass = true;
        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }
        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassWord.setError("密码不能低于6位");
            isPass = false;
        } else {
            mPassWord.setError(null);
        }
        if (repassword.isEmpty() || !(repassword.equals(password)) || repassword.length() < 6) {
            mRePassWord.setError("两次输入不一样");
            isPass = false;
        } else {
            mRePassWord.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}

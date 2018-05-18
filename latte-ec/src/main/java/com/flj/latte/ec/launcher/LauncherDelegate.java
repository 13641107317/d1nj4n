package com.flj.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.flj.latte.app.AccountManager;
import com.flj.latte.app.IUserCheck;
import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.ui.launcher.ILauncherListener;
import com.flj.latte.ui.launcher.OnLauncherFinishTag;
import com.flj.latte.ui.launcher.ScrollLauncherTag;
import com.flj.latte.util.storage.LattePreference;
import com.flj.latte.util.timer.BaseTimerTask;
import com.flj.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 2018/5/17.
 * 启动界面
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private Timer mTimer = null;
    private int mCount = 5;
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTVTimer = null;

    private ILauncherListener iLauncherListener;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            iLauncherListener = (ILauncherListener) activity;
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask baseTimerTask = new BaseTimerTask(this);
        mTimer.schedule(baseTimerTask, 0, 1000);
    }

    //判断是否展示滑动界面
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登录
            AccountManager.checkAccount(new IUserCheck() {
                @Override
                //已经登录
                public void onSignIn() {
                    if (iLauncherListener != null) {
                        iLauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }
                //没有登录
                @Override
                public void onNotSignIn() {
                    if (iLauncherListener != null) {
                        iLauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });

        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

        initTimer();
    }

    @Override
    public void onTimer() {

        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTVTimer != null) {
                    mTVTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                }
                if (mCount < 0) {
                    if (mTimer != null) {
                        mTimer.cancel();
                        mTimer = null;
                        checkIsShowScroll();
                    }

                }
            }
        });
    }
}

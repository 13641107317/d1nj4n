package com.flj.latte.app;

import com.flj.latte.util.storage.LattePreference;

/**
 * Created by wp on 2018/5/18.
 */

public class AccountManager {
    private enum Tag {
        SIGN_TAG
    }

    /**
     * 判断用户登录状态,登录成功后调用
     *
     * @param state
     */
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(Tag.SIGN_TAG.name(), state);
    }


    private static boolean isSignIn() {

        return LattePreference.getAppFlag(Tag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserCheck iUserCheck) {

        if (isSignIn()) {
            iUserCheck.onSignIn();
        } else {
            iUserCheck.onNotSignIn();
        }
    }
}

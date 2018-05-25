package com.flj.latte.ec.sign;

import android.util.Log;

import com.flj.latte.app.AccountManager;
import com.flj.latte.ec.database.DataBaseManager;
import com.flj.latte.ec.database.UserProFile;

import java.util.List;

/**
 * Created by wp on 2018/5/18.
 */

public class SignHandler {
    private static final String TAG = "way";

    /**
     * 注册逻辑
     * @param response
     * @param listener 注册成功回调
     */
    public static void onSignUp(UserProFile response ,ISignListener listener) {
        //json解析
      /* final JSONObject profileJson =(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProFile profile = new UserProFile(userId, name, avatar, gender, address);*/
        DataBaseManager.getDataBaseManager().getDao().insert(response);
        //已经注册并登录成功
        AccountManager.setSignState(true);
        listener.onSignUpSuccess();
    }

    public static void onSignIn(ISignListener iSignListener) {

        List<UserProFile> userProFiles = DataBaseManager.getDataBaseManager().getDao().loadAll();
        for (UserProFile user : userProFiles) {

            Log.i(TAG, "onSignIn: "+user);
        }
        AccountManager.setSignState(true);
        iSignListener.onSignInSuccess();
    }
}

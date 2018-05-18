package com.flj.latte.ec.sign;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flj.latte.ec.database.DataBaseManager;
import com.flj.latte.ec.database.UserProFile;
import com.flj.latte.util.log.LatteLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wp on 2018/5/18.
 */

public class SignHandler {
    private static final String TAG = "way";

    public static void onSignUp(UserProFile response) {
        //json解析
      /* final JSONObject profileJson =(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProFile profile = new UserProFile(userId, name, avatar, gender, address);*/
        DataBaseManager.getDataBaseManager().getDao().insert(response);
    }

    public static void onSignIn() {

        List<UserProFile> userProFiles = DataBaseManager.getDataBaseManager().getDao().loadAll();
        for (UserProFile user : userProFiles) {

            Log.i(TAG, "onSignIn: "+user.getUserId());
        }
    }
}

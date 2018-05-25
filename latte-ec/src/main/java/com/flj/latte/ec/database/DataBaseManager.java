package com.flj.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by wp on 2018/5/18.
 */

public class DataBaseManager {
    private DaoSession mDaoSession = null;
    private UserProFileDao mDao = null;

    private DataBaseManager(){

    }
    public DataBaseManager init(Context context){
        initDao(context);
        return this;
    }
    private static final class Holder{
        private static final DataBaseManager INSTANCE = new DataBaseManager();
    }
    public static DataBaseManager getDataBaseManager(){
        return Holder.INSTANCE;
    }
    private void initDao(Context context){

        final ReleaseOpenHelper openHelper = new ReleaseOpenHelper(context,"fast_ec.db" );
        final Database db = openHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProFileDao();
    }
    public final UserProFileDao getDao(){
        return mDao;
    }
}

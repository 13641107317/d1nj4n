package com.flj.latte.ui.recycle;

import java.util.ArrayList;

/**
 * Created by wp on 2018/5/22.
 */

public abstract class DataConverter {

    protected ArrayList<MultipleItemEntity> ENTITES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> converter();
    public final DataConverter setJsonData(String json){
        this.mJsonData = json;
        return this;
    }
    protected String getJsonData(){
        if (mJsonData==null||mJsonData.isEmpty()){
            throw new NullPointerException("JSON IS NULL!");
        }
        return mJsonData;
    }
}

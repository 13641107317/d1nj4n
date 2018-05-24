package com.flj.latte.ec.main.sort.content;

/**
 * Created by wp on 2018/5/24.
 */

public class SectionContentItemEntity {
    private int goodsId = 0;
    private String goodsUrl = null;
    private String goodsName = null;

    public String getGoodsName() {
        return goodsName;
    }

    public SectionContentItemEntity setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public SectionContentItemEntity setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public SectionContentItemEntity setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
        return this;
    }

    @Override
    public String toString() {
        return "SectionContentItemEntity{" +
                "goodsId=" + goodsId +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}

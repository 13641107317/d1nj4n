package com.flj.latte.ec.main.sort.list;

/**
 * Created by mac on 2018/5/23.
 */

public class BeanSort  {
   private String id;
   private String name;

    public BeanSort(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public BeanSort setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanSort setName(String name) {
        this.name = name;
        return this;
    }
}

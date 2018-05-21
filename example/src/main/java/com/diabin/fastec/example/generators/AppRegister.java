package com.diabin.fastec.example.generators;

import com.flj.latte.annotations.AppRegisterGenerator;
import com.flj.latte.wechat.templates.AppRegisterTemplate;

/**
 * Created by wp on 2018/5/21.
 */
@AppRegisterGenerator(
        packageName = "com.fastec.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}

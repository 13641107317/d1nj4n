package com.diabin.fastec.example.generators;

import com.flj.latte.annotations.PayEntryGenerator;
import com.flj.latte.wechat.templates.WPayEntryTemplate;

/**
 * Created by wp on 2018/5/21.
 */
@PayEntryGenerator(
        packageName = "com.diabin.fastec.example",
        payEntryTemplate = WPayEntryTemplate.class
)
public interface WeChatPayEntry {
}

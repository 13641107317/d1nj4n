package com.diabin.fastec.example;

import com.flj.latte.activities.ProxyActivity;
import com.flj.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }


}

package com.diabin.fastec.example;

import com.flj.latte.activities.ProxyActivity;
import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }


}

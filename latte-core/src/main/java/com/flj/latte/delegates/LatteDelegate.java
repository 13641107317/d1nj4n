package com.flj.latte.delegates;


public abstract class LatteDelegate extends PermissionCheckerDelegate {

    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }

}

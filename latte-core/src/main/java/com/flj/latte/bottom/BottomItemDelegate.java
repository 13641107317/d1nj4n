package com.flj.latte.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.R;
import com.flj.latte.delegates.LatteDelegate;

/**
 * Created by mac on 2018/5/21.
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener {
    private long mEditTime = 0;
    private static final int EDIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        View rootView = getView();
        if (rootView!=null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - mEditTime > EDIT_TIME) {
                Toast.makeText(getContext(), "双击退出" + getString(R.string.app_name), Toast.LENGTH_LONG).show();
                mEditTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
                if (mEditTime != 0) {
                    mEditTime = 0;
                }
            }
            return true;
        }
        return false;
    }
}

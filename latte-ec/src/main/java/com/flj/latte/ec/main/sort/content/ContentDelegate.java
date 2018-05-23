package com.flj.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.ec.R;
import com.flj.latte.delegates.LatteDelegate;

/**
 * Created by wp on 2018/5/23.
 */

public class ContentDelegate extends LatteDelegate {

    private static String ARG_CONTENT_ID = "CONTENT_ID";

    private int mContentId = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    public static ContentDelegate newInstance(int contentId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID, contentId);
        final ContentDelegate contentDelegate = new ContentDelegate();
        contentDelegate.setArguments(args);
        return contentDelegate;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_content;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}

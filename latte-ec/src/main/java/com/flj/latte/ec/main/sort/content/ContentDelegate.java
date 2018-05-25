package com.flj.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.flj.latte.delegates.LatteDelegate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wp on 2018/5/23.
 */

public class ContentDelegate extends LatteDelegate {
    private static final String TAG = "demo";
    private static String ARG_CONTENT_ID = "CONTENT_ID";
    @BindView(R2.id.rv_list_content)
    RecyclerView mRecyclerView = null;
    private int mContentId = -1;
    private List<SectionBean> sectionBeans = null;


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

    private void initData() {
        InputStream in = null;
        try {
            in = getContext().getAssets().open("test_json");
            String josn = inputStreamToString(in);
            sectionBeans = new SectionDataConverter().converter(josn);
            final SectionAdapter adapter = new SectionAdapter(R.layout.item_section_content, R.layout.item_section_header, sectionBeans);
            if (adapter != null) {
                mRecyclerView.setAdapter(adapter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String inputStreamToString(InputStream in) {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[1024];
        try {
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        final StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        initData();
    }

}

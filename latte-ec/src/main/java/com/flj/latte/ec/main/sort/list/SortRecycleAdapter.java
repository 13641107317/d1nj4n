package com.flj.latte.ec.main.sort.list;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.diabin.latte.ec.R;
import com.flj.latte.ec.main.sort.SortDelegate;
import com.flj.latte.ui.recycle.ItemType;
import com.flj.latte.ui.recycle.MultipleFields;
import com.flj.latte.ui.recycle.MultipleItemEntity;
import com.flj.latte.ui.recycle.MultipleRecycleAdapter;
import com.flj.latte.ui.recycle.MultipleViewHolder;

import java.util.List;

/**
 * Created by mac on 2018/5/23.
 */

public class SortRecycleAdapter extends MultipleRecycleAdapter {
    private final SortDelegate DELEGATE;

    private  int mPosition  = 0;
    protected SortRecycleAdapter(List<MultipleItemEntity> data,
                                 SortDelegate delegate) {
        super(data);
        this.DELEGATE = delegate;
        //添加垂直菜单布局
        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list );
    }

    @Override
    protected void convert(final MultipleViewHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()){
            case ItemType.VERTICAL_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClick = entity.getField(MultipleFields.TAG);
                final AppCompatTextView textView = holder.getView(R.id.tv_menu_list);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        final  int currentPosition= holder.getAdapterPosition();
                        if (mPosition!= currentPosition){

                            //还原上一次item
                            getData().get(mPosition).setField(MultipleFields.TAG,false);
                            notifyItemChanged(mPosition);
                            //更新选中的item
                            entity.setField(MultipleFields.TAG,true);
                            notifyItemChanged(currentPosition);
                            mPosition = currentPosition;
                        }
                    }
                });

                if (!isClick){
                    line.setVisibility(View.INVISIBLE);
                    textView.setTextColor(ContextCompat.getColor(mContext,R.color.we_chat_black));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.item_background));
                }else{
                    line.setVisibility(View.VISIBLE);
                    textView.setTextColor(ContextCompat.getColor(mContext,R.color.white));
                    line.setBackgroundColor(ContextCompat.getColor(mContext,R.color.app_main));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.green));
                }

                holder.setText(R.id.tv_menu_list,text);
                break;
                default:
                    break;
        }
    }
}

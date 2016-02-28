package org.ewhappcenter.visualmizing.utils;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Dong on 2016-01-31.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        if(parent.getLayoutManager() instanceof GridLayoutManager){
            if(parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1){
                outRect.top = space;
            }
        }else{
            if(parent.getChildLayoutPosition(view) == 0){
                outRect.top = space;
            }
        }
    }
}

package org.ewhappcenter.visualmizing;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ewhappcenter.visualmizing.model.CategoryItem;

import java.util.ArrayList;

/**
 * Created by Dong on 2016-02-28.
 */
public class CategorySelectionListAdapter extends RecyclerView.Adapter<CategorySelectionListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<CategoryItem> mCategoryItemArrayList;

    //현재 체크된 카테고리 id
    private int currentCheckId = -1;

    public CategorySelectionListAdapter(Context context, ArrayList<CategoryItem> categoryItemArrayList) {
        this.mContext = context;
        this.mCategoryItemArrayList = categoryItemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CategoryItem categoryItem = mCategoryItemArrayList.get(position);

        holder.tvCategoryName.setText(categoryItem.getName());
        holder.ivCategory.setImageResource(categoryItem.getResId());

        //뷰에 선택 여부 표시
        if (categoryItem.isSelected()) {  //선택
            holder.mView.setBackgroundColor(Color.parseColor("#64d4b8"));
        } else {  //미선택
            holder.mView.setBackgroundColor(Color.parseColor("#f9f4f4"));
        }

        //그래프 선택 여부
        //Todo: 하나만 선택되게 만든다.(O) or toggle 가능하게(O)
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택 정보 clear
                for (int i = 0; i < mCategoryItemArrayList.size(); i++) {
                    mCategoryItemArrayList.get(i).setSelected(false);
                }

                if (currentCheckId == position) {  //toggle 기능
                    currentCheckId = -1;  //toggle 기능 초기화
                } else {  //하나만 선택하게
                    //선택 정보 set
                    categoryItem.setSelected(!categoryItem.isSelected());
                    currentCheckId = position;
                }
                notifyDataSetChanged();  //recyclerView 갱신
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView tvCategoryName;
        ImageView ivCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvCategoryName = (TextView) mView.findViewById(R.id.textView_cateogry_name);
            ivCategory = (ImageView) mView.findViewById(R.id.imageView_category);
        }
    }
}

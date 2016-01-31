package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ewhappcenter.visualmizing.model.GraphItem;

import java.util.ArrayList;

public class GraphSelectionListAdapter extends RecyclerView.Adapter<GraphSelectionListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<GraphItem> mGraphItemArrayList;

    //현재 체크된 그래프 id
    private int currentCheckId = -1;

    public GraphSelectionListAdapter(Context context, ArrayList<GraphItem> graphItemArrayList) {
        mContext = context;
        mGraphItemArrayList = graphItemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_grahp, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final GraphItem graphItem = mGraphItemArrayList.get(position);

        holder.tvGraphName.setText(graphItem.getName());
        holder.ivGraph.setImageResource(graphItem.getResId());
        //뷰에 선택 여부 표시
        if (graphItem.isSelected()) {
            ((CardView) holder.mView).setCardBackgroundColor(Color.parseColor("#64d4b8"));
        } else {
            ((CardView) holder.mView).setCardBackgroundColor(Color.parseColor("#f9f4f4"));
        }

        //그래프 선택 여부
        //Todo: 하나만 선택되게 만든다.(O) or toggle 가능하게(O)
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택 정보 clear
                for (int i = 0; i < mGraphItemArrayList.size(); i++) {
                    mGraphItemArrayList.get(i).setSelected(false);
                }

                if (currentCheckId == position) {  //toggle 기능
                    currentCheckId = -1;  //toggle 기능 초기화
                } else {  //하나만 선택하게
                    //선택 정보 set
                    graphItem.setSelected(!graphItem.isSelected());
                    currentCheckId = position;
                }
                notifyDataSetChanged();  //recyclerView 갱신
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGraphItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvGraphName;
        public final ImageView ivGraph;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvGraphName = (TextView) mView.findViewById(R.id.textView_graph_name);
            ivGraph = (ImageView) mView.findViewById(R.id.imageView_graph);
        }
    }
}

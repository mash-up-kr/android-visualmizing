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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final GraphItem graphItem = mGraphItemArrayList.get(position);

        holder.tvGraphName.setText(graphItem.getName());
        holder.ivGraph.setImageResource(graphItem.getResId());

        //그래프 선택 여부
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //그래프 선택 토글
                graphItem.setSelected(!graphItem.isSelected());

                //그래프 선택 여부 표시
                for(int i=0; i<mGraphItemArrayList.size(); i++){
                    if(graphItem.isSelected()){
                        ((CardView)v).setCardBackgroundColor(Color.parseColor("#64d4b8"));
                    }else{
                        ((CardView)v).setCardBackgroundColor(Color.parseColor("#f9f4f4"));
                    }
                }
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

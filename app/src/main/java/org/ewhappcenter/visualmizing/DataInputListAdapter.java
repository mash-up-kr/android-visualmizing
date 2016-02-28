package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.ewhappcenter.visualmizing.model.DataInputItem;

import java.util.ArrayList;

/**
 * Created by Dong on 2016-02-28.
 */
public class DataInputListAdapter extends RecyclerView.Adapter<DataInputListAdapter.ViewHolder> {

    public static final String TAG = DataInputListAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<DataInputItem> mDataInputItemArrayList;

    public DataInputListAdapter(Context context) {
        this.mContext = context;
        this.mDataInputItemArrayList = new ArrayList<>();
        addDataInputItem();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_data_input, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataInputItem dataInputItem = mDataInputItemArrayList.get(position);

        //데이터 불러오기
        if (dataInputItem.getKey() != null && dataInputItem.getValue() != null) {
            holder.etDataInputKey.setText(dataInputItem.getKey());
            holder.etDataInputValue.setText(dataInputItem.getValue().toString());
        }

        Log.e(TAG, " " + dataInputItem.getKey() + " " + dataInputItem.getValue() + " " + position);

        //데이터 저장
        //처음에 표시될 때도 texthange 이벤트 발생
        //Todo: 버그... 해결 요망, 데이터가 꼬인다.
        holder.etDataInputKey.addTextChangedListener(new TextWatcher() {

            int flag = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                flag++;
                if (flag > 1)
                    dataInputItem.setKey(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        holder.etDataInputValue.addTextChangedListener(new TextWatcher() {

            int flag = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //빈칸일 때 NumberFormatException 처리
                flag++;
                if (flag > 1 && count > 0) {
                    dataInputItem.setValue(Float.parseFloat(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataInputItemArrayList.size();
    }

    public void addDataInputItem() {
        mDataInputItemArrayList.add(new DataInputItem());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        EditText etDataInputKey;
        EditText etDataInputValue;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            etDataInputKey = (EditText) mView.findViewById(R.id.editText_data_input_key);
            etDataInputValue = (EditText) mView.findViewById(R.id.editText_data_input_value);
        }
    }
}

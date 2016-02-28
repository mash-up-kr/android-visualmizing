package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.ewhappcenter.visualmizing.utils.SpacesItemDecoration;
import org.ewhappcenter.visualmizing.utils.ViewUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


//dv 3번째 fragment
public class DataInputFragment extends Fragment {

    @Bind(R.id.recyclerView_data_input)
    RecyclerView rvDataInput;

    @Bind(R.id.button_data_input_add)
    Button btnDataInputAdd;

    @Bind(R.id.editText_data_input_text_size)
    EditText etTextSize;

    @Bind(R.id.checkBox_data_input_text_bold)
    CheckBox cbTextBold;

    DataInputListAdapter mDataInputListAdapter;

    public DataInputFragment() {
        // Required empty public constructor
    }

    public static DataInputFragment newInstance() {
        DataInputFragment fragment = new DataInputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_input, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the recyclerView
        rvDataInput.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDataInput.addItemDecoration(new SpacesItemDecoration(ViewUtils.getDpToPixel(getActivity(), 12)));
        mDataInputListAdapter = new DataInputListAdapter(getActivity());
        rvDataInput.setAdapter(mDataInputListAdapter);

        btnDataInputAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataInputListAdapter.addDataInputItem();
            }
        });
    }
}

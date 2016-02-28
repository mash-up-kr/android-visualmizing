package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.ewhappcenter.visualmizing.model.DataVisualizationItem;

import butterknife.Bind;
import butterknife.ButterKnife;

//dv 2번째 fragment
public class DesignSelectionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.imageView_design)
    ImageView ivDesign;

    @Bind(R.id.imageButton_design_left)
    ImageButton ibLeft;

    @Bind(R.id.imageButton_design_right)
    ImageButton ibRight;

    @Bind(R.id.imageView_singleColor)
    ImageView ivSingleColor;

    @Bind(R.id.imageView_pattern)
    ImageView ivPattern;

    DataVisualizationItem mDataVisualizationItem;

    public DesignSelectionFragment() {
        // Required empty public constructor
    }


    public static DesignSelectionFragment newInstance() {
        DesignSelectionFragment fragment = new DesignSelectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_design_selection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Dv객체 획득
        mDataVisualizationItem = ((DataVisualizationActivity)getActivity()).getDvItem();

        //Todo: 색 정보 객체 추가, Color picker용
        //Todo: 무늬 정보 객체 추가, pattern picker용

        //Todo; 디자인은 회전하는 식으로 보여준다. 리스트의 끝에 오면 0번 인덱스로 조정, 원형큐처럼
        //Todo: 여기서 말하는 디자인이란.. 무엇인가.....?
        //디자인 선택 버튼
        ibLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: 모델객체에 데이터 저장
                ivDesign.setImageResource(R.mipmap.ic_launcher);  //Todo: 이전 디자인 보여주기

                Toast.makeText(getActivity(), "이전 디자인", Toast.LENGTH_SHORT).show();
            }
        });

        ibRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: 모델객체에 데이터 저장
                ivDesign.setImageResource(R.mipmap.ic_launcher);   // Todo: 다음 디자인 보여주기

                Toast.makeText(getActivity(), "다음 디자인", Toast.LENGTH_SHORT).show();
            }
        });

        ivSingleColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: show color picker
                Toast.makeText(getActivity(), "show color picker", Toast.LENGTH_SHORT).show();

                //Todo: 모델객체에 데이터 저장
            }
        });

        ivPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: show pattern picker
                Toast.makeText(getActivity(), "show pattern picker", Toast.LENGTH_SHORT).show();

                //Todo: 모델객체에 데이터 저장
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement org.ewhappcenter.visualmizing.OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}

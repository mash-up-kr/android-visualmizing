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

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DesignSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//dv 2번째 fragment
public class DesignSelectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

    public DesignSelectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DesignSelectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DesignSelectionFragment newInstance(String param1, String param2) {
        DesignSelectionFragment fragment = new DesignSelectionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        //Todo: 색깔 추가
        //Todo: 무늬 추가

        //Todo; 디자인은 회전하는 식으로 보여준다. 리스트의 끝에 오면 0번 인덱스로 조정, 원형큐처럼
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

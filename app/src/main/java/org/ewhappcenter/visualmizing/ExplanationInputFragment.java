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
import android.widget.EditText;

import org.ewhappcenter.visualmizing.model.CategoryItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//dv 4번째 fragment
public class ExplanationInputFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.recyclerView_category_selection)
    RecyclerView rvCategorySelection;

    //Todo: 모델 객체에 정보 저장
    @Bind(R.id.editText_explanation_title)
    EditText etExplanationTitle;

    //Todo: 모델 객체에 정보 저장
    @Bind(R.id.editText_explanation_content)
    EditText getEtExplanationContent;

    public ExplanationInputFragment() {
        // Required empty public constructor
    }

    public static ExplanationInputFragment newInstance() {
        ExplanationInputFragment fragment = new ExplanationInputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_explanation_input, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //카테고리 아이템 추가
        ArrayList<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("스포츠", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("재미", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("나라", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("통계", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("인물", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("소설", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("음악", R.mipmap.ic_launcher, false));
        categoryItems.add(new CategoryItem("사회", R.mipmap.ic_launcher, false));

        // Set the adapter
        rvCategorySelection.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvCategorySelection.setAdapter(new CategorySelectionListAdapter(getActivity(), categoryItems));
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

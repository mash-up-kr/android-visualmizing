package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ewhappcenter.visualmizing.model.GraphItem;
import org.ewhappcenter.visualmizing.utils.SpacesItemDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//dv 1번째 fragment
//Todo: 그래프 선택시 콜백리스너로 프래그먼트에서 모델객체에 정보 저장
public class GraphSelectionListFragment extends Fragment {

    private OnFragmentInteractionListener mOnFragmentInteractionListener;
    private OnListFragmentInteractionListener mOnListFragmentInteractionListener;

    @Bind(R.id.recyclerView_graph_selection)
    RecyclerView rvGraphSelection;

    public GraphSelectionListFragment() {
        // Required empty public constructor
    }

    public static GraphSelectionListFragment newInstance() {
        GraphSelectionListFragment fragment = new GraphSelectionListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph_selection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //그래프 아이템 추가
        ArrayList<GraphItem> graphItems = new ArrayList<>();
        graphItems.add(new GraphItem("막대 그래프", R.mipmap.ic_launcher, false));
        graphItems.add(new GraphItem("꺽은선 그래프", R.mipmap.ic_launcher, false));
        graphItems.add(new GraphItem("원형 그래프", R.mipmap.ic_launcher, false));
        graphItems.add(new GraphItem("글자 구름", R.mipmap.ic_launcher, false));

        // Set the adapter
        rvGraphSelection.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvGraphSelection.addItemDecoration(new SpacesItemDecoration(16));
        rvGraphSelection.setAdapter(new GraphSelectionListAdapter(getActivity(), graphItems));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mOnFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement org.ewhappcenter.visualmizing.OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnFragmentInteractionListener = null;
    }
}

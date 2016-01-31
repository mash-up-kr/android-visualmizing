package org.ewhappcenter.visualmizing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ewhappcenter.visualmizing.dummy.DummyContent;
import org.ewhappcenter.visualmizing.model.GraphItem;
import org.ewhappcenter.visualmizing.utils.SpacesItemDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GraphSelectionListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//dv 1번째 fragment
//Todo: 그래프 선택시 콜백리스너로 프래그먼트에서 모델객체에 정보 저장
public class GraphSelectionListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mOnFragmentInteractionListener;
    private OnListFragmentInteractionListener mOnListFragmentInteractionListener;


    @Bind(R.id.recyclerView_graph)
    RecyclerView rvGraph;

    public GraphSelectionListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GraphSelectionListFragment newInstance() {
        GraphSelectionListFragment fragment = new GraphSelectionListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        rvGraph.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvGraph.addItemDecoration(new SpacesItemDecoration(16));
        rvGraph.setAdapter(new GraphSelectionListAdapter(getActivity(), graphItems));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mOnFragmentInteractionListener != null) {
            mOnFragmentInteractionListener.onFragmentInteraction(uri);
        }
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

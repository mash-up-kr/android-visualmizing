package org.ewhappcenter.visualmizing;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.ewhappcenter.visualmizing.model.DataVisualizationItem;
import org.ewhappcenter.visualmizing.model.GraphItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//Todo: GraphItem객체 프레그먼트로 전달하기
public class DataVisualizationActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.container_fragment)
    FrameLayout container;

    @Bind(R.id.button_next)
    Button btnNext;

    @Bind(R.id.button_cancel)
    Button btnCancel;

    FragmentManager fm;

    ArrayList<Fragment> mFragments;

    //프래그먼트를 찾을 tag
    String[] fragmentTags = {"graphSelection", "designSelection", "dataInput", "explanationInput", "preview"};

    //현재 어느 단계에 있는지 알려주는 플래그
    int currentSection;

    //데이터 시각화 객체
    DataVisualizationItem mDataVisualizationItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_visualization);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);  //set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true);  //show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);  //enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false);  //disable the default title element here(for centered title)

        //데이터 시각화 객체 객체 생성
        mDataVisualizationItem = new DataVisualizationItem();

        //inital fragment
        mFragments = new ArrayList<>();
        mFragments.add(GraphSelectionListFragment.newInstance());
        mFragments.add(DesignSelectionFragment.newInstance());
        mFragments.add(DataInputFragment.newInstance());
        mFragments.add(ExplanationInputFragment.newInstance());
        mFragments.add(PreviewFragment.newInstance());

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

        if (fragment == null) {
            currentSection = 0;
            fm.beginTransaction().add(R.id.container_fragment, mFragments.get(currentSection), fragmentTags[currentSection]).commit();
        }

        //Todo: 프래그먼트 전환 애니메이션 구현
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSection < 3) {  //1, 2, 3단계 처리
                    currentSection++;
                    fm.beginTransaction()
                            .setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity)
                            .replace(R.id.container_fragment, mFragments.get(currentSection), fragmentTags[currentSection])
                            .commit();

                } else if (currentSection == 3) {  //4단계(마지막 전) 처리
                    currentSection++;
                    fm.beginTransaction()
                            .setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity)
                            .replace(R.id.container_fragment, mFragments.get(currentSection), fragmentTags[currentSection])
                            .commit();
                    btnNext.setText("완료");
                } else {  //5단계(마지막) 처리
                    //Todo: 데이터 시각화 구현
                    Toast.makeText(DataVisualizationActivity.this, "마지막 단계입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Todo: 이전버튼인지 취소 버튼인지 상의.
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이전버튼이라면
                if (currentSection > 0) {
                    currentSection--;
                    fm.beginTransaction()
                            .setCustomAnimations(R.anim.move_left_in_activity, R.anim.move_right_out_activity)
                            .replace(R.id.container_fragment, mFragments.get(currentSection), fragmentTags[currentSection])
                            .commit();
                    if (currentSection == 3) {
                        btnNext.setText("다음 단계");
                    }
                } else {
                    Toast.makeText(DataVisualizationActivity.this, "1번째 단계입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //HW Back key눌렀을 때의 동작 구현
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

        //액티비티 전환 애니메이션
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }

    public DataVisualizationItem getDvItem(){
        return mDataVisualizationItem;
    }

    public void setDvItem(DataVisualizationItem item){
        mDataVisualizationItem = item;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

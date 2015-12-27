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

import butterknife.Bind;
import butterknife.ButterKnife;

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

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

        if (fragment == null) {
            fm.beginTransaction().add(R.id.container_fragment, GraphSelectionListFragment.newInstance()).commit();
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.example.ibrahim.testworldcup.ui.matches;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.local.DBHelber;
import com.example.ibrahim.testworldcup.data.local.models.Matches;

import java.util.ArrayList;
import java.util.List;

import static com.example.ibrahim.testworldcup.data.contract.DATE;
import static com.example.ibrahim.testworldcup.data.contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.IMAGE_FOR_TEAM_B;
import static com.example.ibrahim.testworldcup.data.contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_A;
import static com.example.ibrahim.testworldcup.data.contract.TEAM_B;

public class MathesActiviy extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mathes_activiy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
       tabLayout.addTab(tabLayout.newTab().setText("Comming Mathes"));
     tabLayout.addTab(tabLayout.newTab().setText("Today Mathes"));
        tabLayout.addTab(tabLayout.newTab().setText("Last Mathes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
package com.example.auladeingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.auladeingles.fragments.BichosFragment;
import com.example.auladeingles.fragments.NumerosFragment;
import com.example.auladeingles.fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

  private SmartTabLayout  smartTabLayout;
  private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);

        smartTabLayout = findViewById(R.id.ViewPagerTab);
        viewPager = findViewById(R.id.ViewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                             getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Bichos", BichosFragment.class                        )
                        .add("numeros" , NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)
                .create()
        );

        viewPager.setAdapter( adapter );
        smartTabLayout.setViewPager( viewPager );

    }
}

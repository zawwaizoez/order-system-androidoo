package v3.ordersystem.a7r48.ordersystem;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class OneFragment extends Fragment {
    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private View v;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


tabLayout=(TabLayout)v.findViewById(R.id.tabs);


        return inflater.inflate(R.layout.activity_simple_tabs, container, false);
    }
}
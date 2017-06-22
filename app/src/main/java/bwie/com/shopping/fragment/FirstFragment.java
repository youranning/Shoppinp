package bwie.com.shopping.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwie.com.shopping.R;
import bwie.com.shopping.adapter.FirstFragmentAdapter;


/**
 */
public class FirstFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tablayout;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        tablayout = (TabLayout) view.findViewById(R.id.first_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.first_viewpage);

        FirstFragmentAdapter adapter=new FirstFragmentAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}

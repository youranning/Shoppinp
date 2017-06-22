package bwie.com.shopping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bwie.com.shopping.fragment.IndexFrag;


/**
 * Created by muhanxi on 17/6/20.
 */

public class FirstFragmentAdapter extends FragmentPagerAdapter {

    String[] titles = {"上新", "纸尿裤", "奶粉", "洗护喂养", "玩具", "服饰", "车窗", "图书", "车床"};


    public FirstFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        return  IndexFrag.newInstance(position);
    }


    @Override
    public int getCount() {
        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

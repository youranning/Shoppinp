package bwie.com.shopping;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import bwie.com.shopping.fragment.FirstFragment;
import bwie.com.shopping.fragment.FourthFragment;
import bwie.com.shopping.fragment.SecondFragment;
import bwie.com.shopping.fragment.ThirdFragment;
import bwie.com.shopping.myview.RadiaoGroup;

public class Shop extends FragmentActivity implements RadiaoGroup.OnSelectListener {

    private FragmentManager fm;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        fm = getSupportFragmentManager();
        createFragment(savedInstanceState);

       RadiaoGroup group = (RadiaoGroup) findViewById(R.id.buttom_layout);
        group.setOnSelectListener(this);
        switchFragment(0);

    }

    public void createFragment(Bundle savedInstanceState) {

        FirstFragment firstFragment = (FirstFragment) fm.findFragmentByTag("FirstFragment");
        SecondFragment secondFragment = (SecondFragment) fm.findFragmentByTag("SecondFragment");
        ThirdFragment thirdFragment = (ThirdFragment) fm.findFragmentByTag("ThirdFragment");
        FourthFragment fourthFragment = (FourthFragment) fm.findFragmentByTag("FourthFragment");

        if (firstFragment == null) {
            firstFragment = new FirstFragment();
        }

        if (secondFragment == null) {
            secondFragment = new SecondFragment();
        }
        if (thirdFragment == null) {
            thirdFragment = new ThirdFragment();
        }
        if (fourthFragment == null) {
            fourthFragment = new FourthFragment();
        }


        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);


    }



    public void switchFragment(int pos){

        FragmentTransaction transaction =  fm.beginTransaction() ;


        if(!fragments.get(pos).isAdded()){

            transaction.add(R.id.container,fragments.get(pos),fragments.get(pos).getClass().getSimpleName());
        }

        for(int i=0;i<fragments.size();i++){

            if(i == pos){
                transaction.show(fragments.get(pos));
            }else {
                transaction.hide(fragments.get(i));
            }

        }
        transaction.commit();


    }
    @Override
    public void onSelect(int index) {
        switchFragment(index);

    }
}

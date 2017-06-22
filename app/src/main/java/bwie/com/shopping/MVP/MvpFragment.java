package bwie.com.shopping.MVP;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwie.com.shopping.R;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public abstract class MvpFragment<V, T extends MvpPresenter<V>> extends Fragment {

    public T presenter;

    public abstract T initPresenter();



    public MvpFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mvp_layout, container);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }
}

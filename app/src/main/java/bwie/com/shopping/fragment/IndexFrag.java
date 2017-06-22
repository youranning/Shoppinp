package bwie.com.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bwie.com.shopping.MVP.MvpFragment;
import bwie.com.shopping.MVP.MvpPresenter;
import bwie.com.shopping.R;
import bwie.com.shopping.adapter.IndexFragmentRecycleViewAdapter;
import bwie.com.shopping.bean.Index;
import bwie.com.shopping.presenter.IndexPresenter;
import bwie.com.shopping.view.IndexView;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public class IndexFrag extends MvpFragment<IndexView, IndexPresenter> implements IndexView {

    private static final String ARG_PARAM1 = "param1";

    private RecyclerView recyclerView;
    private List<Index.DataBean> list = new ArrayList<>();
    private int mParam1;
    private IndexFragmentRecycleViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment, container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.index_recycle);

        adapter = new IndexFragmentRecycleViewAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        presenter.getData(mParam1);
    }
//
    @Override
    public IndexPresenter initPresenter() {
        return new IndexPresenter();
    }

    @Override
    public void onSuccess(Index index) {
        System.out.println(index.toString());
        list.addAll(index.getData());

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFailed(int code) {

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    public static IndexFrag newInstance(int param1) {
        IndexFrag fragment = new IndexFrag();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

}

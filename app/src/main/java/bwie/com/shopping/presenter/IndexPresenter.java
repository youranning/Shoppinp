package bwie.com.shopping.presenter;

import bwie.com.shopping.MVP.MvpPresenter;
import bwie.com.shopping.bean.Index;
import bwie.com.shopping.moudle.IndexModle;
import bwie.com.shopping.moudle.IndexMoudleImpl;
import bwie.com.shopping.view.IndexView;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public class IndexPresenter extends MvpPresenter<IndexView>{

    IndexMoudleImpl indexMoudle;

    public IndexPresenter() {
        indexMoudle=new IndexMoudleImpl();
    }


    public void getData(int pos){
     indexMoudle.getData(pos, new IndexModle.IndexFragmentModelListener() {
         @Override
         public void onSuccess(Index index) {
             view.onSuccess(index);
         }

         @Override
         public void onFailed(int code) {
view.onFailed(code);
         }
     });
    }
}

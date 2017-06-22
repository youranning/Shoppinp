package bwie.com.shopping.moudle;

import bwie.com.shopping.bean.Index;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public interface IndexModle {
    public void getData(int pos, IndexFragmentModelListener listener);


    //


    public interface IndexFragmentModelListener {


        public void onSuccess(Index index);

        public void onFailed(int code);
    }
}
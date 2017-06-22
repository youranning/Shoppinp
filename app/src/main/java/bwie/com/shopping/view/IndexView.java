package bwie.com.shopping.view;

import bwie.com.shopping.bean.Index;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public interface IndexView {

     void onSuccess(Index index);

     void onFailed(int code);
}

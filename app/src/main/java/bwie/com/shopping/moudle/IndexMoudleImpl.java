package bwie.com.shopping.moudle;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bwie.com.shopping.bean.Index;
import bwie.com.shopping.utils.BaseObserver;
import bwie.com.shopping.utils.RetrofitFactory;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public class IndexMoudleImpl implements IndexModle {



    private String [] url = {"http://lib.suning.com/app/redbaby/80000_8.2.0-155.json",
            "http://lib.suning.com/app/redbaby/babydiapers-64.json",
            "http://lib.suning.com/app/redbaby/babymilk-41.json",
            "http://lib.suning.com/app/redbaby/BabyBottles-56.json",
            "http://lib.suning.com/app/redbaby/babytoys-50.json",
            "http://lib.suning.com/app/redbaby/babyclothes-49.json",
            "http://lib.suning.com/app/redbaby/babybooks-39.json"} ;


    @Override
    public void getData(int pos, final IndexFragmentModelListener listener) {

     /*   RetrofitFactory.get(url[pos])
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println(result);
                        Gson gson = new Gson();
                        Index indexBean =  gson.fromJson(result, Index.class);

//                        listener.onSuccess(indexBean);
                    }

                    @Override
                    public void onFailed(int code) {
                    listener.onFailed(code);
                    }
                });*/
        RequestParams parms=new RequestParams(url[pos%url.length]);
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
                Gson gson = new Gson();
                Index indexBean =  gson.fromJson(result, Index.class);
                                        listener.onSuccess(indexBean);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}

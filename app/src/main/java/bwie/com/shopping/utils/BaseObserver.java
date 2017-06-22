package bwie.com.shopping.utils;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by muhanxi on 17/6/19.
 */

public abstract  class BaseObserver implements Observer<String> {


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull String s) {


        onSuccess(s);

    }

    @Override
    public void onError(@NonNull Throwable e) {


        onFailed(0);

    }

    @Override
    public void onComplete() {

    }


    public abstract void onSuccess(String result);
    public abstract void onFailed(int code);

}

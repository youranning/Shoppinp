package bwie.com.shopping.MVP;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public abstract class MvpPresenter<T> {
   public T view;

    public void attach(T view) {

        this.view = view;

    }

    public void detach() {

        this.view = null;

    }
}

package bwie.com.shopping.MVP;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by $USER_NAME on 2017/6/21.
 */

public abstract class MvpActivity<V, T extends MvpPresenter<V>> extends Activity {
    T presenter;

    public abstract T initPresent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = initPresent();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }
}

package bwie.com.shopping.utils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by muhanxi on 17/6/19.
 */

public class IApplication extends Application {


    public static IApplication application ;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        x.Ext.init(this);



    }
}

package bwie.com.shopping.utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import bwie.com.shopping.utils.cookie.CookiesManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RetrofitFactory {



  public static OkHttpClient okHttpClient = new OkHttpClient.Builder()

            .cookieJar(new CookiesManager())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(new LoggingInterceptor())
            .build();


    public static ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://qbh.2dyt.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okHttpClient)
            //把 以前的 call 转化成 Observable
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiService.class);


    public static Observable<String> get(String url) {
        return apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    public static Observable<String> get(String url, Map<String, String> map) {

        return apiService.get(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable<String> post(String url, Map<String, String> map) {
        return apiService.post(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}






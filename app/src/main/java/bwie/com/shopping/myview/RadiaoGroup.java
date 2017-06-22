package bwie.com.shopping.myview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import bwie.com.shopping.R;

/**
 * Created by $USER_NAME on 2017/6/20.
 */

public class RadiaoGroup extends LinearLayout {
    public RadiaoGroup(Context context) {
        this(context, null);
    }

    public RadiaoGroup(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadiaoGroup(Context context, @Nullable
            AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        View view = LayoutInflater.from(context).inflate(R.layout.radiogroup, this);

        RadioGroup group = (RadioGroup) view.findViewById(R.id.tab_radiogroup);

//        RadioButton radioButtonFirst = (RadioButton) view.findViewById(R.id.radiobutton_home);
//        RadioButton radioButtonSecond = (RadioButton) view.findViewById(R.id.radiobutton_discover);
//        RadioButton radioButtonThird = (RadioButton) view.findViewById(R.id.radiobutton_feed);
//        RadioButton radioButtonFourth = (RadioButton) view.findViewById(R.id.radiobutton_me);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


                switch (checkedId) {

                    case R.id.radiobutton_home:

                        setListener(0);
                        break;

                    case R.id.radiobutton_discover:
                        setListener(1);

                        break;

                    case R.id.radiobutton_feed:
                        setListener(2);

                        break;

                    case R.id.radiobutton_me:
                        setListener(3);

                        break;
                }

            }
        });
    }

    public void setListener(int index) {

        if (listener != null) {
            listener.onSelect(index);
        }


    }


    public interface OnSelectListener {
         void onSelect(int index);
    }

    public OnSelectListener listener;

    public void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }


}

package bwie.com.shopping.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwie.com.shopping.R;
import bwie.com.shopping.bean.Index;

public class IndexFragmentRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final String base_image = "http://image3.suning.cn";

    private final int singleType = 0 ;
    private final int horizontalType = 1 ;


    private final int defaultType = 2 ;

    private Context context;

    public List<Index.DataBean> list ;

    public IndexFragmentRecycleViewAdapter(Context context, List<Index.DataBean> list){
        this.context = context;
        this.list = list ;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        RecyclerView.ViewHolder viewHolder = null ;
        switch (viewType) {

            case singleType:
                 view =  LayoutInflater.from(context).inflate(R.layout.singlepic_item,parent,false);
                viewHolder = new SinglePicViewHolder(view);

                break;
            case horizontalType:

                view =  LayoutInflater.from(context).inflate(R.layout.horizontalscroll_item,parent,false);
                viewHolder  = new HorizontalScrollViewViewHolder(view);
                break;
            default:

                view = LayoutInflater.from(context).inflate(R.layout.index_default_item,parent,false);

                viewHolder = new DefaultViewHodler(view);

                break;


        }
        return viewHolder ;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(list == null || list.size() == 0){
            return;
        }


        if(holder instanceof SinglePicViewHolder){


            SinglePicViewHolder holder1 = (SinglePicViewHolder) holder ;

           String pic =   list.get(position).getTag().get(0).getPicUrl() ;
            Glide.with(context).load(base_image+pic).into(holder1.imageView);

        }  else if(holder instanceof HorizontalScrollViewViewHolder){
            HorizontalScrollViewViewHolder horizontalScrollViewViewHolder = (HorizontalScrollViewViewHolder) holder ;
            String pic =   list.get(position).getTag().get(0).getPicUrl() ;

            Glide.with(context).load(base_image+pic).into(horizontalScrollViewViewHolder.topImageView);



            int size =  list.get(position).getTag().size();

            for(int i=1;i<size;i++){
                //图片对应的路径
                String item_pic =   list.get(position).getTag().get(i).getPicUrl();


                System.out.println("item_pic = " +base_image + item_pic);

                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setPadding(10,10,10,0);


                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(200,200));

                Glide.with(context).load(base_image+item_pic).into(imageView);


                TextView textView = new TextView(context);
                textView.setText("95");
                textView.setTextColor(Color.RED);
                textView.setTextSize(20f);
                textView.setGravity(Gravity.CENTER);




                linearLayout.addView(imageView);
                linearLayout.addView(textView);


                //
                horizontalScrollViewViewHolder.linearLayout.addView(linearLayout);



            }












        }





    }




    @Override
    public int getItemViewType(int position) {


        System.out.println("position = " + position);

        if(position == 0){
            return singleType;
        }else if(position == 1){
            return horizontalType;
        }else {
            return defaultType;
        }


    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    // 单张图片
   private class SinglePicViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView ;

        public SinglePicViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.singleitem_imageview);

        }
    }


    //水平滚动的item
    private class HorizontalScrollViewViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout ;
        ImageView topImageView ;

        public HorizontalScrollViewViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.horizontal_linearlayout);
            topImageView = (ImageView) itemView.findViewById(R.id.horizontals_imageview);

        }
    }


    private class DefaultViewHodler extends  RecyclerView.ViewHolder{

        TextView textView ;

        public DefaultViewHodler(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.indexfragment_textview);
        }
    }



}

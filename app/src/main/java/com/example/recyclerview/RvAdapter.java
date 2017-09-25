package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int[] imgs;
    List<String> textList;
    LayoutInflater layoutInflater;
    Context context;

    static final int ITEM1=0;
    static final int ITEM2=1;
    static final int ITEM3=3;
    public RvAdapter(Context context,int[] imgs, List<String> textList){
        layoutInflater = layoutInflater.from(context);
        this.context=context;
        this.imgs=imgs;
        this.textList=textList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case ITEM1:

                return new ViewHolder1(layoutInflater.inflate(R.layout.item1,null,false));

            case ITEM2:

                return new ViewHolder2(layoutInflater.inflate(R.layout.item2,null,false));

            case ITEM3:

                return new ViewHolder3(layoutInflater.inflate(R.layout.item3,null,false));

        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ITEM1;
        } else if (position==1){
            return ITEM2;
        }else {
            return ITEM3;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof ViewHolder1){
             ((ViewHolder1) holder).sliderLayout.removeAllSliders();
             for(int i=0;i<imgs.length;i++){
                 TextSliderView textSliderView=new TextSliderView(context);
                 textSliderView.
                         description(i+1+"")
                         .image(imgs[i])
                         .setScaleType(BaseSliderView.ScaleType.Fit);

                 ((ViewHolder1) holder).sliderLayout.addSlider(textSliderView);
             }
             ((ViewHolder1) holder).sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
             ((ViewHolder1) holder).sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
             ((ViewHolder1) holder).sliderLayout.setCustomAnimation(new DescriptionAnimation());
             ((ViewHolder1) holder).sliderLayout.setDuration(4000);
         }
         if(holder instanceof ViewHolder3){
             ((ViewHolder3) holder).tv.setText(textList.get(position-2));
         }
    }

    @Override
    public int getItemCount() {
        return textList.size()+2;
    }


    static class ViewHolder1 extends RecyclerView.ViewHolder{
        public SliderLayout sliderLayout;
        public ViewHolder1(View itemView) {
            super(itemView);
            sliderLayout= (SliderLayout) itemView.findViewById(R.id.slider);
        }
    }
    static class ViewHolder2 extends RecyclerView.ViewHolder{

        public ViewHolder2(View itemView) {
            super(itemView);
        }
    }
    static class ViewHolder3 extends RecyclerView.ViewHolder{
        public TextView tv;
        public ViewHolder3(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.mTv);
        }
    }
}

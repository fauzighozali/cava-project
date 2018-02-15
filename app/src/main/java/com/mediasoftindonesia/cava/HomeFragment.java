package com.mediasoftindonesia.cava;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{

    android.support.v7.widget.Toolbar toolbarWidget;
    SliderLayout sliderLayout;

    // cek GIT

    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        toolbarWidget = (Toolbar) getActivity().findViewById(R.id.toolbar);
        //toolbarWidget.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarWidget);

        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);

        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);

        AddImageUrlFormLocalRes();
        for (String named : HashMapForLocalRes.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(getActivity());
            textSliderView
                    .description(named)
                    .image(HashMapForLocalRes.get(named))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",named);

            sliderLayout.addSlider(textSliderView);

        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(HomeFragment.this);
        sliderLayout.setCustomIndicator((PagerIndicator) view.findViewById(R.id.custom_indicator));

        return view;

    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    private void AddImageUrlFormLocalRes() {
        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("cek1", R.drawable.banner_ads1);
        HashMapForLocalRes.put("cek2", R.drawable.banner_ads1);
        HashMapForLocalRes.put("cek3", R.drawable.banner_ads1);
        HashMapForLocalRes.put("cek4", R.drawable.banner_ads1);
        HashMapForLocalRes.put("cek5", R.drawable.banner_ads1);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

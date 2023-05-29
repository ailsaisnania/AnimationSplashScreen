package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    OnBoardingAdapter onBoardingAdapter;
    LottieAnimationView lottieAnimationView;
    LinearLayout layoutOnBoarding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        layoutOnBoarding = findViewById(R.id.layoutboarding);

        SetupOnBoardingItems();
        final ViewPager2 onBoardingViewPager = findViewById(R.id.OnBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicator();
        setCurrentOnBoarding(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoarding(position);
            }
        });
    }

    private void SetupOnBoardingItems(){
        List<OnBoardingItems> onBoardingItems = new ArrayList<>();

        OnBoardingItems delivery = new OnBoardingItems();
        delivery.setTitle("Fast Delivery");
        delivery.setDescription("Your order will delivered in one blink of eye");
        delivery.setImage(R.drawable.motor);

        OnBoardingItems payment = new OnBoardingItems();
        payment.setTitle("Easy Order, Easy Payment");
        payment.setDescription("pay with QRIS and minimize direct contact ");
        payment.setImage(R.drawable.pymeny);

        OnBoardingItems items = new OnBoardingItems();
        items.setTitle("Become Healthier");
        items.setDescription("Made with fresh fruits from Jeju Island");
        items.setImage(R.drawable.buah);

        onBoardingItems.add(payment);
        onBoardingItems.add(delivery);
        onBoardingItems.add(items);




        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);

    }

    private void setupOnBoardingIndicator(){
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8,0,8,0);
        for (int i=0; i < indicators.length;i++){
            indicators[i] = new ImageView((getApplicationContext()));
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicate_innactive));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoarding.addView(indicators[i]);
        }
    }

    private void setCurrentOnBoarding(int index){
        int childCount = layoutOnBoarding.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutOnBoarding.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicates_active)
                );
            }
            else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicate_innactive));
            }
        }
    }
}
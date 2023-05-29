package com.example.splashscreenapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingView>{
    private List<OnBoardingItems> onBoardingItems;

    public OnBoardingAdapter(List<OnBoardingItems> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingView(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.onboarding_items, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingView holder, int position) {
        holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingView extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private ImageView ImageOnBoarding;



        public OnBoardingView(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.title);
            textDescription = itemView.findViewById(R.id.description);
            ImageOnBoarding= itemView.findViewById(R.id.imageOnBoarding);

        }

        void setOnBoardingData(OnBoardingItems onBoardingItems){
            textTitle.setText(onBoardingItems.getTitle());
            textDescription.setText(onBoardingItems.getDescription());
            ImageOnBoarding.setImageResource(onBoardingItems.getImage());

        }
    }
}

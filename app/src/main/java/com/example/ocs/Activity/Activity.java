package com.example.ocs.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.ocs.R;

public class Activity extends AppCompatActivity {

    public TextView tabItem1, tabItem2, tabItem3, tabItem4;
    private int selectedTabNumber=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tabItem1 = findViewById(R.id.tabItem1);
        tabItem2=findViewById(R.id.tabItem2);
        tabItem3=findViewById(R.id.tabItem3);
        tabItem4=findViewById(R.id.tabItem4);

        //selecting first fragment by default
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, DrinksFragment.class, null). commit();

        tabItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(1);
            }
        });

        tabItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);
            }
        });

        tabItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(3);
            }
        });

        tabItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(4);
            }
        });
    }

    private void selectTab(int tabNumber){
        TextView selectedTextView;
        TextView nonSelectedView1;
        TextView nonSelectedView2;
        TextView nonSelectedView3;

        //if you have more than three tabs than create nonSelectedView 3
        if(tabNumber==1){
            //user selected first tab, so first tab is displayed
            //other three tabs are non selected

            selectedTextView=tabItem1;
            nonSelectedView1=tabItem2;
            nonSelectedView2=tabItem3;
            nonSelectedView3=tabItem4;

            //setting fragment  to the fragment container view
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, DrinksFragment.class, null).commit();
        }else if(tabNumber ==2){

            selectedTextView=tabItem2;
            nonSelectedView1=tabItem1;
            nonSelectedView2=tabItem3;
            nonSelectedView3=tabItem4;

            //setting fragment  to the fragment container view
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, FastFoodFragment.class, null).commit();
        }else if(tabNumber==3){
            selectedTextView=tabItem3;
            nonSelectedView1=tabItem2;
            nonSelectedView2=tabItem1;
            nonSelectedView3=tabItem4;

            //setting fragment  to the fragment container view
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, SnacksFragment.class, null).commit();
        }else{
            selectedTextView=tabItem4;
            nonSelectedView1=tabItem2;
            nonSelectedView2=tabItem1;
            nonSelectedView3=tabItem3;

            //setting fragment  to the fragment container view
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, VegetablesFragment.class, null).commit();
        }

        float slideTo=(tabNumber-selectedTabNumber) * selectedTextView.getWidth();

        //creating translate animation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, slideTo, 0, 0);
        translateAnimation.setDuration(100);

        //checking for previously slected tab
        if(selectedTabNumber==1){
            tabItem1.startAnimation(translateAnimation);
        }else if(selectedTabNumber==2){
            tabItem2.startAnimation(translateAnimation);
        }else if(selectedTabNumber==3){
            tabItem3.startAnimation(translateAnimation);
        }else{
            tabItem4.startAnimation(translateAnimation);
        }

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //change design of selected tab's TextView
                selectedTextView.setBackgroundResource(R.drawable.round_border);
                selectedTextView.setTypeface(null, Typeface.BOLD);
                selectedTextView.setTextColor(Color.BLACK);

                //Change design of non selected tab's TextViews
                nonSelectedView1.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedView1.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedView1.setTypeface(null, Typeface.NORMAL);

                nonSelectedView2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedView2.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedView2.setTypeface(null, Typeface.NORMAL);

                nonSelectedView3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedView3.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedView3.setTypeface(null, Typeface.NORMAL);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        selectedTabNumber=tabNumber;
    }
}
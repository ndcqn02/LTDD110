package com.example.luonguisiginsingupprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    ListView lvBanBe;
    ArrayList<BanBe> arrayBanBe;
    BanBeAdapter adapter;

    Button btnThem;
    EditText edt;
    int vitri;

    //number of selected tab. we have 4 tab so value must lie between 1-4.
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final LinearLayoutCompat homeLayout = findViewById(R.id.homeLayout);
        final LinearLayoutCompat likeLayout = findViewById(R.id.likeLayout);
        final LinearLayoutCompat notificationLayout = findViewById(R.id.notificationLayout);
        final LinearLayoutCompat profileLayout = findViewById(R.id.profileLayout);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView likeImage = findViewById(R.id.likeImage);
        final ImageView notificationImage = findViewById(R.id.notificationImage);
        final ImageView profileImage = findViewById(R.id.profileImage);


        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView likeTxt = findViewById(R.id.likeTxt);
        final TextView notificationTxt = findViewById(R.id.notificationTxt);
        final TextView profileTxt = findViewById(R.id.profileTxt);


        //set home fragment by default
        /*getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, HomeFragment.class, null)
                .commit();*/

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 1) {
                    // home

                    //set home fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, HomeFragment.class, null)
                            .commit();

                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    likeImage.setImageResource(R.drawable.like_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //select tab
                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.home_selected_icon);
//                    homeLayout.setBackgroundResource(R.drawable.round_back_home_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    selectedTab = 1;
                }
            }
        });

        likeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 2) {
                    //like

                    //set fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, LikeFragment.class, null)
                            .commit();

                    homeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    homeImage.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //select tab
                    likeTxt.setVisibility(View.VISIBLE);
                    likeImage.setImageResource(R.drawable.like_selected_icon);
                    likeLayout.setBackgroundResource(R.drawable.round_back_like_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    likeLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 3) {
                    //notification

                    //set fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, BanBeFragment.class, null)
                            .commit();

                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    likeImage.setImageResource(R.drawable.like_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    homeImage.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //select tab
                    notificationTxt.setVisibility(View.VISIBLE);
                    notificationImage.setImageResource(R.drawable.notification_selected_icon);
                    notificationLayout.setBackgroundResource(R.drawable.round_back_notification_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    notificationLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 4) {
                    //profile

                    //set fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, ProfileFragment.class, null)
                            .commit();


                    homeTxt.setVisibility(View.GONE);
                    likeTxt.setVisibility(View.GONE);
                    notificationTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    likeImage.setImageResource(R.drawable.like_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);

                    homeImage.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    likeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //select tab
                    profileTxt.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.profile_selected_icon);
                    profileLayout.setBackgroundResource(R.drawable.round_back_profile_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;
                }
            }
        });


    }
}
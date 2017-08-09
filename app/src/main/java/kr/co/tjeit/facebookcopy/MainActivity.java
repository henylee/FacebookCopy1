package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.co.tjeit.facebookcopy.fragment.FriendRequestFragment;
import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewsfeedFragment;
import kr.co.tjeit.facebookcopy.fragment.NotificationFragment;
import kr.co.tjeit.facebookcopy.fragment.SeeMoreFragment;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

public class MainActivity extends AppCompatActivity {

    ViewPager mainViewPager;
    private android.widget.LinearLayout newsfeedBtnLayout;
    private android.widget.LinearLayout requestBtnLayout;
    private android.widget.LinearLayout messageBtnLayout;
    private android.widget.LinearLayout notificationBtnLayout;
    private android.widget.LinearLayout seeMoreBtnLayout;
    private android.widget.TextView titleTxt;
    private LinearLayout orderbarBtnLayout;
    private LinearLayout statusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {
        GrobalDatas.initDats();
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void setupEvents() {

        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditStatusActivity.class);
                startActivity(intent);
            }
        });

        View.OnClickListener pageChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pagenum = Integer.parseInt(v.getTag()+"");
                mainViewPager.setCurrentItem(pagenum);
            }
        };

        newsfeedBtnLayout.setOnClickListener(pageChangeListener);
        requestBtnLayout.setOnClickListener(pageChangeListener);
        messageBtnLayout.setOnClickListener(pageChangeListener);
        notificationBtnLayout.setOnClickListener(pageChangeListener);
        seeMoreBtnLayout.setOnClickListener(pageChangeListener);

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    titleTxt.setText("뉴스피드");
                    orderbarBtnLayout.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    titleTxt.setText("요청");
                    orderbarBtnLayout.setVisibility(View.GONE);
                } else if (position == 2) {
                    titleTxt.setText("메세지");
                    orderbarBtnLayout.setVisibility(View.GONE);
                } else if (position == 3) {
                    titleTxt.setText("알림");
                    orderbarBtnLayout.setVisibility(View.GONE);
                } else {
                    titleTxt.setText("더 보기");
                    orderbarBtnLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void bindViews() {

        this.seeMoreBtnLayout = (LinearLayout) findViewById(R.id.seeMoreBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.notificationBtnLayout = (LinearLayout) findViewById(R.id.notificationBtnLayout);
        this.requestBtnLayout = (LinearLayout) findViewById(R.id.requestBtnLayout);
        this.newsfeedBtnLayout = (LinearLayout) findViewById(R.id.newsfeedBtnLayout);
        this.mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        this.orderbarBtnLayout = (LinearLayout) findViewById(R.id.orderbarBtnLayout);
        this.statusBtn = (LinearLayout) findViewById(R.id.statusBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return new NewsfeedFragment();
            }
            else if (position == 1) {
                return new FriendRequestFragment();
            } else if (position == 2) {
                return new MessageFragment();
            } else if (position == 3) {
                return new NotificationFragment();
            } else {
                return new SeeMoreFragment();
            }

        }
    }
}











package asus.com.bwie.marketcxy.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import asus.com.bwie.marketcxy.R;
import asus.com.bwie.marketcxy.adapter.HomePageAdapter;
import asus.com.bwie.marketcxy.fragment.BillFragment;
import asus.com.bwie.marketcxy.fragment.CircleFragment;
import asus.com.bwie.marketcxy.fragment.MyFragment;
import asus.com.bwie.marketcxy.fragment.ShopCarFragment;
import asus.com.bwie.marketcxy.fragment.ShopShowFragment;

public class HomeActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vp = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
        List<Fragment> list=new ArrayList<>();

        list.add(new ShopShowFragment());
        list.add(new CircleFragment());
        list.add(new ShopCarFragment());
        list.add(new BillFragment());
        list.add(new MyFragment());

        HomePageAdapter myPagerAdapter=new HomePageAdapter(getSupportFragmentManager(), (ArrayList<Fragment>) list);
        vp.setAdapter(myPagerAdapter);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home_button_home:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.home_button_circle:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.home_button_shop:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.home_button_bill:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.home_button_my:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.home_button_home);
                        break;
                    case 1:
                        radioGroup.check(R.id.home_button_circle);
                        break;
                    case 2:
                        radioGroup.check(R.id.home_button_shop);
                        break;
                    case 3:
                        radioGroup.check(R.id.home_button_bill);
                        break;
                    case 4:
                        radioGroup.check(R.id.home_button_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}

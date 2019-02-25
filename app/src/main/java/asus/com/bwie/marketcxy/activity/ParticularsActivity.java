package asus.com.bwie.marketcxy.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asus.com.bwie.marketcxy.Apis;
import asus.com.bwie.marketcxy.R;
import asus.com.bwie.marketcxy.bean.AddShopCarBean;
import asus.com.bwie.marketcxy.bean.Goods;
import asus.com.bwie.marketcxy.bean.ShopCarBean;
import asus.com.bwie.marketcxy.bean.ShopParticularsBean;
import asus.com.bwie.marketcxy.presenter.PresenterImpl;
import asus.com.bwie.marketcxy.view.Iview;

public class ParticularsActivity extends AppCompatActivity implements Iview {

    private String pid;
    private PresenterImpl ipresenter;
    private Banner banner;
    private TextView shopxq_name;
    private TextView shopxq_price;
    private TextView shopxq_saleNum;
    private TextView shopxq_xq;
    private WebView webView;
    private ImageView pzmore;
    private ImageView mlmore;
    private ImageView rxmore;
    private Button add_shopCar;
    private AddShopCarBean addShopCarBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);

        banner = findViewById(R.id.banner);
        shopxq_name = findViewById(R.id.shopxq_name);
        shopxq_price = findViewById(R.id.shopxq_price);
        shopxq_saleNum = findViewById(R.id.shopxq_saleNum);
        shopxq_xq = findViewById(R.id.shopxq_xq);
        webView = findViewById(R.id.webView);
        rxmore = findViewById(R.id.rxmore);
        mlmore = findViewById(R.id.mlmore);
        pzmore = findViewById(R.id.pzmore);
        add_shopCar = findViewById(R.id.add_shopCar);


        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        Toast.makeText(this, pid, Toast.LENGTH_SHORT).show();
        ipresenter = new PresenterImpl(this);


        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(ParticularsActivity.this).load(path).into(imageView);
            }
            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
        ipresenter.get(Apis.ShopXQPath + "?commodityId=" + pid, ShopParticularsBean.class);


        add_shopCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chaShopCar();

                Toast.makeText(ParticularsActivity.this, "" + pid, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void chaShopCar() {
        ipresenter.get(Apis.ShopCarPath,ShopCarBean.class);
    }

    private void addShop(List<Goods> list) {
        String string="[";
        if (list.size()==0){
            list.add(new Goods(Integer.valueOf(pid),1));
        }else {
            for(int i=0;i<list.size();i++) {
                if (Integer.valueOf(pid) == list.get(i).getCommodityId()) {
                    int count=list.get(i).getCount();
                    count++;
                    list.get(i).setCount(count);
                    break;
                }
                else if(i==list.size()-1){
                    list.add(new Goods(Integer.valueOf(pid),1));
                    break;
                }
            }
        }


        for (Goods goods:list){
            string+="{\"commodityId\":"+goods.getCommodityId()+",\"count\":"+goods.getCount()+"},";
        }
        String substring = string.substring(0, string.length() - 1);
        substring+="]";
        Log.i("TAG",substring);
        Map<String,String> map=new HashMap<>();
        map.put("data",substring);
        ipresenter.put(Apis.addShopCarPath,map,AddShopCarBean.class);

    }


    @Override
    public void onSuccessData(Object data) {

        if (data instanceof ShopParticularsBean) {
            List<String> list = new ArrayList<>();
            ShopParticularsBean bean = (ShopParticularsBean) data;
            ShopParticularsBean.ResultBean result = bean.getResult();
            String[] split = result.getPicture().split(",");
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
            banner.setImages(list);
            banner.start();

            shopxq_name.setPaintFlags(Paint.FAKE_BOLD_TEXT_FLAG);
            shopxq_price.setText("￥：" + bean.getResult().getPrice() + ".00");
            shopxq_name.setText(bean.getResult().getCommodityName() + "");
            shopxq_saleNum.setText("已售" + bean.getResult().getSaleNum() + "件");
            shopxq_xq.setText(bean.getResult().getDescribe());
            webView.loadDataWithBaseURL(null, bean.getResult().getDetails(), "text/html", "utf-8", null);

        } else if (data instanceof ShopCarBean){
            ShopCarBean bean= (ShopCarBean) data;
            if (bean.getStatus().equals("0000")){
                List<Goods> list=new ArrayList<>();
                List<ShopCarBean.ResultBean> resultBeans=bean.getResult();
                for (ShopCarBean.ResultBean resultBean:resultBeans){
                    list.add(new Goods(resultBean.getCommodityId(),resultBean.getCount()));

                }
                addShop(list);
                Toast.makeText(ParticularsActivity.this,bean.getMessage(),Toast.LENGTH_SHORT).show();
            } else if (data instanceof AddShopCarBean) {
                AddShopCarBean addShopCarBean = (AddShopCarBean) data;
                Toast.makeText(ParticularsActivity.this, data + "", Toast.LENGTH_SHORT).show();
                Log.e("cxy", addShopCarBean.getMessage());


            }


        }


    }

    @Override
    public void onFailData(Exception e) {

        List<Goods> list=new ArrayList<>();
        list.add(new Goods(Integer.valueOf(pid),1));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.setVisibility(View.GONE);
            webView.removeAllViews();
            webView.destroy();
        }

    }

}
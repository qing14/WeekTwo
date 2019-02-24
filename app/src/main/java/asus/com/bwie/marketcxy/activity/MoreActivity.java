package asus.com.bwie.marketcxy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import asus.com.bwie.marketcxy.Apis;
import asus.com.bwie.marketcxy.R;
import asus.com.bwie.marketcxy.adapter.MoreAdapter;
import asus.com.bwie.marketcxy.bean.ClickMoreBean;
import asus.com.bwie.marketcxy.presenter.PresenterImpl;
import asus.com.bwie.marketcxy.utils.SpaceItemDecoration;
import asus.com.bwie.marketcxy.view.Iview;

public class MoreActivity extends AppCompatActivity implements Iview {

    private int pznum=2;
    private MoreAdapter moreAdapter;
    private RecyclerView moreView;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pzsh);
        PresenterImpl presenter=new PresenterImpl(this);
        moreView = findViewById(R.id.moreRecycleView);
        gridLayoutManager = new GridLayoutManager(MoreActivity.this,pznum);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        moreView.setLayoutManager(gridLayoutManager);
        Intent intent = getIntent();
        String num = intent.getStringExtra("num");
        presenter.get(Apis.MoreShopPath+"?labelId="+num+"&page=1&count=10",ClickMoreBean.class);
        moreAdapter = new MoreAdapter(this);
        moreView.addItemDecoration(new SpaceItemDecoration(10));
        moreView.setAdapter(moreAdapter);
        moreAdapter.setOnMoreClickListenter(new MoreAdapter.MoreClickListenter() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(MoreActivity.this,ParticularsActivity.class);
                int pid = moreAdapter.getPid(position);
                Bundle bundle=new Bundle();
                bundle.putString("pid",pid+"");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccessData(Object data) {
        if (data instanceof ClickMoreBean){
            ClickMoreBean clickMoreBean= (ClickMoreBean) data;
            moreAdapter.setResultBeans(clickMoreBean.getResult());
        }
    }

    @Override
    public void onFailData(Exception e) {

    }
}

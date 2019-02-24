package asus.com.bwie.marketcxy.presenter;

import java.util.Map;

import asus.com.bwie.marketcxy.callback.MyCallBack;
import asus.com.bwie.marketcxy.model.ModelImpl;
import asus.com.bwie.marketcxy.view.Iview;

public class PresenterImpl implements Ipresenter {
    private ModelImpl modelimpl;
    private Iview iview;


    public PresenterImpl(Iview iview) {
        this.modelimpl = new ModelImpl();
        this.iview = iview;
    }
    //get
    @Override
    public void get(String urlData, Class clazz) {
        modelimpl.get(urlData, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iview.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iview.onFailData(e);
            }
        });
    }
    //getcircle
    @Override
    public void getCircle(String urlData, int page, int count, Class clazz) {
        modelimpl.getCircleData(urlData, page, count, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iview.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iview.onFailData(e);
            }
        });
    }
    //post
    @Override
    public void post(String urlData, Map<String, String> map, Class clazz) {
        modelimpl.post(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iview.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iview.onFailData(e);
            }
        });
    }
    //put
    @Override
    public void put(String urlData, Map<String, String> map, Class clazz) {
        modelimpl.put(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iview.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iview.onFailData(e);
            }
        });
    }
    //delete
    @Override
    public void delete(String urlData, Map<String, String> map, Class clazz) {
        modelimpl.delete(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iview.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iview.onFailData(e);
            }
        });
    }
    public void detach(){
        modelimpl=null;
        iview=null;
    }
}

package asus.com.bwie.marketcxy.model;

import java.util.Map;

import asus.com.bwie.marketcxy.callback.MyCallBack;

public interface Imodel {
    //get
    void get(String urlData,Class clazz,MyCallBack myCallBack);
    //get圈子列表
    void getCircleData(String urlData,int page,int count,Class clazz,MyCallBack myCallBack);
    //post
    void post(String urlData, Map<String,String> map, Class clazz, MyCallBack myCallBack);
    //put
    void put(String urlData,Map<String,String> map,Class clazz,MyCallBack myCallBack);
    //delete
    void delete(String urlData,Map<String,String> map,Class clazz,MyCallBack myCallBack);

}

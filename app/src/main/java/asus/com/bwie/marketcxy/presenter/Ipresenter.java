package asus.com.bwie.marketcxy.presenter;

import java.util.Map;

public interface Ipresenter {
    //get
    void get(String urlData,Class clazz);
    //get圈子列表
    void getCircle(String urlData,int page,int count, Class clazz );
    //post
    void post(String urlData, Map<String,String> map, Class clazz);
    //put
    void put(String urlData,Map<String,String> map,Class clazz);
    //delete
    void delete(String urlData,Map<String,String> map,Class clazz);
}

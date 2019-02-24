package asus.com.bwie.marketcxy.model;

import com.google.gson.Gson;

import java.util.Map;

import asus.com.bwie.marketcxy.callback.MyCallBack;
import asus.com.bwie.marketcxy.utils.RetrofitUtils;

public class ModelImpl implements Imodel {

    /**
     * get
     *
     * @param urlData
     * @param clazz
     * @param myCallBack
     */
    @Override
    public void get(String urlData, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().get(urlData, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    /**
     * getCirecleData 获取圈子
     *
     * @param urlData
     * @param page
     * @param count
     * @param clazz
     * @param myCallBack
     */
    @Override
    public void getCircleData(String urlData, int page, int count, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().getCircle(urlData, page, count, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    /**
     * post
     *
     * @param urlData
     * @param map
     * @param clazz
     * @param myCallBack
     */
    @Override
    public void post(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().post(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    /**
     * put
     *
     * @param urlData
     * @param map
     * @param clazz
     * @param myCallBack
     */
    @Override
    public void put(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().put(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    /**
     * delete
     *
     * @param urlData
     * @param map
     * @param clazz
     * @param myCallBack
     */

    @Override
    public void delete(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().del(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}

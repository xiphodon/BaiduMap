package com.gc.buaa.baidumap.activity;


import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.RoutePlanSearch;

/**
 * 路线规划搜索基类
 */
public abstract class RoutePlanSearchBaseActivity extends BaseActivity implements OnGetRoutePlanResultListener {

    protected RoutePlanSearch routePlanSearch;

    @Override
    public void init() {
        routePlanSearch = RoutePlanSearch.newInstance();
        routePlanSearch.setOnGetRoutePlanResultListener(this);
        routePlanSearchInit();
    }

    /** 路径搜索初化代码写在这个方法 中*/
    public abstract void routePlanSearchInit();
}

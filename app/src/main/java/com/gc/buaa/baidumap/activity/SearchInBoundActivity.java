package com.gc.buaa.baidumap.activity;


import android.view.View;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;

/**
 * 范围内搜索
 */
public class SearchInBoundActivity extends PoiSearchBaseActivity {

    @Override
    public void poiSearchInit() {
        btn_1.setVisibility(View.GONE);
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);


        poiSearch.searchInBound(getSearchParams());
    }

    private PoiBoundSearchOption getSearchParams() {
        PoiBoundSearchOption params = new PoiBoundSearchOption();

        // 指定搜索范围，由一个西南点和一个东北点组成的范围
        LatLngBounds bounds = new LatLngBounds.Builder().include(new LatLng(40.048459,116.302072))
                .include(new LatLng(40.050675,116.304317)).build();
        params.bound(bounds);	// 指定搜索范围
        params.keyword("加油站");	// 指定搜索什么内容
        return params;
    }

    /** 获取兴趣点详情信息 */
    @Override
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

    }
}

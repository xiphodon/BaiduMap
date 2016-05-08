package com.gc.buaa.baidumap.activity;

import android.view.View;

import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;

/**
 * 在周边搜索
 */
public class SearchInNearbyActivity extends PoiSearchBaseActivity {

    @Override
    public void poiSearchInit() {

        btn_1.setVisibility(View.GONE);
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);

        poiSearch.searchNearby(getSearchParams());
    }


    private PoiNearbySearchOption getSearchParams() {
        PoiNearbySearchOption params = new PoiNearbySearchOption();
        params.location(tamPos);	// 指定在哪个位置搜索
        params.radius(1000);	// 指定搜索范围半径（米）
        params.keyword("银行");	// 指定搜索的内容
        return params;
    }


    /** 获取兴趣点详情信息 */
    @Override
    public void onGetPoiDetailResult(PoiDetailResult result) {

    }
}

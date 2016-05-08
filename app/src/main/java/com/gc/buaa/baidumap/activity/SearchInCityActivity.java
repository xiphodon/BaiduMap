package com.gc.buaa.baidumap.activity;


import android.view.View;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;

public class SearchInCityActivity extends PoiSearchBaseActivity implements View.OnClickListener{

    private int pageNum;

    @Override
    public void poiSearchInit() {
        btn_1.setText("下一页");
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);

        btn_1.setOnClickListener(this);

        poiSearch.searchInCity(getSearchParams());

    }

    @Override
    public boolean onPoiClick(int index) {
        // 当点击一个搜索出来的兴趣点的时候，再去搜索更详细的内容
        PoiInfo poiInfo = poiOverlay.getPoiResult().getAllPoi().get(index);
        poiSearch.searchPoiDetail(getSearchDetailParams(poiInfo.uid));
        return true;
    }

    private PoiDetailSearchOption getSearchDetailParams(String poiUid) {
        PoiDetailSearchOption params = new PoiDetailSearchOption();
        params.poiUid(poiUid);
        return params;
    }

    private PoiCitySearchOption getSearchParams() {
        PoiCitySearchOption params = new PoiCitySearchOption();
        params.city("北京");			// 指定在哪个城市内进行搜索
        params.keyword("加油站");		// 指定搜索的是什么内容
        params.pageCapacity(10);	// 设置一页获取10条数据
        params.pageNum(pageNum);	// 指定获取哪一页
        return params;
    }

    /** 获取到详情信息的回调方法 */
    @Override
    public void onGetPoiDetailResult(PoiDetailResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            showToast("没有搜索到详情信息");
            return ;
        }

        showToast(result.getShopHours() + ", " + result.getTelephone());
    }

    @Override
    public void onClick(View v) {
        // 获取下一页数据
        pageNum++;
        poiSearch.searchInCity(getSearchParams());
    }
}

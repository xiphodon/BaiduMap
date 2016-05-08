package com.gc.buaa.baidumap.activity;

import android.view.View;

import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.gc.buaa.baidumap.utils.overlayutil.DrivingRouteOverlay;

import java.util.ArrayList;
import java.util.List;

/**
 * 驾车路线搜索
 */
public class DrivingSearchActivity extends RoutePlanSearchBaseActivity {

    @Override
    public void routePlanSearchInit() {
        btn_1.setVisibility(View.GONE);
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);

        routePlanSearch.drivingSearch(getSearchParams());
    }

    private DrivingRoutePlanOption getSearchParams() {
        DrivingRoutePlanOption params = new DrivingRoutePlanOption();
        List<PlanNode> nodes = new ArrayList<PlanNode>();
        nodes.add(PlanNode.withCityNameAndPlaceName("北京市", "天安门"));
        params.from(PlanNode.withLocation(eqtPos));	// 设置起点
        params.passBy(nodes);						// 设置途经点
        params.to(PlanNode.withLocation(kjcPos));	// 设置终点
        return params;
    }

    /** 获取驾车搜索结果的回调方法 */
    @Override
    public void onGetDrivingRouteResult(DrivingRouteResult result) {
        DrivingRouteOverlay overlay = new DrivingRouteOverlay(baiduMap);
        baiduMap.setOnMarkerClickListener(overlay);
        List<DrivingRouteLine> routeLines = result.getRouteLines();	// 获取到所有的搜索路线，最优化的路线会在集合的前面
        overlay.setData(routeLines.get(0));	// 把搜索结果设置到覆盖物
        overlay.addToMap();					// 把搜索结果添加到地图
        overlay.zoomToSpan();				// 把搜索结果在一个屏幕内显示完
    }

    /** 获取自行车搜索结果的回调方法 */
    @Override
    public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

    }

    /** 获取换乘（公交、地铁）搜索结果的回调方法 */
    @Override
    public void onGetTransitRouteResult(TransitRouteResult result) {
    }

    /** 获取步行搜索结果的回调方法 */
    @Override
    public void onGetWalkingRouteResult(WalkingRouteResult result) {
    }
}

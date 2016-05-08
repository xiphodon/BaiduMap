package com.gc.buaa.baidumap.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.gc.buaa.baidumap.R;
import com.gc.buaa.baidumap.utils.Utils;

/**
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected static final String TAG = "test";

    /** 天安门坐标 */
    protected LatLng tamPos = new LatLng(39.915112,116.403963);
    /**科教城坐标*/
    protected LatLng kjcPos = new LatLng(32.180054,121.381525);


    protected MapView mapView;
    protected BaiduMap baiduMap;

    protected Button btn_1;
    protected Button btn_2;
    protected Button btn_3;
    protected Button btn_4;
    protected Button btn_5;

    // 这里加final是为了不让子类覆盖，原因是为了预防这里的一些类还没初始化的时候就被子类调用
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_baidu_map);

        //获取地图控件引用
        mapView = (MapView) findViewById(R.id.bmapView);

        // 1.	隐藏缩放按钮、比例尺
        // mapView.showScaleControl(false);	// 隐藏比例按钮，默认是显示的
        // mapView.showZoomControls(false);	// 隐藏缩放按钮，默认是显示的

        // 获取地图控制器
        baiduMap = mapView.getMap();

        // 2.   获取最小缩放级别（3.0）、最大缩放级别（20.0）
        float maxZoomLevel = baiduMap.getMaxZoomLevel(); // 获取地图最大缩放级别
        float minZoomLevel = baiduMap.getMinZoomLevel(); // 获取地图最小缩放级别
        Log.i(TAG, "minZoomLevel = " + minZoomLevel + ", maxZoomLevel" + maxZoomLevel);

        // 3.	设置地图中心点为科教城(维度，经度)
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(kjcPos);
        baiduMap.setMapStatus(mapStatusUpdate);

        // 4.	设置地图缩放为15
        mapStatusUpdate = MapStatusUpdateFactory.zoomTo(15);
        baiduMap.setMapStatus(mapStatusUpdate);

        // 6.	获取地图Ui控制器：隐藏指南针
        // UiSettings uiSettings = baiduMap.getUiSettings();
        // uiSettings.setCompassEnabled(false);	//  不显示指南针

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);

        init();
    }

    /** 这个方法让子类实现 */
    public abstract void init();

    /**
     * 在屏幕中央显示一个Toast
     * @param text
     */
    public void showToast(CharSequence text) {
        Utils.showToast(this,text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }
}

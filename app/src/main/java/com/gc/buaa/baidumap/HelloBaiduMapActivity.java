package com.gc.buaa.baidumap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

/**
 * 百度地图基础功能
 */
public class HelloBaiduMapActivity extends BaseAcivity implements View.OnClickListener {



    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private MapStatusUpdate mapStatusUpdate;

    @Override
    public void init() {


        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }


    /**
     * 按钮
     * @param v
     */
    @Override
    public void onClick(View v) {
        // 5.	更新地图状态
        mapStatusUpdate = null;
        switch (v.getId()) {
            case R.id.btn_1:
                // 		1)	缩小
                mapStatusUpdate = MapStatusUpdateFactory.zoomOut();
                baiduMap.setMapStatus(mapStatusUpdate);
                break;

            case R.id.btn_2:
                // 		2)	放大
                mapStatusUpdate = MapStatusUpdateFactory.zoomIn();
                baiduMap.setMapStatus(mapStatusUpdate);
                break;

            case R.id.btn_3:
                // 		3)	旋转（0 ~ 360），每次在原来的基础上再旋转30度
                MapStatus currentMapStatus = baiduMap.getMapStatus();    // 获取地图当前的状态
                float rotate = currentMapStatus.rotate + 30;
                Log.i(TAG, "rotate = " + rotate);
                MapStatus mapStatus = new MapStatus.Builder().rotate(rotate).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                baiduMap.setMapStatus(mapStatusUpdate);
                break;

            case R.id.btn_4:
                // 		4)	俯仰（0 ~ -45），每次在原来的基础上再俯仰-5度
                currentMapStatus = baiduMap.getMapStatus();    // 获取地图当前的状态
                float overlook = currentMapStatus.overlook - 5;
                Log.i(TAG, "overlook = " + overlook);
                mapStatus = new MapStatus.Builder().overlook(overlook).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                baiduMap.setMapStatus(mapStatusUpdate);
                break;

            case R.id.btn_5:
                // 		5)	移动  移动到天安门
                mapStatusUpdate = MapStatusUpdateFactory.newLatLng(tamPos);
                //动画移动到该位置
                baiduMap.animateMapStatus(mapStatusUpdate, 2000);
                break;
        }
    }



    /**
     * 按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 5.	更新地图状态
        MapStatusUpdate mapStatusUpdate = null;
        switch (keyCode) {
            case KeyEvent.KEYCODE_1:
                // 		1)	缩小
                mapStatusUpdate = MapStatusUpdateFactory.zoomOut();
                break;
            case KeyEvent.KEYCODE_2:
                // 		2)	放大
                mapStatusUpdate = MapStatusUpdateFactory.zoomIn();
                break;
            case KeyEvent.KEYCODE_3:
                // 		3)	旋转（0 ~ 360），每次在原来的基础上再旋转30度
                MapStatus currentMapStatus = baiduMap.getMapStatus();    // 获取地图当前的状态
                float rotate = currentMapStatus.rotate + 30;
                Log.i(TAG, "rotate = " + rotate);
                MapStatus mapStatus = new MapStatus.Builder().rotate(rotate).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);

                break;
            case KeyEvent.KEYCODE_4:
                // 		4)	俯仰（0 ~ -45），每次在原来的基础上再俯仰-5度
                currentMapStatus = baiduMap.getMapStatus();    // 获取地图当前的状态
                float overlook = currentMapStatus.overlook - 5;
                Log.i(TAG, "overlook = " + overlook);
                mapStatus = new MapStatus.Builder().overlook(overlook).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);

                break;
            case KeyEvent.KEYCODE_5:
                // 		5)	移动  移动到天安门
                mapStatusUpdate = MapStatusUpdateFactory.newLatLng(tamPos);
                //动画移动到该位置
                baiduMap.animateMapStatus(mapStatusUpdate, 2000);
                return super.onKeyDown(keyCode, event);
        }
        baiduMap.setMapStatus(mapStatusUpdate);
        return super.onKeyDown(keyCode, event);
    }


}


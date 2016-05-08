package com.gc.buaa.baidumap.activity;

import android.view.View;

import com.baidu.mapapi.map.BaiduMap;
import com.gc.buaa.baidumap.R;

/**
 * 图层
 * Created by Administrator on 2016/5/8.
 */
public class MapLayerActivity extends BaseActivity implements View.OnClickListener {
    @Override
    public void init() {
        btn_1.setText("普通地图");
        btn_2.setText("卫星图");
        btn_3.setText("交通图");
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                // 显示普通地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                baiduMap.setTrafficEnabled(false);
                break;

            case R.id.btn_2:
                // 显示卫星图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                baiduMap.setTrafficEnabled(false);
                break;

            case R.id.btn_3:
                // 交通图
                baiduMap.setTrafficEnabled(true);
                break;

        }
    }
}

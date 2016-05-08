package com.gc.buaa.baidumap.activity;

import android.view.View;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;

/**
 * 圆形覆盖物
 * Created by Administrator on 2016/5/8.
 */
public class CircelOverlayActivity extends BaseActivity{
    @Override
    public void init() {
        btn_1.setVisibility(View.GONE);
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);


        CircleOptions options = new CircleOptions();	// 创建一个圆形覆盖物的参数
        //责任链
        options.center(kjcPos)	// 圆心
                .radius(1000)	// 半径（米）
                .stroke(new Stroke(20, 0x55FF0000))// 线条宽度、颜色
                .fillColor(0x5500FF00);	// 圆的填充颜色
        baiduMap.addOverlay(options);	// 添加一个覆盖物
    }
}

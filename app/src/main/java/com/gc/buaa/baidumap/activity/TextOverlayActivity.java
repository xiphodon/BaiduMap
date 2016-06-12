package com.gc.buaa.baidumap.activity;

import android.view.View;

import com.baidu.mapapi.map.TextOptions;

/**
 * 文字覆盖物
 * Created by Administrator on 2016/5/8.
 */
public class TextOverlayActivity extends BaseActivity{
    @Override
    public void init() {
        btn_1.setVisibility(View.GONE);
        btn_2.setVisibility(View.GONE);
        btn_3.setVisibility(View.GONE);
        btn_4.setVisibility(View.GONE);
        btn_5.setVisibility(View.GONE);


        TextOptions options = new TextOptions();
        options.position(kjcPos)			// 位置
                .text("南通")			// 文字内容
                .fontSize(50)			// 文字大小
                .fontColor(0XFF000000)	// 文字颜色
                .bgColor(0X55FF0000)	// 背景颜色
                .rotate(30);			// 旋转
        baiduMap.addOverlay(options);
    }
}

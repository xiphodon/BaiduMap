package com.gc.buaa.baidumap.activity;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baidu.mapapi.SDKInitializer;
import com.gc.buaa.baidumap.utils.Utils;

public class DemoListActivity extends ListActivity {

    private SDKcheckReceiver sdKcheckReceiver;

    private ClassAndName[] datas = {
            new ClassAndName(HelloBaiduMapActivity.class, "HelloBaiduMap"),
            new ClassAndName(MapLayerActivity.class, "地图图层"),
            new ClassAndName(CircelOverlayActivity.class, "圆形覆盖物"),
            new ClassAndName(TextOverlayActivity.class, "文字覆盖物"),
            new ClassAndName(MarkerOverlayActivity.class, "marker覆盖物"),
            new ClassAndName(SearchInBoundActivity.class, "在范围内搜索"),
            new ClassAndName(SearchInCityActivity.class, "在城市内搜索"),
            new ClassAndName(SearchInNearbyActivity.class, "在周边内搜索"),
//            new ClassAndName(DrivingSearchActivity.class, "驾车路线搜索"),
//            new ClassAndName(TransitSearchActivity.class, "换乘路线搜索"),
//            new ClassAndName(WalkingSearchActivity.class, "步行路线搜索"),
//            new ClassAndName(LocationActivity.class, "定位"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerSDKcheckReceiver();

        ArrayAdapter<ClassAndName> adapter =
                new ArrayAdapter<ClassAndName>(this, android.R.layout.simple_list_item_1, datas);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // 取出单击位置的ClassAndName
        ClassAndName classAndName = (ClassAndName) l.getItemAtPosition(position);
        startActivity(new Intent(this, classAndName.clazz));
    }

    class ClassAndName {
        /** 用于保存Activity的字节码 */
        public Class<?> clazz;
        /** 用于保存Activity对应的名字 */
        public String name;
        public ClassAndName(Class<?> cls, String name) {
            this.clazz = cls;
            this.name = name;
        }

        /**
         * 显示条目
         * @return
         */
        @Override
        public String toString() {
            return name;
        }
    }


    /**
     * 程序启动后监听Key是否正确
     */
    private void registerSDKcheckReceiver() {
        sdKcheckReceiver = new SDKcheckReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        intentFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
        intentFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
        registerReceiver(sdKcheckReceiver, intentFilter);
    }

    class SDKcheckReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(action)) {
                Utils.showToast(DemoListActivity.this,"网络错误！");
            } else if (SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR.equals(action)) {
                Utils.showToast(DemoListActivity.this,"Key验证失败！");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(sdKcheckReceiver);
    }
}

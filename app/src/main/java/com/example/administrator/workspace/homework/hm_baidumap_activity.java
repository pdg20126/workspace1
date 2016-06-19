package com.example.administrator.workspace.homework;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Menu;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.administrator.workspace.R;


/**
 * Created by Administrator on 2016/6/16.
 */
public class hm_baidumap_activity extends Activity {
    MapView map;
    LocationManager lm;
    BaiduMap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm_baidumap_layout);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);*/
        map = (MapView) findViewById(R.id.mymap);
        bm = map.getMap();
        // bm.setTrafficEnabled(true);
        // bm.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
        bm.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location l = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(hm_baidumap_activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(hm_baidumap_activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                //updateView(l);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }



    public void updateView(Location l) {
        if (l != null) {

            LatLng point = new LatLng(l.getLatitude(), l.getLongitude());
//构建Marker图标
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.map_icon);
//构建MarkerOption，用于在地图上添加Marker
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap);
//在地图上添加Marker，并显示
            bm.addOverlay(option);
            bm.setMyLocationEnabled(true);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location l1 = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            LatLng p = new LatLng(l1.getLatitude(),l1.getLongitude());
            //LatLng p = new LatLng(41.808466,123.413759);
            MapStatus mMapStatus = new MapStatus.Builder().target(p).zoom(18)
                    .build();
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
                    .newMapStatus(mMapStatus);
            bm.setMapStatus(mMapStatusUpdate);
        } else {
            Toast.makeText(hm_baidumap_activity.this, "未能加载地图", Toast.LENGTH_SHORT).show();
        }
    }

}

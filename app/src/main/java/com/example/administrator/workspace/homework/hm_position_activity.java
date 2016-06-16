package com.example.administrator.workspace.homework;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.widget.TextView;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/6/16.
 */
public class hm_position_activity extends FatherBarActivity {
    TextView tv;
    LocationManager lm;

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_position_layout);
        tv = (TextView) findViewById(R.id.position);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(hm_position_activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(hm_position_activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Location l1 = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateView(l1);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
    }
    public void updateView(Location l)
    {
        if(l!=null)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("当前的位置是：");
            sb.append("经度：");
            sb.append(l.getLongitude());
            sb.append("，纬度");
            sb.append(l.getLatitude());
            sb.append("，海拔");
            sb.append(l.getAltitude());
            sb.append("，速度");
            sb.append(l.getSpeed());
            sb.append("，方向");
            sb.append(l.getBearing());
            tv.setText(sb.toString());
        }else{
            tv.setText("无信息");
        }
    }
}

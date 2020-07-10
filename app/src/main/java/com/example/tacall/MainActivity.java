package com.example.tacall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static com.baidu.mapapi.map.BitmapDescriptorFactory.*;

public class MainActivity extends AppCompatActivity {

    LocationClient mLocationClient;//
    MapView mMapView;
    BaiduMap mBaiduMap = null;
    boolean isFirstLocate = true;
    float mLastX;
    int mXDirection;
    MyOrientationListener myOrientationListener;
    MyLocationConfiguration myLocationConfiguration;//图标
    double mCurrentLantitude;//当前纬度
    private float mCurrentAccracy;
    private double mCurrentLongitude;//当前经度


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //初始化
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initOritationListener();
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        mMapView = findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        MyLocationConfiguration myLocationConfiguration =new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING,true,null);
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        mBaiduMap.setMyLocationConfiguration(myLocationConfiguration);
        //

        //权限申请
        List<String> permissionList = new ArrayList<String>();

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions,1);
        }else{
            requsetLocation();
        }
        //
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0){
                    for(int result:grantResults){
                        if(result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"错误",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requsetLocation();
                }else {
                    Toast.makeText(this,"未知错误",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }//申请权限

    private void requsetLocation(){
        initLocation();
        mLocationClient.start();

        myOrientationListener.start();
    }//请求坐标


    private void initOritationListener()
    {
        myOrientationListener = new MyOrientationListener(
                getApplicationContext());
        myOrientationListener
                .setOnOrientationListener(new MyOrientationListener.OnOrientationListener()
                {
                    @Override
                    public void onOrientationChanged(float x)
                    {
                        mXDirection = (int) x;

                        // 构造定位数据

                        MyLocationData locData = new MyLocationData.Builder()
                                .accuracy(mCurrentAccracy)
                                // 此处设置开发者获取到的方向信息，顺时针0-360
                                .direction(mXDirection)
                                .latitude(mCurrentLantitude)
                                .longitude(mCurrentLongitude).build();
                        // 设置定位数据
                        mBaiduMap.setMyLocationData(locData);
                        // 设置自定义图标
                        //BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory
                            //    .fromResource(R.drawable.navi_map_gps_locked);
                        myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, null);
                        mBaiduMap.setMyLocationConfigeration(myLocationConfiguration);

                    }
                });
    }//初始化方向监听器


    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");
        option.setScanSpan(1000);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIgnoreKillProcess(false);
        option.setWifiCacheTimeOut(5*60*1000);
        option.setEnableSimulateGps(false);
        option.setIsNeedAddress(true);

        mLocationClient.setLocOption(option);
        MyOrientationListener myOrientationListener = new MyOrientationListener(this);
        myOrientationListener.setOnOrientationListener(new MyOrientationListener.OnOrientationListener() {
            @Override
            public void onOrientationChanged(float x) {
                mLastX = x;
            }
        });
    }//初始化坐标

    private class MyLocationListener extends BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null || mMapView == null)
                return;
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    .direction(mXDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            float mCurrentAccracy = location.getRadius();
            mBaiduMap.setMyLocationData(locData);
            mCurrentLantitude = location.getLatitude();
            mCurrentLongitude = location.getLongitude();
            myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, null);
            mBaiduMap.setMyLocationConfigeration(myLocationConfiguration);
            if (isFirstLocate)
            {
                isFirstLocate = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
                mBaiduMap.animateMapStatus(u);
            }
        }
    }//实现定位和方向显示



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();

        myOrientationListener.stop();
    }//销毁

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }//继续

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }//停止



}
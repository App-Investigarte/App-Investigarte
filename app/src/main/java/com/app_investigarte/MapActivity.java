package com.app_investigarte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {
        mMap=googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        LatLng antioquia = new LatLng(6.55, -75.817);
        mMap.addMarker(new MarkerOptions().position(antioquia).title("Departamento de Antioquia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.0f));

        mMap.setMinZoomPreference(5.5f);

        LatLngBounds colombia = new LatLngBounds(
                new LatLng(2, -78), // SW bounds
                new LatLng(9, -67)  // NE bounds
        );

        // Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(colombia);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.00, -73.817))
                .title("San Francisco")
                .snippet("Population: 776733"));

        // Add a circle in Sydney
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(6.00, -75.817))
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        circle.setClickable(true);


        mMap.addPolygon(new PolygonOptions()
                .add(
                        new LatLng(3,-77.38),
                        new LatLng(7.2,-77.80),
                        new LatLng(10,-75.21),
                        new LatLng(12,-71.25),
                        new LatLng(6.9,-67.38),
                        new LatLng(2,-67.67) ,
                        new LatLng(-2.20,-71.32))
                .strokeColor(Color.RED)
                .fillColor(Color.TRANSPARENT));


    }
}
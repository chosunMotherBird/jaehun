package com.example.sw;

import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sw.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //private GoogleMap mMap;
    //private ActivityMapsBinding binding;
    private Button btn_login, btn_search, btn_now;
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_test);

         fragmentManager=getFragmentManager();
         mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googlemap);
         mapFragment.getMapAsync(this);


        btn_login=findViewById(R.id.btn_logIn);
        btn_search=findViewById(R.id.btn_search);
        btn_now=findViewById(R.id.btn_now);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MapsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(35.139813, 126.934290);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("조선대학교 IT융합대학");
        markerOptions.snippet("단과대학");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}